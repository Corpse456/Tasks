package pvt.notebook1.notepad;

import java.util.Date;

/**
 * Element Notepad
 * 
 * @see Notepad
 * @author Ilya Zhukov
 */
public class Note {
	private static long countID = 5000;
	private long id;
	private Date date;
	private String dateString;
	private String text;

	public Note() {
		countID++;
		writeNote();
		date = new Date();
		this.dateString = NotepadUtilits.dateToString(date);
		this.id = getCount();
	}

	public void writeNote() {
		this.text = NotepadUtilits.scannerLine();
	}

	private static long getCount() {
		return countID;
	}

	public long getId() {
		return id;
	}

	public String getDateString() {
		return dateString;
	}

	public String getText() {
		return text;
	}

	public Date getDate() {
		return date;
	}
	
	@Override
	public String toString(){
		String string = "";
		
		string = string + "ID:" + getId() + "\tDate create: " + getDateString()
						+ "\nText:\n" + getText() + "\n\n";
		return string;
	}

	
}
