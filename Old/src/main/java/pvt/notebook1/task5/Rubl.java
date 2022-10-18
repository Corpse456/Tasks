package pvt.notebook1.task5;

public class Rubl {

    public static void main(String[] args) {
	for (int i = 0; i < 50; i++) {
	print(i);
	}
    }

    private static void print(int sum) {
	if (sum % 10 == 1 && (sum > 14 || sum < 11)) {
	    System.out.println(sum + " рубль");
	} else if (sum % 10 < 5 && sum % 10 > 1 && (sum > 14 || sum < 11)) {
	    System.out.println(sum + " рубля");
	} else {
	    System.out.println(sum + " рублей");
	}
    }
}