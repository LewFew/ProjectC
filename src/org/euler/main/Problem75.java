package org.euler.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.euler.common.Common;

public class Problem75 {

	public static int bent_wires(int n) {
		HashSet<ArrayList<Integer>> ppt = new HashSet<ArrayList<Integer>>();
		HashMap<Integer, Integer> lengths = new HashMap<Integer, Integer>();
		int count = 0;
		int upper = (int)Math.floor(Math.sqrt(n/2));
		for (int t = 1; t <= upper; t++) {
			for (int s = t; s <= upper; s++) {
				if (!(t % 2 == 1 && s % 2 == 1) && (Common.gcd(s, t) == 1)) {
					ArrayList<Integer> triple = new ArrayList<Integer>();
					int a = 2*s*t;
					int b = s*s - t*t;
					if (t % 2 == 1 || s % 2 == 1) {
						triple.add(a);
						triple.add(b);
						triple.add(s*s + t*t);
					} else {
						triple.add((a >= b) ? a : b);
						triple.add((a >= b) ? b : a);
						triple.add(s*s + t*t);
					}
					ppt.add(triple);
				}
			}
		}
		for (ArrayList<Integer> triple : ppt) {
			int len = triple.get(0) + triple.get(1) + triple.get(2);
			for (int r = 1; len*r <= n; r++) {
				lengths.put(len*r, (lengths.containsKey(len*r)) ? lengths.get(len*r) + 1 : 1);
			}
		}
		for (int i : lengths.keySet()) {
			count += (lengths.get(i) == 1) ? 1 : 0;
		}
		return count;
	}

	public static void main(String[] args) {
		long last_time = System.nanoTime();
		int answer = bent_wires(1500000);
		long now = System.nanoTime();
		System.out.println(answer);
		System.out.println("Computed in " + (double)(now - last_time)/1000000000 + " seconds.");
	}

}
 