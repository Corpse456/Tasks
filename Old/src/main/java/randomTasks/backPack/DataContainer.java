package randomTasks.backPack;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class DataContainer {


    private final static Integer[] usages = {10, 10, 23, 35, 30, 24, 36, 35, 40, 8, 4, 4, 8};
    final static List<Room> allRooms;
    final static List<Usage> ALL_USAGES = new ArrayList<>();

    static {
        final Room room3 = new Room(10, 3);
        final Room room4 = new Room(10, 4);
        final Room room5 = new Room(10, 5);
        final Room room30 = new Room(24, 30);
        final Room room34 = new Room(36, 34);

        final Room room14 = new Room(10, 14);
        final Room room13 = new Room(10, 13);
        final Room room12 = new Room(10, 12);
        final Room room32 = new Room(24, 32);
        final Room room36 = new Room(36, 36);

        final Room room17 = new Room(16, 17);
        final Room room18 = new Room(16, 18);
        final Room room37 = new Room(40, 37);
        final Room room23 = new Room(16, 23);
        final Room room24 = new Room(16, 24);
        final Room room39 = new Room(40, 39);
        final Room room41 = new Room(74, 41);
        final Room room19 = new Room(16, 19);
        final Room room22 = new Room(12, 22);
        final Room room38 = new Room(36, 38);
        final Room room43 = new Room(100, 43);

        final Room room6 = new Room(8, 6);
        final Room room11 = new Room(8, 11);
        final Room room7 = new Room(4, 7);
        final Room room8 = new Room(68, 8);
        final Room room10 = new Room(4, 10);
        final Room room40 = new Room(88, 40);
        final Room room42 = new Room(110, 42);
        final Room room20 = new Room(12, 20);
        final Room room21 = new Room(12, 21);
        final Room room33 = new Room(34, 33);
        final Room room44 = new Room(140, 44);

        final Room room46 = new Room(1000, 46);
        final Room room50 = new Room(1200, 50);

        room34.setBaseRooms(room30, room3);
        room30.setBaseRooms(room4, room5);

        room36.setBaseRooms(room32, room14);
        room32.setBaseRooms(room12, room13);

        room37.setBaseRooms(room18, room17);
        room39.setBaseRooms(room23, room24);
        room41.setBaseRooms(room37, room39);
        room38.setBaseRooms(room19, room22);
        room43.setBaseRooms(room38, room41);
        room40.setBaseRooms(room7, room8, room10);
        room42.setBaseRooms(room6, room11, room40);
        room33.setBaseRooms(room21, room20);
        room44.setBaseRooms(room33, room42);
        room46.setBaseRooms(room43, room44);
        room50.setBaseRooms(room34, room36, room46);

        allRooms = asList(room34, room30, room4, room5, room3, room36, room32, room12, room13, room14, room50, room46,
                          room17, room18, room37, room23, room24, room39, room41, room19, room22, room38, room43, room6,
                          room11, room7, room8, room10, room40, room42, room20, room21, room33, room44);

        for (int i = 0; i < usages.length; i++) {
            ALL_USAGES.add(new Usage(i + 1, usages[i]));
        }
    }
}
