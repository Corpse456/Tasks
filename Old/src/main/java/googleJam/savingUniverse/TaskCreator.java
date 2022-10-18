package googleJam.savingUniverse;

import workWithFiles.fileIO.WriterToFile;

public class TaskCreator {

    public static void main (String[] args) {
        WriterToFile writer = new WriterToFile("C:/universe.txt");
        
        int t = 1000;
        writer.writeLine(t);
        
        for (int i = 0; i < t; i++) {
            int d = (int) (Math.random() * 10000);
            writer.write(d + " ");
            
            int p = 30;
            for (int j = 0; j < p; j++) {
                if (Math.random() > 0.5) writer.write("C");
                else writer.write("S");
            }
            writer.writeLine();
        }
        writer.close();
    }
}
