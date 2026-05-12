import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args){
        //bare for at teste compiling af koden
        Car bmw = new Car("GK12345", "BMW");

        System.out.println(bmw);


        Payment pay = new Payment(new Parking("handicap", "rød zone"));
        System.out.println(pay.pricePerNight());
        pay.startPayment();
        pay.endPayment();


        RegularParkingSpot rp = new RegularParkingSpot("regular", "blå zone", 10);
        System.out.println(rp.getPricePerHour());


    }

}
