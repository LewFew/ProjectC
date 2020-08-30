package org.euler.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.euler.common.Common;

public class Problem62 {
	
	public static long permCube(int n) {
		for (int i=2;;i++) {
			long low = (long) Math.ceil(Math.cbrt(Math.pow(10, i)));
			long high = (long) Math.floor(Math.cbrt(Math.pow(10, i+1)-1));
			HashMap<ArrayList<Integer>, Integer> memo = new HashMap<ArrayList<Integer>, Integer>();
			HashMap<ArrayList<Integer>, Long> first = new HashMap<ArrayList<Integer>, Long>();
			for (long j = low; j <= high; j++) {
				long curCube = j*j*j;
				ArrayList<Integer> curCubeDecomp = Common.decompose(curCube);
				if (memo.containsKey(curCubeDecomp)) {
					memo.put(curCubeDecomp, memo.get(curCubeDecomp) + 1);
				} else {
					memo.put(curCubeDecomp, 1);
					first.put(curCubeDecomp, curCube);
				}
			}
			long smallest = 0;
			boolean start = false;
			for (ArrayList<Integer> decomp : memo.keySet()) {
				if (memo.get(decomp) == n) {
					if (!start) {
						start = true;
						smallest = first.get(decomp);
					} else {
						smallest = (first.get(decomp) < smallest) ? first.get(decomp) : smallest;
					}
				}
			}
			if (start) {
				return smallest;
			}
		}
	}

	public static void main(String[] args) {
		long lastTime = System.nanoTime();
		//--------------
		System.out.println(permCube(5));
		//--------------
		long now = System.nanoTime();
		System.out.println("Computed in " + (double)(now-lastTime)/1000000000 + " seconds.");
	}

}
