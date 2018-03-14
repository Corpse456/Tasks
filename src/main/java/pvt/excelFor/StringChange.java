package pvt.excelFor;

public class StringChange {
    private static String[] temp;
    public static void main (String[] args) {
	FileWorks fw = new FileWorks("resources\\exel\\one.txt");
	fw.createFile("resources/exel/two.txt");
	
	while(fw.isReady()) {
	    temp = fw.readLine().split("\t");
	    if (temp.length == 1) {
		fw.writeLine();
		continue;
	    }
	    fw.writeLine(one("ТС - ", temp[0]) + one(", ТУ - ", temp[1]) + one(", ТИС - ", temp[2]) + one(", ТИИ - ", temp[3]));
	}
	fw.close();
    }

    private static String one (String temp, String temp2) {
	if ("0".equals(temp2) || "-".equals(temp2)) return "";
	return temp + temp2;
    }
}