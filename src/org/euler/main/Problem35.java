package org.euler.main;

public class Problem35 {

	public static void main(String[] args) {
		int count = 4;
		
		for (int i = 11; i < 1000000; i++) {
			if (isCircularPrime(i)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean isCircularPrime(int n) {
		
		String st = String.valueOf(n);
		
		for (int i = 0; i < st.length(); i++) {
			st = String.valueOf(st.charAt(st.length() - 1)) + st.substring(0, st.length() - 1);
			if (!isPrime(Integer.parseInt(st))) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPrime(int n) {
		if (n % 2 != 0) {		
			double k = Math.sqrt(n);
			int a = (int)k;
			if (k - a == 0) {
				return false;
			} else {
				for (int i = a; i > 1; i--) {
					if (n % i == 0) {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

}
