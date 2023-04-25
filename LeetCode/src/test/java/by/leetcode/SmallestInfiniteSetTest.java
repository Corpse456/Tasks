package by.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestInfiniteSetTest {

    @Test
    void checkInfinite() {
        // given
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();

        // when
        smallestInfiniteSet.addBack(2);
        var smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(1, smallest);

        // when
        smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(2, smallest);

        // when
        smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(3, smallest);

        // when
        smallestInfiniteSet.addBack(1);
        smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(1, smallest);

        // when
        smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(4, smallest);

        // when
        smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(5, smallest);
    }

    @Test
    void checkInfinite2() {
        // given
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();

        // when
        var smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(1, smallest);

        // when
        smallestInfiniteSet.addBack(1);
        smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(1, smallest);

        // when
        smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(2, smallest);

        // when
        smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(3, smallest);

        // when
        smallestInfiniteSet.addBack(2);
        smallestInfiniteSet.addBack(3);
        smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(2, smallest);

        // when
        smallest = smallestInfiniteSet.popSmallest();
        // then
        assertEquals(3, smallest);
    }
}
