package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueSymbolsTest {

    private final UniqueSymbols uniqueSymbols = new UniqueSymbols();

    @ParameterizedTest
    @MethodSource("symbols")
    void lengthOfLongestSubstring(String string, int expectedResult) {
        // when
        final var result = uniqueSymbols.lengthOfLongestSubstring(string);

        // then
        assertEquals(expectedResult, result);
    }

    // given
    private static Stream<Arguments> symbols() {
        return Stream.of(
                Arguments.of("abcdabc", 4),
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("zabcade", 5),
                Arguments.of("zabcazde", 6),
                Arguments.of("abcdebaabcdefg", 7)
                        );
    }
}