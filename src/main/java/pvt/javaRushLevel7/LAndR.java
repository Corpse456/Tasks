package pvt.javaRushLevel7;

import java.util.ArrayList;

public class LAndR {

    public static void main(String[] args) {

	ArrayList<String> list = new ArrayList<String>();
	list.add("роза"); // 0
	list.add("лоза"); // 1
	list.add("лира"); // 2
	list = fix(list);

	for (String s : list) {
	    System.out.println(s);
	}
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
	int size = list.size();
	for (int i = 0; i < size; i++) {
	    if (list.get(i).contains("л")) {
		list.add(i, list.get(i++));
		size += 1;
	    }
	    if (list.get(i).contains("р")) {
		list.remove(i--);
		size -= 1;
	    }
	}
	return list;
    }
}