package googleJam.bathroomStalls;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FastSolution {
    
    public static void main (String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt(); 
        
        for (int i = 1; i <= tests; i++) {
            String result = solve(in);
            System.out.println("Case #" + i + ": " + result);
        }
        in.close();
    }

    private static String solve (Scanner in) {
        int stalls = in.nextInt();
        int people = in.nextInt();
        
        int interval = stalls / people;
        return null;
    }
}
