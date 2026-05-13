import java.util.ArrayList;
import java.util.List;

public class Zone {

    private String name;
    private double pricePerHour;
    private List<Parking> spots;
    private DisabledParkingSpot disabled;
    private SharingCarParkingSpot sharing;
    private RegularParkingSpot regular;
    private ElCarParkingSpot elCar;
    private PrivateArea prArea;



    public Zone(double pricePerHour, String name, PrivateArea prArea,
                ElCarParkingSpot elCar, RegularParkingSpot regular,
                SharingCarParkingSpot sharing, DisabledParkingSpot disabled,
                List<Parking> spots) {
        this.pricePerHour = pricePerHour;
        this.name = name;
        this.prArea = prArea;
        this.elCar = elCar;
        this.regular = regular;
        this.sharing = sharing;
        this.disabled = disabled;
        this.spots = spots;
    }

    public void addSpot(Parking spot) {
        spots.add(spot);
    }


    public int getAvailableSpots() {
        int count = 0;
        for (Parking spot : spots) {
            if (spot.isAvailable()) count++;
        }
        return count;
    }

    public int getTotalSpots() {
        return spots.size();
    }

    public boolean hasAvailability() {
        return getAvailableSpots() > 0;
    }


    public String getName()          {
        return name;
    }
    public double getPricePerHour()  {
        return pricePerHour;
    }
    public List<Parking> getSpots()  {
        return spots;
    }

    @Override
    public String toString() {
        return name + " — " + getAvailableSpots()
                + "/" + getTotalSpots() + " ledige "
                + pricePerHour + " kr/t";
    }
}