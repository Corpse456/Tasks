package pvt.calculatorArtem;

public interface CalculatorModel {
	
	void plus(); //изменяет внутреннее состояние объекта.
	//may be String. Как промежуточное выражение.
	
	void minus();
	void multiply();
	void divide();
	void plusMinus();
	void inverseNumber();
	void equalsNow();
	void percent();
	void sqrt();
	void sqr();
	void enterDigit(char digit);
	void enterDigit(int digit);
	void clear();
	void clearEror();
	void deleteLastEnteredDigit();
	void memoryRestore();
	void memorySave();
	void memoryClear();
	void memoryPlus();
	void memoryMinus();
	/**
	 * @return to, что было бы на экране реального калькулятора после аналогичных команд
	 */
	String toString(); 
	double calculateExpression(String exp);
	double callJavaMath(String methodName, Object[] args);

	void gistory();

}
