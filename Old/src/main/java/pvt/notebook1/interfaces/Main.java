package pvt.notebook1.interfaces;

public class Main {

    public static void main(String[] args) {
	System.out.println(Lamp.lifeTime);
	
	OrdLamp lamp = new OrdLamp();
	
	lamp.printState();
	
	lamp.on();
	
	lamp.printState();
    }
}