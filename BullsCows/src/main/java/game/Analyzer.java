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
            removeAllExcept(nextGuess);
        }
        analyzePreviousGuess();
    }

    private void analyzePreviousGuess() {
        for (final UserAnswer previousGuess : previousGuesses) {
            final Map<String, Answer> matchedAnswers = new HashMap<>();
            final var guess = previousGuess.getGuess();
            final var bullsCows = previousGuess.getBullsCows();
            tryToPutBullsCows(possibleOptions, matchedAnswers, bullsCows, guess, 0);
        }
    }

    private boolean tryToPutBullsCows(List<List<String>> possibleOptions, final Map<String, Answer> matchedAnswers,
            final List<Answer> bullsCows, final String guess, final int index) {
        final var currentPossibleOptions = cloneList(possibleOptions);
        if (index == bullsCows.size()) {
            return false;
        }
        for (int i = 0; i < guess.length(); i++) {
            final var number = String.valueOf(guess.charAt(i));
            if (!putInMatchers(matchedAnswers, bullsCows.get(index), number)) {
                continue;
            }
            removeRedundantFromPosition(number, i, currentPossibleOptions);
            if (isConflictOptions(currentPossibleOptions)) {
                return false;
            }
            if (!tryToPutBullsCows(currentPossibleOptions, matchedAnswers, bullsCows, guess, index + 1)) {
                break;
            }
        }
        return true;
    }

    private boolean isConflictOptions(final List<List<String>> currentPossibleOptions) {
        return currentPossibleOptions.stream().anyMatch(List::isEmpty);
    }

    private boolean putInMatchers(final Map<String, Answer> matchedAnswers, final Answer answer, final String number) {
        if (!matchedAnswers.containsKey(number)) {
            matchedAnswers.put(number, answer);
            return true;
        }
        return false;
    }

    private void removeRedundantInPositions(final String nextGuess) {
        matrix.removeRedundantInPositions(nextGuess);
        for (int i = 0; i < possibleOptions.size(); i++) {
            final var guessNumber = String.valueOf(nextGuess.charAt(i));
            possibleOptions.get(i).removeIf(guessNumber::equals);
        }
    }

    private void removeRedundantFromPosition(final String number, final int position,
            final List<List<String>> possibleOptions) {
        //        matrix.removeRedundantInPositions(nextGuess);
        possibleOptions.get(position).removeIf(anObject -> !number.equals(anObject));
    }

    private void removeRedundant(final String nextGuess) {
        matrix.removeRedundant(nextGuess);
        for (final List<String> possibleOption : possibleOptions) {
            possibleOption.removeIf(nextGuess::contains);
        }
    }

    private void removeAllExcept(final String nextGuess) {
        final List<String> digitsList = getDigitsList();
        digitsList.removeIf(nextGuess::contains);
        removeRedundant(String.join("", digitsList));
    }

    public String getNextGuess() {
        return matrix.getRandomFromMatrix();
    }

    private List<List<String>> initializePossibleOptions() {
        final var list = new ArrayList<List<String>>();
        for (int i = 0; i < numbersLength; i++) {
            list.add(getDigitsList());
        }
        return list;
    }

    private List<String> getDigitsList() {
        final var integers = new ArrayList<String>();
        for (int j = 0; j < DIGITS_AMOUNT; j++) {
            integers.add(String.valueOf(j));
        }
        return integers;
    }

    private List<List<String>> cloneList(final List<List<String>> lists) {
        final List<List<String>> clonedLists = new ArrayList<>();
        for (final List<String> list : lists) {
            clonedLists.add(new ArrayList<>(list));
        }
        return clonedLists;
    }

}
