package pvt.notebook1.test;

public class Countdown {
    public static void main(String[] args) {
        for (int i = 100; i >= 0; i--) {
            System.out.println(i);
            try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
        }
    }
}