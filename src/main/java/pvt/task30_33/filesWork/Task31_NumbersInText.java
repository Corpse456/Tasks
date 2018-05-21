/**
 * Имеется файл с текстом, в котором присутствуют числа.
 *  Найти все числа, распечатать, посчитать сумму, убрать
 *  все повторяющиеся числа и снова распечатать.
 */
package pvt.task30_33.filesWork;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import workWithFiles.fileIO.ReaderFromFile;

public class Task31_NumbersInText {

    private static StringBuilder text = new StringBuilder();
    private static List<Integer> numbers = new ArrayList<>();

    public static void main (String[] args) {
	ReaderFromFile reader = new ReaderFromFile("src\\main\\resources\\text.txt");

	while (reader.isReady()) {
	    String string = reader.readLine();
	    text.append(string);
	}
	
	String[] splitText = text.toString().split("\\D");
	
	for (String string : splitText ) {
	    if (!string.isEmpty()) {
		numbers.add(Integer.parseInt(string));
	    }
	}
	System.out.println(numbers);
	
	int sum = 0;
	TreeSet<Integer> uniqNum = new TreeSet<>();
	for (int num : numbers) {
	    sum += num;
	    uniqNum.add(num);
	}
	System.out.println(sum);
	System.out.println(uniqNum);
    }
}