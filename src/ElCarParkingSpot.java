public class ElCarParkingSpot extends Parking{

    public ElCarParkingSpot(String label, String zone, int totalSpots) {
        super(label, zone, totalSpots);
    }

    @Override
    public String getSpotTypes() {
        return "El Car";
    }


}
