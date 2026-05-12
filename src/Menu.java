import java.io.FileNotFoundException;
import java.util.List;

public class Menu {

    List<User> users;
    User currentUser;
    TextUI textUI;
    FileIO fileIO;

    public Menu(List<User> users, User currentUser, TextUI textUI, FileIO fileIO) {
        this.users = users;
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
}

