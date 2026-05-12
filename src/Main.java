import java.io.FileNotFoundException;
import java.util.List;

        public class Main {

            public static void main(String[] args) {
                FileIO fileIO = new FileIO();
                TextUI textUI = new TextUI();

                List<User> users = FileIO.loadUsers("Data/UserData");

                try {
                    Menu menu = new Menu(users, null, textUI, fileIO);
                    menu.start();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }


                //bare for at teste compiling af koden
                Car bmw = new Car("GK12345", "BMW");

                System.out.println(bmw);
            }


}
