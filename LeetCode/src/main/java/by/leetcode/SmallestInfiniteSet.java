package by.leetcode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * 2336. Smallest Number in Infinite Set
 * <p>
 * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
 * <p>
 * Implement the SmallestInfiniteSet class:
 * <p>
 * SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
 * int popSmallest() Removes and returns the smallest integer contained in the infinite set.
 * void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
 * [[], [2], [], [], [], [1], [], [], []]
 * Output
 * [null, null, 1, 2, 3, null, 1, 4, 5]
 * <p>
 * Explanation
 * SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
 * smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
 * smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
 * smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
 * smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
 * smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
 * smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
 * // is the smallest number, and remove it from the set.
 * smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
 * smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 1000
 * At most 1000 calls will be made in total to popSmallest and addBack.
 */
public class SmallestInfiniteSet {

    private final LinkedList<Integer> set;

    public SmallestInfiniteSet() {
        set = new LinkedList<>();
        set.offer(1);
    }

    public int popSmallest() {
        final int smallest = Objects.requireNonNull(set.poll());
        if (set.size() == 0) {
            set.offer(smallest + 1);
        }
        return smallest;
    }

    public void addBack(int num) {
        if (num < set.getFirst()) {
            set.offerFirst(num);
        } else if (set.getLast() > num) {
            for (int i = 1; i < set.size(); i++) {
                if (set.get(i) > num && set.get(i - 1) < num) {
                    set.add(i, num);
                }
            }
        }
    }
}
