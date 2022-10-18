package game;

import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Data
public class UserConsoleService implements UserService {

    private final int numbersLength;

    public UserConsoleService(final int numbersLength) {
        this.numbersLength = numbersLength;
    }

    @Override
    public int readBulls() {
        return readAnswer("bulls");
    }

    @Override
    public int readCows() {
        return readAnswer("cows");
    }

    @Override
    public void printGuess(final String nextGuess) {
        System.out.printf("Your number is %s?%n", nextGuess);
    }

    @Override
    public void printAnswer(final String answer) {
        System.out.println("Your number is: " + answer);
    }

    private int readAnswer(final String subject) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var amount = -1;
        do {
            System.out.printf("Please, input %s amount: ", subject);
            try {
                final var line = reader.readLine();
                amount = Integer.parseInt(line);
            } catch (Exception ignore) {
            }
        } while (!correctAmount(amount));

        return amount;
    }

    private boolean correctAmount(final int bullsAmount) {
        return bullsAmount >= 0 && bullsAmount <= numbersLength;
    }

}
