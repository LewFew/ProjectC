package org.euler.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.euler.common.Common;

public class Problem69 {
	
	//We notice that the max will never be a prime number unless
	//n = 3 (because then we're only searching 2, 3 which are both prime)
	
	public static int max_quotient(int n) {
		ArrayList<Integer> found_primes = new ArrayList<Integer>();
		HashSet<Integer> found_primes_set = new HashSet<Integer>();
		double max = 2;
		int max_location = 2;
		for (int i = 2; i <= n; i++) {
			boolean is_prime = true;
			int sqrt = (int)Math.floor(Math.sqrt(i));
			for (int j = 0; j < found_primes.size() && found_primes.get(j) <= sqrt; j++) {
				if (i % found_primes.get(j) == 0) {
					HashMap<Integer, Integer> decomp = Common.prime_factor(i, found_primes, found_primes_set);
					int phi = 1;
					for (int k : decomp.keySet()) {
						if (i == 54670) {
						}
						phi *= Math.pow(k, decomp.get(k) - 1) * (k - 1);
					}
					//System.out.println(i + ": " + phi);
					if (((double)i/(double)phi) > max) {
						max = (double)i/(double)phi;
						max_location = i;
					}
					is_prime = false;
					break;
				}
			}
			if (is_prime) {
				found_primes.add(i);
				found_primes_set.add(i);
			}
		}
		return max_location;
	}

	public static void main(String[] args) {
		long last_time = System.nanoTime();
		System.out.println(max_quotient(1000000));
		long now = System.nanoTime();
		System.out.println("Computed in " + (double)(now - last_time)/1000000000 + " seconds.");
	}

}
