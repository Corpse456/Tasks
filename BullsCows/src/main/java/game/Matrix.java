package game;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@RequiredArgsConstructor
public class Matrix {

    private List<Integer> numbers;

    private final int numbersLength;

    private Random random = new Random();

    public void createMatrix() {
        numbers = new ArrayList<>();
        final var from = getFrom();
        final var to = getTo();
        for (int i = from; i < to + 1; i++) {
            numbers.add(i);
        }
    }

    public int getFirstValue() {
        return numbers.get(0);
    }

    public int size() {
        return numbers.size();
    }

    public int getRandomFromMatrix() {
        return numbers.get(random.nextInt(numbers.size()));
    }

    public void removeRedundant(final int guess) {
        final var guessAsChars = String.valueOf(guess).toCharArray();

        numbers.removeIf(number -> {
            for (final char c : guessAsChars) {
                if (String.valueOf(number).contains(c + "")) {
                    return true;
                }
            }
            return false;
        });
    }

    public void removeRedundantInPositions(final int guess) {
        final var guessAsChars = String.valueOf(guess).toCharArray();

        numbers.removeIf(number -> {
            final var numberAsString = String.valueOf(number);
            for (int i = 0; i < guessAsChars.length; i++) {
                if (numberAsString.charAt(i) == guessAsChars[i]) {
                    return true;
                }
            }
            return false;
        });
    }

    private int getFrom() {
        return getIntLine("1");
    }

    private int getTo() {
        return getIntLine("9");
    }

    private int getIntLine(final String s) {
        return Integer.parseInt(s.repeat(Math.max(0, numbersLength)));
    }

}
