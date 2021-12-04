package pvt.notebook1.xo;

public class AI {
    byte lasMove = -1;

    public int move(Field field) {
	int i = 0, j = 0;

	if (lasMove == -1) {
	    if (field.isEmpty()) {
		i = 1;
		j = 1;
	    } else {
		i = 0 + ((int) (Math.random() * 2) * 2);
		j = 0 + ((int) (Math.random() * 2) * 2);
	    }
	}
	
	

	return i * 10 + j;
    }
}