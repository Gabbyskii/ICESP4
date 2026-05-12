public class SharingCarParkingSpot extends Parking {

    public SharingCarParkingSpot(String label, String zone) {
        super(label, zone);
    }

    @Override
    public String getSpotTypes() {
        return "Sharing Car";
    }


}
