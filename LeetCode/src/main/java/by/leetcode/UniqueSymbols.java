package by.leetcode;

import java.util.LinkedList;

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

public interface UniqueSymbols {

    int lengthOfLongestSubstring(String s);
}

class UniqueSymbolsQue implements UniqueSymbols {

    public int lengthOfLongestSubstring(String s) {
        var maxLength = 0;

        var currentList = new LinkedList<>();
        for (var c : s.toCharArray()) {
            while (currentList.contains(c)) {
                currentList.poll();
            }
            currentList.offer(c);
            maxLength = Math.max(maxLength, currentList.size());
        }

        return maxLength;
    }
}

class UniqueSymbolsArray implements UniqueSymbols {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cache[s.charAt(i)] > 0) {
                j = Math.max(j, cache[s.charAt(i)]);
            }
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}



