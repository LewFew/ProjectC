package org.euler.main;

import java.util.ArrayList;

public class Problem60 {
	
	static int[] primes = {3, 7, 109, 673, 1};
	
	static ArrayList<Long> foundPrimes = new ArrayList<Long>();
	
	public static boolean isPrime(long n) {
		long sqrt = (int) Math.sqrt(n);
		
		if (n == 1) {
			return false;
		} else {
			for (int i = 2; i <= sqrt; i++) {
				if (n % i == 0) {
					return false;
				}
			}
		}
		
		foundPrimes.add(n);
		return true;
	}
	
	public static long concatenate(long a, long b) {
		return Long.parseLong(String.valueOf(a) + String.valueOf(b));
	}
	
	public static boolean test() {
		
		for (int i = 0; i < primes.length - 1; i++) {
			if (!isPrime(concatenate(primes[i], primes[primes.length - 1])) || !isPrime(concatenate(primes[primes.length - 1], primes[i]))) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void show() {
		for (int i = 0; i < primes.length - 1; i++) {
			if (isPrime(concatenate(primes[i], primes[primes.length - 1])) && isPrime(concatenate(primes[primes.length - 1], primes[i]))) {
				System.out.println(primes[i] + " and " + primes[primes.length - 1] + " is a check");
			}
		}
	}

	public static void main(String[] args) {
		
		long lastTime = System.nanoTime();
		
		int i = 1;

		while (true) {
			i++;
			if (isPrime(i)) {
				primes[4] = i;
				boolean k = test();
				if (k) {
					System.out.println(primes[0] + primes[1] + primes[2] + primes[3] + primes[4]);
					show();
					break;
				}
			}
		}
		
		long deltaTime = System.nanoTime() - lastTime;
		
		System.out.println("Computed in " + ((deltaTime/1000000000)/60) + " minutes.");
	}

}
