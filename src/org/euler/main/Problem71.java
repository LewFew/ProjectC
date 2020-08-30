package org.euler.main;

import java.util.Iterator;
import java.util.LinkedList;

import org.euler.common.Frac;

public class Problem71 {
	
	public static Frac left_of(Frac f, int d) {
		LinkedList<Frac> candidates = new LinkedList<Frac>();
		Frac lower_bound = new Frac(f.multiply(d).numericalBigInt().intValueExact(), d);
		for (int i = 1; i <= d; i++) {
			Frac base = new Frac(1, i);
			int multiplier = f.multiply(i).numericalBigInt().intValueExact();
			int compare_1 = base.multiply(multiplier).compareTo(lower_bound);
			int compare_2 = base.multiply(multiplier).compareTo(f);
			if ((compare_1 == 0 || compare_1 == 1) && compare_2 == -1) {
				candidates.add(base.multiply(multiplier));
			}
		}
		Frac max = candidates.getFirst();
		candidates.removeFirst();
		Iterator<Frac> it = candidates.iterator();
		while (it.hasNext()) {
			Frac candidate = it.next();
			max = (candidate.compareTo(max) == 1) ? candidate : max;
		}
		return max;
	}

	public static void main(String[] args) {
		long last_time = System.nanoTime();
		System.out.println(left_of(new Frac(3, 7), 1000000));
		long now = System.nanoTime();
		System.out.println("Computed in " + (double)(now - last_time)/1000000 + " milleseconds.");
	}

}
