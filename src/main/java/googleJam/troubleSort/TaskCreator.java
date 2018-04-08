package googleJam.troubleSort;

import fileOperation.WriterToFile;

public class TaskCreator {

    public static void main (String[] args) {
        WriterToFile writer = new WriterToFile("C:/trouble.txt");
        
        int t = 100;
        writer.writeLine(t);
        
        for (int i = 1; i <= t; i++) {
            int d = i;
            writer.writeLine(d);
            
            for (int j = 0; j < d; j++) {
                writer.write((int) (Math.random() * 100 + 3) + " ");
            }
            writer.writeLine();
        }
        writer.close();
    }
}
