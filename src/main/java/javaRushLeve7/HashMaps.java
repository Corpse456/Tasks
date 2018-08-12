package javaRushLeve7;

import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args) throws Exception {
	HashMap<String, String> flora = new HashMap<String, String>();

	flora.put("арбуз", "ягода");
	flora.put("банан", "трава");
	flora.put("вишня", "ягода");
	flora.put("груша", "фрукт");
	flora.put("дыня", "овощ");
	flora.put("ежевика", "куст");
	flora.put("жень-шень", "корень");
	flora.put("земляника", "ягода");
	flora.put("ирис", "цветок");
	flora.put("картофель", "клубень");

	for (HashMap.Entry<String, String> pair : flora.entrySet()) {
	    String key = pair.getKey();
	    String value = pair.getValue();
	    System.out.println(key + " - " + value);
	}
    }
}