package org.euler.main;

import java.util.HashMap;

public class Problem44 {
	
	static HashMap<Integer, Boolean> pentagonal = new HashMap<Integer, Boolean>();
	static HashMap<int[], Boolean> works = new HashMap<int[], Boolean>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int chunk = 0;
		int d = -1;
		
		while (true) {
			chunk++;
			
			int maxGap = 10 * chunk - 2;
			
			for (int i = 0; i <= maxGap; i++) {
				for (int j = 1; j < 10 * chunk - i; j++) {
					//System.out.println("trying " + j + " to " + (j + i + 1) + " or: " + pentagon(j) + " and " + pentagon(j + i + 1) + " gap: " + i);
					if (isPentagon(sumDifferenceSeries(j - 1, j + i - 1))) {
						if (isPentagon(pentagon(j) + pentagon(j + i + 1))) {
							d = Math.abs(pentagon(j) - pentagon(j + i + 1));
							break;
						}
					}
				}
				if (d != -1) {
					break;
				}
			}
			
			if (d != -1) {
				break;
			}
		}
		
		System.out.println(d);
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Completed in " + (double) elapsedTime / 1000000000 + " seconds.");
	}
	
	public static boolean isPentagon(int n) {
		if (pentagonal.containsKey(n)) {
			return pentagonal.get(n);
		} else {
			
			double sol = (1 + Math.sqrt(1 + 24 * n)) / 6;
			double solFloor = Math.floor(sol);
			
			boolean k = sol == solFloor;
			pentagonal.put(n, k);
			
			return k;
		}
	}
	
	public static int sumDifferenceSeries(int p, int q) {
		
		//System.out.println((q + 1) + " * " + "(" + difference(0) + " + " + difference(q) + ") / 2 = " + (((difference(0) + difference(q)) / 2)));
		
		return (int)((q + 1) * ((float)(difference(0) + difference(q)) / 2)) - (int)((p + 1) * ((float)(difference(0) + difference(p)) / 2)) + difference(p);
	}
	
	public static int pentagon(int n) {
		return (n * (3 * n - 1)) / 2;
	}
	
	public static int difference(int n) {
		return 3 * n + 4;
	}

}
