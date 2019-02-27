package org.euler.main;

import java.util.Scanner;

public class J32017 {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		String point1S[] = s.nextLine().split(" ");
		String point2S[] = s.nextLine().split(" ");
		
		int fuel = Integer.parseInt(s.nextLine());
		
		int point1[] = {Integer.parseInt(point1S[0]), Integer.parseInt(point1S[1])};
		int point2[] = {Integer.parseInt(point2S[0]), Integer.parseInt(point2S[1])};

		int smallestDistance = (Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]));
		
		if ((fuel - smallestDistance) % 2 == 0 && fuel >= smallestDistance) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
		
	}

}
