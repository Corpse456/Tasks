package game;

public interface UserService {

    int readBulls();

    int readCows();

    void printGuess(String nextGuess);

    void printAnswer(String answer);
}
