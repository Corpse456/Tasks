package pvt.task29.freq;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Days {
    public static void main(String[] args) throws Exception {
	InputStream input = System.in;
	Reader reader = new InputStreamReader(input);
	BufferedReader buff = new BufferedReader(reader);

	int day = Integer.parseInt(buff.readLine());

	switch (day) {
	case 1:
	    System.out.println("понедельник");
	    break;
	case 2:
	    System.out.println("вторник");
	    break;
	case 3:
	    System.out.println("среда");
	    break;
	case 4:
	    System.out.println("четверг");
	    break;
	case 5:
	    System.out.println("пятница");
	    break;
	case 6:
	    System.out.println("суббота");
	    break;
	case 7:
	    System.out.println("воскресенье");
	    break;

	default:
	    System.out.println("такого дня недели не существует");
	    break;
	}
    }
}