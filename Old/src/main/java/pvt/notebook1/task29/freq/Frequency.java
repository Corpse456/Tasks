package pvt.notebook1.task29.freq;

public class Frequency {

    private static String text = "The British Isles lie in the north-west of Europe. They consist of two large islands, Great Britain and Ireland, and many smaller ones. Great Britain, the largest island in Europe, includes England, Scotland, and Wales. It is separated from Ireland by the Irish Sea, and from the Continent by the English Channel and the Straits of Dover. Great Britain and Northern Ireland form the United Kingdom (UK). The surface of England and Ireland is flat, but the surface of Scotland and Wales is mountainous. The mountains are almost all in the western part. The highest mountain in the United Kingdom is Ben Nevis in Scotland (1343 m). The longest river is the Severn. It is in the south-west of England. The Thames is not so long as the Severn, it is shorter. The sea enters deeply into the land and has a great influence on the climate, which is damp but rather mild: the winter is not very cold and the summer is not very hot. Over 57 million people live in the United Kingdom. Most of the people of Great Britain live in big towns and cities. The capital of the country is London. The main industrial centres are Sheffield and Birmingham where iron goods are made, Manchester, the cotton centre of England, and others. The important ports of the country are London, Liverpool, Glasgow and others.";

    public static void main(String[] args) {

	int[] alphabet = new int[26];
	int temp = 0;
	for (int i = 0; i < text.length(); i++) {
	    if (text.charAt(i) < 'A' || text.charAt(i) > 'z' || (text.charAt(i) > 'Z' && text.charAt(i) < 'a')) {
		continue;
	    }

	    temp = text.charAt(i) - ((text.charAt(i) > 'Z') ? 'a' : 'A');

	    alphabet[temp] += 1;
	}

	for (int i = 0; i < alphabet.length; i++) {
	    System.out.println((char) (i + 'A') + " : " + ((alphabet[i] / (double) text.length()) * 100
		    - ((alphabet[i] / (double) text.length()) * 100 % 0.3)));
	}
    }
}