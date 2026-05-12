import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class fileIO {

    private String userFile = "csv/UserData";

    public List<User> loadUsers(ArrayList<User> users) {
        List<User> userList = new ArrayList<>();

        try {
            BufferedReader breader = new BufferedReader(new FileReader(userFile));
            String line = breader.readLine();

            while (line != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    User newUser = new User(values[0].trim(), values[1].trim());
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
