package pvt.calculatorArtem;

public class CalculatorPlus {

	public static String test(CalculatorModel calc) {
		
		calc.clear();
		calc.sqr();
		calc.plus();
		calc.sqr();
		calc.enterDigit(9);
		calc.plus();
		calc.enterDigit(1);
		calc.plusMinus();
		calc.divide();
		calc.plus();
		calc.enterDigit(2);
		calc.enterDigit(2);
		calc.enterDigit(2);
		calc.enterDigit(2);
		calc.deleteLastEnteredDigit();
		calc.deleteLastEnteredDigit();
		calc.deleteLastEnteredDigit();
		calc.sqr();
		calc.sqrt();
		calc.equalsNow();
		calc.divide();
		calc.enterDigit(0);
		calc.plus();
		calc.enterDigit(9);
		calc.enterDigit('.');
		calc.enterDigit(0);
		calc.enterDigit('.');
		calc.enterDigit(0);
		calc.plus();
		calc.enterDigit(1);
		calc.equalsNow();
		return calc.toString();
	}
	
	public static String test2(CalculatorModel calc) {
	    calc.clear();
		calc.enterDigit(1);
		calc.plusMinus();
		calc.minus();
		calc.enterDigit(5);
		calc.multiply();
		calc.enterDigit(1);
		calc.plusMinus();
		calc.equalsNow();
		calc.multiply();
		calc.equalsNow();
		calc.memorySave();
		calc.enterDigit(4);
		calc.enterDigit('.');
		calc.enterDigit(5);
		calc.multiply();
		calc.enterDigit(1);
		calc.enterDigit(0);
		calc.divide();
		calc.memoryRestore();
		calc.plus();
		calc.enterDigit(3);
		calc.plusMinus();
		calc.equalsNow();
		return calc.toString();
	}
}
