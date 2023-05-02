package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static by.leetcode.Point.points;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class YandexVerticalSymLineTest {

    abstract YandexVerticalSymLine cinema();

    @ParameterizedTest
    @MethodSource("source")
    void hasVerticalSymLine(Point[] points, boolean expectedResult) {
        // when
        final var result = cinema().hasVerticalSymLine(points);

        // then
        assertEquals(expectedResult, result);
    }

    // given
    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(points(1, 3, 5, 3, 4, 3, 2, 3, 0, 3, 6, 3), true),
                Arguments.of(points(1, 3, 5, 3, 4, 2, 2, 2, 0, 4, 6, 4), true),
                Arguments.of(points(6, 3, 5, 3, 4, 2, 2, 2, 0, 4, 6, 4), false),
                Arguments.of(points(5, 3, 4, 3, 2, 3, 0, 3, 6, 3), false)
                        );
    }
}

class YandexVerticalSymLineMyTest extends YandexVerticalSymLineTest {

    @Override
    YandexVerticalSymLine cinema() {
        return new YandexVerticalSymLineMy();
    }
}

class YandexVerticalSymLineOptimalTest extends YandexVerticalSymLineTest {

    @Override
    YandexVerticalSymLine cinema() {
        return new YandexVerticalSymLineOptimal();
    }
}
