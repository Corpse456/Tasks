package techCup.AndreyAndSocks.taskCreator;

import java.util.ArrayList;
import java.util.List;

public class ContentCreator {

    private final static int AMOUNT = 10;

    public static void main(String[] args) {
	FileWorks fw = new FileWorks();
	fw.createFile("resources/Andrew/Socks.csv");
	
	for (int i = 0; i < AMOUNT; i++) {
	    System.out.println(i+1);
	    int amount = (int) (Math.random() * 20 + 1);
	    fw.writeLine(amount);
	    List<Integer> pairs = new ArrayList<Integer>();
	    for (int j = 0; j < amount; j++) {
		pairs.add(j + 1);
		pairs.add(j + 1);
	    }
	    List<Integer> chaos = new ArrayList<Integer>();
	    while (pairs.size() > 0) {
		int index = (int) (Math.random() * pairs.size());
		chaos.add(pairs.get(index));
		pairs.remove(index);
	    }
	    fw.writeLine(chaos);
	    //System.out.println(chaos);
	}
	fw.close();
    }
}