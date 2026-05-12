import java.util.ArrayList;

public class User {

    private int phoneNumber;
    private String mail;
    private ArrayList<Car> license = new ArrayList<>();

    public User(int phoneNumber, String mail) {
        this.phoneNumber = phoneNumber;
        this.mail = mail;
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


    @Override
    public String toString() {
        return "User{" +
                "mail='" + mail + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
