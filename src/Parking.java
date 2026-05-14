import java.util.List;

public abstract class Parking {

    private static String zones;
    private int pricePerHour;
    private int totalSpots;
    private int disabledParkingSpot;
    private int elCarParkingSpot;
    private int regularParkingSpot;
    private int sharingCarParkingSpot;
    private int privateArea;
    private int availableSpots;


    public Parking(String zone, int pricePerHour, int totalSpots, int disabledParkingSpot, int elCarParkingSpot, int regularParkingSpot, int sharingCarParkingSpot, int privateArea, int availableSpots) {
        this.zones = zones;
        this.pricePerHour = pricePerHour;
        this.totalSpots = totalSpots;
        this.disabledParkingSpot = disabledParkingSpot;
        this.elCarParkingSpot = elCarParkingSpot;
        this.regularParkingSpot = regularParkingSpot;
        this.sharingCarParkingSpot = sharingCarParkingSpot;
        this.privateArea = privateArea;
        this.availableSpots = availableSpots;
    }

    public static int getZone() {
        return zones;
    }

    public int getTotalSpots() {
        return totalSpots;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public boolean isAvailable() {
        return availableSpots > 0;
    }

    public void takeSpot() {
        if (availableSpots > 0) availableSpots--;
    }

    public void releaseSpot() {
        if (availableSpots < totalSpots) availableSpots++;
    }

    public abstract String getSpotTypes();

    public double getPricePerHour() {
        switch (zones) {
            case "rød zone":  return 37.00;
            case "blå zone":  return 20.00;
            case "grøn zone": return 11.00;
            case "gul zone":  return 17.00;
            default:
                throw new IllegalArgumentException("Ukendt zone: " + zones);
        }
    }



    @Override
    public String toString() {
        return "Parking{" +
                ", zone='" + zones + '\'' +
                ", spots=" + availableSpots + "/" + totalSpots +
                '}';
    }


}
