/*
 * Problem
A certain bathroom has N + 2 stalls in a single row; the stalls on the left and right ends are permanently occupied by the bathroom guards. The other N stalls are for users.
Whenever someone enters the bathroom, they try to choose a stall that is as far from other people as possible. To avoid confusion, they follow deterministic rules: For each empty stall S, they compute two values LS and RS, each of which is the number of empty stalls between S and the closest occupied stall to the left or right, respectively. Then they consider the set of stalls with the farthest closest neighbor, that is, those S for which min(LS, RS) is maximal. If there is only one such stall, they choose it; otherwise, they choose the one among those where max(LS, RS) is maximal. If there are still multiple tied stalls, they choose the leftmost stall among those.
K people are about to enter the bathroom; each one will choose their stall before the next arrives. Nobody will ever leave.
When the last person chooses their stall S, what will the values of max(LS, RS) and min(LS, RS) be?
Input
The first line of the input gives the number of test cases, T. T lines follow. Each line describes a test case with two integers N and K, as described above.
Output
For each test case, output one line containing Case #x: y z, where x is the test case number (starting from 1), y is max(LS, RS), and z is min(LS, RS) as calculated by the last person to enter the bathroom for their chosen stall S.
Limits
1 ≤ T ≤ 100.
1 ≤ K ≤ N.
Time limit: 30 seconds per test set.
Memory limit: 1GB.
Test set 1 (Visible)
1 ≤ N ≤ 1000.
Test set 2 (Visible)
1 ≤ N ≤ 106.
Test set 3 (Hidden)
1 ≤ N ≤ 1018.
Sample
Input     
5
4 2
5 2
6 2
1000 1000
1000 1
Output 
Case #1: 1 0
Case #2: 1 0
Case #3: 1 1
Case #4: 0 0
Case #5: 500 499
 */

package googleJam.bathroomStalls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SlowSoltion {
    
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
        
        boolean[] stall = new boolean[stalls + 2];
        stall[0] = stall[stall.length - 1] = true;
        
        for (int i = 0; i < people; i++) {
            int max = maximum(stall);
            stall[max] = true;
        }
        return null;
    }

    private static int maximum (boolean[] stall) {
        List<int[]> list = new ArrayList<>();
        for (int j = 1; j < stall.length - 1; j++) {
            if (!stall[j]) {
                int[] dist = new int[2];

                for (int i = j - 1; i >= 0; i--) {
                    if (!stall[i]) dist[0]++;
                    else break;
                }
                for (int i = j; i < stall.length; i++) {
                    if (!stall[i]) dist[1]++;
                    else break;
                }
                list.add(dist);
            }
        }
        
        
        return 0;
    }
}