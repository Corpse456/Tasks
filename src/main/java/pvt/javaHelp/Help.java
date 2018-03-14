package pvt.javaHelp;

public class Help {

    private static String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John",
	    "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
    private static int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

    public static void main(String[] args) {
	System.out.println(byPoint(
		"Разработка высокоэффективных водонагревателей для утилизации скрытой теплоты парообразования водяных паров в дымовых газах. Расчет нормативных потерь по теплотрассам. Разработка нормативных документов в области энергетики. Разработка систем оптимизации распределения тепловых и электрических нагрузок между котло-турбоагрегатами, энергоблоками ТЭС."));
	System.out.println(weightOnMoon(107));
	System.out.println(stringBack("Already"));
	System.out.println(winner());
    }

    private static String winner() {
	int max = times[0];
	int name = 0;
	for (int i = 0; i < times.length; i++) {
	    if (max < times[i]) {
		max = times[i];
		name = i;
	    }
	}
	return names[name];
    }

    private static int byPoint(String string) {
	int countSpaces = 0;
	for (int i = 0; i < string.length() && string.charAt(i) != '.'; i++) {
	    if (string.charAt(i) == ' ') {
		countSpaces++;
	    }
	}
	return countSpaces;
    }

    private static double weightOnMoon(int mass) {
	return mass * 0.17;
    }

    private static String stringBack(String string) {
	if (string.length() == 0) {
	    return "";
	}

	String shorter = new String();
	for (int i = 0; i < string.length() - 1; i++) {
	    shorter += string.charAt(i);
	}

	return string.charAt(string.length() - 1) + stringBack(shorter);
	// return string.charAt(string.length()-1) +
	// stringBack(string.substring(0, string.length() - 1));
    }
}