package pvt.calculatorArtem;

import java.util.LinkedList;

public class OneCalc implements CalculatorModel {

    private String screen = "0"; // окно калькулятора
    private LinkedList<String> history = new LinkedList<String>(); // окно
								  
    public void gistory() {
        System.out.println();
        for (String t : history) {
	    System.out.print(t + " ");
	}
        System.out.println();
    }

    // истории
								   // операций
    private String lastOperatorApply = ""; // текущий оператор
    private String lastResultInMemory = ""; // текущий результат
    private String curentNumber = "0"; // текущее значение
    private String saveDigit = ""; // сохраненое значение
    private String error = ""; // сообщение обошибке деления на ноль

    // ================================================================================

    public String getScreen() {
	return screen;
    }

    public String getSaveDigit() {
	return saveDigit;
    }

    // функции элементарных операций
    private Double applyLastOpertion() {
	switch (lastOperatorApply) {
	case "+":
	    return Double.parseDouble(lastResultInMemory) + Double.parseDouble(curentNumber);
	case "-":
	    return Double.parseDouble(lastResultInMemory) - Double.parseDouble(curentNumber);
	case "*":
	    return Double.parseDouble(lastResultInMemory) * Double.parseDouble(curentNumber);
	case "/":
	    if (Double.parseDouble(curentNumber) == 0 || screen == "0") {
		error = "Деление на ноль невозможно";
		return 0.0;
	    } else {
		return Double.parseDouble(lastResultInMemory) / Double.parseDouble(curentNumber);
	    }
	}
	return null;
    }

    // есть ли ситуацияпопытки деления на ноль
    private boolean Error() {
	if (error == "Деление на ноль невозможно") {
	    screen = "";
	    lastOperatorApply = "";
	    lastResultInMemory = "";
	    curentNumber = "0";
	    return true;
	}
	return false;
    }

    @Override
    public void plus() {
	if (curentNumber != "") {
	    if (lastOperatorApply != "") {
		lastResultInMemory = applyLastOpertion().toString();
		if (Error()) {
		    return;
		}
		history.add(curentNumber);
		history.add("+");
		curentNumber = "";
		lastOperatorApply = "+";
		screen = equalsScreen(lastResultInMemory);
		return;
	    } else {
		lastResultInMemory = curentNumber;
		history.add(curentNumber);
		history.add("+");
		curentNumber = "";
		lastOperatorApply = "+";
	    }
	} else {
	    lastOperatorApply = "+";
	    history.removeLast();
	    history.add("+");
	}
    }

    @Override
    public void minus() {
	if (curentNumber != "") {
	    if (lastOperatorApply != "") {
		lastResultInMemory = applyLastOpertion().toString();
		if (Error()) {
		    return;
		}
		history.add(curentNumber);
		history.add("-");
		curentNumber = "";
		lastOperatorApply = "-";
		screen = equalsScreen(lastResultInMemory);
		return;
	    } else {
		lastResultInMemory = curentNumber;
		history.add(curentNumber);
		history.add("-");
		curentNumber = "";
		lastOperatorApply = "-";
	    }
	} else {
	    lastOperatorApply = "-";
	    history.removeLast();
	    history.add("-");
	}
    }

    @Override
    public void multiply() {
	if (curentNumber != "") {
	    if (lastOperatorApply != "") {
		lastResultInMemory = applyLastOpertion().toString();
		if (Error()) {
		    return;
		}
		history.add(curentNumber);
		history.add("*");
		curentNumber = "";
		lastOperatorApply = "*";
		screen = equalsScreen(lastResultInMemory);
		return;
	    } else {
		lastResultInMemory = curentNumber;
		history.add(curentNumber);
		history.add("*");
		curentNumber = "";
		lastOperatorApply = "*";
	    }
	} else {
	    lastOperatorApply = "*";
	    history.removeLast();
	    history.add("*");
	}
    }

    @Override
    public void divide() {
	if (curentNumber != "") {
	    if (lastOperatorApply != "") {
		lastResultInMemory = applyLastOpertion().toString();
		if (Error()) {
		    return;
		}
		history.add(curentNumber);
		history.add("/");
		curentNumber = "";
		lastOperatorApply = "/";
		screen = equalsScreen(lastResultInMemory);
		return;
	    } else {
		lastResultInMemory = curentNumber;
		history.add(curentNumber);
		history.add("/");
		curentNumber = "";
		lastOperatorApply = "/";
	    }
	} else {
	    lastOperatorApply = "/";
	    history.removeLast();
	    history.add("/");
	}
    }

