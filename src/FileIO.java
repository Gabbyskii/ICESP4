import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    static final String userHeader = "phoneNumber, mail";
    private static final String userFile = "Data/UserData";
    private String carFile = "Data/carData";
    private String zoneFile = "Data/zoneData";


    public static List<User> loadUsers(String path) {
        List<User> users = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(path))) {
            if (scan.hasNextLine()) {
                scan.nextLine();
            }

            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",", -1);
                if (parts.length < 2) {
                    continue;
                }

                int phoneNumber = Integer.parseInt(parts[0].trim());
                String mail = parts[1].trim();
                User user = new User(phoneNumber, mail);

                users.add(user);

            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke: " + e.getMessage());
        }

        return users;
    }

    public void saveUsers(List<User> users) {
        try (FileWriter writer = new FileWriter(userFile)) {
            writer.write(userHeader + "\n");

            for (User user : users) {
                writer.write(user.getPhoneNumber() + ", " + user.getMail() + "\n");
            }
        }catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }


    public static List<Car> loadCars(String path) {
        List<Car> cars = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(path))) {
            if (scan.hasNextLine()) {
                scan.nextLine();
            }

            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",", -1);
                if (parts.length < 2) {
                    continue;
                }

                String licensePlate = parts[0].trim();
                //String carName = parts[1].trim();
                Car car = new Car(licensePlate);

                cars.add(car);

            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke: " + e.getMessage());
        }

        return cars;
    }



    public void saveCars(List<Car> cars) {
        try (FileWriter writer = new FileWriter(carFile)) {

            for (Car car : cars) {
                writer.write(car.getLicensePlate() + ", " + car.getLicensePlate() + "\n");
            }
        }catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }


    public static List<Parking> loadParking(String path) {
        List<Zone> zone = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(path))) {
            if (scan.hasNextLine()) {
                scan.nextLine();
            }

            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",", -1);
                if (parts.length < 2) {
                    continue;
                }


                String zones = parts[0].trim();
                int pricePerHour = Integer.parseInt(parts[1].trim());
                int totalSpots = Integer.parseInt(parts[2].trim());
                int disabledParkingSpot = Integer.parseInt(parts[3].trim());
                int elCarParkingSpot = Integer.parseInt(parts[4].trim());
                int regularParkingSpot = Integer.parseInt(parts[5].trim());
                int sharingCarParkingSpot = Integer.parseInt(parts[6].trim());
                int privateArea = Integer.parseInt(parts[7].trim());


                Zone z = new Zone(zones, pricePerHour, totalSpots, disabledParkingSpot,
                        elCarParkingSpot, regularParkingSpot, sharingCarParkingSpot, privateArea);


                zone.add(z);

            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke: " + e.getMessage());
        }

        return Parking;
    }



    public void saveZone(List<Zone> zones) {
        try (FileWriter writer = new FileWriter(zoneFile)) {

            for (Zone z : zones) {
                writer.write(z.getName() + ", " + z.getAvailableSpots() + "\n");
            }
        }catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }

}
