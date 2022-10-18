package javaRushLeve7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Max {
    
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
	}
        
        int max = -1;
        ArrayList<String> maxIndex = new ArrayList<String>();
        
        for (int i = 0; i < list.size(); i++) {
	    if (max < list.get(i).length()) {
		max = list.get(i).length();
		maxIndex.clear();
		maxIndex.add(list.get(i));
	    } else if (max == list.get(i).length()) {
		maxIndex.add(list.get(i));
	    }
	}
        
        for (int i = 0; i < maxIndex.size(); i++) {
	    System.out.println(maxIndex.get(i));
	}
    }
}