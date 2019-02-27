package org.euler.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problem32 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 999999999; i++) {
			//System.out.println(i);
			if (i % 10000000 == 0) {
				System.out.println(i);
			}
			if (uniqueNumbers(i)) {
				if (special(i)) {
					sum += i;
				}
			}
		}
		System.out.println(sum);
	}
	
	public static ArrayList<boolean[]> choose(int k, int n) {
		ArrayList<boolean[]> l = new ArrayList<boolean[]>();
		
		boolean[] q = new boolean[k];
		
		for (int i = 0; i < q.length; i++) {
			q[i] = false;
		}
		
		for (int i = 0; i < n; i++) {
			q[i] = true;
		}
		
		//printBoolArray(q);
		
		l.add(q);
		
		choose(n, q, l);
		
		return l;
	}
	
	public static void printBoolArray(boolean[] k) {
		String q = "";
		for (int i = 0; i < k.length; i++) {
			q += (k[i]) ? "1" : "0";
		}
		System.out.println(q);
	}
	
	public static void choose(int n, boolean[] k, ArrayList<boolean[]> l) {
		
		for (int i = 0; i < k.length; i++) {
			if (!k[i]) {
				boolean temp = k[n];
				k[n] = k[i];
				k[i] = temp;
				
				l.add(Arrays.copyOf(k, k.length));
				
				if (n > 1) {
					choose(n - 1, k, l);
				}
				
				printBoolArray(k);
				
				temp = k[n];
				k[n] = k[i];
				k[i] = temp;
				
			}
		}
	}
	
	public static boolean uniqueNumbers(int k) {
		String q = String.valueOf(k);
		int t[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		
		for (int i = 0; i < q.length(); i++) {
			
			if (q.charAt(i) == 48) {
				return false;
			}
			
			t[(int)(q.charAt(i)) - 49]++;
		}
		
		for (int i = 0; i < t.length; i++) {
			if (t[i] > 1) {
				return false;
			}
		}
		
		return true;
	}
	
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
	
	public static boolean special(int n) {
		
		HashMap<Integer, Integer> prime = primeFactor(n);
		ArrayList<Integer> exponents = new ArrayList<Integer>();
		
		int factors = 1;
		
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
			
			if (pandigital(String.valueOf(product) + String.valueOf(n) + String.valueOf(n/product))) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean pandigital(String q) {

		int t[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		
		for (int i = 0; i < q.length(); i++) {
			
			if (q.charAt(i) == 48) {
				return false;
			}
			
			t[(int)(q.charAt(i)) - 49]++;
		}
		
		for (int i = 0; i < t.length; i++) {
			if (t[i] != 1) {
				return false;
			}
		}
		
		return true;
	}

}
