package game;

import lombok.Data;

@Data
public class Game {

    private Matrix matrix;
    private UserService userService;
    private Analyzer analyzer;

    public Game() {
        final var numbersLength = 4;
        matrix = new Matrix(numbersLength);
        userService = new UserConsoleService(numbersLength);
        analyzer = new Analyzer(matrix, numbersLength);
    }

    public void start() {
        matrix.createMatrix();

        while (matrix.size() > 1) {
            final var nextGuess = analyzer.getNextGuess();
            userService.printGuess(nextGuess);

            final var bullsAmount = userService.readBulls();
            final var cowsAmount = userService.readCows();
            analyzer.analyze(nextGuess, bullsAmount, cowsAmount);
        }

        userService.printAnswer(matrix.getFirstValue());
    }

}
