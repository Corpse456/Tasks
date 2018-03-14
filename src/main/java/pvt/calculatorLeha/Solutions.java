package pvt.calculatorLeha;

import java.util.*;

public class Solutions {
    private static final String OPERATORS = "+-*/()";
    private static final String DIGITS = "0123456789.,";
    private static List<String> exampl = new LinkedList<String>();
    private static List<String> ready = new LinkedList<String>();
    private static List<String> operators = new LinkedList<String>();
    private static double result;

    protected static void calc(String exp) {
	reversPolish(exp);
    }

    /**
     * Данный метод принимает введенную строку <i><b>exp</i></b> и преобразует
     * ее<br>
     * в два LinkedList <i><b>exampl</i></b> и <i><b>operators</i></b>, которые
     * содержат<br>
     * числа и операторы соответственно.
     * 
     * 
     * @param exp
     */
    private static void preparation(String exp) {
	String newNumb;
	int insert = 0;
	// разбиение число/оператор на ячейки (одна число/оператор = 1 ячейка)
	for (int i = insert; i <= exp.length(); i++) {
	    for (int j = insert; j < exp.length(); j++) {
		if (OPERATORS.contains(exp.substring(j, j + 1))) {
		    if (j == 0) {
			newNumb = exp.substring(j, j + 1);
			exampl.add(exampl.size(), newNumb);
			insert = j + 1;
			i = insert;
			break;
		    } else if (j == exp.length() - 1) {
			if (DIGITS.contains(exp.subSequence(j - 1, j))) {
			    newNumb = exp.substring(insert, j);
			    exampl.add(exampl.size(), newNumb);
			    newNumb = exp.substring(j, j + 1);
			    exampl.add(exampl.size(), newNumb);
			    insert = j + 1;
			    i = insert;
			    break;
			} else {
			    newNumb = exp.substring(j, j + 1);
			    exampl.add(exampl.size(), newNumb);
			    insert = j + 1;
			    i = insert;
			    break;
			}
		    } else if (OPERATORS.contains(exp.substring(j, j + 1))) {
			if (DIGITS.contains(exp.subSequence(j - 1, j))) {
			    newNumb = exp.substring(insert, j);
			    exampl.add(exampl.size(), newNumb);
			    newNumb = exp.substring(j, j + 1);
			    exampl.add(exampl.size(), newNumb);
			    insert = j + 1;
			    i = insert;
			    break;
			} else {
			    newNumb = exp.substring(j, j + 1);
			    exampl.add(exampl.size(), newNumb);
			    insert = j + 1;
			    i = insert;
			    break;
			}
		    }
		} else if (j == exp.length() - 1) {
		    newNumb = exp.substring(insert, j + 1);
		    exampl.add(exampl.size(), newNumb);
		    insert = j + 1;
		    i = insert;
		    break;
		}
	    }
	}
	// преобразование одного листа в два (числа и операторы)
	// exampl - числа
	// operators - скобки и операторы
	for (int i = 0; i < exampl.size(); i++) {
	    if (OPERATORS.contains(exampl.get(i))) {
		operators.add(exampl.get(i));
		exampl.remove(i);
		i--;
	    }
	}
    }

