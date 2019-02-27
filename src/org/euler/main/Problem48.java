package org.euler.main;

import java.math.BigInteger;

public class Problem48 {
	
	//Brute force because I'm too lazy to do cool modular arithmetic stuff

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		BigInteger sum = new BigInteger("0");
		
		for (int i = 1; i <= 1000; i++) { 
			BigInteger part = new BigInteger(String.valueOf(i));
			part = part.pow(i);
			sum = sum.add(part);
		}
		
		String inString = sum.toString();
		System.out.println(inString.substring(inString.length() - 10));
		
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Computed in " + (double) elapsedTime / 1000000 + " milliseconds.");
	}

}
