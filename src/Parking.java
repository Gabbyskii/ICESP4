import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Parking {

    private String label;
    private String zone;
    private int availableSpots;
    private int totalSpots;

    public Parking(String label, String zone, int totalSpots) {
        this.label = label;
        this.zone = zone;
        this.totalSpots = totalSpots;
        this.availableSpots = totalSpots;
    }

    public String getZone() {
        return zone;
    }

    public String getLabel() {
        return label;
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
        switch (zone) {
            case "rød zone":  return 37.00;
            case "blå zone":  return 20.00;
            case "grøn zone": return 11.00;
            case "gul zone":  return 17.00;
            default:
                throw new IllegalArgumentException("Ukendt zone: " + zone);
        }
    }





    @Override
    public String toString() {
        return "Parking{" +
                "label='" + label + '\'' +
                ", zone='" + zone + '\'' +
                ", spots=" + availableSpots + "/" + totalSpots +
                '}';
    }


}
