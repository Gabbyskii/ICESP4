public class RegularParkingSpot extends Parking{

    private double regularPrice;

    public RegularParkingSpot(String label, String zone, int totalSpots, double regularPrice) {
        super(label, zone, totalSpots);
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
