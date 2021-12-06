package game;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@RequiredArgsConstructor
public class Matrix {

    private List<String> numbers;

    private final int numbersLength;

    private Random random = new Random();

    public void createMatrix() {
        numbers = new ArrayList<>();
        final var from = getFrom();
        final var to = getTo();
        for (int i = from; i < to + 1; i++) {
            final var iAsString = String.valueOf(i);
            if (withoutRepeats(iAsString) && zeroNotFirst(iAsString)) {
                numbers.add(iAsString);
            }
        }
    }

    public String getFirstValue() {
        return numbers.get(0);
    }

    public int size() {
        return numbers.size();
    }

    public String getRandomFromMatrix() {
        return numbers.get(random.nextInt(numbers.size()));
    }

    public void removeRedundant(final String guess) {
        final var guessAsChars = guess.toCharArray();

        numbers.removeIf(number -> {
            for (final char c : guessAsChars) {
                if (String.valueOf(number).contains(c + "")) {
                    return true;
                }
            }
            return false;
        });
    }

    public void removeRedundantInPositions(final String guess) {
        final var guessAsChars = guess.toCharArray();

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

    private static boolean withoutRepeats(final String number) {
        for (final char c : number.toCharArray()) {
            if (number.indexOf(c) != number.lastIndexOf(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean zeroNotFirst(final String number) {
        return number.charAt(0) != '0';
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
