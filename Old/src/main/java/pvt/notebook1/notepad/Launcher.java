package pvt.notebook1.notepad;

/**
 * Launcher<br>
 * Notepad v 1.0
 * 
 * @author Ilya Zhukov
 */
public class Launcher {

    public static void main(String[] args) {

	Notepad notepad1 = new Notepad();
	// Notepad notepad2 = new Notepad();
	// Notepad notepad3 = new Notepad();

	TextUI tui = new TextUI(notepad1);
	tui.StartUI();
    }
}