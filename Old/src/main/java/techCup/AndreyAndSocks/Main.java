package techCup.AndreyAndSocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import techCup.AndreyAndSocks.taskCreator.FileWorks;

public class Main {

    public static void main (String[] args) {
        one();
        System.out.println();
        two();

    }

    /**
     * 
     */
    private static void one () {
        FileWorks fw = new FileWorks("resources/Andrew/Socks.csv");

        while (fw.isReady()) {
            fw.readLine();
            String line = fw.readLine();
            String[] socksString = line.substring(1, line.length() - 1).split(", ");
            List<Integer> socks = new ArrayList<Integer>();

            for (int i = 0; i < socksString.length; i++) {
                socks.add(Integer.parseInt(socksString[i]));
            }

            int maxOnTable = 0;
            Set<Integer> table = new TreeSet<Integer>();
            for (int i = 0; i < socks.size(); i++) {
                if (table.add(socks.get(i))) {
                    if (table.size() > maxOnTable) {
                        maxOnTable = table.size();
                    }
                } else {
                    table.remove(socks.get(i));
                }
            }
            System.out.print(maxOnTable + " ");
        }
    }

    private static void two () {
        FileWorks fw = new FileWorks("resources/Andrew/Socks.csv");

        while (fw.isReady()) {
            int maxOnTable = 0;
            fw.readLine();
            String s = fw.readLine();
            Set<Integer> table = new TreeSet<Integer>();
            for (int i = 1; i < s.length() - 1; i++) {
                String temp = "";
                while (!Character.isDigit(s.charAt(i)))
                    i++;
                while (Character.isDigit(s.charAt(i))) {
                    temp += s.charAt(i++);
                }
                int nextNum = Integer.parseInt(temp);
                if (table.add(nextNum)) {
                    if (table.size() > maxOnTable) {
                        maxOnTable = table.size();
                    }
                } else {
                    table.remove(nextNum);
                }
            }
            System.out.print(maxOnTable + " ");
        }
    }
}
