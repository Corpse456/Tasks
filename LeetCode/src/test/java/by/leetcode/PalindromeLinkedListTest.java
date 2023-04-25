package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeLinkedListTest {

    private final PalindromeLinkedList palindrome = new PalindromeLinkedList();

    @ParameterizedTest
    @MethodSource("lists")
    void isPalindrome(final ListNode node, boolean expectedResult) {
        final var result = palindrome.isPalindrome(node);

        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> lists() {
        return Stream.of(
                Arguments.of(new ListNode(1, 2), false),
                Arguments.of(new ListNode(1, 2, 2, 1), true),
                Arguments.of(new ListNode(1, 2, 3, 2, 1), true),
                Arguments.of(new ListNode(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1), true),
                Arguments.of(new ListNode(1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 2, 1), false)
                        );
    }
}
