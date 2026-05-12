import java.io.FileNotFoundException;
import java.util.List;

        public class Main {

            public static void main(String[] args) throws FileNotFoundException {

                FileIO fileIO = new FileIO();
                TextUI textUI = new TextUI();

                List<User> users = FileIO.loadUsers("Data/UserData");

                Menu menu = new Menu(users, null, textUI, fileIO);
                menu.start();
            }



        //bare for at teste compiling af koden
        Car bmw = new Car("GK12345", "BMW");

        //System.out.println(bmw);

}
