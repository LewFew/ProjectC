package org.euler.main;

import java.math.BigInteger;

public class Problem53A {
	
	/*
	 * Brute Force Approach.
	 * 
	 * Note: If this method is too slow, another solution "Problem52B" will be created
	 * that will use an optimized algorithm utilizing combinatorial inequalities.
	 */
	
	public static BigInteger fact(int n) {
		BigInteger product = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			product = product.multiply(new BigInteger(String.valueOf(i)));
		}
		return product;
	}
	
	public static BigInteger choose(int n, int r) {
		return fact(n).divide(fact(r).multiply(fact(n - r)));
	}

	public static void main(String[] args) {
		
		long lastTime = System.nanoTime();
		
		int count = 0;
		BigInteger million = new BigInteger("1000000");
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= i; j++) {
				if (choose(i, j).compareTo(million) == 1) {
					count++;
				}
			}
		}
		
		long deltaTime = System.nanoTime() - lastTime;
		
		System.out.println(count);
		System.out.println("Computed in " + (deltaTime / 1000000) + " milleseconds.");
	}

}
