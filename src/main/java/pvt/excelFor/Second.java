package pvt.excelFor;

public class Second {

    public static void main(String[] args) {
	String output = "=СУММ(";
	
	int i = 9;
	while (i <= 277) {
	    output += "E" + i + ";";
	    i += 16;
	}
	output += ")";
	
	System.out.println(output);
    }
}