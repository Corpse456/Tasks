package by.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 4. Median of Two Sorted Arrays
 * Companies
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var medianNumbers = new ArrayList<Integer>();
        var commonMiddle = getMiddle(nums1.length, nums2.length);
        int index1 = 0, index2 = 0, commonIndex = 0;
        while (commonIndex <= commonMiddle.getLast()) {
            if (index2 == nums2.length || (index1 != nums1.length && nums1[index1] < nums2[index2])) {
                if (commonMiddle.contains(commonIndex)) {
                    medianNumbers.add(nums1[index1]);
                }
                index1++;
            } else {
                if (commonMiddle.contains(commonIndex)) {
                    medianNumbers.add(nums2[index2]);
                }
                index2++;
            }
            commonIndex++;
        }
        return medianNumbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    private LinkedList<Integer> getMiddle(final int nums1Length, final int nums2Length) {
        final var list = new LinkedList<Integer>();
        final var commonLength = nums1Length + nums2Length;
        final var middle = commonLength / 2;
        if (commonLength % 2 == 0) {
            list.add(middle - 1);
        }
        list.add(middle);
        return list;
    }
}
