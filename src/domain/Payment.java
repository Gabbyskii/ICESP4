package domain;

import java.time.Duration;
import java.time.LocalTime;


public class Payment {

     private Parking parking;
     private LocalTime startTime;

    public Payment(Parking parking) {
        this.parking = parking;
    }

    public void startPayment() {
            startTime =LocalTime.now();
        System.out.println("Parkering startet: " + startTime);
    }

    public double endPayment() {

        long minutes = Duration.between(startTime,
                LocalTime.now()).toSeconds();

        return (minutes / 60.0) * parking.getPricePerHour();

    }
}