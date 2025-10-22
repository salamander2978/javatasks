public class HotelManagementSystem {
    private RoomManager roomManager;
    private GuestManager guestManager;
    private BookingService bookingService;
    private ReportService reportService;

    public HotelManagementSystem() {
        this.roomManager = new RoomManager();
        this.guestManager = new GuestManager();
        
        PriceCalculator priceCalculator = new StandardPriceCalculator();
        NotificationService notificationService = new EmailService();
        
        this.bookingService = new BookingService(roomManager, guestManager, 
                                                  priceCalculator, notificationService);
        this.reportService = new ReportService(roomManager, guestManager);
    }

    public void addRoom(int roomNumber, String type) {
        roomManager.addRoom(roomNumber, type);
    }

    public void registerGuest(String name, String email) {
        guestManager.registerGuest(name, email);
    }

    public void bookRoom(String guest, int roomNumber, int nights) {
        bookingService.bookRoom(guest, roomNumber, nights);
    }

    public void checkout(String guest) {
        bookingService.checkout(guest);
    }

    public void printGuestSummary(String guest) {
        reportService.printGuestSummary(guest);
    }

    public void printAvailableRooms() {
        reportService.printAvailableRooms();
    }

    public void generateReport() {
        reportService.generateOccupancyReport();
    }

    public static void main(String[] args) {
        HotelManagementSystem hotel = new HotelManagementSystem();

        hotel.addRoom(101, "Standard");
        hotel.addRoom(102, "Deluxe");
        hotel.addRoom(201, "Suite");
        hotel.addRoom(202, "Standard");

        hotel.registerGuest("Alice", "alice@mail.com");
        hotel.registerGuest("Bob", "bob@mail.com");

        hotel.bookRoom("Alice", 101, 3);
        hotel.bookRoom("Bob", 201, 2);

        hotel.printAvailableRooms();
        hotel.printGuestSummary("Alice");
        hotel.generateReport();

        hotel.checkout("Alice");
        hotel.printAvailableRooms();
        hotel.generateReport();
    }
}
