package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryVectorTest {

    private final BinaryVector binaryVector = new BinaryVector();

    @ParameterizedTest
    @MethodSource("arraysWithAnswer")
    void findUnitsSeq(byte[] input, int expectedResult) {
        // when
        final var result = binaryVector.findUnitsSequential(input);

        // then
        assertEquals(expectedResult, result);
    }

    // given
    private static Stream<Arguments> arraysWithAnswer() {
        return Stream.of(
                Arguments.of(new byte[] { 1, 1, 0, 1, 1, 1 }, 3),
                Arguments.of(new byte[] { 1, 1, 1 }, 3),
                Arguments.of(new byte[] { 1, 1, 1, 1, 1, 1 }, 6),
                Arguments.of(new byte[] { 0, 0, 0 }, 0),
                Arguments.of(new byte[0], 0)
                        );
    }
}
