package game;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Analyzer {

    private final Matrix matrix;

    private final int numbersLength;

    public void analyze(final int nextGuess, final int bullsAmount, final int cowsAmount) {
        if (cowsAmount == 0 && bullsAmount == 0) {
            matrix.removeRedundant(nextGuess);
        }
        if (cowsAmount > 0 && bullsAmount == 0) {
            matrix.removeRedundantInPositions(nextGuess);
        }
    }

    public int getNextGuess() {
        return matrix.getRandomFromMatrix();
    }
}
