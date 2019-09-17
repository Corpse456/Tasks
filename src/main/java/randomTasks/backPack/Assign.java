package randomTasks.backPack;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static randomTasks.backPack.DataContainer.ALL_USAGES;
import static randomTasks.backPack.DataContainer.allRooms;

@Data
public class Assign {

    private static int counter = 0;
    private static List<Room> sortedRooms;
    private static List<Usage> registeredUsage = new ArrayList<>();

    public static void main(String[] args) {
        sortedRooms = sortAllRoom();
        ALL_USAGES.forEach(Assign::assign);
    }

    private static void assign(final Usage usage) {
        sortedRooms.forEach(r -> r.setBooked(false));
        if (usage != null) {
            registeredUsage.add(usage);
        }
        final List<Usage> usages = new ArrayList<>(registeredUsage);
        usages.sort(Comparator.comparing(Usage::getSize).reversed());

        if (!assignAllAllocations(usages)) {
            System.out.println("!!!!!!!!!!" + usage + " cannot be approved!!!!!!!!");
            counter--;
            usages.remove(usage);
            sortedRooms.forEach(r -> r.setBooked(false));
            assignAllAllocations(usages);
        }
    }

    private static boolean assignAllAllocations(final List<Usage> usages) {
        System.out.println("----------------" + ++counter + "---------------------");
        for (final Usage usage : usages) {
            findRoom(usage, sortedRooms);
            if (usage.getStatus() != Status.OK) {
                final List<Room> rooms = new ArrayList<>(sortedRooms);
                rooms.forEach(r -> r.setBooked(false));
                usages.forEach(u -> u.setRoom(null));
                Collections.reverse(rooms);
                tryToChange(usages, rooms);
                if (usage.getStatus() != Status.OK) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void findRoom(final Usage usage, final List<Room> sortedRooms) {
        for (Room room : sortedRooms) {
            if (room.getSize() >= usage.getSize() && !room.isBooked()) {
                room.setUsage(usage);
                System.out.println(usage + " assigned to room #" + room);
                return;
            }
        }
        usage.setStatus(Status.NO);
    }

    private static void tryToChange(final List<Usage> usages, final List<Room> rooms) {
        System.out.println("----------------" + counter + "---------------------");
        for (final Usage usage : usages) {
            findRoom(usage, rooms);
        }
    }

    private static List<Room> sortAllRoom() {
        final ArrayList<Room> rooms = new ArrayList<>();

        final List<Room> collect = allRooms.stream().filter(r -> r.getSuperRoom() == null).collect(toList());
        getTreeBranch(rooms, collect);

        return rooms;
    }

    private static void getTreeBranch(final List<Room> rooms, final List<Room> collect) {
        collect.sort(Comparator.comparing(Room::getSize));
        for (final Room room : collect) {
            if (!room.getBaseRooms().isEmpty()) {
                getTreeBranch(rooms, room.getBaseRooms());
            }
            rooms.add(room);
        }
    }
}
