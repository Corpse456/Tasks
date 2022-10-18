package pvt.notebook2.threads;

public class MyThread extends Thread {
	
	public MyThread() {
		super("mythread");
		start();
	}

	public void run() {
		int counter = 0;
		while (counter < 100) {
			counter++;
			System.out.println(counter);
			yield();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();
		System.err.println(t.getName());
		t.setName("newName");
		t.join();
		t.run();
		System.out.println(t.getName());
	}
	
	public class NewThread implements Runnable {
	    private Thread thread;
	    public NewThread(){
	        thread = new Thread(this);
	    }
	    public void run() {
	        int count = 0;
	        while(count<100) {
	            count++;
	            System.out.println(count);
	            
	        }
	    }
	    public void start() {
	        thread.start();
	    }
	    public Thread getThread() {
	        return thread;
	    }
	    
	}
}