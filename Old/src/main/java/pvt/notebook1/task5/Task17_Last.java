package pvt.notebook1.task5;

public class Task17_Last
{
	public static void main(String[] args)
	{
		String test = "        fuck   off     me ";

		char[] testChar = test.toCharArray();

		String temp = new String();
		for (int i = 0; i < testChar.length; i++)
		{
			while (testChar[i] == ' ')
			{
				i++;
			}
			while (i != testChar.length - 1 && testChar[i + 1] != ' ')
			{
				i++;
			}
			temp += testChar[i];
			i++;
		}
		System.out.println(temp);
	}
}