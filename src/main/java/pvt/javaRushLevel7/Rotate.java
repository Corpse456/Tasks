package pvt.javaRushLevel7;

public class Rotate {
    public static void main(String[] args) throws Exception {
	int[][] tempo = new int[4][4];

	for (int i = 0; i < tempo.length; i++) {
	    for (int j = 0; j < tempo[i].length; j++) {
		tempo[i][j] = i * tempo[i].length + 1 + j;
	    }
	}
	print(tempo);
	tempo = rotate(tempo);
	print(tempo);
	tempo = rotate(tempo);
	print(tempo);
	tempo = rotate(tempo);
	print(tempo);
	tempo = rotate(tempo);
	print(tempo);
	
	System.out.println();
	int[][] jopa2 = rotate2(tempo);
	print(jopa2);
	
	int[][] jopa = rotateTemp(tempo);
	print(jopa);
	
    }

    private static int[][] rotateTemp(int[][] tempo) {
	int[][] jopa = rotate2(tempo);
	jopa[0][2] = tempo[0][0];
	jopa[1][2] = tempo[0][1];
	jopa[2][2] = tempo[0][2];
	
	jopa[0][1] = tempo[1][0];
	jopa[1][1] = tempo[1][1];
	jopa[2][1] = tempo[1][2];
	
	jopa[0][0] = tempo[2][0];
	jopa[1][0] = tempo[2][1];
	jopa[2][0] = tempo[2][2];
	
	if (tempo[1][3] != -1) {
	    jopa[3][1] = tempo[1][3];
	}
	if (tempo[3][1] != -1) {
	    jopa[1][3] = tempo[3][1];
	}
	return jopa;
    }

    private static int[][] rotate2(int[][] tempo) {
	int[][] jopa = new int[tempo.length][tempo[0].length];
	
	for (int i = 0; i < jopa.length; i++) {
	    for (int j = 0; j < jopa[i].length; j++) {
		jopa[j][jopa.length - 1 - i] = tempo[i][j];
	    }
	}
	return jopa;
    }

    private static int[][] rotate(int[][] tempo) {
	int[][] jopa = new int[tempo.length][tempo[0].length];

	for (int i = 0; i < jopa.length; i++) {
	    for (int j = 0; j < jopa[i].length; j++) {
		jopa[j][jopa.length - 1 - i] = tempo[i][j];
	    }
	}
	return jopa;
    }

    private static void print(int[][] tempo) {
	System.out.println();
	for (int i = 0; i < tempo.length; i++) {
	    for (int j = 0; j < tempo[0].length; j++) {
		System.out.print(tempo[i][j] + " ");
	    }
	    System.out.println();
	}
    }
}