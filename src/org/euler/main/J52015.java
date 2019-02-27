package org.euler.main;

import java.util.Scanner;

public class J52015 {
	
	static int pieces;
	static int people;
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		pieces = Integer.parseInt(s.nextLine());
		people = Integer.parseInt(s.nextLine());
		
		System.out.println(ways(pieces, people, 1));
	}
	
	public static long ways(int pieces, int people, int min) {
		
		int max = pieces/people;
		int combos = 0;
		
		if (pieces == people || people == 1) {
			return 1;
		} else {
			for (int i = min; i <= max; i++) {
				combos += ways(pieces - i, people - 1, i);
			}
			return combos;
		}
	}

}
