package pvt.notebook1.javaHelp;

public class Number2 {
    
    private static final String[][] view = {
	    {"  000  ", "   1   ", "  222  ", "  333  ", "    4  ", " 55555 ", "  666  ", " 77777 ", "  888  ", "  999  "},
	    {" 0   0 ", "  11   ", " 2   2 ", " 3   3 ", "   44  ", " 5     ", " 6   6 ", "     7 ", " 8   8 ", " 9   9 "},
	    {"0     0", " 1 1   ", " 2   2 ", "     3 ", "  4 4  ", " 5     ", " 6     ", "    7  ", " 8   8 ", " 9   9 "},
	    {"0     0", "   1   ", "    2  ", "  333  ", " 4  4  ", " 5555  ", " 6666  ", "   7   ", "  888  ", "  9999 "},
	    {"0     0", "   1   ", "   2   ", "     3 ", " 44444 ", "     5 ", " 6   6 ", "  7    ", " 8   8 ", "     9 "},
	    {" 0   0 ", "   1   ", "  2    ", " 3   3 ", "    4  ", " 5   5 ", " 6   6 ", "  7    ", " 8   8 ", "     9 "},
	    {"  000  ", " 11111 ", " 22222 ", "  333  ", "    4  ", "  555  ", "  666  ", "  7    ", "  888  ", "  999  "}};

    public static void main(String[] args) {

	System.out.print("Please input the number: ");

        int[] digits = GetInt.get();

        print(digits);
    }

    /**
     * @param digits
     */
    private static void print(int[] digits) {
	for (int line = 0; line < 7; line++) {
            for (int j = 0; j < digits.length; j++) {
                System.out.print(view[line][digits[j]]);
            }
            System.out.println();
        }
    }

}
