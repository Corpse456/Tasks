package worldOfTanks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Yura {
	private static final int DISTANCE_MIN = 2;
	private static final int DISTANCE_MAX = 1000;
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TIME_MIN = 1;
	private static final int TIME_MAX = 1000;

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int s = in.nextInt(); // office
		int x1 = in.nextInt();// dotVasya
		int x2 = in.nextInt();// directionVasya
		int t1 = in.nextInt();// shuttleTimeM
		int t2 = in.nextInt();// VasyaTimeM
		int p = in.nextInt(); // positionShuttle
		int d = in.nextInt();// directionShuttle
		double timeSpeedVasya = 0;
		double timeSpeedShuttle = 0;
		int quickTime = 0;
		int distanceShuttle = 0;
		int distanceVasya = 0;
		double intersectionPoint = 0;

		if (x1 != x2) {
			if (DISTANCE_MIN >= s)
				s = DISTANCE_MIN;
			if (s >= DISTANCE_MAX)
				s = DISTANCE_MAX;
			if (ZERO > x1)
				x1 = ONE;
			if (t1 <= TIME_MIN)
				t1 = TIME_MIN;
			if (t2 >= TIME_MAX)
				t2 = TIME_MAX;
			if (ONE >= p)
				p = ONE;
			if (p >= (s - ONE))
				p = s - ONE;

			timeSpeedShuttle = ONE / (double) t1;
			timeSpeedVasya = ONE / (double) t2;

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

			double[] stepVasya = new double[(int) Math.floor(distanceVasya / timeSpeedVasya) + 1];
			double temporaryVasya = x1;
			for (int i = 0; i < stepVasya.length; i++) {

				if (x1 < x2) {// в офис
					stepVasya[i] = temporaryVasya;
					temporaryVasya += timeSpeedVasya;
				} else if (x1 > x2) {// в метро
					stepVasya[i] = temporaryVasya;
					temporaryVasya -= timeSpeedVasya;
				}
			}

			double[] stepShuttle = new double[(int) Math.floor(distanceShuttle / timeSpeedShuttle) + 1];
			double temporaryShuttle = p;
			boolean back = false;
			for (int i = 0; i < stepShuttle.length; i++) {

				if (d == 1) {
					if (x1 < x2) { // в офис
						stepShuttle[i] = temporaryShuttle;
						temporaryShuttle += timeSpeedShuttle;
					} else if (x1 > x2) { // в метро
						if (back) {
							stepShuttle[i] = temporaryShuttle;
							temporaryShuttle -= timeSpeedShuttle;
						} else {
							stepShuttle[i] = temporaryShuttle;
							temporaryShuttle += timeSpeedShuttle;
						}
					}
					if (temporaryShuttle >= s) {
						back = true;
					}
				} else if (d == -1) {
					if (x1 < x2) { // в офис
						if (back) {
							stepShuttle[i] = temporaryShuttle;
							temporaryShuttle += timeSpeedShuttle;
						} else {
							stepShuttle[i] = temporaryShuttle;
							temporaryShuttle -= timeSpeedShuttle;
						}
					} else if (x1 > x2) { // в метро
						if (back) {
							stepShuttle[i] = temporaryShuttle;
							temporaryShuttle += timeSpeedShuttle;
						} else {
							stepShuttle[i] = Math.abs(temporaryShuttle);
							temporaryShuttle -= timeSpeedShuttle;
						}
					}
					if (temporaryShuttle <= 0) {
						back = true;
					}
				}
			}

			int summaryindex = 0;
			if (stepVasya.length >= stepShuttle.length) {
				summaryindex = stepShuttle.length;
			} else {
				summaryindex = stepVasya.length;
			}

			for (int i = 0; i < summaryindex; i++) {
				if (stepVasya[i] == stepShuttle[i]) {
					intersectionPoint = stepVasya[i];
					break;
				}
			}
			if (x1 < x2) { // в офис
				if (intersectionPoint == 0.0) {
					quickTime = (int) ((distanceVasya * (timeSpeedVasya * t2)) * t2);
					System.out.println(quickTime);
				} else {
					if (d == 1) {
						quickTime = (int) (((distanceVasya * (timeSpeedVasya * t2)) * t2)
								- ((s - intersectionPoint) * t2)
								+ (int) ((s - (distanceShuttle - (distanceShuttle - intersectionPoint))) * t1)); // work
						System.out.println(quickTime);
					} else if (d == -1) {

						quickTime = (int) (((distanceVasya * (timeSpeedVasya * t2)) * t2)
								- ((s - intersectionPoint) * t2)
								+ (int) (s - (((distanceShuttle - (distanceShuttle - intersectionPoint))) * t1))); // work
						System.out.println(quickTime);
					}
				}

			} else if (x1 > x2) { // в метро

				if (intersectionPoint == 0.0) {
					quickTime = (int) ((distanceVasya * (timeSpeedVasya * t2)) * t2);
					System.out.println(quickTime);
				} else {
					if (d == 1) {
						quickTime = (int) (((distanceVasya * (timeSpeedVasya * t2)) * t2)
								- (((distanceVasya - (distanceVasya - intersectionPoint))) * t2))
								+ (int) (((distanceShuttle - (distanceShuttle - intersectionPoint))) * t1); // work
						System.out.println(quickTime);
					} else if (d == -1) {
						quickTime = (int) (((distanceVasya * (timeSpeedVasya * t2)) * t2)
								- (((distanceVasya - (distanceVasya - intersectionPoint))) * t2))
								+ (int) (((distanceShuttle - (distanceShuttle - intersectionPoint))) * t1);
						System.out.println(quickTime);
					}

				}
			}

		} else
			System.out.println(quickTime);

		in.close();
	}
}