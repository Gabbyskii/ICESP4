public class PrivateArea extends Parking {


    public PrivateArea(String label, String zone) {
        super(label, zone);
    }

    @Override
    public String getSpotTypes() {
        return "Private Area";
    }


}
