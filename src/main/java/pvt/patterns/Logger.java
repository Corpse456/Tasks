package pvt.patterns;

import java.text.DateFormat;
import java.util.Date;

import workWithFiles.fileIO.WriterToFile;

public class Logger {

    private String path = "C:/log.txt";
    private static Logger inst = null;
    
    public static Logger getInstance () {
        if (inst == null) inst = new Logger();
        return inst;
    }

    private Logger () {
    }

    public <N> void log (N message) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.DEFAULT);
        WriterToFile writer = new WriterToFile(path, true);
        
        writer.write(df.format(new Date()) + " " + message + "\r\n");
        writer.close();
    }

    public String getPath () {
        return path;
    }

    public void setPath (String path) {
        this.path = path;
    }
}
