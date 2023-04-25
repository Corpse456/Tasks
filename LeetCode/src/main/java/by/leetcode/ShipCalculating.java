package by.leetcode;

public class ShipCalculating {

    public int calculateShips(int[][] field) {
        int shipsAmount = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1 && (i == 0 || field[i - 1][j] != 1) && (j == 0 || field[i][j - 1] != 1)) {
                    shipsAmount++;
                }
            }
        }
        return shipsAmount;
    }
}
