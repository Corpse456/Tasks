package by.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {

    private static final Map<Character, Integer> romanGreeksMap = generateMap();

    public int convertFromRoman(String romanNumber) {
        final var chars = romanNumber.toCharArray();
        var result = romanGreeksMap.get(chars[chars.length - 1]);
        ;
        for (var i = chars.length - 2; i >= 0; i--) {
            final var currentNumber = romanGreeksMap.get(chars[i]);
            if (currentNumber < romanGreeksMap.get(chars[i + 1])) {
                result -= currentNumber;
            } else {
                result += currentNumber;
            }
        }
        return result;
    }

    private static Map<Character, Integer> generateMap() {
        final var map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
}
