public class DisabledParkingSpot extends Parking{

    public DisabledParkingSpot(String label, String zone) {
        super(label, zone);
    }

    @Override
    public String getSpotTypes() {
        return "Disabled Car";
    }



}
