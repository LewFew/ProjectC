package org.euler.main;

import java.util.HashMap;

public class Problem27 {
	
	static HashMap<Integer, Boolean> primes = new HashMap<Integer, Boolean>();

	public static void main(String[] args) {
		
		primes.put(1, false);
		
		int largestTriple[] = {1, 1, 0};
		
		for (int a = 1; a <= 1000; a++) {
			for (int b = 1; b < 999; b+=2) {
				
				if (isPrime(b)) {
					
					int x = 0;
					while (isPrime(quadraticOutput(a, b, x))) {
						x++;
					}
					
					if (x > largestTriple[2]) {
						largestTriple[0] = a;
						largestTriple[1] = b;
						largestTriple[2] = x;
					}
					
					x = 0;
					
					while (isPrime(quadraticOutput(-a, b, x))) {
						x++;
					}
					
					if (x > largestTriple[2]) {
						largestTriple[0] = -a;
						largestTriple[1] = b;
						largestTriple[2] = x;
					}
					
				} else {
					continue;
				}
			}
		}
		
		System.out.println(largestTriple[0] + " " + largestTriple[1] + " " + largestTriple[2]);
	}
	
	public static int quadraticOutput(int a, int b, int n) {
		return (int) (Math.pow(n, 2) + a * n + b);
	}
	
	public static boolean isPrime(int n) {
		
		if (n < 0) {
			return false;
		}
		
		if (primes.containsKey(n)) {
			return primes.get(n);
		}
		
		int pivot = (int) (Math.sqrt(n));
		for (int i = 2; i <= pivot; i++) {
			if (n % i == 0) {
				primes.put(n, false);
				return false;
			}
		}
		primes.put(n, true);
		return true;
	}

}
