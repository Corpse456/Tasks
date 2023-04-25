package by.leetcode;

import java.util.TreeSet;

public class WeakestRowsMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        var rows = mat.length;

        var scores = new TreeSet<Integer>();
        for (var i = 0; i < rows; i++) {
            scores.add(countSoldier(mat[i]) * rows + i);
        }

        return scores.stream().limit(k).mapToInt(score -> score % rows).toArray();
    }

    private int countSoldier(int[] arr) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
