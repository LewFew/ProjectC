package org.euler.main;

import java.math.BigInteger;

public class Problem55B {
	
	public static void escape() {
	//	System.out.println(lychrel(new BigInteger("196"),));
		System.exit(0);
	}

	public static void main(String[] args) {
	//	escape();
		long lastTime = System.nanoTime();
		
		long counter = 0;
		
		for (int i = 3; i < 10000; i++) {
			counter += (lychrel(new BigInteger(String.valueOf(i)), 0)) ? 1 : 0;
		}
		
		long deltaTime = System.nanoTime() - lastTime;
		
		System.out.println(counter);
		System.out.println("Computed in " + (deltaTime/1000000) + " milleseconds.");
	}
	
	public static BigInteger reverseDigits(BigInteger n) {
		String[] k = n.toString().split("");
		String z = "";
		for (int i = 0; i < k.length; i++) {
			z += k[k.length - i - 1];
		}
		return new BigInteger(z);
	}
	
	public static boolean palindromic(BigInteger n) {
		return n.equals(reverseDigits(n));
	}
	
	public static boolean lychrel(BigInteger a, int c) {
		c++;
		BigInteger k = a.add(reverseDigits(a));
		//System.out.println(a);
		if (palindromic(k)) {
			return false;
		} else if (c < 50) {
			return lychrel(k, c);
		} else {
			return true;
		}
	}

}