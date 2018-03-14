package pvt.excelFor;

public class Change23 {

    private static String[] temp;
    
    public static void main (String[] args) {
	FileWorks fw = new FileWorks("resources\\exel\\3.txt");
	fw.createFile("resources/exel/4.txt");
	
	int count = 0;
	while(fw.isReady()) {
	    temp = fw.readLine().split("/");
	    if (count % 2 == 0) {
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
		    sum += Integer.parseInt(temp[i]);
		}
		fw.write("Аналоговые: " + sum + " ");
	    } else {
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
		    sum += Integer.parseInt(temp[i]);
		}
		fw.writeLine("Дискретные: " + sum);
	    }
	    count++;
	}
	fw.close();
    }
}