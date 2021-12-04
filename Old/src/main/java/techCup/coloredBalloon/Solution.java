package techCup.coloredBalloon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {

    private static List<Glade> glades = new ArrayList<Glade>();

    public static void main (String[] args) {
	String input = "5\n2 3\n5 3\n4 3\n1 3";

	String[] connections = input.substring(2, input.length()).split("\n");
	for (int i = 0; i < connections.length; i++) {
	    String[] temp = connections[i].split(" ");
	    int one = Integer.parseInt(temp[0]);
	    int two = Integer.parseInt(temp[1]);

	    Glade first = gladeCreator(one);
	    Glade second = gladeCreator(two);

	    first.getConnections().add(second);
	    second.getConnections().add(first);
	}
	
	for (int i = 0; i < glades.size(); i++) {
	    Glade temp = glades.get(i);
	    Set<Integer> set = temp.colorFinder();
	    for (int j = 1; j < glades.size() + 1; j++) {
		if (!set.contains(j)) {
		    temp.setColor(j);
		    break;
		}
	    }
	}
	
	
	
	for (Glade g : glades) {
	    System.out.println(g + " " + g.getColor());
	}
    }

    private static Glade gladeCreator (int num) {
	Glade current;
	try {
	    current = glades.get(findInd(num));
	} catch (IOException e) {
	    current = new Glade(num);
	    glades.add(current);
	}
	return current;
    }

    private static int findInd (int one) throws IOException {
	for (int i = 0; i < glades.size(); i++) {
	    if (glades.get(i).getGladeNum() == one) return i;
	}
	throw new IOException();
    }
}