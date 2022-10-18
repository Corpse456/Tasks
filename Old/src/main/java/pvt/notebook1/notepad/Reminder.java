package pvt.notebook1.notepad;

import java.util.Date;

/**
 * Element Notepad
 * 
 * @see Notepad
 * @author Ilya Zhukov
 */
public class Reminder {
	private static long countID = 1000;
	private long id;
	private Date date;// TODO
	private String dateString;
	private String reminder;
	private String dateReminder;

	public Reminder() {
		countID++;
		System.out.println("Enter reminder:\n");
		writeReminder();
		writeDateReminder();
		date = new Date();
		this.dateString = NotepadUtilits.dateToString(date);
		this.id = getCount();
	}

	public void writeDateReminder() {
		System.out.println("Enter date reminder(yyyy.mm.dd hh:mm)\n");
		while (true) {
			this.dateReminder = NotepadUtilits.scannerLine();

			// Отмена ввода
			if (dateReminder.equals("-1")) {
				dateReminder = "No date";
				return;
			}

			// Проветка коректного ввода
			if (NotepadUtilits.validateDateString(dateReminder)) {
				return;
			} else {
				System.out.println("Invalid input");
			}
		}

	}

	public void writeReminder() {
		this.reminder = NotepadUtilits.scannerLine();
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

	public String getReminder() {
		return reminder;
	}

	public String getDateReminder() {
		return dateReminder;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		String string = "";
		string = string + "ID:" + getId() + "\tDate create: " + getDateString() + "\tDateReamider: " + getDateReminder()
				+ "\nRemider:\n" + getReminder() + "\n\n";

		return string;
	}

}
