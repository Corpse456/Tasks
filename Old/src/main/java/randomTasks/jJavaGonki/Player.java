package randomTasks.jJavaGonki;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {

    public static final int MAX_V = 77;
    public static final int MAX_TOP = 270;
    public static final int MAX_BOTTOM = 720;

    Image img_c = new ImageIcon(getClass().getClassLoader().getResource("Resurses/carone.png")).getImage();
    Image img_l = new ImageIcon(getClass().getClassLoader().getResource("Resurses/carjneleft.png")).getImage();
    Image img_r = new ImageIcon(getClass().getClassLoader().getResource("Resurses/caroneright.png")).getImage();

    Image img = img_c;

    public Rectangle getRect() {
	return new Rectangle(x, y, 150, 60);
    }

    int v = 0;
    int dv = 0;
    int s = 0;

    int x = 100;
    int y = 300;
    int dy = 0;

    int layer1 = 0;
    int layer2 = 1200;

    public void move() {
	s += v;
	v += dv;
	if (v <= 0)
	    v = 0;
	if (v >= MAX_V)
	    v = MAX_V;
	y -= dy;
	if (y <= MAX_TOP)
	    y = MAX_TOP;
	if (y >= MAX_BOTTOM)
	    y = MAX_BOTTOM;
	if (layer2 - v <= 0) {
	    layer1 = 0;
	    layer2 = 1200;
	} else {
	    layer1 -= v;
	    layer2 -= v;
	}
    }

    public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	if (key == KeyEvent.VK_RIGHT) {
	    dv = 100000;
	}
	if (key == KeyEvent.VK_LEFT) {
	    dv = -1;
	}
	if (key == KeyEvent.VK_UP) {
	    dy = 4;
	    img = img_l;
	}
	if (key == KeyEvent.VK_DOWN) {
	    dy = -4;
	    img = img_r;
	}
    }

    public void keyReleased(KeyEvent e) {
	int key = e.getKeyCode();
	if (key == KeyEvent.VK_RIGHT) {
	    dv = 0;
	}
	if (key == KeyEvent.VK_LEFT) {
	    dv = 0;
	}
	if (key == KeyEvent.VK_UP) {
	    dy = 0;
	    img = img_c;
	}
	if (key == KeyEvent.VK_DOWN) {
	    dy = 0;
	    img = img_c;
	}
    }
}