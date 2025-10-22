import java.util.HashMap;
import java.util.Map;

public class RoomManager {
    private Map<Integer, Room> rooms;

    public RoomManager() {
        this.rooms = new HashMap<>();
    }

    public void addRoom(int roomNumber, String type) {
        Room room = new Room(roomNumber, type);
        rooms.put(roomNumber, room);
        System.out.println("Added room " + roomNumber + " (" + type + ")");
    }

    public Room getRoom(int roomNumber) {
        return rooms.get(roomNumber);
    }

    public boolean roomExists(int roomNumber) {
        return rooms.containsKey(roomNumber);
    }

    public Map<Integer, Room> getAllRooms() {
        return rooms;
    }
}

