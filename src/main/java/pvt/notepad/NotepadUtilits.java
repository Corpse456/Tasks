package pvt.notepad;

/**
 * Sub-Element Notepad
 * 
 * @see Notepad
 * @author Ilya Zhukov
 */
import java.util.Date;
import java.util.Scanner;

public class NotepadUtilits {
    static Scanner sc = new Scanner(System.in);

    public static String scannerLine() {
	String string = sc.nextLine();
	return string;
    }

    @SuppressWarnings("deprecation")
    public static String dateToString(Date date) {
	String dateString = null;
	// TODO поправить выаод что бы всегда было 16 символов

	dateString = "" + (date.getYear() + 1900) + "." + (date.getMonth() + 1) + "." + date.getDay() + " "
		+ (date.getHours() + 1) + ":" + date.getMinutes() + "\t";
	return dateString;
    }

    public static Date stringToDate(String dateString) {
	Date date = null;
	// TODO for v1.1

	return date;
    }

    public static boolean validateDateString(String dateString) {
	// TODO проверка на числа
	// TODO проверка на актуальность даты
	if (dateString.length() == 16) {
	    if (dateString.charAt(4) == '.' && dateString.charAt(7) == '.' && dateString.charAt(10) == ' '
		    && dateString.charAt(13) == ':') {
		return true;
	    }
	}
	return false;
    }

}
