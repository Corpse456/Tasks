package googleJam.troubleSort;

import workWithFiles.fileIO.WriterToFile;

public class TaskCreator {

    public static void main (String[] args) {
        WriterToFile writer = new WriterToFile("trouble.txt");
        
        int t = 100;
        writer.writeLine(t);
        
        for (int i = 1; i <= t; i++) {
            int d = (int) (Math.random() * 100000 + 3);
            writer.writeLine(d);
            
            for (int j = 0; j < d; j++) {
                writer.write((int) (Math.random() * 1000000000) + " ");
            }
            writer.writeLine();
        }
        writer.close();
    }
}
