package pvt.FiveTasks;

import java.util.HashSet;

public class Sum100 {
    public static void main(String[] args) {
	int count = 0;
	int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	String oper = "+-";
	HashSet<String> all = new HashSet<String>();

	while (count < 100) {
	    String output = "";
	    for (int i = 0; i < numbers.length; i++) {
		int next = (int) (Math.random() * 5);
		if (next == 0) {
		    if (i != numbers.length - 1) {
			output += "" + numbers[i] + numbers[i + 1];
			i++;
		    } else
			output += numbers[i];
		} else if (next > 0 && next < 3) {
		    if (output.length() != 0 && !oper.contains("" + output.charAt(output.length() - 1))) {
			output += "+";
			i--;
		    } else
			output += numbers[i];
		} else if (next > 2 && next < 5) {
		    if (output.length() != 0 && !oper.contains("" + output.charAt(output.length() - 1))) {
			output += "-";
			i--;
		    } else
			output += numbers[i];
		}

	    }
	    if (Polish.refactoring(output) == 100) {
		all.add(output);
		count++;
	    }
	}
	
	count = 1;
	for (String string : all) {
	    System.out.println(count++ + ": " + string);
	}
	
	String res = "1+2+34-5+67-8+9";
	double result = Polish.refactoring(res);
	System.out.println(result);
    }

}