    @Override
    public void plusMinus() {
	if (curentNumber.charAt(0) == '-') {
	    curentNumber.replace("-", "");
	    screen = equalsScreen(curentNumber);
	    return;
	} else {
	    curentNumber = '-' + curentNumber;
	    screen = equalsScreen(curentNumber);
	}
    }

    @Override
    public void inverseNumber() {
	// если ужебыл вызван подобный метод, то в истории этот метод
	// добавляетсяв текущий метод
	if (((history.isEmpty()) != true) && (history.getLast().charAt(history.getLast().length() - 1)) == ')') {
	    String temp = history.getLast();
	    history.removeLast();
	    history.add("1/(" + temp + ")");
	    if (Double.parseDouble(curentNumber) == 0) { // проверка нет ли
							 // деления на ноль
		error = "Деление на ноль невозможно";
	    }
	    if (Error()) {
		return;
	    }
	    curentNumber = Double.toString(1 / (Double.parseDouble(curentNumber)));
	    screen = equalsScreen(curentNumber);
	    return;
	} else {
	    history.add("1/(" + curentNumber + ")");
	    if (Double.parseDouble(curentNumber) == 0) {
		error = "Деление на ноль невозможно";
	    }
	    if (Error()) {
		return;
	    }
	    if (curentNumber == "") {
		curentNumber = screen;
		curentNumber = Double.toString(1 / (Double.parseDouble(curentNumber)));
		screen = equalsScreen(curentNumber);
		return;
	    } else {
		curentNumber = Double.toString(1 / (Double.parseDouble(curentNumber)));
		screen = equalsScreen(curentNumber);
	    }
	}
    }

    @Override
    public void equalsNow() {
	if (lastOperatorApply != "") {
	    if (curentNumber == "") {
		curentNumber = lastResultInMemory;
		lastResultInMemory = applyLastOpertion().toString();
		if (Error()) {
		    return;
		}
		lastOperatorApply = "";
		history.clear();
		screen = equalsScreen(lastResultInMemory);
		return;
	    } else {
		lastResultInMemory = applyLastOpertion().toString();
		if (Error()) {
		    return;
		}
		curentNumber = lastResultInMemory;
		lastOperatorApply = "";
		history.clear();
		screen = equalsScreen(lastResultInMemory);
		return;
	    }
	} else {
	    lastResultInMemory = curentNumber;
	    lastOperatorApply = "";
	    history.clear();
	    screen = equalsScreen(lastResultInMemory);
	}
    }

    @Override
    public void percent() {
	if (curentNumber == "") {
	    curentNumber = Double
		    .toString(Double.parseDouble(lastResultInMemory) * Double.parseDouble(lastResultInMemory) / 100);
	    history.add(curentNumber);
	    screen = equalsScreen(curentNumber);
	} else {
	    if (lastResultInMemory == "") {
		curentNumber = "0";
		history.clear();
		history.add(curentNumber);
		screen = equalsScreen(curentNumber);
	    } else {
		curentNumber = Double
			.toString(Double.parseDouble(lastResultInMemory) * Double.parseDouble(curentNumber) / 100);
		history.add(curentNumber);
		screen = equalsScreen(curentNumber);
	    }
	}
    }

    @Override
    public void sqrt() {
	if (((history.isEmpty()) != true) && (history.getLast().charAt(history.getLast().length() - 1)) == ')') {
	    String temp = history.getLast();
	    history.removeLast();
	    history.add("\u221A" + "(" + temp + ")");
	    curentNumber = Double.toString(Math.sqrt(Double.parseDouble(curentNumber)));
	    screen = equalsScreen(curentNumber);
	    return;
	} else {
	    if (curentNumber == "") {
		curentNumber = screen;
		history.add("\u221A" + "(" + curentNumber + ")");
		curentNumber = Double.toString(Math.sqrt(Double.parseDouble(curentNumber)));
		screen = equalsScreen(curentNumber);
	    } else {
		history.add("\u221A" + "(" + curentNumber + ")");
		curentNumber = Double.toString(Math.sqrt(Double.parseDouble(curentNumber)));
		screen = equalsScreen(curentNumber);
	    }
	}
    }

