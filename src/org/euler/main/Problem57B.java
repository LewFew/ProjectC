package org.euler.main;

import java.math.BigInteger;

public class Problem57B {
	
	public static BigInteger GCD(BigInteger a, BigInteger b) {
		if (b.equals(new BigInteger("0"))) {
			return a;
		} else {
			return GCD(b, a.mod(b));
		}
	}
	
	public static class Fraction {
		
		BigInteger numerator, denominator;
		
		public Fraction(BigInteger numerator, BigInteger denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}
		
		public Fraction reduce(Fraction k) {
			Fraction z = new Fraction(k.numerator, k.denominator);
			BigInteger gcd = GCD(z.numerator, z.denominator);
			z.numerator = z.numerator.divide(gcd);
			z.denominator = z.denominator.divide(gcd);
			return z;
		}
		
		public Fraction add(Fraction k) {
			Fraction z = new Fraction(numerator.multiply(k.denominator).add(
					k.numerator.multiply(denominator)), denominator.multiply(k.denominator));
			return reduce(z);
		}
		
		public void print() {
			System.out.println(numerator.toString() + "/" + denominator.toString());
		}
	}
	
	public Fraction phi(int n) {
		return null;
	}
	
	public Fraction zeta(int n) {
		return null;
	}

	public static void main(String[] args) {
		BigInteger one = new BigInteger("1");
		BigInteger seven = new BigInteger("7");
		BigInteger four = new BigInteger("4");
		BigInteger three = new BigInteger("3");
		Fraction a = new Fraction(one, seven);
		Fraction b = new Fraction(three, four);
		Fraction c = a.add(b);
		c.print();
	}

}
