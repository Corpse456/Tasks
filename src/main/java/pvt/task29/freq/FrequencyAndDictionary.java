package pvt.task29.freq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import fileOperation.ReaderFromFile;
import fileOperation.WriterToFile;

public class FrequencyAndDictionary {

    private static List<String> text = new ArrayList<>();

    public static void main (String[] args) {
	ReaderFromFile reader = new ReaderFromFile("src\\main\\resources\\text.txt");

	while (reader.isReady()) {
	    String string = reader.readLine();
	    text.add(string);
	}

	dictionary();
	freq();
	reader.close();
    }

    private static void dictionary () {
	WriterToFile writer = new WriterToFile("Dictionary.txt");
	Map<String, Integer> dict = new TreeMap<String, Integer>();

	for (String each : text) {
	    if (each.isEmpty()) continue;
	    String[] words = each.replaceAll("(<|\\*|\\(|\\)|\\.|,|\"|!|\\?|:|;|\\d)", "").toLowerCase().split(" "); // [^\\w|\\s]

	    for (String word : words) {
		if (word.isEmpty()) continue;
		if (!dict.containsKey(word)) {
		    dict.put(word, 1);
		} else {
		    dict.put(word, dict.get(word) + 1);
		}
	    }
	}
	writer.write(dict);
	writer.close();
    }

    private static void freq () {
	int amountOfSimbols = 0;
	Map<Character, Integer> alpha = new TreeMap<Character, Integer>();

	for (String each : text) {
	    for (int i = 0; i < each.length(); i++) {
		char cha = each.charAt(i);
		if (Character.isAlphabetic(each.charAt(i))) {
		    amountOfSimbols++;
		    cha = Character.toLowerCase(cha);
		    if (!alpha.containsKey(cha)) {
			alpha.put(cha, 1);
		    } else {
			alpha.put(cha, alpha.get(cha) + 1);
		    }
		}
	    }
	}

	System.out.println("Amount of simbols is " + amountOfSimbols);
	print(alpha, amountOfSimbols);
    }

    private static void print (Map<Character, Integer> map, int amountOfSimbols) {
	for(Entry<Character, Integer> entry: map.entrySet()) {
	    double percent = (int)(entry.getValue()/(double)amountOfSimbols * 100 * 100) / 100.0;
	    System.out.println(entry.getKey() + ": " + entry.getValue() + "\t| " + percent + "%");
	}
    }
}