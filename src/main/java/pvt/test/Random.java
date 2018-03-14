package pvt.test;

public class Random {

    public static void main(String[] args) {
	int count = 1;
	for (int i = 0; i < 1000000000; i++) {
	    if (i % 10000000 == 0) {
		System.out.println(count++);
	    }
	    double x = Math.random();
	    if (x > 0.999999999) {
		System.out.println("Got it!");
		System.out.println(x);
		break;
	    }
	}
    }
}