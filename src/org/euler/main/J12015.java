package org.euler.main;

import java.util.Scanner;

public class J12015 {
	
	static int month, day;
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		month = Integer.parseInt(s.nextLine());
		day = Integer.parseInt(s.nextLine());
		
		if (month > 2) {
			System.out.println("After");
		} else if (month == 1) {
			System.out.println("Before");
		} else if (month == 2 && day == 18) {
			System.out.println("Special");
		} else if (month == 2 && day > 18) {
			System.out.println("After");
		} else if (month == 2 && day < 18) {
			System.out.println("Before");
		}
	}

}
