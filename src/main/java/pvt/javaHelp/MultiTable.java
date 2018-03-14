package pvt.javaHelp;

public class MultiTable {

    public static void main(String[] args) {
	milti(3);
    }

    private static void milti(int k) {
	for (int i = 1; i <= 10; i++) {
	    System.out.println(k + " * " + i + " = " + i * k);
	}
    }
}