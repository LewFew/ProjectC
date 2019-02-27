package org.euler.main;

import java.util.Arrays;
import java.util.HashMap;

public class Problem49 {
	
	static HashMap<Integer, Boolean> prime = new HashMap<Integer, Boolean>();
	static HashMap<Integer, Integer> nextPrime = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int nextSequence = -1;
		int x = 1001;
		
		while (x < 10000) {
			x = nextPrime(x);
			int uBound = (10000 - x) / 2;
			for (int j = 1; j <= uBound; j++) {
				if (!(isPermutation(x, x + j) && isPermutation(x + j, x + 2 * j))) {
					continue;
				} else {
					if (isPrime(x + j) && isPrime(x + 2 * j)) {
						if (x != 1487) {
							nextSequence = x;
							break;
						}
					} else {
						continue;
					}
				}
			}
			if (nextSequence != -1) {
				break;
			}
		}
		
		System.out.println(nextSequence);
		
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Computed in " + (double) elapsedTime / 1000000 + " milliseconds.");
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
	
	public static boolean isPermutation(int a, int b) {
		int aIdentity[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int bIdentity[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		int aL = 3;
		int bL = 3;
		
		for (int i = 0; i <= aL; i++) {
			int p = (int) ((int) (a / 10) * 10);
			int h = a - p;
			aIdentity[h]++;
			a = (int) ((a - h) / 10);
		}
		
		for (int i = 0; i <= bL; i++) {
			int p = (int) ((int) (b / 10) * 10);
			int h = b - p;
			bIdentity[h]++;
			b = (int) ((b - h) / 10);
		}
		
		return Arrays.equals(aIdentity, bIdentity);
	}

}
