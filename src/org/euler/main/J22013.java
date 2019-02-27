package org.euler.main;

import java.util.Scanner;

public class J22013 {
	
	static Scanner s = new Scanner(System.in);
	static char[] rotate = {'I', 'O', 'S', 'H', 'Z', 'X', 'N'};

	public static void main(String[] args) {
		
		char[] input = s.nextLine().toCharArray();
		
		for (int i = 0; i < input.length; i++) {
			boolean works = false;
			for (int j = 0; j < rotate.length; j++) {
				if (input[i] == rotate[j]) {
					works = true;
				}
			}
			if (!works) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		
		System.out.println("YES");
	}

}
