package pvt.notebook1.abstractt;

abstract class Fig
{
	protected float x;
	protected float y;

	float getX()
	{
		return x;
	}

	float getY()
	{
		return y;
	}

	void move(float dx, float dy)
	{
		x += dx;
		y += dy;
	}

	abstract float calcArea();

	abstract void printType();
}