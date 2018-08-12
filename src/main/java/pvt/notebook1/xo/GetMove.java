package pvt.notebook1.xo;

import java.util.Scanner;

public class GetMove {
    
    private final static String EXIT = "exitExitEXITQUITQuitquit";
    private final static String numbers = "012";
    private static Scanner take = new Scanner(System.in);

    public static byte get() {
	String input = take.nextLine();

	while (!check(input)) {
	    System.out.println("Wrong Input. Retry >>");
	    input = take.nextLine();
	}
	return Byte.parseByte(input);
    }

    private static boolean check(String input) {
	if (input.length() == 4 && EXIT.contains(input)) {
	    System.out.println("Exiting...");
	    System.exit(0);
	}

	if (input.length() != 2) {
	    return false;
	}

	if (!numbers.contains("" + input.charAt(0)) || !numbers.contains("" + input.charAt(1))) {
	    return false;
	}

	return true;
    }
}