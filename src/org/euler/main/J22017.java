package org.euler.main;

import java.util.Scanner;

public class J22017 {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n = Integer.parseInt(s.nextLine());
		int k = Integer.parseInt(s.nextLine());
		
		int q;
		int sum = 0;
		
		for (int i = 0; i <= k; i++) {
			q = (int) Math.pow(10, i);
			sum = sum + (n * q);
		}
		
		System.out.println(sum);

	}

}
