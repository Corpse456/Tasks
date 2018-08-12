package pvt.notebook1.abstractt;

public class Rectangle extends Fig
{
	private float h;
	private float w;

	public Rectangle()
	{
		x = 1;
		y = 1;
		w = 1;
		h = 1;
	}

	public float calcArea()
	{
		return h * w;
	}

	public void printType()
	{
		System.out.println("Прямоугольник");
	}
}