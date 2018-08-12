package pvt.notebook1.notepad;

/**
 * Controller-View for Notebook
 * 
 * @author Ilya Zhukov
 */
public class TextUI {
    private Notepad np = null;;

    public TextUI(Notepad np) {
	this.np = np;
    }

    public TextUI() {
	this.np = new Notepad();
    }

    public void StartUI() {
	if (np != null) {
	    TopMenu(np);
	}
	// TODO обработка ошибки если интерфес не имеет блокнота;
    }

    // Level 1
    private void TopMenu(Notepad np) {
	System.out.print("Welcom Notepad v1.0. ");
	while (true) {
	    System.out.println("What do you want to do?");
	    System.out.println("\t1.Work for notes\n\t2.Work for reminders\n\t3.Exit");

	    String choise = NotepadUtilits.scannerLine();

	    switch (choise) {
	    // Work for notes
	    case ("1"):
		menuNotes(np);
		break;
	    // Work for reminders
	    case ("2"):
		menuReminders(np);
		break;
	    // Show all records
	    case ("4"):
		menuShowAll(np);
		break;
	    // Exit
	    case ("3"):
		return;

	    default:
		break;
	    }
	}
    }

    // Level 2
    private Notepad menuNotes(Notepad np) {
	while (true) {
	    System.out.println("What do you want to do for notes?");
	    System.out.println("\t1.Add notes\n\t2.Show notes\n\t3.Will return");
	    String choiseNotes = NotepadUtilits.scannerLine();
	    switch (choiseNotes) {
	    case ("1"):
		System.out.println("Enter text:\n");
		np.addNote();
		break;
	    case ("2"):
		menuShowAllNotes(np);
		break;
	    case ("3"):
		return np;
	    default:
		break;
	    }
	}

    }

    // Level 2
    private Notepad menuReminders(Notepad np) {
	while (true) {
	    System.out.println("What do you want to do for reminders?");
	    System.out.println("\t1.Add reminders\n\t2.Show reminders\n\t3.Will return");
	    String choiseRemainders = NotepadUtilits.scannerLine();
	    switch (choiseRemainders) {
	    case ("1"):
		np.addReminder();
		break;
	    case ("2"):
		menuShowAllReminder(np);
		break;
	    case ("3"):
		return np;
	    default:
		break;
	    }

	}

    }

    // Level 2
    private Notepad menuShowAll(Notepad np) {
	// TODO 3-е задание
	return np;
    }

    // Level 3
    private Notepad menuShowAllNotes(Notepad np2) {

	System.out.println(np.showAllNotes());

	while (true) {
	    System.out.println("\n-=MENU NOTES=-");
	    System.out.println(
		    "\t1.Add note\n\t2.Overwrite note\n\t3.Remove note\n\t4.Show all notes\n\t5.Will return\n\n\n");

	    long id;

	    String choiseMenuShowNotes = NotepadUtilits.scannerLine();
	    switch (choiseMenuShowNotes) {

	    // Add note
	    case ("1"):
		np.addNote();
		break;

	    // Overwrite note
	    case ("2"):
		System.out.println("\nEnter ID of note for overwrite(For cancel enter -1)\n");
		while (true) {
		    try {
			id = Long.parseLong(NotepadUtilits.scannerLine());
		    } catch (Exception e) {
			id = -500;
		    }

		    if (id == -500 || id < 0) {
			System.out.println("Invalid enter");
		    } else {
			if (id == -1) {
			    System.out.println("Enter canceled");
			} else {
			    System.out.println("Note: " + id + " ready to overwrite\n\n");
			    np.overwriteNote(id);
			}
			break;
		    }
		}
		break;

	    // Remove note
	    case ("3"):
		System.out.println("\nEnter ID of note for remove(For cancel enter -1)\n");
		while (true) {
		    try {
			id = Long.parseLong(NotepadUtilits.scannerLine());
		    } catch (Exception e) {
			id = -501;
		    }

		    if (id == -501 || id < 0) {
			System.out.println("Invalid enter");
		    } else {
			if (id == -1) {
			    System.out.println("Enter canceled");
			} else {
			    np.removeNote(id);
			    System.out.println("Note: " + id + " was removed");
			}
			break;
		    }
		}
		break;

	    // Show all notes
	    case ("4"):
		System.out.println("\n\n\n********Notes*********\n\n");
		System.out.println(np.showAllNotes());
		System.out.println("\n***********************\n");
		break;

	    // Will return
	    case ("5"):
		return np;
	    default:
		break;
	    }
	}

    }

    // Level 3
    private Notepad menuShowAllReminder(Notepad np) {

	System.out.println(np.showAllReminder());

	while (true) {
	    System.out.println("\n-=MENU REMAINDER=-");
	    System.out.println(
		    "\t1.Add remainder\n\t2.Overwrite remainder\n\t3.Remove remainder\n\t4.Show all remainders\n\t5.Will return\n\n\n");

	    long id;

	    String choiseShowReminder = NotepadUtilits.scannerLine();
	    switch (choiseShowReminder) {

	    // Add remainder
	    case ("1"):
		np.addReminder();
		break;

	    // Overwrite remainder
	    case ("2"):
		System.out.println("\nEnter ID of reminderfor overwrite(For cancel enter -1)\n");
		while (true) {
		    try {
			id = Long.parseLong(NotepadUtilits.scannerLine());
		    } catch (Exception e) {
			id = -100;
		    }

		    if (id == -100 || id < 0) {
			System.out.println("Invalid enter");
		    } else {
			if (id == -1) {
			    System.out.println("Enter canceled");
			} else {
			    System.out.println("Reminder: " + id + " ready to overwrite\n\n");
			    np.overwriteReminder(id);
			}
			break;
		    }
		}
		break;

	    // Remove remainder
	    case ("3"):

		System.out.println("\nEnter ID of remindern for remove(For cancel enter -1)\n");
		while (true) {
		    try {
			id = Long.parseLong(NotepadUtilits.scannerLine());
		    } catch (Exception e) {
			id = -101;
		    }

		    if (id == -101 || id < 0) {
			System.out.println("Invalid enter");
		    } else {
			if (id == -1) {
			    System.out.println("Enter canceled");
			} else {
			    System.out.println("Reminder: " + id + " was removed");
			    np.removeReminder(id);
			}
			break;
		    }
		}
		break;

	    // Show all remainders
	    case ("4"):
		System.out.println("\n\n\n*******Reamaiders******\n\n");
		System.out.println(np.showAllReminder());
		System.out.println("\n***********************\n");
		break;

	    // Will return
	    case ("5"):
		return np;
	    default:
		break;
	    }
	}

    }

}
