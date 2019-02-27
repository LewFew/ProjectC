package org.euler.main;

import java.util.Scanner;

public class J12013 {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int age1 = Integer.parseInt(s.nextLine());
		int age2 = Integer.parseInt(s.nextLine());
		
		System.out.println(age2 + (age2 - age1));
	}

}
