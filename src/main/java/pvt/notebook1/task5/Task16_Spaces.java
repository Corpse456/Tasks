package pvt.notebook1.task5;

public class Task16_Spaces
{
	public static void main(String[] args)
	{
		String test = "        fuck   off     me ";

		char[] testChar = test.toCharArray();

		int words = 0;
		String temp = new String();
		for (int i = 0; i < testChar.length; i++)
		{
			if (i == 0 && testChar[i] == ' ')
			{
				while (testChar[i + 1] == ' ')
				{
					i++;
				}
			}
			if (testChar[i] == ' ' && i != testChar.length - 1)
			{
				words++;
				while (testChar[i] == ' ')
				{
					i++;
				}
				while (testChar[i] != ' ')
				{
					temp += testChar[i];
					i++;
				}
				if (i != testChar.length - 1)
				{
					temp += ' ';
				}
			}
		}
		String[] result = new String[words];
		int count = 0;
		for (int i = 0; i < temp.length(); i++)
		{
			if (temp.charAt(i) == ' ')
			{
				i++;
				count++;
			}
			result[count] = (result[count] == null) ? new String() : result[count];
			result[count] += temp.charAt(i);
		}
		System.out.println(words);
		System.out.println(temp);
		print(result);
	}

	private static void print(String[] result)
	{
		for (int i = 0; i < result.length; i++)
		{
			System.out.print(result[i] + "/");
		}
	}
}