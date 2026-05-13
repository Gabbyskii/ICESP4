import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    List<User> users;
    List<Parking> zoneList;
    List<Parking> parkinglist;
    Payment payment;
    User currentUser;
    Parking p;
    TextUI textUI;
    FileIO fileIO;

    public Menu(List<User> users, List<Parking> zoner, User currentUser, TextUI textUI, FileIO fileIO) {
        this.users = users;
        this.zoneList = zoner;
        this.currentUser = currentUser;
        this.textUI = textUI;
        this.fileIO = fileIO;
    }

    public void start() throws FileNotFoundException {

        if (textUI.promptBinary("Do you have a login?")) {
            login();
        } else {
            register();
        }
    }

    public void register() {

        int phoneNumber = Integer.parseInt(textUI.promptText("Write your phone number"));
        String mail = textUI.promptText("Write your mail");

        User newUser = new User(phoneNumber, mail);

        users.add(newUser);
        fileIO.saveUsers(users);

        currentUser = newUser;

        textUI.displayMsg("User created! Welcome");
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


    private void showMenu() {
        System.out.println("\n" + "MENU TESTER - WORKING");
    }

    public void chooseParkingType() {
        textUI.displayMsg("Parkerings typer:");
        for (Parking p : parkinglist) {
            textUI.displayMsg(" - " + p.getSpotTypes());
            p.takeSpot();
            payment.startPayment();

        }

    }

    private List<String> zones = new ArrayList<>();

    public void ZoneManager() {
        zones.add("Rød Zone");
        zones.add("Grøn Zone");
        zones.add("Blå Zone");
        zones.add("Gul Zone");
    }

    public String showAllZones() {
        ZoneManager();
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
        return "test";
    }

        public void showMenu() {
            boolean parkingRuns;
            if (parkingRuns = false){
                payment.endPayment();
                p.releaseSpot();
            }

            while (parkingRuns) {
                textUI.displayMsg("\n--- Tilgængelige muligheder ---");
                for (Parking p : zoneList) {
                    textUI.displayMsg(p.getZone() + " (" + p.getSpotTypes() + ")");
                }
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


}


