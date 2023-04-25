package by.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraysCommonTest {

    private final ArraysCommon arraysCommon = new ArraysCommon();

    @Test
    void findCommon() {
        // given
        int expectedCommon = 4;
        int[] a = { 1, 2, 4, 5 };
        int[] b = { 3, 3, 4 };
        int[] c = { 2, 3, 4, 5, 6 };

        // when
        final var common = arraysCommon.findCommon(a, b, c);

        // then
        assertEquals(expectedCommon, common);
    }
}
