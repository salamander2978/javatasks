public class StandardPriceCalculator implements PriceCalculator {
    @Override
    public double calculatePrice(String roomType, int nights) {
        double pricePerNight;
        if (roomType.equalsIgnoreCase("STANDARD")) {
            pricePerNight = 80;
        } else if (roomType.equalsIgnoreCase("DELUXE")) {
            pricePerNight = 120;
        } else if (roomType.equalsIgnoreCase("SUITE")) {
            pricePerNight = 200;
        } else {
            pricePerNight = 100;
        }
        return pricePerNight * nights;
    }
}

