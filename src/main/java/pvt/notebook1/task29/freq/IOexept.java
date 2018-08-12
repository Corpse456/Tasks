package pvt.notebook1.task29.freq;

import java.io.*;

public class IOexept {

    public static void main(String[] args) throws Exception {
	InputStream input = System.in;
	Reader reader = new InputStreamReader(input);
	BufferedReader buff = new BufferedReader(reader);

	String name = buff.readLine();
	String sAge = buff.readLine();
	int nAge = Integer.parseInt(sAge);
	System.out.println(name + " захватит мир через " + nAge + " лет. Му-ха-ха!");
    }
}