package org.euler.main;

import java.util.ArrayList;

public class Problem51 {
	
	static ArrayList<Integer> foundPrimes = new ArrayList<Integer>();
	static ArrayList<Integer> checked = new ArrayList<Integer>();
	
	public static int replaceDigits(int num, int a, int b) {
		
		int len = (int) (Math.log10(num));
		int l = len - a + 1;
		
		int k = (int) (num % Math.pow(10, l));
		int z = (int) (num / Math.pow(10, l + 1));
		
		return (int) (z * Math.pow(10, l + 1) + (b * Math.pow(10, l)) + k);
	}
	
	public static boolean isPrime(int candidate) {
		
		int sqr = (int) Math.sqrt(candidate);
		
		/*
		 * I believe that this method is causing the incorrect result. Namely,
		 * values are being tested for primality too soon. For example, 12345 with 1111
		 * would test 19999 for primality before all of the primes in between are found. Thus,
		 * a more primitive approach to verifying primality will be implemented.
		 */
		
		//Old approach.
		
		/*
		for (int i = 0; i < foundPrimes.size(); i++) {
			
			if (candidate % foundPrimes.get(i) == 0) {
				return false;
			}
			
			if (foundPrimes.get(i) > sqr) {
				break;
			}
		}
		*/
		
		//New Approach (Primitive)
		
		if (candidate % 2 == 0) {
			return false;
		}
		
		for (int i = 3; i < sqr; i+=2) {
			if (candidate % i == 0) {
				return false;
			}
		}
		
		
		return true;
	}
	
	public static int nextPrime(int prevPrime) {
		
		int candidate = prevPrime + 1;
		int sqr;
		boolean found = false;
		
		while (!found) {
			sqr = (int) Math.sqrt(candidate);
			found = true;
			for (int i = 0; i < foundPrimes.size(); i++) {
				if (candidate % foundPrimes.get(i) == 0) {
					found = false;
					break;
				}
				if (foundPrimes.get(i) > sqr) {
					break;
				}
				
			}
			if (!found) {
				candidate++;
			}
		}
		
		foundPrimes.add(candidate);
		
		return candidate;
	}
	
	public static boolean check(int prime) {
		
		int primeLength = (int) Math.log10(prime);
		boolean works = false;
		
	//	System.out.println("----------------------"+prime);
		
		for (int i = 1; i < Math.pow(2, primeLength + 1); i++) {
			String k = "";
			String z = "";
			z = Integer.toBinaryString(i);
			for (int j = 0; j < primeLength + 1 - z.length(); j++) {
				k += "0";
			}
			k += z;
		//	System.out.println("* "+k);
			//System.out.println(k);
			char[] choice = k.toCharArray();
			
			int prime2 = prime;
			int count = 0;
			
			boolean t = false;
			int candidate = 0;
			
			for (int q = 0; q < 10; q++) {
				if (!(choice[0] == '1' && q == 0)) {
					for (int j = 0; j < choice.length; j++) {
						if (choice[j] == '1') {
							prime2 = replaceDigits(prime2, j + 1, q);
						}
					}
					if (!t) {
						candidate = prime2;
						t = true;
					}
					if (isPrime(prime2)) {
						//System.out.println(prime2 + " is prime");
						count++;
					}
				}
			}
			
			if (count == 8) {
				works = true;
				System.out.println(prime + " has " + count + " with " + k);
				System.out.println(choice);
				System.out.println("this is prime " + foundPrimes.size());
				System.out.println("However, the smallest in the family is " + candidate);
				break;
			}
			
		}
		
		return works;
	}
	
	public static void main(String[] args) {
		
		foundPrimes.add(2);
		
		int lastPrime = 2;

		while (true) {
			lastPrime = nextPrime(lastPrime);
			if (check(lastPrime)) {
				//System.out.println(lastPrime);
				break;
			}
		}
		
		//check(10000);
	}
	
}
