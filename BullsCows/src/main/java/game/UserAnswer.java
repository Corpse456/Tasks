package game;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserAnswer {

    private final String guess;

    private final List<Answer> bullsCows;

    public UserAnswer(final String nextGuess, final int bullsAmount, final int cowsAmount) {
        this.guess = nextGuess;
        bullsCows = new ArrayList<>();
        for (int i = 0; i < bullsAmount; i++) {
            bullsCows.add(Answer.BULL);
        }
        for (int i = 0; i < cowsAmount; i++) {
            bullsCows.add(Answer.COW);
        }
    }
}
