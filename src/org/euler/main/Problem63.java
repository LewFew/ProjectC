package org.euler.main;

import java.math.BigInteger;

public class Problem63 {

	public static void main(String[] args) {
		long lastTime = System.nanoTime();
		//-------------------
		int count = 0;
		for (int i = 1; i <= 21; i++) {
			for (int j = 1; j <= 9; j++) {
				BigInteger big = new BigInteger(String.valueOf(j));
				count += (big.pow(i).toString().length() == i) ? 1 : 0;
			}
		}
		System.out.println(count);
		//-------------------
		long now = System.nanoTime();
		System.out.println("Computed in " + (double)((now-lastTime)/1000000) + " milleseconds.");
	}

}
