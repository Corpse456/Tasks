package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddDigitsTest {

    private final AddDigits addDigits = new AddDigits();

    @ParameterizedTest
    @MethodSource("numbers")
    void addDigits(int number, int expectedResult) {
        // when
        final var result = addDigits.addDigits(number);

        // then
        assertEquals(expectedResult, result);
    }

    // given
    private static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(38, 2),
                Arguments.of(0, 0),
                Arguments.of(234, 9),
                Arguments.of(1234, 1),
                Arguments.of(12345, 6),
                Arguments.of(999999999, 9)
                        );
    }
}
