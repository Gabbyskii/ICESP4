import domain.Car;
import domain.Menu;
import domain.User;
import domain.Zone;
import util.FileIO;
import util.TextUI;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        FileIO fileIO = new FileIO();
        TextUI textUI = new TextUI();

        List<User> users = FileIO.loadUsers("Data/UserData");
        List<Zone> zones = fileIO.loadZones("Data/zoneData");
        List<Car> cars = fileIO.loadCars("Data/carData");

        Menu menu = new Menu(users, zones, cars, textUI, fileIO);

        menu.start();
    }

}