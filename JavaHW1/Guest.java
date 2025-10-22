import java.util.ArrayList;
import java.util.List;

public class Guest {
    private String name;
    private String email;
    private List<Integer> bookedRooms;
    private double totalBill;

    public Guest(String name, String email) {
        this.name = name;
        this.email = email;
        this.bookedRooms = new ArrayList<>();
        this.totalBill = 0.0;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Integer> getBookedRooms() {
        return bookedRooms;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void addBooking(int roomNumber, double cost) {
        bookedRooms.add(roomNumber);
        totalBill += cost;
    }

    public void clearBookings() {
        bookedRooms.clear();
        totalBill = 0.0;
    }
}

