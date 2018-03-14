package pvt.FiveTasks;

public class Union {
    public static void main(String[] args) {
	char[] simbols = { 'a', 'b', 'c', 'd', 'e', 'f' };
	int[] numbers = { 1, 2, 4, 79 };

	String[] result = new String[simbols.length + numbers.length];
	int resultIndex = 0;
	for (int i = 0; i < Math.max(simbols.length, numbers.length); i++) {
	    if (i < simbols.length) {
		result[resultIndex++] = "" + simbols[i];
	    }
	    if (i < numbers.length) {
		result[resultIndex++] = "" + numbers[i];
	    }
	}

	for (String next : result) {
	    System.out.print(next + " ");
	}
    }

}
