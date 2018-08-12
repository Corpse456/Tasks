package pvt.notebook1.notepad;

import java.util.Date;
import java.util.LinkedList;

/**
 * Model Notepad
 * 
 * @author Ilya Zhukov
 */
public class Notepad {
    private LinkedList<Reminder> listReminder;
    private LinkedList<Note> listNote;

    public Notepad() {
	listNote = new LinkedList<Note>();
	listReminder = new LinkedList<Reminder>();
    }

    // Методы добавления
    public void addNote() {
	Note newNode = new Note();
	listNote.addLast(newNode);
    }

    public void addReminder() {
	Reminder newNode = new Reminder();
	listReminder.addLast(newNode);
    }

    // Методы показа записи по ID
    public void showNote(long id) {
	for (int i = 0; i < listNote.size(); i++) {
	    if (listNote.get(i).getId() != id) {
		continue;
	    } else {
		System.out.println(listNote.get(i));
	    }
	}
    }

    public void showRemider(long id) {
	for (int i = 0; i < listNote.size(); i++) {
	    if (listReminder.get(i).getId() != id) {
		continue;
	    } else {
		System.out.println(listReminder.get(i));
	    }
	}
    }

    // Методы показа всех записей одно типа
    public String showAllNotes() {
	String string = "";
	for (int i = 0; i < listNote.size(); i++) {
	    string = string + listNote.get(i);
	}
	return string;
    }

    public String showAllReminder() {
	String string = "";
	for (int i = 0; i < listReminder.size(); i++) {
	    string = string + "ID:" + listReminder.get(i);
	}
	return string;
    }

    // Медоды удаления записи по ID
    public void removeNote(long id) {
	for (int i = 0; i < listNote.size(); i++) {
	    if (listNote.get(i).getId() != id) {
		continue;
	    } else {
		listNote.remove(i);
	    }
	}
    }

    public void removeReminder(long id) {

	for (int i = 0; i < listReminder.size(); i++) {
	    if (listNote.get(i).getId() != id) {
		continue;
	    } else {
		listReminder.remove(i);
	    }
	}
    }

    public String showAll(Date dateBegin, Date dateEnd) {
	// TODO

	return null;

    }

    public void overwriteReminder(long id) {
	for (int i = 0; i < listReminder.size(); i++) {
	    if (listReminder.get(i).getId() != id) {
		continue;
	    } else {

		listReminder.get(i).writeReminder();
		System.out.println("Do you want to change the reminder date? (y/n)");

		while (true) {
		    String answer = NotepadUtilits.scannerLine();

		    switch (answer) {
		    case "n":
			return;
		    case "y":
			listReminder.get(i).writeDateReminder();
			return;
		    default:
			System.out.println("Invalid enter");

		    }
		}
	    }
	}

    }

    public void overwriteNote(long id) {
	for (int i = 0; i < listNote.size(); i++) {
	    if (listNote.get(i).getId() != id) {
		continue;
	    } else {
		listNote.get(i).writeNote();
	    }
	}
    }

}
