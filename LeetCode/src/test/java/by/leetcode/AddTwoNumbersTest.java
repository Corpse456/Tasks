package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class AddTwoNumbersTest {

    private final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @ParameterizedTest
    @MethodSource("data")
    void addTwoNumbers(ListNode l1, ListNode l2, ListNode expectedResult) {
        // when
        final var result = addTwoNumbers.addTwoNumbers(l1, l2);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    // given
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new ListNode(2, 4, 3), new ListNode(5, 6, 4), new ListNode(7, 0, 8)),
                Arguments.of(new ListNode(0), new ListNode(0), new ListNode(0)),
                Arguments.of(new ListNode(9, 9, 9, 9, 9, 9, 9), new ListNode(9, 9, 9, 9),
                        new ListNode(8, 9, 9, 9, 0, 0, 0, 1))
                        );
    }
}
