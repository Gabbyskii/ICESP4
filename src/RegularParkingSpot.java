public class RegularParkingSpot extends Parking{

    private double regularPrice;

    public RegularParkingSpot(String label, String zone, double regularPrice) {
        super(label, zone);
        this.regularPrice = getPricePerHour();

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
