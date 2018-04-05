/*
 * Problem
A small fire started in the senate room, and it needs to be evacuated!
There are some senators in the senate room, each of whom belongs to of one of N political parties. Those parties are named after the first N (uppercase) letters of the English alphabet.
The emergency door is wide enough for up to two senators, so in each step of the evacuation, you may choose to remove either one or two senators from the room.
The senate rules indicate the senators in the room may vote on any bill at any time, even in the middle of an evacuation! So, the senators must be evacuated in a way that ensures that no party ever has an absolute majority. That is, it can never be the case after any evacuation step that more than half of the senators in the senate room belong to the same party.
Can you construct an evacuation plan? The senate is counting on you!

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of two lines. The first line contains a single integer N, the number of parties. The second line contains N integers, P1, P2, ..., PN, where Pi represents the number of senators of the party named after the i-th letter of the alphabet.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the evacuation plan. The plan must be a space-separated list of instructions, in the order in which they are to be carried out, where each instruction is either one or two characters, representing the parties of the senators to evacuate in each step.
It is guaranteed that at least one valid evacuation plan will exist. If multiple evacuation plans are valid, you may output any of them.
 */

package googleJam;

import java.util.ArrayList;
import java.util.HashMap;

public class SenateEvacuation {

    public static void main(String[] args) {
        int[] amounts = {2, 2};
        senatorSaving(amounts);
    }

    private static void senatorSaving(int[] amounts) {
        HashMap<Character, Integer> senat = new HashMap<>();
        ArrayList<String> plan = new ArrayList<String>();
        
        for (int i = 0; i < amounts.length; i++) {
            senat.put((char) ('A' + i), amounts[i]);
        }
        
        while (!senat.isEmpty()) {
            Character key = maxFinder(senat);
            String current = senat.get(key) + "";
            current += secondMan(amounts);
        }
    }

    private static String secondMan(int[] amounts) {
        
        return "";
    }

    private static Character maxFinder(HashMap<Character, Integer> senat) {
        int max = 0;
        Character number = 0;
        for (int i = 0; i < senat.size(); i++) {
            Character key = (char) ('A' + i);
            if (senat.get(key) > max) {
                max = senat.get(key);
                number = key;
            }
        }
        return number;
    }
}

/*for (Entry<Character, Integer> entry : senat.entrySet()) {
    System.out.println(entry);
}*/