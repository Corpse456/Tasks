package by.leetcode;

public class ArraysCommon {

    public int findCommon(int[] a, int[] b, int[] c) {
        int indexA = 0, indexB = 0, indexC = 0;
        while (indexA < a.length && indexB < b.length && indexC < c.length) {
            if (a[indexA] == b[indexB] && b[indexB] == c[indexC]) {
                return a[indexA];
            }
            while (a[indexA] < b[indexB] || a[indexA] < c[indexC]) {
                indexA++;
            }
            while (b[indexB] < a[indexA] || b[indexB] < c[indexC]) {
                indexB++;
            }
            while (c[indexC] < a[indexA] || c[indexC] < b[indexB]) {
                indexC++;
            }
        }
        return -1;
    }
}
