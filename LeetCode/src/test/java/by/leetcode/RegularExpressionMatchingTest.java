package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegularExpressionMatchingTest {

    private final RegularExpressionMatching matcher = new RegularExpressionMatching();

    @ParameterizedTest
    @MethodSource("strings")
    void isMatch(String string, String pattern, boolean expectedResult) {
        // when
        final var result = matcher.isMatch(string, pattern);

        // then
        assertEquals(expectedResult, result);
    }

    // given
    private static Stream<Arguments> strings() {
        return Stream.of(
                Arguments.of("aa", "a", false),
                Arguments.of("aa", "a*", true),
                Arguments.of("ab", ".*", true)
                        );
    }
}
