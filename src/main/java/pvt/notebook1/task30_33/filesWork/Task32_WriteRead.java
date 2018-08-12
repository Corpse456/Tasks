/**
 * Записать в двоичный файл 20 случайных чисел.
 *  Прочитать записанный файл, распечатать числа и их среднее арифметическое
 */
package pvt.notebook1.task30_33.filesWork;

import workWithFiles.fileIO.ReaderFromFile;
import workWithFiles.fileIO.WriterToFile;

public class Task32_WriteRead {
    
    public static void main (String[] args) {
	WriterToFile writer = new WriterToFile("src\\main\\resources\\num.txt");
	for (int i = 0; i < 20; i++) {
	    writer.writeLine((int) (Math.random() * 10));
	}
	writer.close();
	ReaderFromFile reader = new ReaderFromFile("src\\main\\resources\\num.txt");

	int sum = 0, amount = 0;
	while (reader.isReady()) {
	    String string = reader.readLine();
	    System.out.println(string);
	    amount++;
	    sum += Integer.parseInt(string);    
	}
	reader.close();
	System.out.println("Sum: " + sum);
	System.out.println("Average: " + sum / amount);
    }
}