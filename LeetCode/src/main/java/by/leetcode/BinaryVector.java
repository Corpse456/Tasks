package by.leetcode;

public class BinaryVector {

    public int findUnitsSequential(byte[] array) {
        var maxSequential = 0;
        var currentSequential = 0;
        for (final var number : array) {
            if (number == 1) {
                currentSequential++;
            } else {
                currentSequential = 0;
            }
            if (currentSequential > maxSequential) {
                maxSequential = currentSequential;
            }
        }
        return maxSequential;
    }
}
