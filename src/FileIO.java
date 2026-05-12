import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    static final String userHeader = "phoneNumber, mail";
    private static final String userFile = "Data/UserData";


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

}
