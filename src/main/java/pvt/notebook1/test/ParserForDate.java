package pvt.notebook1.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ParserForDate {

    private static String path = "resources/notebook/Rem.txt";
    private static SimpleDateFormat formatForFile = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.ENGLISH);
    
    public static void main(String[] args) {
	FileTreatment ft = new FileTreatment(path);
	
	String temp = ft.fileToString();
	
	String[] longs = temp.split("\r\n\n");
	
	for (String s : longs) {
	    Date data = new Date(Long.parseLong(s));
	    
	    System.out.println(formatForFile.format(data));
	}
    }
}