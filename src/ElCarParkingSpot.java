public class ElCarParkingSpot extends Parking{

    public ElCarParkingSpot(String label, String zone) {
        super(label, zone);
    }

    @Override
    public String getSpotTypes() {
        return "El Car";
    }


}
