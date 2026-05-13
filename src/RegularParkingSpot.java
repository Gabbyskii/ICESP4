public class RegularParkingSpot extends Parking{

    private double regularPrice;

    public RegularParkingSpot(String zone, int pricePerHour, int totalSpots, int disabledParkingSpot, int elCarParkingSpot, int regularParkingSpot, int sharingCarParkingSpot, int privateArea, int availableSpots) {
        super(zone, pricePerHour, totalSpots, disabledParkingSpot, elCarParkingSpot, regularParkingSpot, sharingCarParkingSpot, privateArea, availableSpots);
        this.regularPrice = regularPrice;
    }

    public double getRegularPrice() {
        return getPricePerHour();
    }

    @Override
    public String getSpotTypes() {
        return "Regular car";
    }

    @Override
    public String toString() {
        return "RegularParkingSpot: "+ regularPrice;
    }


}
