package pvt.task29.freq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import workWithFiles.fileIO.ReaderFromFile;
import workWithFiles.fileIO.WriterToFile;

public class FrequencyAndDictionary2 {

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
	sort(dict, writer);
	writer.write(dict);
	writer.close();
    }

    /**
     * @param dict
     * @param writer 
     */
    private static void sort (Map<String, Integer> dict, WriterToFile writer) {
	List<Entry<String, Integer>> list = new ArrayList<>(dict.entrySet());
	for (int i = 0; i < list.size(); i++) {
	    int max = i;
	    for (int j = i + 1; j < list.size(); j++) {
		if (list.get(j).getValue() > list.get(max).getValue()) {
		    max = j;
		}
	    }
	    if (max != i) {
		swap(max, i, list);
	    }
	}
	for (Entry<String, Integer> entry : list) {
	    System.out.println(entry.getKey() + ": " + entry.getValue());
	}
	writer.write(list);
    }

    private static void swap (int max, int i, List<Entry<String, Integer>> list) {
	Entry<String, Integer> temp = list.get(max);
	list.set(max, list.get(i));
	list.set(i, temp);
	
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