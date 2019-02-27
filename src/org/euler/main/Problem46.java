package org.euler.main;

import java.util.HashMap;

public class Problem46 {
	
	static HashMap<Integer, Boolean> prime = new HashMap<Integer, Boolean>();
	static HashMap<Integer, Integer> nextPrime = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int x = 1;
		int counterEx = -1;
		
		while (counterEx == -1) {
			x += 2;
			int p = 3;
			int d = 1;
			
			boolean valid = false;
			
			if (!isPrime(x)) {
				while (d > 0) {
					p = nextPrime(p);
					d = x - p;
					if (d % 2 == 0) {
						int dr = d / 2;
						int r = (int) Math.sqrt(dr);
						if (r * r == dr) {
							valid = true;
							break;
						}
					}
				}
			} else {
				valid = true;
			}
			
			if (!valid) {
				counterEx = x;
			}
		}
		System.out.println(counterEx);
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Completed in " + (double) elapsedTime / 1000000 + " milleseconds.");
	}
	
	public static int nextPrime(int n) {
		if (nextPrime.containsKey(n)) {
			return nextPrime.get(n);
		} else {
			if (n == 2) {
				return 3;
			} else {
				int x = n;
				while (true) {
					x += 2;
					if (isPrime(x)) {
						nextPrime.put(n, x);
						return x;
					}
				}
			}
		}
	}
	
	public static boolean isPrime(int n) {
		if (prime.containsKey(n)) {
			return prime.get(n);
		} else {
			int r = (int) Math.sqrt(n);
			if (r * r == n) {
				return false;
			} else {
				for (int i = r; i > 1; i--) {
					if (n % i == 0) {
						prime.put(n, false);
						return false;
					}
				}
				prime.put(n, true);
				return true;
			}
		}
	}

}
