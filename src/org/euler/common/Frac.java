package org.euler.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;

public class Frac {
	
	public static final Frac ZERO = new Frac(0, 1);
	public static final Frac ONE = new Frac(1, 1);
	public static final Frac TEN = new Frac(10, 1);
	
	public static Frac intExtend(int n) {
		return new Frac(n, 1);
	}
	
	public static Frac bigExtend(BigInteger n) {
		return new Frac(n, BigInteger.ONE);
	}
	
	BigInteger[] val;
	public Frac(int a, int b) {
		val = new BigInteger[2];
		if (a == 0) {
			val[0] = BigInteger.ZERO;
			val[1] = BigInteger.ONE;
		} else {
			int gcd = Common.gcd(a, b);
			int sign = (((a < 0) || (b < 0)) && !((a < 0) && (b < 0))) ? -1 : 1;
			val[0] = new BigInteger(String.valueOf(Math.abs(a/gcd) * sign));
			val[1] = new BigInteger(String.valueOf(Math.abs(b/gcd)));
		}
	}
	public Frac(BigInteger a, BigInteger b) {
		val = new BigInteger[2];
		if (a.equals(BigInteger.ZERO)) {
			val[0] = BigInteger.ZERO;
			val[1] = BigInteger.ONE;
		} else {
			BigInteger gcd = a.gcd(b);
			boolean negative = ((a.abs().equals(a.negate())) || (b.abs().equals(b.negate())))
					&& !((a.abs().equals(a.negate())) && (b.abs().equals(b.negate())));
			val[0] = (negative) ? a.abs().divide(gcd).negate() : a.abs().divide(gcd);
			val[1] = b.abs().divide(gcd);
		}
	}
	public double numerical() {
		BigDecimal temp = new BigDecimal(val[0].toString());
		BigDecimal temp2 = new BigDecimal(val[1].toString());
		return temp.divide(temp2, 10, RoundingMode.HALF_DOWN).doubleValue();
	}
	public BigInteger numericalBigInt() {
		return val[0].divideAndRemainder(val[1])[0];
	}
	public BigInteger numericalBigIntCeil() {
		return val[0].divideAndRemainder(val[1])[0].add((val[0].divideAndRemainder(val[1])[1].compareTo(BigInteger.ZERO) == 1) ? BigInteger.ONE : BigInteger.ZERO);
	}
	public Frac add(Frac b) {
		BigInteger denom = b.val[1].multiply(this.val[1]);
		BigInteger num = (this.val[0].multiply(b.val[1])).add(b.val[0].multiply(this.val[1]));
		return new Frac(num, denom);
	}
	public Frac multiply(Frac b) {
		return new Frac(this.val[0].multiply(b.val[0]), this.val[1].multiply(b.val[1]));
	}
	public Frac multiply(int b) {
		return new Frac(this.val[0].multiply(new BigInteger(String.valueOf(b))), this.val[1]);
	}
	public Frac subtract(Frac b) {
		return this.add(b.multiply(-1));
	}
	public Frac divide(Frac b) {
		return new Frac(this.val[0].multiply(b.val[1]), this.val[1].multiply(b.val[0]));
	}
	public Frac pow(int n) {
		return (n >= 0) ? new Frac(val[0].pow(n), val[1].pow(n)) : new Frac(val[1].pow(-n), val[0].pow(-n));
	}
	@Override
	public boolean equals(Object o) {
		return (this.val[0].equals(BigInteger.ZERO) && ((Frac) o).val[0].equals(this.val[0])) ? true : Arrays.equals(((Frac) o).val, this.val);
	}
	@Override
	public String toString() {
		if (this.val[1].equals(BigInteger.ONE)) {
			return String.valueOf(this.val[0]);
		} else {
			return String.valueOf(this.val[0])+"/"+String.valueOf(this.val[1]);
		}
	}
	@Override
	public int hashCode() {
		//Bad hash, but I'm too lazy to think of a better one.
		return val[0].intValue() + val[1].intValue();
	}
	public int compareTo(Frac b) {
		return (val[0].multiply(b.val[1])).compareTo(b.val[0].multiply(val[1]));
	}
}
