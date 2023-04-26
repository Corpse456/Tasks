package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianOfTwoSortedArraysTest {

    private final MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();

    @ParameterizedTest
    @MethodSource("arrays")
    void findMedianSortedArrays(int[] nums1, int[] nums2, double expectedResult) {
        // when
        final var result = median.findMedianSortedArrays(nums1, nums2);

        // then
        assertEquals(expectedResult, result);
    }

    // given
    private static Stream<Arguments> arrays() {
        return Stream.of(
                Arguments.of(new int[] { 1, 3 }, new int[] { 2 }, 2),
                Arguments.of(new int[] { 1, 2 }, new int[] { 3, 4 }, 2.5),
                Arguments.of(new int[] { 0, 1, 2, 3, 5, 6, 7, 8, 9 }, new int[] { 4 }, 4.5),
                Arguments.of(new int[] { 4 }, new int[] { 0, 1, 2, 3, 5, 6, 7, 8, 9 }, 4.5),
                Arguments.of(new int[] {}, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 4.5),
                Arguments.of(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, new int[] {}, 4.5),
                Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, new int[] {}, 5)
                        );
    }
}
