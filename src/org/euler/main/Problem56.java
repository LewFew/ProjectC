package org.euler.main;

import java.math.BigInteger;

public class Problem56 {
	
	public static int digitSum(BigInteger n) {
		char l[] = String.valueOf(n).toCharArray();
		int sum = 0;
		for (char k : l) {
			sum += Character.getNumericValue(k);
		}
		return sum;
	}

	public static void main(String[] args) {
		
		long lastTime = System.nanoTime();
		
		int largestSum = 0;
		int k = 0;
		BigInteger current;
		
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				current = new BigInteger(String.valueOf(i)).pow(j);
				k = digitSum(current);
				largestSum = (k > largestSum) ? k : largestSum;
			}
		}
		
		long deltaTime = System.nanoTime() - lastTime;
		
		System.out.println(largestSum);
		System.out.println("Computed in " + (deltaTime/1000000) + " milleseconds.");
	}

}
