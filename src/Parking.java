import java.util.ArrayList;

public abstract class Parking {

    private String label;
    private String zone;
    private ArrayList<?> parkering = new ArrayList<>();
    private int price;

    public Parking(String label, String zone) {
        this.label = label;
        this.zone = zone;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getZone() {
        return zone;
    }

    public boolean isAvailable() {

    }


    public abstract String getSpotTypes();


    public double getPricePerHour() {
       switch (zone){
           case "rød zone", "grøn zone":
           return 35.00;
           case "blå zone":
           return 20.00;
           case "gul zone":
           return 17.00;

           default:
               System.out.println("Invalid");
       }

        return 0;
    }


    @Override
    public String toString() {
        return "Parking{" +
                "label='" + label + '\'' +
                ", zone='" + zone + '\'' +
                ", parkering=" + parkering +
                ", price=" + price +
                '}';
    }


}
