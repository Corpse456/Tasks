package game;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Analyzer {

    private static final int DIGITS_AMOUNT = 10;

    private final Matrix matrix;

    private final int numbersLength;

    private final List<List<String>> possibleOptions;

    private List<UserAnswer> previousGuesses;

    public Analyzer(final Matrix matrix, final int numbersLength) {
        this.matrix = matrix;
        this.numbersLength = numbersLength;
        possibleOptions = initializePossibleOptions();
        previousGuesses = new ArrayList<>();
    }

    public void analyze(final String nextGuess, final int bullsAmount, final int cowsAmount) {
        previousGuesses.add(new UserAnswer(nextGuess, bullsAmount, cowsAmount));
        if (cowsAmount == 0 && bullsAmount == 0) {
            removeRedundant(nextGuess);
        }
        if (cowsAmount > 0 && bullsAmount == 0) {
            removeRedundantInPositions(nextGuess);
        }
        if (cowsAmount + bullsAmount == numbersLength) {
            //TODO remove all digits with is not contains in this guess
//            removeRedundantInPositions(nextGuess);
        }
        analyzePreviousGuess();
    }

    private void analyzePreviousGuess() {
        final var currentPossibleOptions = cloneList(possibleOptions);
        for (final UserAnswer previousGuess : previousGuesses) {
            final Map<String, Answer> matchedAnswers = new HashMap<>();
            final var guess = previousGuess.getGuess();
            final var bullsCows = previousGuess.getBullsCows();
            tryToPutBullsCows(matchedAnswers, bullsCows, guess, 0);
        }
    }

    private void tryToPutBullsCows(final Map<String, Answer> matchedAnswers, final List<Answer> bullsCows,
            final String guess, final int index) {
        if (index == bullsCows.size()) {
            return;
        }
        for (int i = 0; i < guess.length(); i++) {
            putInMatchers(matchedAnswers, bullsCows.get(index), guess.charAt(i) + "");
            tryToPutBullsCows(matchedAnswers, bullsCows, guess, index + 1);
        }
    }

    private void putInMatchers(final Map<String, Answer> matchedAnswers, final Answer answer, final String number) {
        if (!matchedAnswers.containsKey(number)) {
            matchedAnswers.put(number, answer);
        }
    }

    private void removeRedundantInPositions(final String nextGuess) {
        matrix.removeRedundantInPositions(nextGuess);
        for (int i = 0; i < possibleOptions.size(); i++) {
            final int finalI = i;
            possibleOptions.get(i).removeIf(number -> number.equals(String.valueOf(nextGuess.charAt(finalI))));
        }
    }

    private void removeRedundant(final String nextGuess) {
        matrix.removeRedundant(nextGuess);
        for (final List<String> possibleOption : possibleOptions) {
            possibleOption.removeIf(nextGuess::contains);
        }
    }

    public String getNextGuess() {
        return matrix.getRandomFromMatrix();
    }

    private List<List<String>> initializePossibleOptions() {
        final var list = new ArrayList<List<String>>();
        for (int i = 0; i < numbersLength; i++) {
            final var integers = new ArrayList<String>();
            for (int j = 0; j < DIGITS_AMOUNT; j++) {
                integers.add(String.valueOf(j));
            }
            list.add(integers);
        }
        return list;
    }

    private List<List<String>> cloneList(final List<List<String>> lists) {
        final List<List<String>> clonedLists = new ArrayList<>();
        for (final List<String> list : lists) {
            clonedLists.add(new ArrayList<>(list));
        }
        return clonedLists;
    }

}
