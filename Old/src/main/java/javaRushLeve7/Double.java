package javaRushLeve7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Double {
    
    public static void main(String[] args) throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<String> list = new ArrayList<String>();
	
	for (int i = 0; i < 3; i++) {
            list.add(reader.readLine());
	}
	
	doubleValues(list);
	for (String string : list) {
	    System.out.println(string);
	}
    }

    public static void doubleValues(ArrayList<String> list) {
	for (int i = 0; i < list.size(); i += 2) {
	    list.add(i, list.get(i));
	}
    }
}