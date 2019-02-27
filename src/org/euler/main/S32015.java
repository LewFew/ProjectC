package org.euler.main;

import java.util.Scanner;

public class S32015 {
	
	Scanner s = new Scanner(System.in);
	
	public S32015() {
		int gates, planes;
		gates = Integer.parseInt(s.nextLine());
		planes = Integer.parseInt(s.nextLine());
		int g[] = new int[gates];
		for (int i = 0; i < planes; i++) { 
			g[i] = Integer.parseInt(s.nextLine());
		}
		
	}

	public static void main(String[] args) {
		new S32015();
	}

}
