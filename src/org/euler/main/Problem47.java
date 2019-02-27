package org.euler.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problem47 {
	
	static HashMap<Integer, Integer> distinctPrimes = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int x = 2;
		int firstSequence = -1;
		
		while (true) {
			x++;
			if (distinctFactors(x) == 4 && distinctFactors(x + 1) == 4
					&& distinctFactors(x + 2) == 4 && distinctFactors(x + 3) == 4) {
				firstSequence = x;
				break;
			}
		}
		
		System.out.println(firstSequence);
		
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Computed in " + (double) elapsedTime / 1000000 + " milliseconds.");
	}
	
	public static int distinctFactors(int n) {
		if (distinctPrimes.containsKey(n)) {
			return distinctPrimes.get(n);
		} else {	
			HashMap<Integer, Integer> k = primeFactor(n);
			distinctPrimes.put(n, k.size());
			return k.size();
		}
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

}
