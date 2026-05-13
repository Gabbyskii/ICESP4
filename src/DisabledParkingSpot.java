public class DisabledParkingSpot extends Parking{

    public DisabledParkingSpot(String label, String zone, int totalSpots) {
        super(label, zone, totalSpots);
    }

    @Override
    public String getSpotTypes() {
        return "Disabled Car";
    }



}
