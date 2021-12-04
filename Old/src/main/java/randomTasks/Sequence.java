package randomTasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sequence {

    public static void main (String[] args) {
        findSequence((long)(Math.random() * 9223372036854775807L));
    }

    private static void findSequence (long string) {
        char[] charArray = (string + "").toCharArray();
        List<Integer> ascendingSequences = new ArrayList<>();
        List<Integer> descendingSequences = new ArrayList<>();
        List<Integer> repeatSequences = new ArrayList<>();
        StringBuilder currentAscending = new StringBuilder();
        StringBuilder currentDescending = new StringBuilder();
        StringBuilder currentRepeat = new StringBuilder();

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] > charArray[i - 1]) {
                updateSecuences(charArray, descendingSequences, repeatSequences, i, currentAscending, currentDescending,
                        currentRepeat);
            } else if (charArray[i] < charArray[i - 1]) {
                updateSecuences(charArray, ascendingSequences, repeatSequences, i, currentDescending, currentAscending,
                        currentRepeat);
            } else {
                updateSecuences(charArray, ascendingSequences, descendingSequences, i, currentRepeat, currentAscending,
                        currentDescending);
            }
        }
        if (currentAscending.length() != 0) ascendingSequences.add(Integer.parseInt(currentAscending.toString()));
        if (currentDescending.length() != 0) descendingSequences.add(Integer.parseInt(currentDescending.toString()));
        if (currentRepeat.length() != 0) repeatSequences.add(Integer.parseInt(currentRepeat.toString()));
        
        System.out.println("ascendingSequences: " + (ascendingSequences.isEmpty() ? "Nope" : Collections.max(ascendingSequences)));
        System.out.println("descendingSequences: " + (descendingSequences.isEmpty() ? "Nope" : Collections.max(descendingSequences)));
        System.out.println("repeatSequences: " + (repeatSequences.isEmpty() ? "Nope" : Collections.max(repeatSequences)));
    }

    private static void updateSecuences (char[] charArray, List<Integer> descendingSequences, List<Integer> repeatSequences,
            int i, StringBuilder currentHead, StringBuilder currentFirst, StringBuilder currentSecond) {
        if (currentHead.length() == 0) {
            currentHead.append(charArray[i - 1]);
            if (currentFirst.length() != 0) {
                descendingSequences.add(Integer.parseInt(currentFirst.toString()));
                currentFirst.setLength(0);
            }
            if (currentSecond.length() != 0) {
                repeatSequences.add(Integer.parseInt(currentSecond.toString()));
                currentSecond.setLength(0);
            }
        }
        currentHead.append(charArray[i]);
    }
}
