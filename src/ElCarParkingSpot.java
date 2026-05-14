public class ElCarParkingSpot extends Parking{

    public ElCarParkingSpot(String zone, int pricePerHour, int totalSpots, int disabledParkingSpot, int elCarParkingSpot, int regularParkingSpot, int sharingCarParkingSpot, int privateArea, int availableSpots) {
        super(zone, pricePerHour, totalSpots, disabledParkingSpot, elCarParkingSpot, regularParkingSpot, sharingCarParkingSpot, privateArea, availableSpots);
    }

    @Override
    public String getSpotTypes() {
        return "El Car";
    }


}