    /**
     * 
     * <i><b>Данный метод является сложным для понимания!<br>
     * По-этому его надо просто принять так как он есть! =) <br>
     * Спасибо за понимание =)<br>
     * <br>
     * </i></b>
     * 
     * Данный метод вызывает метод <i><b>preparation</i></b>, принимает
     * введенную пользователем строку и <br>
     * возвращает готовый <i><b>List<String></i></b> в виде обратной польской
     * записи.<br>
     * Затем вызывает метод <i><b>calculation</i></b> передавая ему
     * <i><b>List<String></i></b>.<br>
     * <br>
     * Парочка примеров с ответом:<br>
     * <br>
     *
     *
     * (9-9)-((8-8)-((5-5)-5)) = 9 9 - 8 8 - 5 5 - 5 - - - = -5.0<br>
     * <br>
     * 56*(56-(56-56)) = 56 56 56 56 - - * = 3136.0<br>
     * <br>
     * (((36/6)+4)-5)*4-10*(5-4*(35-30)) = 36 6 / 4 + 5 - 4 * 10 5 4 35 30 - * -
     * * - = 170.0<br>
     * <br>
     * ((((5-1)*2)*55-545+56-87)*5+(43-43)*56-98) = 5 1 - 2 * 55 * 545 - 56 + 87
     * - 5 * 43 43 - 56 * + 98 - = -778.0<br>
     * <br>
     * 5*5-6*6+5*5 = 5 5 * 6 6 * 5 5 * + - = -36.0<br>
     * <br>
     * (5*5-5+5)*6 = 5 5 * 5 - 5 + 6 * = 150.0<br>
     * <br>
     * 
     * @param exp
     */
    private static void reversPolish(String exp) {
	int bracket = 0;
	int count = 0;
	String temp = null;
	preparation(exp);
	operators.iterator();
	for (int i = 0; i < operators.size(); i++) {
	    if (i < operators.size() - 1) {
		if (operators.get(i).equals("+") || operators.get(i).equals("-")) {
		    if (operators.get(i + 1).equals("+") || operators.get(i + 1).equals("-")) {
			ready.add(exampl.get(0));
			exampl.remove(0);
			ready.add(operators.get(i));
			temp = operators.get(i);
			operators.remove(i);
			i--;
		    } else if (operators.get(i + 1).equals("*") || operators.get(i + 1).equals("/")) {
			// ready.add(exampl.get(0));
			// exampl.remove(0);
			temp = operators.get(i);
			count++;
		    } else if (operators.get(i + 1).equals("(")) {
			if (ready.isEmpty()) {
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			}
			count++;
		    } else if (operators.get(i + 1).equals(")")) {
			ready.add(exampl.get(0));
			exampl.remove(0);
			ready.add(operators.get(i));
			temp = operators.get(i);
			operators.remove(i);
			i--;
		    }
		} else if (operators.get(i).equals("*") || operators.get(i).equals("/")) {
		    if (count == 0) {
			if (operators.get(i + 1).equals("+") || operators.get(i + 1).equals("-")) {
			    if (ready.isEmpty()) {
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(operators.get(i));
				temp = operators.get(i);
				operators.remove(i);
				i--;
			    } else {
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(operators.get(i));
				temp = operators.get(i);
				operators.remove(i);
				i--;
			    }
			} else if (operators.get(i + 1).equals("*") || operators.get(i + 1).equals("/")) {
			    if (ready.isEmpty()) {
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(operators.get(i));
				temp = operators.get(i);
				operators.remove(i);
				i--;
			    } else {
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(operators.get(i));
				temp = operators.get(i);
				operators.remove(i);
				i--;
			    }
			} else if (operators.get(i + 1).equals("(")) {
			    if (ready.isEmpty()) {
				ready.add(exampl.get(0));
				exampl.remove(0);
			    } else if (temp.equals(")")) {
			    }
			    count++;
			} else if (operators.get(i + 1).equals(")")) {
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			    ready.add(operators.get(i));
			    temp = operators.get(i);
			    operators.remove(i);
			    i--;
			}
		    } else if (count != 0) {
			if (operators.get(i + 1).equals("+") || operators.get(i + 1).equals("-")) {
			    if (ready.isEmpty() || ready.size() == 1) {
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(operators.get(count));
				operators.remove(count);
				i--;
				ready.add(operators.get(i));
				temp = operators.get(i);
				operators.remove(i);
				count--;
				i--;
			    } else if (temp.equals("-") || temp.equals("+")) {
				if (operators.get(i + 2).equals("*") || operators.get(i + 2).equals("/")) {
				    ready.add(exampl.get(0));
				    exampl.remove(0);
				    ready.add(exampl.get(0));
				    exampl.remove(0);
				    ready.add(operators.get(i));
				    temp = operators.get(i);
				    operators.remove(i);
				    i--;
				} else {
				    ready.add(exampl.get(0));
				    exampl.remove(0);
				    ready.add(exampl.get(0));
				    exampl.remove(0);
				    ready.add(operators.get(count));
				    operators.remove(count);
				    i--;
				    ready.add(operators.get(i));
				    temp = operators.get(i);
				    operators.remove(i);
				    count--;
				    i--;
				}
			    } else {
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(operators.get(count));
				operators.remove(count);
				i--;
				ready.add(operators.get(i));
				temp = operators.get(i);
				operators.remove(i);
				count--;
				i--;
			    }
			} else if (operators.get(i + 1).equals("*") || operators.get(i + 1).equals("/")) {
			    if (ready.isEmpty()) {
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(operators.get(count));
				operators.remove(count);
				i--;
				ready.add(operators.get(i));
				temp = operators.get(i);
				operators.remove(i);
				count--;
				i--;
			    } else {
				if (temp.equals("(")) {
				    ready.add(exampl.get(0));
				    exampl.remove(0);
				    ready.add(operators.get(i));
				    temp = operators.get(i);
				    operators.remove(i);
				    i--;
				} else {
				    ready.add(exampl.get(0));
				    exampl.remove(0);
				    ready.add(operators.get(count));
				    operators.remove(count);
				    i--;
				    ready.add(operators.get(i));
				    temp = operators.get(i);
				    operators.remove(i);
				    count--;
				    i--;
				}
			    }
			} else if (operators.get(i + 1).equals("(")) {
			    if (ready.isEmpty()) {
				ready.add(exampl.get(0));
				exampl.remove(0);
				ready.add(exampl.get(0));
				exampl.remove(0);
			    } else if (temp.equals(")")) {// ||
							  // operators.get(i).equals("*")
							  // ||
							  // operators.get(i).equals("/")
			    } else {
				ready.add(exampl.get(0));
				exampl.remove(0);
			    }
			    count++;
			} else if (operators.get(i + 1).equals(")")) {
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			    ready.add(operators.get(i));
			    temp = operators.get(i);
			    operators.remove(i);
			    i--;
			}
		    }
		} else if (operators.get(i).equals("(")) {
		    if (operators.get(i + 1).equals("+") || operators.get(i + 1).equals("-")) {
			ready.add(exampl.get(0));
			exampl.remove(0);
		    } else if (operators.get(i + 1).equals("*") || operators.get(i + 1).equals("/")) {
			ready.add(exampl.get(0));
			exampl.remove(0);
		    }
		    temp = operators.get(i);
		    operators.remove(i);
		    bracket++;
		    i--;
		} else if (operators.get(i).equals(")")) {
		    bracket--;
		    if (count == 0) {
			for (int j = count; count != 0; j--) {
			    ready.add(operators.get(j));
			    operators.remove(j);
			    count--;
			    i--;
			}
		    }
		    temp = operators.get(i);
		    operators.remove(i);
		    i--;
		}
	    } else {
		if (operators.get(i).equals("+") || operators.get(i).equals("-")) {
		    ready.add(exampl.get(0));
		    exampl.remove(0);
		    if (exampl.isEmpty()) {
			ready.add(operators.get(i));
			temp = operators.get(i);
			operators.remove(i);
		    } else {
			ready.add(exampl.get(0));
			exampl.remove(0);
			ready.add(operators.get(i));
			temp = operators.get(i);
			operators.remove(i);
		    }
		    i--;
		} else if (operators.get(i).equals("*") || operators.get(i).equals("/")) {
		    if (count == 0) {
			if (ready.isEmpty()) {
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			    ready.add(operators.get(i));
			    temp = operators.get(i);
			    operators.remove(i);
			} else {
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			    ready.add(operators.get(i));
			    temp = operators.get(i);
			    operators.remove(i);
			}
		    }
		    if (count != 0) {
			if (ready.isEmpty()) {
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			    ready.add(operators.get(i));
			    temp = operators.get(i);
			    operators.remove(i);
			} else {
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			    ready.add(exampl.get(0));
			    exampl.remove(0);
			    ready.add(operators.get(i));
			    temp = operators.get(i);
			    operators.remove(i);
			}
		    }
		    for (int j = count - 1; j >= 0; j--) {
			ready.add(operators.get(j));
			operators.remove(j);
		    }
		    i--;
		} else if (operators.get(i).equals(")")) {
		    bracket--;
		    if (bracket == 0) {
			for (int j = count - 1; count != 0; j--) {
			    ready.add(operators.get(j));
			    operators.remove(j);
			    count--;
			}
		    }
		    operators.removeAll(operators);
		    i--;
		}
	    }
	}
	System.out.print(exp + " = ");
	for (int i = 0; i < ready.size(); i++) {
	    System.out.print(ready.get(i) + " ");
	}
	calculation(ready);
    }

