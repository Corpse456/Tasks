package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YandexCinemaTest {

    private final YandexCinema cinema = new YandexCinema();

    @ParameterizedTest
    @MethodSource("source")
    void findBestSeatDist(int[] seats, int expectedResult) {
        // when
        final var result = cinema.findBestSeatDist(seats);

        // then
        assertEquals(expectedResult, result);
    }

    // given
    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(new int[] { 1, 0, 0, 0, 1 }, 2),
                Arguments.of(new int[] { 1, 0, 0, 0, 0, 1 }, 2),
                Arguments.of(new int[] { 1, 0, 0, 0, 0, 0, 1 }, 3),
                Arguments.of(new int[] { 1, 0, 1, 0, 0, 1, 0, 0, 0, 1 }, 2),
                Arguments.of(new int[] { 1, 0, 1, 0, 1 }, 1),
                Arguments.of(new int[] { 1, 0, 0, 0 }, 3),
                Arguments.of(new int[] { 0, 0, 0, 1 }, 3)
                        );
    }
}
