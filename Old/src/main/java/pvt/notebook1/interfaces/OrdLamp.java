package pvt.notebook1.interfaces;

public class OrdLamp implements Lamp {

    protected boolean state = false;

    public void on() {
	state = true;
    }

    public void off() {
	state = false;
    }

    public void printState() {
	if (state) {
	    System.out.println("Лампа включена!");
	} else {
	    System.out.println("Лампа выключена!");
	}
    }
}