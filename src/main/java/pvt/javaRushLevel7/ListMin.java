package pvt.javaRushLevel7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListMin {

    public static void main(String[] args) throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<String> list = new ArrayList<String>();

	for (int i = 0; i < 5; i++) {
	    list.add(reader.readLine());
	}

	int min = list.get(0).length();

	for (int i = 1; i < list.size(); i++) {
	    if (list.get(i).length() < min)
		min = list.get(i).length();
	}

	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i).length() == min) {
		System.out.println(list.get(i));
	    }
	}
    }
}