package org.euler.main;

import java.util.Scanner; 

public class J32011 {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int a = Integer.parseInt(s.nextLine());
		int b = Integer.parseInt(s.nextLine());
		
		System.out.println(sumac(a, b));
	}
	
	private static int sumac(int a, int b) {

		int i = 2;
			
		while (a - b > 0) {
			int temp = a;
			a = b;
			b = temp - b;
			i++;
		}
		
		return i;
	}

}
