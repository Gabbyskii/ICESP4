public class SharingCarParkingSpot extends Parking {

    public SharingCarParkingSpot(String label, String zone, int totalSpots) {
        super(label, zone, totalSpots);
    }

    @Override
    public String getSpotTypes() {
        return "Sharing Car";
    }


}
