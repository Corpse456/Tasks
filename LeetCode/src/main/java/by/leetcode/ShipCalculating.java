package by.leetcode;

public class ShipCalculating {

    public int calculateShips(int[][] field) {
        var shipsAmount = 0;

        for (var i = 0; i < field.length; i++) {
            for (var j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1 && (i == 0 || field[i - 1][j] != 1) && (j == 0 || field[i][j - 1] != 1)) {
                    shipsAmount++;
                }
            }
        }
        return shipsAmount;
    }
}
