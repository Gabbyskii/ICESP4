import java.util.ArrayList;
import java.util.List;

public class Zone {

    private String name;
    private double pricePerHour;
    private List<Parking> spots;
    private int totalSpots;
    private int disabled;
    private int el;
    private int regular;
    private int sharing;
    private int privateArea;

    public Zone(String name, double pricePerHour, int totalSpots, int disabled, int el, int regular, int sharing, int privateArea) {

        this.name = name;
        this.pricePerHour = pricePerHour;
        this.spots = new ArrayList<>();

        for (int i = 0; i < disabled; i++)
            spots.add(new DisabledParkingSpot("D"+i, this));

        for (int i = 0; i < el; i++)
            spots.add(new ElCarParkingSpot("E"+i, this));

        for (int i = 0; i < regular; i++)
            spots.add(new RegularParkingSpot("R"+i, this));

        for (int i = 0; i < sharing; i++)
            spots.add(new SharingCarParkingSpot("S"+i, this));

        for (int i = 0; i < privateArea; i++)
            spots.add(new PrivateArea("P"+i, this));
    }

    public String getName() {
        return name;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public List<Parking> getSpots() {
        return spots;
    }

    public String getZoneInfo() {
        return "Zone: " + name +
                "\nTotal spots: " + totalSpots +
                "\nDisabled spots: " + disabled +
                "\nEl spots: " + el +
                "\nRegular spots: " + regular +
                "\nSharing spots: " + sharing +
                "\nPrivate area spots: " + privateArea +
                "\nPrice per hour: " + pricePerHour;
    }

    @Override
    public String toString() {
        return name + " - " + pricePerHour + " kr/t";
    }
}