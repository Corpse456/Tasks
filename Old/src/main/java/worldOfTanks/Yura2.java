package worldOfTanks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Yura2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int officeCoordinates = in.nextInt();
		int vasyaPosition = in.nextInt();
		int vasyaDestination = in.nextInt();
		int shuttleSecForMetr = in.nextInt();
		int vasyaSecForMetr = in.nextInt();
		int shuttlePosition = in.nextInt();
		int shuttleDirectionToOffice = in.nextInt();
		in.close();

		int shuttleMettersLeft;
		if (vasyaDestination == officeCoordinates) {
			shuttleMettersLeft = Math.abs(officeCoordinates - shuttlePosition * shuttleDirectionToOffice);
		} else {
			shuttleMettersLeft = Math
				.abs(officeCoordinates - shuttlePosition + officeCoordinates * shuttleDirectionToOffice);
		}
		
		int vasyaTime = Math.abs(vasyaDestination - vasyaPosition) * vasyaSecForMetr; 
		int shuttleTime = shuttleMettersLeft * shuttleSecForMetr; 
		
		System.out.println(vasyaTime < shuttleTime ? vasyaTime : shuttleTime);
	}
}