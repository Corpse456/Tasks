package pvt.notebook1.Task17_18;

public class WordFinder {
    public static void main(String[] args) {
        String s = "A comparison function, which imposes ";
        int wordNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                wordNumber++;
                while (Character.isAlphabetic(s.charAt(++i)));
            }
        }
        System.out.println("wordNumber = " + wordNumber);
    }
}