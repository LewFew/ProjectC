package org.euler.main;

import java.util.Scanner;

public class J12017 {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		int x = Integer.parseInt(s.nextLine());
		int y = Integer.parseInt(s.nextLine());
		
		if (x > 0 && y > 0) {
			System.out.println("1");
		} else if (x < 0 && y > 0) {
			System.out.println("2");
		} else if (x < 0 && y < 0) {
			System.out.println("3");
		} else {
			System.out.println("4");
		}

	}

}
