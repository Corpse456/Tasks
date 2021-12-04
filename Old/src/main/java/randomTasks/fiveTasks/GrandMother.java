package randomTasks.fiveTasks;

import java.util.Set;
import java.util.TreeSet;

public class GrandMother {

    public static void main (String[] args) {
	int[] pir = new int[5];
	int amount = 40;
	int count = 0;
	int par1 = 16, par2 = 17, par3 = 22;
	Set<String> set = new TreeSet<String>();

	while (count < 20) {
	    int sum = 0;
	    pir[0] = (int) (Math.random() * amount - pir.length) + 1;
	    sum += pir[0];
	    for (int i = 1; i < pir.length - 1; i++) {
		pir[i] = (int) (Math.random() * (amount - pir.length - sum - +i)) + 1;
		sum += pir[i];
	    }
	    pir[pir.length - 1] = amount - sum;

	    if (pir[0] + pir[3] == par1 && pir[1] + pir[4] == par2 && pir[2] + pir[3] + pir[4] == par3) {
		StringBuilder mass = new StringBuilder();
		for (int i : pir) {
		    mass.append(i + " ");
		}
		String arr = mass.toString();
		if (set.add(arr)) {
		    System.out.println(++count + ": " + arr);
		}
	    }
	}
    }
}