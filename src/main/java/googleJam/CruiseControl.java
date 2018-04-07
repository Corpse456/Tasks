import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) {
        Map<Integer, Integer> horses = new HashMap<>();
        horses.put(120, 60);
        horses.put(60, 90);
        
		cruiseControl(300, horses);
	}
   
    public static void cruiseControl(int dest, Map<Integer, Integer> horses) {
        double slowly = 0;
        
        for (Entry<Integer, Integer> entry : horses.entrySet()) {
            double value = (dest - entry.getKey()) / (double) entry.getValue();
            if (value > slowly) slowly = value;
        }
       
        double optimal = dest / slowly;
        System.out.println(optimal);
	}
}
