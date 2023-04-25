package by.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Дана строка, найти длину наибольшей подстроки, состоящей из уникальных символов.

Строка может содержать только маленькие буквы английского алфавита.

Пример: "abcdabc" → 4 ("abcd")

"abcabcbb" → 3 ("abc")
"bbbbb" → 1 ("b")
"zabcade" → 5 ("bcade")
"zabcazde" → 6 ("bcazde")
"abcdebaabcdefg" → 7("abcdefg")

*/

public class UniqueSymbols {

    public int lengthOfLongestSubstring(String s) {
        int notExisted = -1;
        int maxLength = 0;
        int startIndex = 0;
        Map<Character, Integer> characterToIndexMap = new HashMap<>();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            Integer currentIndex = characterToIndexMap.get(charArray[i]);
            if (currentIndex != null && currentIndex != notExisted) {
                maxLength = Math.max(maxLength, characterToIndexMap.size());

                Iterator<Map.Entry<Character, Integer>> entrySet = characterToIndexMap.entrySet().iterator();
                for (Iterator<Map.Entry<Character, Integer>> it = entrySet; it.hasNext(); ) {
                    final Map.Entry<Character, Integer> entry = it.next();
                    if (entry.getValue() <= currentIndex) {
                        it.remove();
                    }
                }
            }

            characterToIndexMap.put(charArray[i], i);
        }
        maxLength = Math.max(maxLength, characterToIndexMap.size());

        return maxLength;
    }
}



