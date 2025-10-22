public class ReportService {
    private RoomManager roomManager;
    private GuestManager guestManager;

    public ReportService(RoomManager roomManager, GuestManager guestManager) {
        this.roomManager = roomManager;
        this.guestManager = guestManager;
    }

    public void printGuestSummary(String guestName) {
        Guest guest = guestManager.getGuest(guestName);
        if (guest == null) {
            System.out.println("Guest not found!");
            return;
        }

        System.out.println("=== Guest Summary ===");
        System.out.println("Guest: " + guest.getName());
        System.out.println("Email: " + guest.getEmail());
        System.out.println("Booked rooms: " + guest.getBookedRooms());
        System.out.println("Total bill: $" + guest.getTotalBill());
        System.out.println("=====================");
    }

    public void printAvailableRooms() {
        System.out.println("=== Available Rooms ===");
        for (Room room : roomManager.getAllRooms().values()) {
            if (room.isAvailable()) {
                System.out.println("Room " + room.getRoomNumber() + " (" + room.getType() + ")");
            }
        }
        System.out.println("=======================");
    }

    public void generateOccupancyReport() {
        System.out.println("=== Hotel Occupancy Report ===");
        int totalRooms = roomManager.getAllRooms().size();
        long occupied = roomManager.getAllRooms().values().stream()
                .filter(room -> !room.isAvailable())
                .count();
        System.out.println("Total rooms: " + totalRooms);
        System.out.println("Occupied: " + occupied);
        System.out.println("Available: " + (totalRooms - occupied));
        System.out.println("===============================");
    }
}

