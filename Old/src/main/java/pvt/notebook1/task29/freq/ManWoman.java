package pvt.notebook1.task29.freq;

public class ManWoman {

    public static void main(String[] args) {
	Man man1 = new Man("man1", 40, "Minsk");
	Man man2 = new Man("man2", 20, "Bobr");
	
	Woman woman1 = new Woman("woman1", 30, "Minsk");
	Woman woman2 = new Woman("woman2", 17, "Bobr");
	
	System.out.println(man1);
        System.out.println(man2);
        
        System.out.println(woman1);
        System.out.println(woman2);
    }

    public static class Man {
	String name;
	int age;
	String address;

	public Man(String name, int age, String address) {
	    super();
	    this.name = name;
	    this.age = age;
	    this.address = address;
	}
	
	@Override
	public String toString() {
	    return name + " " + age + " " + address;
	}
    }

    public static class Woman {
	String name;
	int age;
	String address;
	
	public Woman(String name, int age, String address) {
	    super();
	    this.name = name;
	    this.age = age;
	    this.address = address;
	}
	
	@Override
	public String toString() {
	    return name + " " + age + " " + address;
	}
    }
}