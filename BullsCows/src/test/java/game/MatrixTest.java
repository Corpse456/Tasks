package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void createMatrix() {
        final var numbersLength = 5;
        final var matrix = new Matrix(5);

        matrix.createMatrix();

        assertEquals(numbersLength, matrix.getNumbers().get(0).toString().length());
        assertEquals(numbersLength, matrix.getNumbers().get(matrix.getNumbers().size() - 1).toString().length());
    }
}
