package pvt.FiveTasks;

public class BiggerNumber {
    public static void main(String[] args) {
	int[] num = { 1, 5, 109, 3, 4, 7, 100 };

	String result = "";
	for (int i = 0; i < num.length; i++) {
	    for (int j = 0; j < num.length - 1; j++) {
		if (big(num[j]) < big(num[j + 1])) {
		    int temp = num[j];
		    num[j] = num[j + 1];
		    num[j + 1] = temp;
		}
	    }
	}
	for (int i : num) {
	    result += i;
	}

	System.out.println(result);
    }

    private static int big(int i) {
	return new String("" + i).charAt(0) - '0';
    }
}
