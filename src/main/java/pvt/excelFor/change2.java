package pvt.excelFor;

public class change2 {
    
    private static String[] temp;
    public static void main (String[] args) {
	FileWorks fw = new FileWorks("resources\\exel\\3.txt");
	fw.createFile("resources/exel/4.txt");
	
	int cout = 0;
	while(fw.isReady()) {
	    int t = 0;
	    temp = fw.readLine().split("/");
	    if ("AI".equals(temp[0])) {
		System.out.println("Fck");
		t = Integer.parseInt(temp[1]);
	    }
	    if ("AO".equals(temp[0])) {
		int ans = Integer.parseInt(temp[1]) + t;
		System.out.println("Аналоговых сигналов: " + ans);
	    }
	    
	    int z = 0;
	    temp = fw.readLine().split(" - ");
	    if ("DI".equals(temp[0])) {
		z = Integer.parseInt(temp[1]);
	    }
	    if ("DO".equals(temp[0])) {
		int ans2 = Integer.parseInt(temp[1]) + z;
		System.out.println("Цифровых сигналов: " + ans2);
	    }
	    System.out.println(++cout);
	}
	fw.close();
    }
}
