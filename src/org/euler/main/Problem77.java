package org.euler.main;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem77 {
	
	public static int prime_partitions(int n, ArrayList<Integer> prime_list, int last, HashMap<ArrayList<Integer>, Integer> memo) {
		ArrayList<Integer> pair = new ArrayList<Integer>();
		pair.add(n);
		pair.add(last);
		if (memo.containsKey(pair)) {
			return memo.get(pair);
		} else {
			if (n < 0) {
				return 0;
			} else if (n == 0) {
				return 1;
			} else {
				int count = 0;
				for (int i = last; i >= 0; i--) {
					count += prime_partitions(n - prime_list.get(i), prime_list, i, memo);
				}
				memo.put(pair, count);
				return count;
			}
		}
	}
	
	public static int first_over(int n) {
		ArrayList<Integer> prime_list = new ArrayList<Integer>();
		HashMap<ArrayList<Integer>, Integer> memo = new HashMap<ArrayList<Integer>, Integer>();
		for (int i = 2;; i++) {
			int sqrt = (int)Math.floor(Math.sqrt(i));
			boolean is_prime = true;
			for (int j = 0; j < prime_list.size() && prime_list.get(j) <= sqrt; j++) {
				if (i % prime_list.get(j) == 0) {
					is_prime = false;
					break;
				}
			}
			if (is_prime) {
				prime_list.add(i);
			}
			int partitions = prime_partitions(i, prime_list, prime_list.size() - 1, memo);
			if (partitions > n) {
				return i;
			}
		}
	}

	public static void main(String[] args) {
		int answer;
		long last_time = System.nanoTime();
		answer = first_over(5000);
		long now = System.nanoTime();
		System.out.println(answer);
		System.out.println("Computed in " + (double)(now - last_time)/1000000 + " milleseconds.");
	}

}
