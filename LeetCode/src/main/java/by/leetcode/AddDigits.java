package by.leetcode;

import java.util.ArrayList;

/**
 * 258. Add Digits
 * Companies
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 */
public class AddDigits {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        var digits = new ArrayList<Integer>();
        while (num >= 10) {
            digits.add(num % 10);
            num = num / 10;
        }
        digits.add(num);
        return addDigits(digits.stream().mapToInt(Integer::intValue).sum());
    }
}
