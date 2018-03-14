package pvt.xo;

public class Main {
    
    public static void main(String[] args) {
	
	Field field = new Field();
	System.out.println(field);

	int i, j;
	int queue = 0;
	do {
	    queue %= 2;
	    System.out.println("Player " + (queue+1) + " move");
	    byte move = GetMove.get();
	    i = move / 10;
	    j = move % 10;
	    if (field.field[i][j] == 0) {
		field.field[i][j] = queue+++ 1;
		System.out.println(field);
	    }
	} while (field.notEnd(i, j));

	System.out.println("Player " + queue + " win!");
    }
}