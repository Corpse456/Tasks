package fifteen.two;

public class Application {

    private final static int MIN = 3;
    private final static int MAX = 9;

    // размер игрового поля
    private static int d;

    public static void main(String[] args) throws InterruptedException {
	// Убедиться в наличие единственного аргумента
	if (args.length != 1) {
	    System.out.println("Usage: fifteen d");
	    System.exit(0);
	}

	// убедиться что аргумент - число в пределах от 3 до 9 включительно
	try {
	    d = Integer.parseInt(args[0]);
	} catch (NumberFormatException e) {
	    System.out.println("Agrument must be a number");
	    System.exit(0);
	}
	if (d < MIN || d > MAX) {
	    System.out.printf("Board must be between %d x %d and %d x %d, inclusive.\n", MIN, MIN, MAX, MAX);
	    System.exit(0);
	}
	
	Fifteen.start();
    }
}