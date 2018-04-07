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
import java.util.List;
import java.util.Map.Entry;

public class SenateEvacuation {
    private static HashMap<Character, Integer> senat = new HashMap<>();

    public static void main (String[] args) {
        int[] amounts = { 3, 1, 2, 10, 6, 4, 4, 8, 6, 4, 9, 3, 40 };
        senatorSaving(amounts);
    }

    private static void senatorSaving (int[] amounts) {
        ArrayList<String> plan = new ArrayList<String>();

        for (int i = 0; i < amounts.length; i++) {
            senat.put((char) ('A' + i), amounts[i]);
        }

        for (Entry<Character, Integer> entry : senat.entrySet()) {
            System.out.print(entry + " ");
        }
        System.out.println();

        while (!senat.isEmpty()) {
            Character key = maxFinder();
            String current = key + "";

            exit(key);

            if (!senat.isEmpty()) current += secondMan();
            plan.add(current);
            check();
        }
        System.out.println(plan);
    }

    private static void exit (Character key) {
        int amount = senat.get(key);

        if (amount == 1) senat.remove(key);
        else senat.put(key, amount - 1);
    }

    private static String secondMan () {
        if (senat.size() > 2 || senat.size() == 1) {
            Character key = maxFinder();
            exit(key);
            return key + "";
        }

        List<Integer> valueList = new ArrayList<>(senat.values());

        if (valueList.get(0).equals(valueList.get(1))) return "";

        Character key = maxFinder();
        exit(key);
        return key + "";
    }

    private static Character maxFinder () {
        int max = 0;
        Character letter = null;
        for (Entry<Character, Integer> entry : senat.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                letter = entry.getKey();
            }
        }
        return letter;
    }

    private static void check () {
        List<Integer> valueList = new ArrayList<>(senat.values());

        int sum = 0;
        for (Integer i : valueList) {
            sum += i;
        }

        System.out.println(sum);
        for (Integer i : valueList) {
            if (i > sum - i) System.out.println("false!");
        }
    }
}
