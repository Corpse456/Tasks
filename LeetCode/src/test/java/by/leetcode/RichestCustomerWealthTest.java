package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RichestCustomerWealthTest {

    private final RichestCustomerWealth customerWealth = new RichestCustomerWealth();

    @ParameterizedTest
    @MethodSource("accounts")
    void maximumWealth(int[][] accounts, int expectedWealth) {
        // when
        final var result = customerWealth.maximumWealth(accounts);

        assertEquals(expectedWealth, result);
    }

    private static Stream<Arguments> accounts() {
        return Stream.of(
                Arguments.of(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }, 6),
                Arguments.of(new int[][] { { 1, 5 }, { 7, 3 }, { 3, 5 } }, 10),
                Arguments.of(new int[][] { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } }, 17)
                        );
    }
}
