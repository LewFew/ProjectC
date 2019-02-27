package org.euler.main;

public class Problem58 {
	
	public static boolean isPrime(int n) {
		int sqrt = (int) Math.sqrt(n);
		if (n == 1) {
			return false;
		}
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int alpha(int n) {
		return (int) (4 * Math.pow(n, 2) - 10 * n + 7);
	}
	
	public static int beta(int n) {
		return (int) (4 * Math.pow(n, 2) - 6 * n + 3);
	}
	
	public static int rho(int n) {
		return (int) (4 * Math.pow(n, 2) - 8 * n + 5);
	}

	public static void main(String[] args) {
		
		long lastTime = System.nanoTime();
		
		int totalPrimes = 0;
		int totalComposites = 1;
		
		int n = 1;
		while ((double)(totalPrimes) / (double)((totalPrimes + totalComposites)) > 0.1 || n < 3) {
			totalComposites++;
			if (isPrime(alpha(n))) {
				totalPrimes++;
			} else {
				totalComposites++;
			}
			if (isPrime(beta(n))) {
				totalPrimes++;
			} else {
				totalComposites++;
			}
			if (isPrime(rho(n))) {
				totalPrimes++;
			} else {
				totalComposites++;
			}
			n++;
		}
		
		long elapsedTime = System.nanoTime() - lastTime;
		
		System.out.println(n * 2 - 1 + " computed in " + (elapsedTime/1000000) + " milleseconds.");
	}

}
