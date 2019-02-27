package org.euler.main;

import java.util.Scanner;

public class PrimeChecker {
	
	public static boolean isPrime(long n) {
		
		long sqrt = (long) Math.sqrt(n);
		
		if (n == 1) {
			return false;
		} else {
			for (int i = 2; i <= sqrt; i++) {
				if (n % i == 0) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while (true) {
			String input = s.nextLine();
			
			if (input.equals("exit")) {
				break;
			}
			
			long n = Long.parseLong(input);
			System.out.println((isPrime(n)) ? (n + " is prime") : (n + " is not prime"));
		}
		
		s.close();
	}

}
