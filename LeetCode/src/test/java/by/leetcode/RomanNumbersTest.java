package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumbersTest {

    private final RomanNumbers romanNumbers = new RomanNumbers();

    @ParameterizedTest
    @MethodSource("numbers")
    void convertFromRoman(String romanNumber, int greekNumber) {
        final var result = romanNumbers.convertFromRoman(romanNumber);

        assertEquals(greekNumber, result);
    }

    private static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of("XV", 15),
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994)
                        );
    }
}
