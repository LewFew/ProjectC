package org.euler.main;

import java.math.BigInteger;
import java.util.HashMap;

public class Problem57 {
	
	public static HashMap<Integer, Fraction> expansion = new HashMap<Integer, Fraction>();
	
	public static class Fraction {
		BigInteger numerator, denominator;
		
		public Fraction(BigInteger numerator, BigInteger denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}
		
		public void print() {
			System.out.println(numerator + "/" + denominator);
		}
		
		public void reduce() {
			BigInteger gcd = GCD(numerator, denominator);
			
			numerator = numerator.divide(gcd);
			denominator = denominator.divide(gcd);
		}
		
		public Fraction divide(Fraction b) {
			numerator = numerator.multiply(b.denominator);
			denominator = denominator.multiply(b.numerator);
			reduce();
			
			return this;
		}
		
		public Fraction add(Fraction b) {
			numerator = numerator.multiply(b.denominator);
			numerator = numerator.add(b.numerator.multiply(denominator));
			denominator = denominator.multiply(b.denominator);

			reduce();
			
			return this;
		}
	}
	
	public static Fraction epsilon(int n) {
		Fraction f = new Fraction(new BigInteger("2"), new BigInteger("1"));
		Fraction k = new Fraction(new BigInteger("1"), new BigInteger("1"));
		
		if (expansion.containsKey(n)) {
			return expansion.get(n);
		} else if (n > 0) {
			k.divide(epsilon(n - 1));
			f.add(k);
			expansion.put(n, f);
			return f;
		} else {
			k.divide(new Fraction(new BigInteger("2"), new BigInteger("1")));
			f.add(k);
			return f;
		}
	}
	
	public static Fraction expand(int n) {
		Fraction k = new Fraction(new BigInteger("1"), new BigInteger("1"));
		Fraction f = new Fraction(new BigInteger("1"), new BigInteger("1"));
		f.divide(epsilon(n - 2));
		k.add(f);
		return k;
	}
	
	public static BigInteger GCD(BigInteger a, BigInteger b) {
		if (b.equals(new BigInteger("0"))) {
			return a;
		} else {
			return GCD(b, a.mod(b));
		}
	}

	public static void main(String[] args) {
		
		long lastTime = System.nanoTime();
		
		int counter = 0;
		
		for (int i = 3; i <= 1000; i++) {
			Fraction t = expand(i);
			if (t.numerator.toString().length() > t.denominator.toString().length()) {
				counter++;
				//break;
			}
		}
		
		long deltaTime = System.nanoTime() - lastTime;
		System.out.println(counter);
		System.out.println("Computed in " + (deltaTime/1000000) + " milleseconds.");
	}

}
