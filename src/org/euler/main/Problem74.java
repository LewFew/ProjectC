package org.euler.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.euler.common.Common;

public class Problem74 {
	
	public static int chain_length_count(int n, int len) {
		HashMap<ArrayList<Integer>, Integer> memo = new HashMap<ArrayList<Integer>, Integer>();
		return chain_length_count_helper(n, len, memo);
	}
	
	//might stack overflow lol
	
	public static int chain_length(int n, HashMap<ArrayList<Integer>, Integer> memo) {
		ArrayList<Integer> decomposition = Common.decompose(n);
		if (memo.containsKey(decomposition)) {
			return memo.get(decomposition);
		} else {
			memo.put(decomposition, 0);
			int next = 0;
			int dummy = n;
			int num_length = (int)Math.floor(Math.log10(n));
			for (int i = 0; i <= num_length; i++) {
				next += Common.factorial(dummy % 10);
				dummy /= 10;
			}
			int next_length = chain_length(next, memo);
			memo.put(decomposition, 1 + next_length);
			return memo.get(decomposition);
		}
	}
	
	private static int chain_length_count_helper(int n, int len, HashMap<ArrayList<Integer>, Integer> memo) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int length = chain_length(i, memo);
			if (length == len) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		long last_time = System.nanoTime();
		System.out.println(chain_length_count(1000000, 60));
		long now = System.nanoTime();
		System.out.println("Computed in " + (double)(now - last_time)/1000000000 + " seconds.");
	}

}
