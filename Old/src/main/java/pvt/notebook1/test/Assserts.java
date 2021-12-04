package pvt.notebook1.test;

public class Assserts {

    public static void main(String[] args) {
	int[] a = new int[100];
	
	for (int i = 0; i < 100; ++i) {
	    a[i] = factorial(i);
	}
	for (int i : a) {
	    System.out.println(i);
	}
    }

    private static int factorial(int n) {
	// Факториал отрицательного числа не считается
	assert (n >= 0) : "Fuck";

	// Если n превысит 10, то это может привести либо к целочисленному
	// переполнению результата, либо к переполнению стэка.
	assert (n <= 10) : "You";

	if (n < 2) {
	    return 1;
	}

	return factorial(n - 1) * n;
    }
}