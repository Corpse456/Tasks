package pvt.notebook1.task29.freq;

public class Cat2 {
    String name;
    int age;
    int weight;
    String address;
    String color;

    String[] colors = { "red", "orange", "yellow", "green", "blue", "sky", "blue", "violet" };
    
    public Cat2(String name) {
	this.name = name;
	age = (int) (Math.random() * 10);
	weight = (int) (Math.random() * 10 + 5);
	color = colors[(int) (Math.random() * colors.length)];
    }

    public Cat2(String name, int weight, int age) {
	this.name = name;
	this.weight = weight;
	this.age = age;
	color = colors[(int) (Math.random() * colors.length)];
    }
    
    public Cat2(String name, int age) {
	this.name = name;
	weight = (int) (Math.random() * 10 + 5);
	this.age = age;
	color = colors[(int) (Math.random() * colors.length)];
    }
    
    public Cat2(int weight, String color) {
	this.weight = weight;
	this.color = color;
	age = (int) (Math.random() * 10);
    }
    
    public Cat2(int weight, String color, String address) {
	this.weight = weight;
	this.color = color;
	this.address = address;
	age = (int) (Math.random() * 10);
    }

    public static void main(String[] args) {

    }
}