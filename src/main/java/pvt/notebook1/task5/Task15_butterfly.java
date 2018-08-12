package pvt.notebook1.task5;

public class Task15_butterfly {
    private static int[][] array = new int[11][11];

    public static void main(String[] args) {
	for (int i = 0; i < array.length; i++) {
	    int k = (i > array.length/2 - 1) ? array.length - 1 - i: i;
	    for (int j = k; j < array[i].length - k; j++) {
		array[i][j] = 1;
	    }
	}
	print();
    }

    private static void print() {
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		System.out.print(array[i][j] + " ");
	    }
	    System.out.println();
	}
	System.out.println();
    }
}