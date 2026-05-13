public class PrivateArea extends Parking {


    public PrivateArea(String label, String zone, int totalSpots) {
        super(label, zone, totalSpots);
    }

    @Override
    public String getSpotTypes() {
        return "Private Area";
    }


}
