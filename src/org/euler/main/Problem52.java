package org.euler.main;

import java.util.HashMap;

public class Problem52 {

	public static void main(String[] args) {
		
		long lastTime = System.nanoTime();
		
		int n = 1;
		boolean found = false;
		
		HashMap<Integer, Integer> digits = new HashMap<Integer, Integer>();
		
		while (!found) {
			n++;
			for (int i = (int) (Math.pow(10, n - 1)); i < (int) (Math.pow(10, n) / 6); i++) {
				digits.clear();
				for (int j = 0; j < n; j++) {
					digits.put((int) ((i % Math.pow(10, j + 1) / Math.pow(10, j))), 1);
				}
				for (int u = 2; u <= 6; u++) {
					boolean skip = false;
					int c = i * u;
					for (int j = 0; j < n; j++) {
						int digit = (int) ((c % Math.pow(10, j + 1) / Math.pow(10, j)));
						if (digits.containsKey(digit)) {
							digits.put(digit, digits.get(digit) + 1);
						} else {
							skip = true;
							break;
						}
					}
					if (skip) {
						break;
					}
				}
				found = true;
				for (int t : digits.keySet()) {
					if (digits.get(t) != 6) {
						found = false;
						break;
					}
				}
				if (found) {
					System.out.println(i);
					break;
				}
			}
		}
		
		long deltaTime = System.nanoTime() - lastTime;
		
		System.out.println("Computed in " + deltaTime / 1000000 + " milleseconds.");
	}
}