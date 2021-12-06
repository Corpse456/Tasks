package game;

import lombok.Data;

@Data
public class Game {

    private Matrix matrix;
    private UserConsoleService userConsoleService;
    private Analyzer analyzer;

    public Game() {
        final var numbersLength = 4;
        matrix = new Matrix(numbersLength);
        userConsoleService = new UserConsoleService(numbersLength);
        analyzer = new Analyzer(matrix, numbersLength);
    }

    public void start() {
        matrix.createMatrix();

        while (matrix.size() > 1) {
            final var nextGuess = analyzer.getNextGuess();
            userConsoleService.printGuess(nextGuess);

            final var bullsAmount = userConsoleService.readBulls();
            final var cowsAmount = userConsoleService.readCows();
            analyzer.analyze(nextGuess, bullsAmount, cowsAmount);
        }

        userConsoleService.printAnswer(matrix.getFirstValue());
    }

}
