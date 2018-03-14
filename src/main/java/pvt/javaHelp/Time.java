package pvt.javaHelp;

public class Time {
    
    public static void main(String[] args) {
	System.out.println(time(11));
    }

    private static String time(int i) {
	String output = new String();
	
	output += "Hours: " + i * 24;
	output += "\nMinutes: " + i * 24 * 60;
	output += "\nSeconds: " + i * 24 * 60 * 60;
	
	return output;
    }
}