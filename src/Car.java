import java.util.ArrayList;

public class Car {

    private String licensePlate;
    private String carName;
    ArrayList<Car> cars = new ArrayList<>();

    public Car(String licensePlate, String carName) {
        this.licensePlate = licensePlate;
        this.carName = carName;
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void removeCar(Car car){
        cars.remove(car);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Car info = "+ "LicensePlate: " + licensePlate +
                ", Car name: " + carName;
    }
}
