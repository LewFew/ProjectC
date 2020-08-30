package org.euler.main;

import java.math.BigInteger;
import java.util.HashMap;

public class Problem78 {
	
	public static BigInteger partitions_modulo(int n, BigInteger m) {
		HashMap<Integer, BigInteger> memo = new HashMap<Integer, BigInteger>();
		return partitions_modulo_helper(n, m, memo);
	}
	
	private static BigInteger partitions_modulo_helper(int n, BigInteger m, HashMap<Integer, BigInteger> memo) {
		if (n == 0 || n == 1) {
			return BigInteger.ONE;
		} else if (n < 0) {
			return BigInteger.ZERO;
		} else {
			if (memo.containsKey(n)) {
				return memo.get(n);
			} else {
				BigInteger count = BigInteger.ZERO;
				int upper = (int)Math.floor((1.0 + Math.sqrt(1 + 24*n))/6.0);
				for (int i = 1; i <= upper; i++) {
					BigInteger abs = (partitions_modulo_helper(n - i * (3*i - 1)/2, m, memo).add(partitions_modulo_helper(n - i * (3*i + 1)/2, m, memo))).mod(m);
					count = (i % 2 == 0) ? count.add(abs.negate()).mod(m) : count.add(abs).mod(m);
				}
				memo.put(n, count);
				return count;
			}
		}
	}
	
	public static int first_to_divide(int d) {
		BigInteger big_d = new BigInteger(String.valueOf(d));
		HashMap<Integer, BigInteger> memo = new HashMap<Integer, BigInteger>();
		for (int i = 1;; i++) {
			BigInteger candidate = partitions_modulo_helper(i, big_d, memo);
			if (candidate.equals(BigInteger.ZERO)) {
				return i;
			}
		}
	}

	public static void main(String[] args) {
		long last_time = System.nanoTime();
		System.out.println(first_to_divide(1000000));
		long now = System.nanoTime();
		System.out.println("Computed in " + (double)(now - last_time)/1000000000 + " seconds.");
	}

}
