package pvt.javaHelp;

public class Array2d {
    
    public static void main(String[] args) {
	char[][] alphabet = new char[5][5];
	char count = 'A';
	for (int i = 0; i < alphabet.length; i++) {
	    for (int j = 0; j < alphabet[i].length; j++) {
		alphabet[i][j] = count++; 
	    }
	}
	print(alphabet);
	
	char[][] alphabet2 = new char[alphabet.length][alphabet[0].length];
	for (int i = 0; i < alphabet.length; i++) {
	    for (int j = alphabet[i].length - 1; j >= 0; j--) {
		alphabet2[alphabet[i].length - 1 - j][i] = alphabet[i][j]; 
	    }
	}
	print(alphabet2);
    }
    
    public static void print(char[][] alphabet) {
	for (int i = 0; i < alphabet.length; i++) {
	    for (int j = 0; j < alphabet[i].length; j++) {
		System.out.print(alphabet[i][j] + " ");
	    }
	    System.out.println();
	}
	System.out.println();
    }
}