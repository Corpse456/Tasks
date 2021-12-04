package techCup.notDuble;


import java.util.Set;
import java.util.TreeSet;

public class NotDuble {
    static final int SIZE = 100000;
    static int[] one = new int[SIZE];// = { 3, 1, 2, 3, 6, 4, 3, 4, 8, 2 };

    public static void main(String[] args) {
	for (int i = 0; i < one.length; i++) {
	    one[i] = (int) (Math.random() * (SIZE / 10));
	}
	
	for (int i = 0; i < one.length; i++) {
	    boolean duplicate = false;
	    for (int j = i + 1; j < one.length; j++) {
		if (one[j] == one[i]) {
		    duplicate = true;
		    break;
		}
	    }
	    if (duplicate) continue;
	    for (int j2 = i - 1; j2 >= 0; j2--) {
		if (one[j2] == one[i]) {
		    duplicate = true;
		    break;
		}
	    }
	    if (duplicate) continue;
	    else System.out.print(one[i] + " ");
	}
	
	System.out.println();
	sposob2();
    }

    private static void sposob2() {
	Set<Integer> tree = new TreeSet<Integer>();
	Set<Integer> tree2 = new TreeSet<Integer>();
	
	for (int i = 0; i < one.length; i++) {
	    if(!tree.add(one[i])) {
		tree2.add(one[i]);
	    }
	}
	for (int i = 0; i < one.length; i++) {
	    if (!tree2.contains(one[i])) {
		System.out.print(one[i] + " ");
	    }
	}
    }
}
