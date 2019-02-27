package org.euler.main;

public class Problem26 {

	public static void main(String[] args) {
		for (int i = 1; i < 1000; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
		
	}
	
	public static boolean isPrime(int n) {
		int pivot = (int) (Math.sqrt(n));
		for (int i = 2; i <= pivot; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
