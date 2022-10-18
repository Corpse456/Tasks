package techCup.teamName;

import java.util.ArrayList;

public class App {

    private static ArrayList<String> varA = new ArrayList<String>();
    private static ArrayList<String> varB = new ArrayList<String>();
    private static ArrayList<String> abbr = new ArrayList<String>();

    public static void main (String[] args) {
	String[] commands = { "Dinamo ByteCity", "playfootball Moscow", "playvolleyball SPB", "GOGO Technocuup",
		"ABC DEF", "ABC EFG", "ABD OOO" };

	for (int i = 0; i < commands.length; i++) {
	    String[] temp = commands[i].split(" ");
	    String temp1 = temp[0].substring(0, 3).toUpperCase();
	    String temp2 = (temp[0].substring(0, 2) + temp[1].substring(0, 1)).toUpperCase();
	    varA.add(temp1);
	    varB.add(temp2);
	}

	for (int i = 0; i < varA.size(); i++) {
	    int count = 0;
	    for (int j = 0; j < varA.size(); j++) {
		if (varA.get(j).equals(varA.get(i))) count++;
	    }
	    if (count > 2) {
		System.out.println("No");
		return;
	    }
	    if (count == 2) {
		abbr.add(varB.get(i));
		continue;
	    }
	    if (!abbr.contains(varA.get(i))) {
		abbr.add(varA.get(i));
	    } else {
		if (!abbr.contains(varB.get(i))) {
		    abbr.add(varB.get(i));
		} else {
		    System.out.println("No");
		    return;
		}
	    }
	}

	for (String s : abbr) {
	    System.out.println(s);
	}
    }
}