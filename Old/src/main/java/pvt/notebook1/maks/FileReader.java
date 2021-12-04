///Вообще всё отлично. Максимально придирчиво откоментировал. По сути претензий нет. Только по стилю коментарии, как улучшить.
///Почему долго, если долго, не скажу. Не вижу простых способов, как это можно значительно ускорить. Потенциально тормознутых мест тоже не вижу. 
///Хотя ускорить можно попробовать, если прочитать в память весь файл одной командой рид, потом также записать однойкомандой, а не строчка за строчкой.
///Некоторые улучшения ты ещё можешь сделать, если почитаешь главу 10 или 11 книги Совершенный 
///код (не помню в какой из них про оптимальную область видимости и интервал использования переменных было).
package pvt.notebook1.maks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

///Это ещё что за чудо-импорт? Видимо случайно кликнул на подсказку не ту, та ещё экзотика).
//import com.sun.corba.se.impl.orbutil.graph.Node;

///Я просил писать текст выполненного задания при домашке. А то ж не помню, что должна программа вообще делать.
public class FileReader {
    public static void main(String[] args) throws IOException {
	long time = System.nanoTime();
	/// лучше List<cityUnit> cityList = new ArrayList<cityUnit>();
	/// Переменные лучше иметь наболее абстрактного типа из подходящих, а
	/// объекты уже какие требуются.
	/// И имя класса cityUnit с маленькой буквы, нарушение конвенции
	/// именования.
	ArrayList<cityUnit> list = new ArrayList<cityUnit>();
	String temp; /// Неудачное имя. Лучше называть так, чтоб я сразу мог
		     /// догадаться, что с этим темпои потом будет.
	File source = new File("resources/cities/worldcities.txt"); /// Стоит выносить такой текст в именованные константы.7
	 /// Ты наверное хотел сказать worldNonEmptyPopulation.txt?
	PrintWriter writer = new PrintWriter(new FileWriter("resources/cities/worldEmptyPopulation.txt"));
	Scanner sc = new Scanner(source);
	while (sc.hasNextLine()) {
	    temp = sc.nextLine();
	    String[] arrayCity = temp.split(",");
	    if (arrayCity[4].isEmpty()) {
		/// неудачное имя node, ты как бы акцентируешь, что это узел
		/// листа. Но по смыслу это прежде всего город
		cityUnit node = new cityUnit(arrayCity[0], arrayCity[1], arrayCity[2], Integer.parseInt(arrayCity[3]),
			Double.parseDouble(arrayCity[5]), Double.parseDouble(arrayCity[6]));
		list.add(node);
	    } else {
		cityUnit node = new cityUnit(arrayCity[0], arrayCity[1], arrayCity[2], Integer.parseInt(arrayCity[3]),
			Integer.parseInt(arrayCity[4]), Double.parseDouble(arrayCity[5]),
			Double.parseDouble(arrayCity[6]));
		list.add(node);
	    }
	}
	sc.close(); /// тут try-finally было правильнее использовать. А то если
		    /// исключение, которое ты отдал Джава машине обрабатывать,
		    /// то не закроется поток в сканнере.
	ArrayList<cityUnit> listBy = new ArrayList<cityUnit>();
	ArrayList<cityUnit> listNotEmptyPopulation = new ArrayList<cityUnit>();

	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i).getShortName().equals("by") && list.get(i).getPopulation() > 50000) {
		listBy.add(list.get(i));
	    }
	    if (list.get(i).getPopulation() != 0) {
		listNotEmptyPopulation.add(list.get(i));
	    }

	}
	getAllcities(listBy); /// ты наверное хотел сказать printAllCities

	for (int i = 0; i < listNotEmptyPopulation.size(); i++) {

	    writer.println(listNotEmptyPopulation.get(i));
	}
	writer.close();
	
	System.out.println((System.nanoTime() - time)/1000000000.0);
    }

    public static void getAllcities(ArrayList<cityUnit> list) {
	for (int i = 0; i < list.size(); i++) {
	    System.out.println(list.get(i).toString());
	}
    }
}
