package randomTasks.backPack;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {

    @ToString.Exclude
    private Room superRoom;

    @ToString.Exclude
    private List<Room> baseRooms = new ArrayList<>();

    private int size;

    private int number;

    private Usage usage;

    private boolean booked;

    Room(final int size, final int number) {
        this.size = size;
        this.number = number;
    }

    void setBaseRooms(final Room... rooms) {
        for (final Room room : rooms) {
            room.setSuperRoom(this);
            baseRooms.add(room);
        }
    }

    void setUsage(final Usage usage) {
        this.usage = usage;
        usage.setStatus(Status.OK);
        usage.setRoom(this);
        setSuperRoomsBooked(this);
        setBaseRoomsBooked(this);
    }

    private void setSuperRoomsBooked(final Room room) {
        if (room != null) {
            room.setBooked(true);
            setSuperRoomsBooked(room.getSuperRoom());
        }
    }

    private void setBaseRoomsBooked(final Room room) {
        if (room != null) {
            room.setBooked(true);
            room.getBaseRooms().forEach(this::setBaseRoomsBooked);
        }
    }
}
