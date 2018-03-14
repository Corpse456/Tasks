package pvt.excelFor;

public class ExcelFor {

    public static void main(String[] args) {
	String input = "=СУММ(H9;H25;H41;H57;H73;H89;H105;H121;H137)";
	String first = "";
	String second = "";
	String third = "";
	
	for (int i = 0; i < input.length(); i++) {
	    if (!Character.isDigit(input.charAt(i))) {
		first += input.charAt(i);
		second += input.charAt(i);
		third += input.charAt(i);
	    } else {
		int j = i;
		while (Character.isDigit(input.charAt(++i)));
		first += (Integer.parseInt(input.substring(j, i)) + 4);
		second += (Integer.parseInt(input.substring(j, i)) + 8);
		third += (Integer.parseInt(input.substring(j, i)) + 12);
		i--;
	    }
	}
	
	System.out.println(input);
	System.out.println(first);
	System.out.println(second);
	System.out.println(third);
    }
}