    /**
     * http://primat.org/news/obratnaja_polskaja_zapis/2016-04-09-1181 сайт
     * где<br>
     * можно проверить правильность перевода в польскую запись :) думаю не<br>
     * понадобится :)<br>
     * <br>
     * 
     * Этот метод производит расчет обратной польской записи. Он принимает
     * <i><b>List</i></b><br>
     * готовой польской записи, проивзодит расчет и возвращает готовый
     * результат<br>
     * В конце расчетов он все <i><b>List`s</i></b> обнуляет для дальнейших
     * расчетов!<br>
     * <br>
     * 
     * @param List
     * @return double result
     */
    private static double calculation(List<String> solution) {
	String temp = "";
	int removeTemp = 0;
	for (int i = 0; i < solution.size(); i++) {
	    if (OPERATORS.contains(solution.get(i))) {
		if (OPERATORS.contains(solution.get(i - 2))) {
		} else {
		    if (solution.get(i).equals("+")) {
			result = Double.parseDouble(solution.get(i - 2)) + Double.parseDouble(solution.get(i - 1));
			removeTemp = 1;
		    } else if (solution.get(i).equals("-")) {
			result = Double.parseDouble(solution.get(i - 2)) - Double.parseDouble(solution.get(i - 1));
			removeTemp = 1;
		    } else if (solution.get(i).equals("*")) {
			result = Double.parseDouble(solution.get(i - 2)) * Double.parseDouble(solution.get(i - 1));
			removeTemp = 1;
		    } else if (solution.get(i).equals("/")) {
			result = Double.parseDouble(solution.get(i - 2)) / Double.parseDouble(solution.get(i - 1));
			removeTemp = 1;
		    }
		    if (removeTemp > 0) {
			solution.remove(i - 2);
			solution.remove(i - 2);
			solution.remove(i - 2);
			solution.add(i - 2, temp + result);
			i = i - 2;
			removeTemp = 0;
		    }
		}
	    }
	}
	ready.removeAll(ready);
	exampl.removeAll(exampl);
	operators.removeAll(operators);
	System.out.println(" = " + result);
	return result;
    }
}