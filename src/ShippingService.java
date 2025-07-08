class ShippingService {
    public static void processShipping(Shippable item, String address, int quantity) {
        item.ship(address, quantity);
    }
}