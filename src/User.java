import java.util.ArrayList;

public class User {

    int phoneNumber;
    String mail;
    ArrayList<Car> license = new ArrayList<>();

    public User(int phoneNumber, String mail, ArrayList<Car> license) {
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.license = license;
    }

    public void addCarLicense(Car car){
        license.add(car);
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public String getMail(){
        return mail;
    }
}
