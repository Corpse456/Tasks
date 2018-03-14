package pvt.internationalization;

import java.text.NumberFormat;
import java.util.Locale;

public class Task1_Money {
    public static void main (String[] args) {
	Locale loc = new Locale("uk", "UA");
	
	NumberFormat num = NumberFormat.getCurrencyInstance(loc);
	System.out.println(num.format(153.5));
    }
}