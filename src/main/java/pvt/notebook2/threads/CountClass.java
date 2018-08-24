package pvt.notebook2.threads;

public class CountClass extends Thread {
	private StringBuffer text;
	private int countTo;

	public CountClass(StringBuffer s, int c) {
		text = s;
		countTo = c;
	}

	@Override
	public void run() {
		synchronized (text) {
			int sum = 0;
			for (int i = 1; i <= countTo; i++) {
				sum += i;
				text.append("Next value: " + i + ".");
			}
			text.append("\nsum=" + sum + "\n");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		StringBuffer text = new StringBuffer();
		CountClass c1 = new CountClass(text, 200);
		CountClass c2 = new CountClass(text, 100);
		c1.start();
		c2.start();
		c1.join();
		c2.join();
		System.out.println("Result: \n" + text);
	}
}