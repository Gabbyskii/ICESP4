import java.io.FileNotFoundException;
import java.util.List;

        public class Main {

            public static void main(String[] args) {
                FileIO fileIO = new FileIO();
                TextUI textUI = new TextUI();

                List<User> users = FileIO.loadUsers("Data/UserData");
                List<Parking> parkings = FileIO.loadParking("Data/zoneData");

                try {
                    Menu menu = new Menu(users, textUI, fileIO);
                    menu.start();
                    menu.showMenu();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }



                //bare for compiling af koden
                /*Car bmw = new Car("GK12345", "BMW");

                System.out.println(bmw);*/
            }


}
