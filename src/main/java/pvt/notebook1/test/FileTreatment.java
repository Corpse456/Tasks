package pvt.notebook1.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author Neznaev_AI
 *
 */
public class FileTreatment {
    private File f;
    private String path;
    private FileOutputStream fWrite;
    private FileInputStream fRead;

    /**
     * @param path
     *            Путь до файла, содержащего заметки
     * @throws WriteReadException
     *             включает все ошибки при работе с фалом
     */
    public FileTreatment(String path) {
	this.path = path;
	creatingConnectionWithAFile();
    }

    /**
     * @param path
     * @throws WriteReadException
     */
    private void creatingConnectionWithAFile() {
	f = new File(path);
	f.mkdirs();
	if (!f.exists() || !f.isFile()) {
	    f.delete();
	    try {
		f.createNewFile();
	    } catch (IOException e) {
		System.out.println("Could not create file");
	    }
	}
	try {
	    fWrite = new FileOutputStream(f, true);
	    fRead = new FileInputStream(f);
	} catch (FileNotFoundException e) {
	    System.out.println("Some problem with creation FileOutputStream");
	}
    }

    public void clearFile() {
	try {
	    fWrite = new FileOutputStream(f);
	} catch (FileNotFoundException e) {
	    System.out.println("Some problem with creation FileOutputStream");
	}
	print("");
    }

    /**
     * @return Возвращает содержимое фала одним стрингом
     * @throws WriteReadException
     */
    public String fileToString() {
	String s = new String();
	try {
	    while (fRead.available() > 0) {
		s += (char) fRead.read();
	    }
	} catch (IOException e) {
	    System.out.println("Can't open " + f.getAbsolutePath());
	}
	return s;
    }

    public void print(Object s) {
	write(s.toString());
    }

    public void println(Object s) {
	write(s.toString());
	write("\n");
    }

    public void print(String s) {
	write(s);
    }

    public void println(String s) {
	write(s);
	write("\n");
    }

    public void println(byte i) {
	write(i + "");
	write("\n");
    }

    public void print(byte i) {
	write(i + "");
    }

    public void println(short i) {
	write(i + "");
	write("\n");
    }

    public void print(short i) {
	write(i + "");
    }

    public void println(char i) {
	write(i + "");
	write("\n");
    }

    public void print(char i) {
	write(i + "");
    }

    public void println(int i) {
	write(i + "");
	write("\n");
    }

    public void print(int i) {
	write(i + "");
    }

    public void println(double d) {
	write(String.valueOf(d));
	write("\n");
    }

    public void print(double d) {
	write(String.valueOf(d));
    }

    public void println(float f) {
	write(String.valueOf(f));
	write("\n");
    }

    public void print(float f) {
	write(String.valueOf(f));
    }

    private void write(String s) {
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == '\n') {
		try {
		    fWrite.write(13);
		    fWrite.write(10);
		    fWrite.write(s.charAt(i));
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
    }
}