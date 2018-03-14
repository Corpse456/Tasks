package pvt.excelFor;

public class Change {

    public static void main(String[] args) {
	FileWorks fw = new FileWorks("d:\\Me\\JAVA\\Homeworks\\resources\\box\\output.csv");
	fw.createFile("resources/box/output.scsv");
	
	while (fw.isReady()) {
	    String s = fw.readLine();
	    s = s.replaceAll(",", ";");
	    
	    fw.writeLine(s);
	}
	System.out.println("Done");
    }
}