package org.euler.main;

public class Problem55 {
	
	/*
	 * Note: This solution is unusable as the longs are not large enough. Another
	 * solution will be made, Problem55B, which will utilize the BigInteger class
	 * and string manipulation instead.
	 */
	
	public static void escape() {
		System.out.println(lychrel(196,0));
		System.exit(0);
	}

	public static void main(String[] args) {
		//escape();
		long lastTime = System.nanoTime();
		
		long counter = 0;
		
		for (int i = 3; i < 10000; i++) {
			counter += (lychrel(i, 0)) ? 1 : 0;
		}
		
		long deltaTime = System.nanoTime() - lastTime;
		
		System.out.println(counter);
		System.out.println("Computed in " + (deltaTime/1000000) + " milleseconds.");
	}
	
	public static long reverseDigits(long n) {
		long z = 0;
		long l = (long) Math.log10(n);
		for (int i = 0; i <= l; i++) {
			z += Math.pow(10, l - i) * (long)((n % Math.pow(10, i+1) / Math.pow(10, i)));
		}
		return z;
	}
	
	public static boolean palindromic(long n) {
		return n == reverseDigits(n);
	}
	
	public static boolean lychrel(long a, long c) {
		c++;
		long k = a + reverseDigits(a);
		System.out.println(a);
		if (palindromic(k)) {
			return true;
		} else if (c < 50) {
			return lychrel(k, c);
		} else {
			return false;
		}
	}

}
