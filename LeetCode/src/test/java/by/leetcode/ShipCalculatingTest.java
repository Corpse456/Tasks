package by.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipCalculatingTest {

    private final ShipCalculating shipCalculating = new ShipCalculating();

    @Test
    void calculateShips() {
        // given
        int expectedShipsAmount = 6;
        int[][] field = new int[][] {
                { 1, 1, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 1, 0 },
                { 1, 0, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0 }
        };

        // when
        final var ships = shipCalculating.calculateShips(field);

        // then
        assertEquals(expectedShipsAmount, ships);
    }
}
