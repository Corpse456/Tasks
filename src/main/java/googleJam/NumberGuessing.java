package googleJam;

public class NumberGuessing {

    private static int realAnswer;
    private static int a = 0;
    private static int b = 1000000000;
    private static int answer;
    private static int count;
    
    public static void main(String[] args) {
        int max = 100000000;
        for (int i = 1; i < max; i++) {
            realAnswer = i;
            count = 0;
            a = 0;
            b = max;
            trying(i);
            int percent = max / 100;
            if (i % percent == 0) {
                System.out.println(i / percent);
            }
        }
    }

    private static void trying(int i) {
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

    private static int findNumber(int a, int b) {
        /*System.out.printf("a: %d| b: %d\t",a,b);
        System.out.println(++count);*/
        count++;
        if (b == a + 1) return b;
        
        answer = (a + b) / 2;
        return answer + 1;
    }
    
    private static String check(int answer) {
        if (answer == realAnswer) return "CORRECT";
        else if (answer > realAnswer) return "TOO_BIG";
        else if (answer < realAnswer) return "TOO_SMALL";
        else return "WRONG_ANSWER";
    }
    
    private static boolean correct(String check, int i) {
        if ("CORRECT".equals(check)) {
            //System.out.println(i + ": Yept!");
            return true;
        }
        else if ("TOO_BIG".equals(check)) {
            b = answer - 1;
            return false;
        }
        else if ("TOO_SMALL".equals(check)) {
            a = answer;
            return false;
        }
        return false;
    }
}
