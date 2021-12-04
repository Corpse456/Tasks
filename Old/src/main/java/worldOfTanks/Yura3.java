package worldOfTanks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Yura3 {
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int s = in.nextInt(); // office
		int x1 = in.nextInt();// dotVasya
		int x2 = in.nextInt();// directionVasya
		int t1 = in.nextInt();// shuttleTimeM
		int t2 = in.nextInt();// VasyaTimeM
		int p = in.nextInt(); // positionShuttle
		int d = in.nextInt();// directionShuttle

		int quickTimeShuttle = 0;
		int quickTimeVasya = 0;
		int distanceShuttle = 0;
		int distanceVasya = 0;

		if (x1 != x2) {
			// Поиск сколько надо лететь шатлу в метрах

			// в офис
			if (d == 1) {
				if (x1 < x2) { // в офис
					distanceShuttle = (s - p);
				} else if (x1 > x2) { // в метро
					distanceShuttle = ((s - p) + s);
				}
			} else if (d == -1) {
				if (x1 < x2) { // в офис
					distanceShuttle = ((s - (s - p)) + s);
				} else if (x1 > x2) { // в метро
					distanceShuttle = s - (s - p);
				}
			}

			if (x1 < x2) {// в офис
				distanceVasya = s - x1;

			} else if (x1 > x2) {// в метро
				distanceVasya = s - (s - x1);
			}

			quickTimeShuttle = distanceShuttle * t1;
			quickTimeVasya = distanceVasya * t2;

			System.out.println((quickTimeShuttle > quickTimeVasya) ? quickTimeVasya : quickTimeShuttle);

		} else
			System.out.println(0);

		in.close();
	}
}