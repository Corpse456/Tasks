package pvt.notebook1.javaHelp;

public class Number {

    public static void main(String[] args) {

	System.out.print("Please input the number: ");
	int[] number = GetInt.get();
	
	print(number);
    }

    private static void print(int[] number) {
	String output = new String();
	String one = new String();
	String two = new String();
	String thr = new String();
	String fou = new String();
	String fiv = new String();
	for (int j = 0; j < 5; j++) {
	    for (int i = 0; i < number.length; i++) {
		switch (number[i]) {
		case (0): {
		   one = "    00    ";
		   two = "   0  0   ";
		   thr = "   0  0   ";
		   fou = "   0  0   ";
		   fiv = "    00    ";
		    break;
		}
		case (1): {
		   one = "    11    ";
		   two = "   1 1    ";
		   thr = "     1    ";
		   fou = "     1    ";
		   fiv = "     1    ";
		    break;
		}
		case (2): {
		   one = "    22    ";
		   two = "   2  2   ";
		   thr = "      2   ";
		   fou = "     2    ";
		   fiv = "   2222   ";
		    break;
		}
		case (3): {
		   one = "   333    ";
		   two = "      3   ";
		   thr = "    333   ";
		   fou = "      3   ";
		   fiv = "   333    ";
		    break;
		}
		case (4): {
		   one = "   4  4   ";
		   two = "   4  4   ";
		   thr = "   4444   ";
		   fou = "      4   ";
		   fiv = "      4   ";
		    break;
		}
		case (5): {
		   one = "   5555   ";
		   two = "   5      ";
		   thr = "   5555   ";
		   fou = "      5   ";
		   fiv = "   555    ";
		    break;
		}
		case (6): {
		   one = "    666   ";
		   two = "   6      ";
		   thr = "   666    ";
		   fou = "   6  6   ";
		   fiv = "    66    ";
		    break;
		}
		case (7): {
		   one = "   7777   ";
		   two = "     7    ";
		   thr = "    7     ";
		   fou = "    7     ";
		   fiv = "    7     ";
		    break;
		}
		case (8): {
		   one = "    88    ";
		   two = "   8  8   ";
		   thr = "    88    ";
		   fou = "   8  8   ";
		   fiv = "    88    ";
		    break;
		}
		case (9): {
		   one = "    99    ";
		   two = "   9  9   ";
		   thr = "    999   ";
		   fou = "      9   ";
		   fiv = "    99    ";
		    break;
		}
		}
		switch (j) {
		case(0): {
		    output += one;
		    break;
		}
		case(1): {
		    output += two;
		    break;
		}
		case(2): {
		    output += thr;
		    break;
		}
		case(3): {
		    output += fou;
		    break;
		}
		case(4): {
		    output += fiv;
		    break;
		}
		}
	    }
	    output += "\n";
	}
	System.out.println(output);
    }
}