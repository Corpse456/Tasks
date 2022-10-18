package pvt.notebook1.javaHelp;

public class Salary {

    public static void main(String[] args) {
	double inHour = salaryInMonth(760);
	System.out.println(inHour);
	System.out.println(salary(inHour, 40));
    }
    
    private static double salaryInMonth(int i) {
	return i/21/8;
    }

    private static double salary(double inHour, double hours) {
	hours = (hours > 60) ? 60 : hours;
	
	inHour = (inHour < 8) ? 8 : inHour;
	
	return inHour * (hours - hours%40) + inHour * 1.5 * hours%40;
    }
}