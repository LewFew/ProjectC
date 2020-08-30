package org.euler.main;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem76 {
	
	public static int partitions(int n) {
		int count = 0;
		HashMap<ArrayList<Integer>, Integer> memo = new HashMap<ArrayList<Integer>, Integer>();
		for (int i = 2; i <= n; i++) {
			count += partitions_helper(n, i, 1, memo);
		}
		return count;
	}
	
	private static int partitions_helper(int n, int pieces, int start, HashMap<ArrayList<Integer>, Integer> memo) {
		ArrayList<Integer> parameters = new ArrayList<Integer>();
		parameters.add(n);
		parameters.add(pieces);
		parameters.add(start);
		if (memo.containsKey(parameters)) {
			return memo.get(parameters);
		} else {
			int count = 0;
			if (pieces == 1) {
				return (start <= n) ? 1 : 0;
			} else {
				for (int i = start; i <= n; i++) {
					count += partitions_helper(n - i, pieces - 1, i, memo);
				}
				memo.put(parameters, count);
				return count;
			}
		}
	}

	public static void main(String[] args) {
		int answer;
		long last_time = System.nanoTime();
		answer = partitions(100);
		long now = System.nanoTime();
		System.out.println(answer);
		System.out.println("Computed in " + (double)(now - last_time)/1000000000 + " seconds.");
	}

}
