package org.euler.main;

import java.util.ArrayList;

public class Problem37 {
	
	static int[] singlePrimes = {2, 3, 5, 7};
	static int[] singleOdds = {1, 3, 7, 9};
	
	static ArrayList<Integer> trunctables = new ArrayList<Integer>();

	public static void main(String[] args) {
		trunctableSearch();
		int sum = 0;
		for (int i = 0; i < trunctables.size(); i++) {
			sum += trunctables.get(i);
		}
		System.out.println(sum);
	}
	
	public static void trunctableSearch() {
		for (int i = 0; i < singlePrimes.length; i++) {
			trunctableAdd(singlePrimes[i]);
		}
	}
	
	public static void trunctableAdd(int k) {
		if (isPrime(k)) {
			if (trunctable(k)) {
				if (k > 9)
					trunctables.add(k);
			}
			for (int i = 0; i < singleOdds.length; i++) {
				trunctableAdd(k * 10 + singleOdds[i]);
			}		
		}
		
	}
	
	public static boolean trunctable(int n) {	
		for (int i = (int) Math.log10(n); i >= 0; i--) {
			if (!isPrime(n)) {
				return false;
			}
			n -= Math.pow(10, i) * (int) (n / Math.pow(10, i));
		}	
		return true;
	}
	
	public static boolean isPrime(int n) {
		double q = Math.sqrt(n);
		int k = (int) q;
		if (q - k == 0 || (n % 2 == 0 && n != 2)) {
			return false;
		} else {
			for (int i = k; i > 1; i--) {
				if (n % i == 0)
					return false;
			}
		}
		return true;
	}

}
