package pvt.calculatorLeha;

import java.util.*;

public class ValueIn extends Solutions {
    private static Scanner input = new Scanner(System.in);
    private static String exp;
    private static boolean test = false;

    /**
     * Данный метод принимает строку примера и вызывает метод
     * <i><b>inValid</i></b> для<br>
     * проверки его на корректность.<br>
     * <i><b>Но, так как было лень начинающему Junior Developer Java<br>
     * доделать корректность ввода, пользуемся тем что есть!</i></b><br>
     * Так же метод удаляет все лишние пробелы из введенной строки.<br>
     * <br>
     * Далее вызывается метод <i><b>calc</i></b> и передается ему параметр
     * <i><b>String exp</i></b><br>
     * 
     * @param String
     *            exp
     */
    protected static void Value() {
	while (!test) {
	    System.out.print("Enter your example (0 - exit):\n");
	    exp = input.nextLine().replaceAll(" ", "");
	    if (exp.equals("0")) {
		System.out.println("Program stop.");
		System.exit(0);
	    }
	    // inValid(exp); - его надо допилить
	    calc("3+4.5*10");
	}
    }

    /**
     * Данный метод принимает значение типа <i><b>List<String></i></b> и
     * проверяет его на корректность ввода значения и возвращает true или false.
     * 
     * @param List
     * 
     */
    @SuppressWarnings("unused")
    private static boolean inValid(String exampl) {
	int brackIn = 0;
	int brackOut = 0;
	char[] array = exampl.toCharArray();
	/*
	 * Пробегаемся и проверяем чтобы был корректный ввод, чтобы небыло
	 * лишних символов и правильность расстановки символов.
	 */
	for (int i = 0; i < array.length; i++) {
	    for (char j = 1; j < 255; j++) {
		if (j == array[i]) {
		    if (j <= 39) {
			System.err.print("Incorrect expression!");
			test = false;
			return test;
		    }
		    if (j >= 58) {
			if (j != 94) {
			    System.err.print("Incorrect expression!");
			    test = false;
			    return test;
			    /*
			     * проверка на корректность использования знака
			     * степени
			     */
			} else if (j == 94) {
			    if (i == 0) {
				System.out.print("No correctly! ' " + j + " '");
				System.err.print(j);
				System.out.println(" '");
				test = false;
				return test;
			    } else if (i > 0) {
				if (i == array.length - 1) {
				    System.out.print("No correctly! ' " + j + " '");
				    System.err.print(j);
				    System.out.println(" '");
				    test = false;
				    return test;
				}
				if (array[i + 1] >= 48 && array[i + 1] <= 57) {
				    if (array[i - 1] >= 48 && array[i - 1] <= 57) {
					test = true;
				    } else {
					System.out.print("No correctly! ' " + j + " '");
					System.err.print(j);
					System.out.println(" '");
					test = false;
					return test;
				    }
				} else {
				    System.out.print("No correctly! ' " + j + " '");
				    System.err.print(j);
				    System.out.println(" '");
				    test = false;
				    return test;
				}
			    }
			}
			/*
			 * проверка на корректность использования знака точки
			 * или запятой, а так же скобок и знаков после и перед
			 * ними
			 */
		    } else if (j >= 40 && j <= 57) {
			if (j == 40) {
			    brackIn++;
			} else if (j == 41) {
			    brackOut++;
			}
			if (j == 44 || j == 46) {
			    if (i == 0) {
				if (j == 44) {
				    System.out.print("No correctly! ' " + j + " '");
				    System.err.print(j);
				    System.out.println(" '");
				}
				if (j == 46) {
				    System.out.print("No correctly! ' " + j + " '");
				    System.err.print(j);
				    System.out.println(" '");
				}
				return test = false;
			    }
			    if (i >= 1) {
				if (array[i - 1] >= 48 && array[i - 1] <= 57) {
				    test = true;
				} else {
				    test = false;
				    if (j == 44) {
					System.out.print("No correctly! ' " + j + " '");
					System.err.print(j);
					System.out.println(" '");
				    }
				    if (j == 46) {
					System.out.print("No correctly! ' " + j + " '");
					System.err.print(j);
					System.out.println(" '");
				    }
				    return test;
				}
			    }
			} else if (j == 40) {
			    if (brackOut == 0 && i > 0) {
				if (array[i - 1] >= 48 && array[i - 1] <= 57) {
				    System.out.print("No correctly! ' ");
				    System.err.print(array[i - 1]);
				    System.out.print(" and ");
				    System.err.print(j);
				    System.out.println(" '");
				    test = false;
				    return test;
				} else if (array[i + 1] >= 48 && array[i + 1] <= 57) {
				    test = true;
				} else {
				    System.out.print("No correctly! ' ");
				    System.err.print(j);
				    System.out.print(" and ");
				    System.err.print(array[i + 1]);
				    System.out.println(" '");
				    test = false;
				    return test;
				}
			    } else if (brackIn < brackOut) {
				System.out.print("No correctly! ' ");
				System.err.print(")");
				System.out.print(" and ");
				System.err.print(j);
				System.out.println(" '");
				test = false;
				return test;
			    }

			}

			if (j == array[i]) {
			    test = true;
			}
		    }
		    if ((array.length - 1) == i && array[i] == j) {
			break;
		    }
		}
	    }

	}
	System.out.println(test);
	return test;
    }

}
