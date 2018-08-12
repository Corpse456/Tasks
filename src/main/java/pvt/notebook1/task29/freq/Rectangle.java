package pvt.notebook1.task29.freq;

public class Rectangle {
    int top, left, width, height;

    public Rectangle(int top, int left, int width, int height) {
	this.top = top;
	this.left = left;
	this.width = width;
	this.height = height;
    }

    public Rectangle(int top, int left) {
	this.top = top;
	this.left = left;
	width = 0;
	height = 0;
    }
    
    public Rectangle(int top, int left, int width) {
	this.top = top;
	this.left = left;
	this.width = width;
	height = width;
    }
    
    public Rectangle(Rectangle other) {
	top = other.top;
	left = other.left;
	width = other.width;
	height = other.width;
    }

    public static void main(String[] args) {

    }
}