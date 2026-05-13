import java.util.ArrayList;
import java.util.List;

public class Zone {

    private String name;
    private double pricePerHour;
    private List<Parking> spots;

    public Zone(String name, double pricePerHour) {
        this.name         = name;
        this.pricePerHour = pricePerHour;
        this.spots        = new ArrayList<>();
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