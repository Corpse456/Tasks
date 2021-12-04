package randomTasks.fiveTasks;

import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
	LinkedList<Double> Fibonacci = new LinkedList<Double>();

	Fibonacci.add(0.0);
	Fibonacci.add(1.0);

	for (int i = 2; i < 100; i++) {
	    Fibonacci.add(Fibonacci.get(i - 1) + Fibonacci.get(i - 2));
	}

	for (double i : Fibonacci) {
	    System.out.print(i + " ");
	}
    }
}