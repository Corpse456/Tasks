/*
 * Problem
This problem is a well-known classic; we present it primarily as an opportunity for you to try out the interactive judging system.
We are thinking of an integer P within the range (A,B] — that is, A < P ≤ B. You have N tries to guess our number. After each guess that is not correct, we will tell you whether P is higher or lower than your guess.

Input and output
This problem is interactive, which means that the concepts of input and output are different than in standard Code Jam problems. You will interact with a separate process that both provides you with information and evaluates your responses. All information comes into your program via standard input; anything that you need to communicate should be sent via standard output. Remember that many programming languages buffer the output by default, so make sure your output actually goes out (for instance, by flushing the buffer) before blocking to wait for a response. See the FAQ for an explanation of what it means to flush the buffer. Anything your program sends through standard error is ignored, but it might consume some memory and be counted against your memory limit, so do not overflow it. To help you debug, a local testing tool script (in Python) is provided at the very end of the problem statement.
Initially, your program should read a single line containing a single integer T indicating the number of test cases. Then, you need to process T test cases.
For each test case, your program will read a single line with two integers A and B, representing the exclusive lower bound and inclusive upper bound, as described above. In the next line, you will read a single integer N, representing the maximum number of guesses you can make. Your program will process up to N exchanges with our judge.
For each exchange, your program needs to use standard output to send a single line with one integer Q: your guess. In response to your guess, the judge will print a single line with one word to your input stream, which your program must read through standard input. The word will be CORRECT if your guess is correct, TOO_SMALL if your guess is less than the correct answer, and TOO_BIG if your guess is greater than the correct answer. Then, you can start another exchange.
If your program gets something wrong (e.g., wrong output format, or out-of-bounds values), the judge will send WRONG_ANSWER to your input stream and it will not send any other output after that. If your program continues to wait for the judge after receiving WRONG_ANSWER, your program will time out, resulting in a Time Limit Exceeded error. Notice that it is your responsibility to have your program exit in time to receive the appropriate verdict (Wrong Answer, Runtime Error, etc.) instead of a Time Limit Exceeded error. As usual, if the total time or memory is exceeded, or your program gets a runtime error, you will receive the appropriate verdict.
If your test case is solved within N tries, you will receive the CORRECT message from the judge, as mentioned above, and then continue to get input (a new line with two integers A and B, etc.) for the next test case. After N tries, if the test case is not solved, the judge will print WRONG_ANSWER and then stop sending output to your input stream.
You should not send additional information to the judge after solving all test cases. In other words, if your program keeps printing to standard output after receiving CORRECT for the last test case, you will get a Wrong Answer judgment.
 */
package googleJam;

public class NumberGuessing {

    private static int realAnswer;
    private static int a = 0;
    private static int b = 1000000000;
    private static int answer;
    private static int count;

    public static void main (String[] args) {
        int max = 10;
        for (int i = 1; i < max; i++) {
            realAnswer = i;
            count = 0;
            a = 0;
            b = max;
            trying(i);
            int percent = max / 100;
            if (max > 100 && i % percent == 0) {
                System.out.println(i / percent);
            }
        }
    }

    private static void trying (int i) {
        boolean find = false;
        do {
            answer = findNumber(a, b);
            String check = check(answer);
            find = correct(check, i);
        } while (!find);

        if (count > 30) {
            System.out.println(realAnswer);
            System.exit(0);
        }
    }

    private static int findNumber (int a, int b) {
        /*
         * System.out.printf("a: %d| b: %d\t",a,b); System.out.println(++count);
         */
        count++;
        if (b == a + 1) return b;

        answer = (a + b) / 2;
        return answer + 1;
    }

    private static String check (int answer) {
        if (answer == realAnswer) return "CORRECT";
        else if (answer > realAnswer) return "TOO_BIG";
        else if (answer < realAnswer) return "TOO_SMALL";
        else return "WRONG_ANSWER";
    }

    private static boolean correct (String check, int i) {
        if ("CORRECT".equals(check)) {
            System.out.println(i + ": Yept!");
            return true;
        } else if ("TOO_BIG".equals(check)) {
            b = answer - 1;
            return false;
        } else if ("TOO_SMALL".equals(check)) {
            a = answer;
            return false;
        }
        return false;
    }
}
