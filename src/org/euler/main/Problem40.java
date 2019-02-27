package org.euler.main;

import java.util.ArrayList;

public class Problem40 {
	
	static ArrayList<Integer> digits = new ArrayList<Integer>();
	
	public static void main(String[] args) {	
		
		long startTime = System.nanoTime();	
		
		for (int i = 1; i <= 200000; i++) {
			int z = i;
			for (int j = (int) Math.log10(i); j >=0; j--) {
				int k = z;
				z = (int) (z / Math.pow(10, j));
				digits.add(z);
				z = (int) (k - z * Math.pow(10, j));
			}
		}	
		
		int product = 1;
		
		for (int i = 0; i < 7; i++) {
			product *= digits.get((int) (Math.pow(10, i) - 1));
		}
		
		System.out.println(product);	
		
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Completed in " + ((double) elapsedTime / 1000) + " microseconds.");
	}
}
