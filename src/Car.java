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


    @Override
    public String toString() {
        return "Car info = "+ "LicensePlate: " + licensePlate +
                ", Car name: " + carName;
    }
}
