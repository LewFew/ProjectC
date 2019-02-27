package org.euler.main;

import java.util.Scanner;

public class J32013 {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		int year = Integer.parseInt(s.nextLine());
		
		year++;
		
		while (!distinct(digits(year))) {
			year++;
		}
		
		System.out.println(year);
	}
	
	private static int[] digits(int q) {
		String yearChar[] = String.valueOf(q).split("");
		int digits[] = new int[yearChar.length];
		
		for (int i = 0; i < yearChar.length; i++) {
			digits[i] = Integer.parseInt(yearChar[i]);
		}
		return digits;
	}
	
	private static boolean distinct(int[] digits) {
		
		boolean works = true;
		
		for (int i = 0; i < digits.length; i++) {
			for (int j = i + 1; j < digits.length ; j++) {
				if (digits[i] == digits[j]) {
					works = false;
				}
			}
		}
		
		return works;
	}

}
