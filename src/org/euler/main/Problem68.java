package org.euler.main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.euler.common.Common;

public class Problem68 {
	
	//Note: The problem forbids 17-digit representations.
	//So the 10 must belong to the "orbit".

	public static BigInteger magic_ngon(int n) {
		ArrayList<Integer> pool = new ArrayList<Integer>();
		for (int i = 1; i <= 2*n; i++) {
			pool.add(i);
		}
		BigInteger[] max = {BigInteger.ZERO};
		int[] base_ring = new int[n];
		magic_ngonhelper(n, pool, base_ring, max);
		return max[0];
	}
	
	public static HashSet<int[]> form_orbits(int n, ArrayList<Integer> pool, int[] ring) {
		HashSet<int[]> ret = new HashSet<int[]>();
		HashSet<Integer> pool_set = Common.to_set(pool);
		int[] difference = new int[n];
		int[] sorted_difference;
		for (int i = 0; i < n; i++) {
			difference[i] = (ring[0] + ring[1]) - (ring[i] + ring[(i+1)%n]);
		}
		sorted_difference = Arrays.copyOf(difference, n);
		Arrays.sort(sorted_difference);
		for (int i = 0; i < n-1; i++) {
			if (sorted_difference[i] == sorted_difference[i+1]) {
				return ret;
			}
		}
		for (int i : pool_set) {
			int[] candidate_orbit = new int[n];
			boolean add = true;
			for (int j = 0; j < difference.length; j++) {
				if (pool_set.contains(difference[j] + i)) {
					candidate_orbit[j] = difference[j] + i;
				} else {
					add = false;
				}
			}
			if (add) {
				ret.add(candidate_orbit);
			}
		}
		return ret;
	}
	
	public static void magic_ngonhelper(int n, ArrayList<Integer> pool, int[] ring, BigInteger[] max) {
		if (pool.size() == n) {
			HashSet<int[]> orbit_set = form_orbits(n, pool, ring);
			for (int[] orbit : orbit_set) {
				int orbit_min_index = Common.min_array_index(orbit);
				int[] orbit_shift = Arrays.copyOf(orbit, n);
				int[] ring_shift = Arrays.copyOf(ring, n);
				String representation = "";
				for (int i = 0; i < n; i++) {
					orbit_shift[i] = orbit[(i+orbit_min_index) % n];
					ring_shift[i] = ring[(i+orbit_min_index) % n];
				}
				for (int i = 0; i < n; i++) {
					representation += String.valueOf(orbit_shift[i]) + String.valueOf(ring_shift[i]) + String.valueOf(ring_shift[(i+1)%n]);
				}
				BigInteger candidate = new BigInteger(representation);
				max[0] = (candidate.compareTo(max[0]) == 1) ? candidate : max[0];
			}
		} else {
			for (int i = 0; i < pool.size(); i++) {
				if (pool.get(i) == 2 * n) { continue; }
				ArrayList<Integer> new_pool = new ArrayList<Integer>();
				int[] new_ring = Arrays.copyOf(ring, n);
				new_ring[2*n - pool.size()] = pool.get(i);
				for (int j = 0; j < pool.size(); j++) {
					if (i != j) {
						new_pool.add(pool.get(j));
					}
				}
				magic_ngonhelper(n, new_pool, new_ring, max);
			}
		}
	}

	public static void main(String[] args) {
		long last_time = System.nanoTime();
		//----------------
		System.out.println(magic_ngon(5));
		//----------------
		long now = System.nanoTime();
		System.out.println("Computed in " + (double) (now - last_time) / 1000000 + " milleseconds.");
	}

}
