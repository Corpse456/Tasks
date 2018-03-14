package pvt.javaRushLevel7;

import java.util.HashSet;

public class List {
    public static void main(String[] args) throws Exception {
        HashSet<String> fuck = new HashSet<String>();
        
        fuck.add("арбуз");
        fuck.add("банан");
        fuck.add("вишня");
        fuck.add("груша");
        fuck.add("дыня");
        fuck.add("ежевика");
        fuck.add("жень-шень");
        fuck.add("земляника");
        fuck.add("ирис");
        fuck.add("картофель");
        
        for (String string : fuck) {
	    System.out.println(string);
	}
    }
}