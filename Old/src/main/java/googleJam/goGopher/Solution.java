package googleJam.goGopher;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    private static final int SIZE = 1000;
    private static boolean[][] field;
    
    public static void main (String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
        for (int i = 1; i <= t; i++) {
            solve(in);
        }
        in.close();
    }

    private static void solve (Scanner in) {
        field = new boolean[SIZE][SIZE];
        int start = SIZE / 2;
        int start2 = start;
        int width;
        int height;
        int a = in.nextInt();
        
        if (a == 20) {
            width = 4;
            height = 5;
        } else if (a == 200){
            width = 20;
            height = 10;
        } else {
            width = 3;
            height = 4;
        }
        
        start -= width / 2;
        int end = start + width;
        start2 -= height / 2;
        int end2 = start2 + height;
        
        do {
            for (int i = start + 1; i < end - 1; i++) {
                for (int j = start2 + 1; j < end2 - 1; j++) {
                    if (checkSquare(i, j)) continue;
                    
                    System.out.println(i + " " + j);
                    
                    int x = in.nextInt();
                    int y = in.nextInt();
                    
                    if (x < 1 && y < 1) return;
                    
                    field[x][y] = true;
                }
            } 
        } while(true);
    }

    private static boolean checkSquare (int i, int j) {
        for (int l = i - 1; l <= i + 1; l++) {
            for (int k = j - 1; k <= j + 1; k++) {
                if (!field[l][k]) return false;
            }
        }
        return true;
    }
}
