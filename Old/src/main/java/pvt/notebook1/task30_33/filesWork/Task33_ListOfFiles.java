package pvt.notebook1.task30_33.filesWork;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Task33_ListOfFiles {
    public static void main (String[] args) {
	File f = new File("D:/");
	File[] listFiles = f.listFiles();
	List<File> cat = new ArrayList<>();
	List<File> fil = new ArrayList<>();
	for (File file : listFiles) {
	    if (file.isDirectory()) {
		cat.add(file);
	    } else fil.add(file);
	}
	
	System.out.println("Directory: " + cat);
	System.out.println("Files: " + fil);
    }
}