    @Override
    public void sqr() {
	if (((history.isEmpty()) != true) && (history.getLast().charAt(history.getLast().length() - 1)) == ')') {
	    String temp = history.getLast();
	    history.removeLast();
	    history.add("sqr(" + temp + ")");
	    curentNumber = Double.toString((Double.parseDouble(curentNumber)) * (Double.parseDouble(curentNumber)));
	    screen = equalsScreen(curentNumber);
	    return;
	} else {
	    if (curentNumber == "") {
		curentNumber = screen;
		history.add("sqr(" + curentNumber + ")");
		curentNumber = Double.toString((Double.parseDouble(curentNumber)) * (Double.parseDouble(curentNumber)));
		screen = equalsScreen(curentNumber);
	    } else {
		history.add("sqr(" + curentNumber + ")");
		curentNumber = Double.toString((Double.parseDouble(curentNumber)) * (Double.parseDouble(curentNumber)));
		screen = equalsScreen(curentNumber);
	    }
	}
    }

    @Override
    public void enterDigit(char digit) {
	if (error == "Деление на ноль невозможно") {
	    error = "";
	    history.clear();
	}
	if (((history.isEmpty()) != true) && (history.getLast().charAt(history.getLast().length() - 1)) == ')') {
	    history.removeLast();
	    curentNumber = "0" + digit;
	    screen = curentNumber;
	    return;
	}
	if (curentNumber == "") {
	    curentNumber = "0" + digit;
	    screen = curentNumber;
	} else {
	    if (curentNumber.contains("."))
		return; // не дает ввести точку более одного раза
	    curentNumber = curentNumber + digit;
	    screen = curentNumber;
	}
    }

    @Override
    public void enterDigit(int digit) {
	if (error == "Деление на ноль невозможно") {
	    error = "";
	    history.clear();
	}
	if (((history.isEmpty()) != true) && (history.getLast().charAt(history.getLast().length() - 1)) == ')') {
	    history.removeLast();
	    curentNumber = "" + digit;
	    screen = curentNumber;
	    return;
	}
	if (curentNumber == "0") {
	    curentNumber = "" + digit;
	    screen = curentNumber;
	} else {
	    curentNumber = curentNumber + digit;
	    screen = curentNumber;
	}
    }

    @Override
    public void clear() {
	screen = "0";
	history.clear();
	lastOperatorApply = "";
	lastResultInMemory = "";
	curentNumber = "0";
	error = "";

    }

    @Override
    public void clearEror() {
	curentNumber = "";
	screen = "0";
    }

    @Override
    public void deleteLastEnteredDigit() {
	if (curentNumber.length() == 1 || curentNumber.length() == 0) {
	    curentNumber = "";
	    screen = "0";
	} else {
	    curentNumber = curentNumber.substring(0, curentNumber.length() - 1);
	    screen = equalsScreen(curentNumber);
	}
    }

    @Override
    public void memoryRestore() {
	curentNumber = saveDigit;
	screen = equalsScreen(curentNumber);
    }

    @Override
    public void memorySave() {
	saveDigit = curentNumber;
    }

    @Override
    public void memoryClear() {
	saveDigit = "";
    }

    @Override
    public void memoryPlus() {
	if (curentNumber == "") {
	    return;
	} else {
	    saveDigit = Double.toString(Double.parseDouble(saveDigit) + Double.parseDouble(curentNumber));
	}
    }

    @Override
    public void memoryMinus() {
	if (curentNumber == "") {
	    return;
	} else {
	    saveDigit = Double.toString(Double.parseDouble(saveDigit) - Double.parseDouble(curentNumber));
	}
    }

    // возвращает текущее отображение экрана
    @Override
    public String toString() {
	return screen;
    }

    // метод для вывода целого текущего результата без плавающей точки
    private String equalsScreen(String number) {
	double numDouble = Double.parseDouble(number);
	Integer numInt = (int) numDouble;
	if (numDouble - (double) numInt != 0) {
	    return number;
	} else {
	    return numInt.toString();
	}
    }

    @Override
    public double calculateExpression(String exp) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public double callJavaMath(String methodName, Object[] args) {
	// TODO Auto-generated method stub
	return 0;
    }

}
