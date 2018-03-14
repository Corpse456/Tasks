package pvt.task29.freq;

public class TomAndJerry {
    public static void main(String[] args) {
        Mouse jerry = new Mouse("Jerry", 12, 5);
        Dog dog = new Dog("Dog", 12, 5);
        Cat tom = new Cat("Tom", 12, 5);
        System.out.println(jerry + "\n" + dog + "\n" + tom);
        System.out.println("04 08 2017");
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }
    
    public static class Dog {
	String name;
	int height;
	int tail;
	
	public Dog(String name, int height, int tail) {
	    this.name = name;
	    this.height = height;
	    this.tail = tail;
	}
    }
    
    public static class Cat {
	String name;
	int height;
	int tail;
	
	public Cat(String name, int height, int tail) {
	    this.name = name;
	    this.height = height;
	    this.tail = tail;
	}
    }
}