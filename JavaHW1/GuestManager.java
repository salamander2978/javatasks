import java.util.HashMap;
import java.util.Map;

public class GuestManager {
    private Map<String, Guest> guests;

    public GuestManager() {
        this.guests = new HashMap<>();
    }

    public void registerGuest(String name, String email) {
        Guest guest = new Guest(name, email);
        guests.put(name, guest);
        System.out.println("Registered guest: " + name);
    }

    public Guest getGuest(String name) {
        return guests.get(name);
    }

    public boolean guestExists(String name) {
        return guests.containsKey(name);
    }
}

