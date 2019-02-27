package org.euler.main;

import java.util.Scanner;

public class J22015 {
	
	static int happy = 0, sad = 0;
	static String input;
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		input = s.nextLine();
		
		for (int i = 0; i < input.length() - 2; i++) {
			String subString = input.substring(i, i + 3);
			if (subString.equals(":-)")) {
				happy++;
			} else if (subString.equals(":-(")) {
				sad++;
			}
		}
		
		if (happy > sad) {
			System.out.println("happy");
		} else if (sad > happy) {
			System.out.println("sad");
		} else if (sad == 0 && happy == 0) {
			System.out.println("none");
		} else if (sad == happy) {
			System.out.println("unsure");
		}
	}

}
