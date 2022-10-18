package javaRushLeve7;

public class Delay {
    
    public static void main(String[] args) throws InterruptedException{
	for (int i = 30; i >= 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
	}
	System.out.println("Бум!");
    }
}