package org.euler.main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.euler.common.Common;

public class Problem72 {
	
	public static BigInteger count_fractions(int d) {
		BigInteger count = BigInteger.ZERO;
		ArrayList<Integer> prime_list = new ArrayList<Integer>();
		HashSet<Integer> prime_set = new HashSet<Integer>();
		for (int i = 2; i <= d; i++) {
			int sqrt = (int) Math.floor(Math.sqrt(i));
			HashMap<Integer, Integer> factorize;
			boolean is_prime = true;
			for (int j = 0; j < prime_list.size() && prime_list.get(j) <= sqrt; j++) {
				int cur_prime = prime_list.get(j);
				if (i % cur_prime == 0) {
					is_prime = false;
					break;
				}
			}
			if (is_prime) {
				prime_list.add(i);
				prime_set.add(i);
			}
			int phi = 1;
			factorize = Common.prime_factor(i, prime_list, prime_set);
			for (int k : factorize.keySet()) {
				phi *= Math.pow(k, factorize.get(k) - 1) * (k - 1);
			}
			count = count.add(new BigInteger(String.valueOf(phi)));
		}
		return count;
	}

	public static void main(String[] args) {
		long last_time = System.nanoTime();
		System.out.println(count_fractions(1000000));
		long now = System.nanoTime();
		System.out.println("Computed in " + (double) (now - last_time)/1000000 + " milleseconds.");
	}

}
