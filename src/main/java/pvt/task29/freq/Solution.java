package pvt.task29.freq;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        int[] big = new int[15];
        
        for (int i = 0; i < big.length; i++) {
	    big[i] = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
	}
        
        int odd = 0;
        int even = 0;
        
        for (int i = 0; i < big.length; i++) {
	    if (i % 2 == 0) {
		even += big[i];
	    } else {
		odd += big[i];
	    }
	}
        
        System.out.println(even > odd ? "В домах с четными номерами проживает больше жителей." : 
            "В домах с нечетными номерами проживает больше жителей."); 
    }
}