import java.util.ArrayList;

public class User {

    private int phoneNumber;
    private String mail;
    private int licensPlate;
    private ArrayList<Car> license = new ArrayList<>();

    public User(int phoneNumber, String mail, int licensPlate) {
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.licensPlate = licensPlate;
    }

    public void addCarLicense(Car car) {
        license.add(car);
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail(){
        return mail;
    }

    public int getLicens(){
        return licensPlate;
    }







    @Override
    public String toString() {
        return "User{" +
                "mail='" + mail + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
