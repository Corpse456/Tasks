package by.leetcode;

public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        var maxWealth = 0;
        for (final var account : accounts) {
            var currentWealth = 0;
            for (final var i : account) {
                currentWealth += i;
            }
            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }

        return maxWealth;
    }
}
