package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberStepsToReduceTest {

    private final NumberStepsToReduce numberStepsToReduce = new NumberStepsToReduce();

    @ParameterizedTest
    @MethodSource("data")
    void numberOfSteps(final int number, int expectedResult) {
        // when
        final var result = numberStepsToReduce.numberOfSteps(number);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    // given
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(14, 6),
                Arguments.of(8, 4),
                Arguments.of(123, 12)
                        );
    }
}
