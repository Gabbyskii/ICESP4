import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        FileIO fileIO = new FileIO();
        TextUI textUI = new TextUI();

        List<User> users = FileIO.loadUsers("Data/UserData");
        List<Zone> zones = FileIO.loadZones("Data/zoneData");
        List<Car> cars = FileIO.loadCars("Data/carData");

        Menu menu = new Menu(users, zones, cars, textUI, fileIO);

        menu.start();
    }



}

