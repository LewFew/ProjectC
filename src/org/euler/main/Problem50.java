package org.euler.main;

import java.util.HashMap;

public class Problem50 {
	
	static HashMap<Integer, Boolean> prime = new HashMap<Integer, Boolean>();
	static HashMap<Integer, Integer> nextPrime = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int point = 1;
		int largest = 0;
		
		while (point < 7) {
			int x = point;
			int s1 = 0;
			point = nextPrime(point);
			while (s1 < 1000000) {
				x = nextPrime(x);
				s1 += x;
				if (isPrime(s1) && s1 > largest) {
					largest = s1;
				}
			}
		}
		
		System.out.println(largest);
		
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Computed in " + (double) elapsedTime / 1000000 + " milliseconds.");
	}
	
	public static int nextPrime(int n) {
		if (nextPrime.containsKey(n)) {
			return nextPrime.get(n);
		} else {
			if (n == 1) {
				return 2;
			} else if (n == 2) {
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
