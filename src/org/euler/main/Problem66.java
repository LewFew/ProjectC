package org.euler.main;

import java.math.BigInteger;

import org.euler.common.Common;
import org.euler.common.ZRootD;

public class Problem66 {
	
	public static int maxPellLocation(int range) {
		BigInteger max = BigInteger.ZERO;
		int location = -1;
		for (int i = 1; i <= range; i++) {
			double sqrt = Math.sqrt(i);
			if (Math.floor(sqrt) != sqrt) {
				ZRootD pells = Common.pellsEquation(i);
				if (pells.component()[0].compareTo(max) == 1) {
					location = i;
					max = pells.component()[0];
				}
			}
		}
		return location;
	}

	public static void main(String[] args) {
		long lastTime = System.nanoTime();
		//-----------
		System.out.println(maxPellLocation(1000));
		//-----------
		long now = System.nanoTime();
		System.out.println("Computed in " + (double)(now-lastTime)/1000000 + " milleseconds.");
	}

}
