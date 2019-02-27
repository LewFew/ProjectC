package org.euler.main;

import java.util.ArrayList;

public class Problem60B {
	
	static ArrayList<Integer> foundPrimes = new ArrayList<Integer>();

	public static boolean isPrimeEff(int n) {
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; foundPrimes.get(i) <= sqrt; i++) {
			if (n % foundPrimes.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime(int n) {
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<int[]> nSet(ArrayList<Integer> data, int n) {
		
		ArrayList<int[]> k = new ArrayList<int[]>();
		
		if (n == 1) {
			
		} else {
			
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		foundPrimes.add(2);
		foundPrimes.add(3);
		foundPrimes.add(5);
		foundPrimes.add(7);
		foundPrimes.add(11);
	}

}