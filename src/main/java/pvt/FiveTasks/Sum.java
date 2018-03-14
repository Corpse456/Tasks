package pvt.FiveTasks;

public class Sum {
    static int[] list = { 1, 2, 5, 7, 9, 4, 6, 8, 70 };

    public static void main(String[] args) {
	int sum = 0;
	for (int i = 0; i < list.length; i++) {
	    sum += list[i];
	}

	int i = 0, sum2 = 0;
	while (i < list.length) {
	    sum2 += list[i++];
	}

	int sum3 = sum(0, 0);

	System.out.println(sum + " " + sum2 + " " + sum3);
    }

    private static int sum(int sum, int i) {
	if (i == list.length) {
	    return sum;
	}

	return sum(sum + list[i], ++i);
    }
}
