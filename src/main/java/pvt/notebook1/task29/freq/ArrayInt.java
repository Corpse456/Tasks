package pvt.notebook1.task29.freq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayInt {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
	int[] array = new int[3];
	
	for (int i = 0; i < array.length; i++) {
	    array[i] = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
	}
        return array;
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i : array) {
	    if (i > max) {
		max = i;
	    }
	}
        return max;
    }
}