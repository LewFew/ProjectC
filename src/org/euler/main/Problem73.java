package org.euler.main;

import java.util.HashSet;

import org.euler.common.Frac;

public class Problem73 {
	
	public static HashSet<Frac> frac_in_range(Frac a, Frac b, int d) {
		HashSet<Frac> ret = new HashSet<Frac>();
		for (int i = 1; i <= d; i++) {
			Frac base = new Frac(1, i);
			int low = a.divide(base).numericalBigIntCeil().intValueExact();
			int high = b.divide(base).numericalBigInt().intValueExact();
			for (int j = low; j <= high; j++) {
				Frac candidate = new Frac(j, i);
				if (candidate.compareTo(a) == 1 && candidate.compareTo(b) == -1) {
					ret.add(candidate);
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		long last_time = System.nanoTime();
		System.out.println(frac_in_range(new Frac(1, 3), new Frac(1, 2), 12000).size());
		long now = System.nanoTime();
		System.out.println("Computed in " + (double)(now - last_time)/1000000000 + " seconds.");
	}

}
