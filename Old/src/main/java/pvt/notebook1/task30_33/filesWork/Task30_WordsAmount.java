//Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов.
package pvt.notebook1.task30_33.filesWork;

import java.util.ArrayList;
import java.util.List;

import workWithFiles.fileIO.ReaderFromFile;

public class Task30_WordsAmount {

    private static List<String> text = new ArrayList<>();
    private static String punctuationMarks = "():-.,?!\"";

    public static void main (String[] args) {
	ReaderFromFile reader = new ReaderFromFile("src\\main\\resources\\text.txt");
	int punctMarks = 0, words = 0;

	while (reader.isReady()) {
	    String string = reader.readLine();
	    text.add(string);
	}

	for (String string : text) {
	    for (int i = 0; i < string.length(); i++) {
		if (punctuationMarks.contains(string.charAt(i) + "")) {
		    if (string.charAt(i) == '.' && i < string.length() - 2 && string.charAt(i + 1) == '.' 
			    && string.charAt(i + 2) == '.') i += 2;
		    punctMarks++;
		    continue;
		}
		if (Character.isAlphabetic(string.charAt(i))) {
		    words++;
		    while (i < string.length() - 1 && Character.isAlphabetic(string.charAt(i + 1))) i++;
		}
	    }
	}
	
	System.out.printf("Punctuation marks: %d, words: %d",punctMarks,words);
    }
}