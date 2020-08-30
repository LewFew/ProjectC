package org.euler.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.euler.common.Common;
import org.euler.common.Frac;

public class Problem70 {
	
	public static int perm_small_ratio(int n) {
		ArrayList<Integer> prime_list = new ArrayList<Integer>();
		HashSet<Integer> prime_set = new HashSet<Integer>();
		Frac min = Frac.intExtend(2);
		int location = 0;
		for (int i = 2; i <= n; i++) {
			int sqrt = (int)Math.floor(Math.sqrt(i));
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
			} else {
				HashMap<Integer, Integer> factorize = Common.prime_factor(i, prime_list, prime_set);
				ArrayList<Integer> decompose_phi, decompose_original;
				int phi = 1;
				for (int j : factorize.keySet()) {
					phi *= Math.pow(j, factorize.get(j) - 1) * (j - 1);
				}
				decompose_phi = Common.decompose(phi);
				decompose_original = Common.decompose(i);
				if (decompose_phi.equals(decompose_original)) {
					Frac ratio = new Frac(i, phi);
					if (ratio.compareTo(min) == -1) {
						min = ratio;
						location = i;
					}
				}
			}
		}
		return location;
	}

	public static void main(String[] args) {
		long last_time = System.nanoTime();
		System.out.println(perm_small_ratio(10000000));
		long now = System.nanoTime();
		System.out.println("Computed in " + (double) (now - last_time)/1000000000 + " seconds.");
	}

}
