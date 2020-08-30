package org.euler.main;

import java.util.HashMap;

import org.euler.common.Frac;
import org.euler.common.QRootD;

public class Problem64 {

	public static void main(String[] args) {
		long lastTime = System.nanoTime();
		System.out.println(oddPeriods(10000));
		long now = System.nanoTime();
		System.out.println("Computed in " + (double)(now-lastTime)/1000000 + " milleseconds.");
	}
	
	public static int oddPeriods(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			double sqrt = Math.sqrt(i);
			if (Math.floor(sqrt) != sqrt) {
				HashMap<QRootD, Integer> firstOccurence = new HashMap<QRootD, Integer>();
				QRootD x_i = new QRootD(Frac.ZERO, Frac.ONE, i);
				QRootD a_i = QRootD.intExtend((int)Math.floor(x_i.numerical()), i);
				firstOccurence.put(x_i, 1);
				for (int j = 2;; j++) {
					x_i = ((x_i.subtract(a_i)).inverse());
					a_i = (QRootD.intExtend((int)Math.floor(x_i.numerical()), i));
					if (firstOccurence.containsKey(x_i)) {
						count += ((j - firstOccurence.get(x_i)) % 2 == 1) ? 1 : 0;
						break;
					} else {
						firstOccurence.put(x_i, j);
					}
				}
			}
		}
		return count;
	}
}
