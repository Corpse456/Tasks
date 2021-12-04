package javaRushLeve7;

public class Humans {
    public static void main(String[] args) {
	Human[] humans = new Human[9];
	
	humans[0] = new Human("One", true, 25);
	humans[1] = new Human("Two", false, 23);
	humans[2] = new Human("Three", true, 29);
	humans[3] = new Human("Four", false, 19);
	humans[4] = new Human("Five", true, 25, humans[0], humans[1]);
	humans[5] = new Human("Six", true, 25, humans[2], humans[3]);
	humans[6] = new Human("Seven", false, 23, humans[4], humans[5]);
	humans[7] = new Human("Eight", true, 2, humans[4], humans[5]);
	humans[8] = new Human("Nine", false, 19, humans[4], humans[5]);
	
	for (Human human : humans) {
	    System.out.println(human);
	}
    }

    public static class Human {
	String name;
	boolean sex;
	int age;
	Human father;
	Human mother;

        public Human(String name, boolean sex, int age) {
	    super();
	    this.name = name;
	    this.sex = sex;
	    this.age = age;
	}

	public Human(String name, boolean sex, int age, Human father, Human mother) {
	    super();
	    this.name = name;
	    this.sex = sex;
	    this.age = age;
	    this.father = father;
	    this.mother = mother;
	}

	public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}