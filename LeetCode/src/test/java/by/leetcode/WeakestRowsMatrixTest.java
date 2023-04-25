package by.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class WeakestRowsMatrixTest {

    private final WeakestRowsMatrix weakestRowsMatrix = new WeakestRowsMatrix();

    @Test
    void kWeakestRows() {
        // given
        int[] expectedRows = { 2, 0 };
        int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };

        // when
        final var weakestRows = weakestRowsMatrix.kWeakestRows(mat, 2);

        // then
        assertArrayEquals(expectedRows, weakestRows);
    }
}
