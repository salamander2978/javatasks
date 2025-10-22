public class BookingService {
    private RoomManager roomManager;
    private GuestManager guestManager;
    private PriceCalculator priceCalculator;
    private NotificationService notificationService;

    public BookingService(RoomManager roomManager, GuestManager guestManager, 
                          PriceCalculator priceCalculator, NotificationService notificationService) {
        this.roomManager = roomManager;
        this.guestManager = guestManager;
        this.priceCalculator = priceCalculator;
        this.notificationService = notificationService;
    }

    public void bookRoom(String guestName, int roomNumber, int nights) {
        if (!roomManager.roomExists(roomNumber)) {
            System.out.println("Room not found!");
            return;
        }

        Room room = roomManager.getRoom(roomNumber);
        if (!room.isAvailable()) {
            System.out.println("Room " + roomNumber + " is already booked!");
            return;
        }

        if (!guestManager.guestExists(guestName)) {
            System.out.println("Guest not found!");
            return;
        }

        Guest guest = guestManager.getGuest(guestName);
        double cost = priceCalculator.calculatePrice(room.getType(), nights);

        room.setAvailable(false);
        guest.addBooking(roomNumber, cost);

        System.out.println("Booked room " + roomNumber + " for " + guestName + 
                         " (" + nights + " nights) - $" + cost);

        notificationService.sendNotification(guest.getEmail(), 
            "Booking confirmation for room " + roomNumber + ". Total: $" + cost);
    }

    public void checkout(String guestName) {
        if (!guestManager.guestExists(guestName)) {
            System.out.println("Guest not found!");
            return;
        }

        Guest guest = guestManager.getGuest(guestName);
        
        for (int roomNumber : guest.getBookedRooms()) {
            Room room = roomManager.getRoom(roomNumber);
            if (room != null) {
                room.setAvailable(true);
            }
        }

        double total = guest.getTotalBill();
        System.out.println("Guest " + guestName + " checked out. Total bill: $" + total);
        
        notificationService.sendNotification(guest.getEmail(), 
            "Thank you for staying with us! Your total bill: $" + total);
        
        guest.clearBookings();
    }
}
