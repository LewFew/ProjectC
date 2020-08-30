package org.euler.main;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem65 {
	
	public static int enConvergentSum(int n) {
		ArrayList<Integer> a_k = new ArrayList<Integer>();
		ArrayList<BigInteger> p_k = new ArrayList<BigInteger>();
		for (int k = 0; k < n; k++) {
			switch (k) {
			case 0:
				a_k.add(2);
				p_k.add(new BigInteger(String.valueOf(a_k.get(0))));
				break;
			case 1:
				a_k.add(1);
				p_k.add(new BigInteger(String.valueOf(a_k.get(0) * a_k.get(1) + 1)));
				break;
			default:
				a_k.add(((k % 3) == 2) ? 2 * ((k + 1) / 3) : 1);
				p_k.add((p_k.get(k - 1).multiply(new BigInteger(String.valueOf(a_k.get(k))))).add(p_k.get(k - 2)));
				break;
			}
		}
		BigInteger dummy = p_k.get(n - 1);
		int sum = 0;
		int dummyLen = dummy.toString().length();
		for (int i = 0; i < dummyLen + 1; i++) {
			//First line is to make sure we get the "floor"
			sum += (dummy.divideAndRemainder(BigInteger.TEN))[1].intValueExact();
			dummy = dummy.divideAndRemainder(BigInteger.TEN)[0];
		}
		return sum;
	}

	public static void main(String[] args) {
		long lastTime = System.nanoTime();
		System.out.println(enConvergentSum(100));
		long now = System.nanoTime();
		System.out.println("Computed in " + (double)(now - lastTime)/1000000 + " milleseconds.");
	}

}
