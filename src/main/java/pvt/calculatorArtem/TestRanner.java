package pvt.calculatorArtem;

public class TestRanner {

    public static void main(String[] args) {
	CalculatorModel calc = new OneCalc();
	String result = CalculatorPlus.test(calc);
	System.out.println(result);
	String result2 = CalculatorPlus.test2(calc);
	System.out.println(result2);
    }
}