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

public class UniqueSymbols {

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



