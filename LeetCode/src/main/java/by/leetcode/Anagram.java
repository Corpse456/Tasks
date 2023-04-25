package by.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public boolean checkStrings(String first, String second) {
        var firstMap = getStringMap(first);
        var secondMap = getStringMap(second);

        return firstMap.equals(secondMap);
    }

    private Map<String, Integer> getStringMap(final String string) {
        Map<String, Integer> map = new HashMap<>();
        for (final var nextChar : string.toLowerCase().toCharArray()) {
            map.merge(String.valueOf(nextChar), 1, Integer::sum);
        }
        return map;
    }

}
