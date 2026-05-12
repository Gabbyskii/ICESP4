public class Payment {
    private double pricePerHour;
    private Parking zone;
    private java.time.LocalTime startTime;

    public Payment(Parking zone) {
        this.zone = zone;
        this.pricePerHour = zone.getPricePerHour();
    }

    public double pricePerHour() {
        return pricePerHour;
    }

    public double pricePerDay() {
        return pricePerHour * 10;
    }
    public double pricePerEvening(){
        return pricePerHour * 4;
    }
    public double pricePerNight(){
        return pricePerHour * 1;
    }

    public void startPayment() {
        this.startTime = java.time.LocalTime.now();
        System.out.println("Parkering startet: " + startTime);
    }

    public double endPayment() {
        long minutes = java.time.Duration.between(
                startTime, java.time.LocalTime.now()).toMinutes();
        double cost = (minutes / 60.0) * pricePerHour;
        System.out.println("Parkering slut. Betaling: "
                + String.format("%.2f", cost) + " kr");
        return cost;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "pricePerHour=" + pricePerHour +
                ", zone=" + zone +
                ", startTime=" + startTime +
                '}';
    }
}

