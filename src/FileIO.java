import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileIO {

    private String userFile = "csv/UserData";

    public List<User> loadUsers(ArrayList<User> users) {
        List<User> userList = new ArrayList<>();

        try {
            BufferedReader breader = new BufferedReader(new FileReader(userFile));
            String line = breader.readLine();

            while (line != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    int phoneNumber = Integer.parseInt(values[0].trim());
                    String mail = values[1].trim();

                    User newUser = new User(phoneNumber, mail);
                    userList.add(newUser);
                }
                line = breader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fejl ved indlæsning af brugere: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Fejl ved indlæsning af bruger. " + e.getMessage());
        }

        return userList;
    }

    public void saveUsers(List<User> userList) {
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(userFile));

            for (User user : userList) {
                bWriter.write(user.getPhoneNumber() + ", " + user.getMail());
                bWriter.newLine();
            }
            bWriter.close();

        } catch (Exception e) {
            System.out.println("Fejl ved gemning af bruger: " + e.getMessage());
        }
    }



}
