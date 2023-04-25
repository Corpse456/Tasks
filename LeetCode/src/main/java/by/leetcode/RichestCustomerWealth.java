package by.leetcode;

public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (final int[] account : accounts) {
            int currentWealth = 0;
            for (final int i : account) {
                currentWealth += i;
            }
            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }

        return maxWealth;
    }
}
