import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    List<User> users;
   // List<Parking> zoneList;
    List<Parking> parkinglist;
    List<Car> cars;
    Payment payment;
    User currentUser;
    Parking parking;
    TextUI textUI;
    FileIO fileIO;

    public Menu(List<User> users, TextUI textUI, FileIO fileIO) {
        this.users = users;
       // this.zoneList = zoner;
        this.currentUser = currentUser;
        this.textUI = textUI;
        this.fileIO = fileIO;
    }

    public void start() throws FileNotFoundException {

        if (textUI.promptBinary("Do you have a login?")) {
            login();

        } else {
            registerUser();
        }
    }



    public void registerUser() throws FileNotFoundException {

        int phoneNumber = Integer.parseInt(textUI.promptText("Write your phone number"));
        String mail = textUI.promptText("Write your mail");

        User newUser = new User(phoneNumber, mail);

        users.add(newUser);
        fileIO.saveUsers(users);

        currentUser = newUser;

        textUI.displayMsg("User created! Welcome");
        start();
    }

    public void registerLicense() {

        String licensePlate = textUI.promptText("Write your licensePlate: ");

        Car newCar = new Car(licensePlate);

        cars.add(newCar);
        fileIO.saveCars(cars);

        textUI.displayMsg("License added for your car! ");
        showMenu();
    }

    public void login() throws FileNotFoundException {

        int phoneNumber = Integer.parseInt(textUI.promptText("Write your phone number"));
        String mail = textUI.promptText("Write your mail");

        for (User user : users) {

            if (user.getPhoneNumber() == phoneNumber &&
                    user.getMail().equals(mail)) {

                currentUser = user;
                textUI.displayMsg("Login successful!");
                showMenu();
                return;
            }
        }

        textUI.displayMsg("Wrong login!");
        start();
    }




    public void chooseParkingType() {
        textUI.displayMsg("Parkerings typer:");
        for (Parking p : parkinglist) {
            textUI.displayMsg(" - " + p.getSpotTypes());
            p.takeSpot();
            payment.startPayment();

        }

    }

        public void showMenu() {
           // System.out.println("Test");
            boolean parkingRuns = true;
            if (!parkingRuns){
                payment.endPayment();
                parking.releaseSpot();
            }

            while (parkingRuns) {
                textUI.displayMsg("\n--- Tilgængelige muligheder ---");
                /*for (Parking z: zoneList){
                    textUI.displayMsg(z.getZones() + " (" + z.getSpotTypes() + ") "+ z.getAvailableSpots() + " ledige.");
                }*/

                textUI.displayMsg("---------------------------\n");

                textUI.displayMsg("1. Vis alle zoner ");
                textUI.displayMsg("2. Vis ledig parkering i zone ");
                textUI.displayMsg("3. Vælg parkeringstyper ");
                textUI.displayMsg("4. Log ud af bruger ");

                String choice = textUI.promptText("Vælg en af mulighederne (1-4) ");

                switch (choice) {
                    case "1" -> showAllZones();
                    case "2" -> showAvailableParkingInZone();
                    case "3" -> chooseParkingType();
                    case "4" -> parkingRuns = false;
                }

            }
        }

    public List<String> getZones() {
        List<String>  zones = new ArrayList<>();
        zones.add("Rød Zone");
        zones.add("Grøn Zone");
        zones.add("Blå Zone");
        zones.add("Gul Zone");
        return zones;
    }

    public String showAllZones() {
        List<String> zones = getZones();
        Scanner scan = new Scanner(System.in);

        System.out.println("Alle zoner:");

        for (int i = 0; i < zones.size(); i++) {
            System.out.println((i + 1) + ": " + zones.get(i));
        }

        System.out.print("Vælg zone nummer: ");
        int choice = scan.nextInt();

        if (choice >= 1 && choice <= zones.size()) {
             return zones.get(choice - 1);
        }
        return null;
    }

    private void showAvailableParkingInZone() {
        String selectedZone = showAllZones();

        if (selectedZone == null) {
            textUI.displayMsg("Ingen zone valgt.");
            return;
        }

        textUI.displayMsg("\nLedige pladser i: " + selectedZone);

        boolean found = false;

        for (Parking p : parkinglist) {

            if (p.getZone().equals(selectedZone)) {

                textUI.displayMsg(" - " + p.getSpotTypes());
                found = true;
            }
        }

        if (!found) {
            textUI.displayMsg("Ingen parkering fundet i denne zone.");
        }
    }

}


