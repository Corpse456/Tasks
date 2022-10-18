package pvt.notebook1.patterns;

import java.util.HashMap;
import java.util.Map;

public class Task3 {

    public static void main (String[] args) {
        Logger log = Logger.getInstance();
        log.log("first");
        log.log("Second");
        log.log("last");
        log.log(10000);
        
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        
        log.log(map);
        
        try {
            int[] mass = new int[1];
            int t = mass[15];
            System.out.println(t);
        } catch (ArrayIndexOutOfBoundsException e) {
            log.log(e.getClass() + " " + e.getStackTrace()[0] + ": " + e.getMessage());
        }
    }
}
