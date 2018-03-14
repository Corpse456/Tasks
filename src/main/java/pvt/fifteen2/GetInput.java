package pvt.fifteen2;

import java.util.Scanner;

public class GetInput {

    public final static String[] exit = { "exit", "Exit", "EXIT", "QUIT", "Quit", "quit" };
    
    private static Scanner take = new Scanner(System.in);

    public static int get() throws GodException {
        while (true) {
            try {
                String input = take.nextLine();
                if (input.length() > 3 && inputIsExit(input)) {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                if ("GOD".equals(input)) {
                    throw new GodException();
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Wrong Input. Retry >>");
            }
        }
    }

    private static boolean inputIsExit(String input) {
	for (String s : exit) {
	    if (s.equals(input)) {
		return true;
	    }
	}
	return false;
    }
}