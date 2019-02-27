package org.euler.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problem23 {
	
	public static HashMap<Integer, Integer> primeFactor(int n) {
		int pivot = (int) Math.sqrt(n);
		
		for (int i = pivot; i > 1; i--) {
			if (n % i == 0) {
				return combineFactors(primeFactor(i), primeFactor(n / i));
			}
		}
		
		HashMap<Integer, Integer> k = new HashMap<Integer, Integer>();
		k.put(n, 1);
		return k;
	}
	
	public static HashMap<Integer, Integer> combineFactors(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b) {
		HashMap<Integer, Integer> c = new HashMap<Integer, Integer>();
		
		Set<Integer> q = new HashSet<Integer>();
		
		q.addAll(b.keySet());
		q.removeAll(a.keySet());
		
		for (int i : a.keySet()) {
			if (b.containsKey(i)) {
				c.put(i, a.get(i) + b.get(i));
			} else {
				c.put(i, a.get(i));
			}
		}
		
		for (int i : q) {
			c.put(i, b.get(i));
		}
		
		return c;
	}
	
	public static void printArrLine(int[] k) {
		String q = "";
		for (int i = 0; i < k.length; i++) {
			q = q + k[i] + " ";
		}
		System.out.println(q);
	}
	
	public static int sumOfFactors(int n) {
		
		HashMap<Integer, Integer> prime = primeFactor(n);
		ArrayList<Integer> exponents = new ArrayList<Integer>();
		
		int factors = 1;
		int sum = 0;
		
		for (int i : prime.keySet()) {
			exponents.add(prime.get(i));
			factors *= (prime.get(i) + 1);
		}
		
		int[] testNumbers = new int[exponents.size()];
		
		for (int i = 0; i < testNumbers.length; i++) {
			testNumbers[i] = 0;
		}
		
		for (int i = 0; i < factors; i++) {
			testNumbers[testNumbers.length - 1]++;
			
			for (int j = testNumbers.length - 1; j >= 0; j--) {
				if (testNumbers[j] > exponents.get(j) && j > 0) {
					testNumbers[j] = 0;
					testNumbers[j - 1]++;
				} else if (testNumbers[j] > exponents.get(j) && j == 0) {
					testNumbers[j] = 0;
				}
			}
			
			int product = 1;
			int x = 0;
			
			for (int j : prime.keySet()) {
				product *= Math.pow(j, testNumbers[x]);
				x++;
			}
			sum += product;
		}
		
		return sum - n;
	}
	
	public static boolean h(int n) {
		for (int i = 1; i <= n / 2; i++) {
			if (sumOfFactors(i) > i && sumOfFactors(n - i) > (n - i)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 28123; i++) {
			if (!h(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
