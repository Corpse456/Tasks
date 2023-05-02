package by.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class PathExistsInGraphTest {

    abstract PathExistsInGraph pathExaminer();

    @ParameterizedTest
    @MethodSource("source")
    void validPath(int n, int[][] edges, int source, int destination, boolean expectedResult) {
        // when
        final var result = pathExaminer().validPath(n, edges, source, destination);

        // then
        assertEquals(expectedResult, result);
    }

    // given
    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }, 0, 2, true),
                Arguments.of(6, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } }, 0, 5, false)
                        );
    }
}

class PathExistsInGraphBFSTest extends PathExistsInGraphTest {

    @Override
    PathExistsInGraph pathExaminer() {
        return new PathExistsInGraphBFS();
    }
}

class PathExistsInGraphDFSTest extends PathExistsInGraphTest {

    @Override
    PathExistsInGraph pathExaminer() {
        return new PathExistsInGraphDFS();
    }
}
