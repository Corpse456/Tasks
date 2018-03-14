package pvt.xo;

public class Field {
    int size = 3;
    int[][] field = new int[size][size];

    public boolean notEnd(int i, int j) {
	if (field[i][j] == field[(i + 1) % size][j] && field[i][j] == field[(i + 2) % size][j]) {
	    return false;
	}
	if (field[i][j] == field[i][(j + 1) % size] && field[i][j] == field[i][(j + 2) % size]) {
	    return false;
	}
	if (i == j && (field[0][0] == field[1][1] && field[0][0] == field[2][2])) {
	    return false;
	}
	if (Math.abs(i - j) == 2 && (field[0][2] == field[1][1] && field[0][2] == field[2][0])) {
		return false;
	    }
	return true;
    }

    public boolean isEmpty() {
	for (int[] is : field) {
	    for (int i : is) {
		if (i != 0) {
		    return false;
		}
	    }
	}
	return true;
    }
    
    public String toString() {
	String out = new String();
	for (int i = 0; i < field.length; i++) {
	    out += "\t     |     |     \n\t";
	    for (int j = 0; j < field[i].length; j++) {
		if (field[i][j] != 0) {
		    out += (field[i][j] == 1 ? "  X  " : "  O  ");
		} else {
		    out += "     ";
		}
		if (j != size - 1)
		    out += "|";
	    }
	    out += "\n\t     |     |     ";
	    if (i != size - 1)
		out += "\n\t-----------------\n";
	}
	return out;
    }
}
