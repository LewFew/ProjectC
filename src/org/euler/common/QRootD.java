package org.euler.common;

import java.math.BigInteger;
import java.util.Arrays;

public class QRootD {
	//Deals with elements in Q[sqrt(d)] with d >= 0
	
	public static QRootD qExtend(Frac q, int d) {
		return new QRootD(q, Frac.ZERO, d);
	}
	
	public static QRootD intExtend(int n, int d) {
		return qExtend(Frac.intExtend(n), d);
	}
	
	public BigInteger toBigInt() {
		return new BigInteger(String.valueOf(val[0].val[0]));
	}
	
	public static boolean zRD(QRootD candidate) {
		return candidate.val[0].val[1].equals(BigInteger.ONE) && candidate.val[1].val[1].equals(BigInteger.ONE);
	}
	
	public int d;
	public Frac[] val;
	public QRootD (Frac a, Frac b, int d) {
		val = new Frac[2];
		val[0] = a;
		val[1] = b;
		this.d = d;
	}
	public QRootD(BigInteger a, BigInteger b, int d) {
		val = new Frac[2];
		val[0] = Frac.bigExtend(a);
		val[1] = Frac.bigExtend(b);
		this.d = d;
	}
	public QRootD(int a, int b, int d) {
		val = new Frac[2];
		val[0] = Frac.intExtend(a);
		val[1] = Frac.intExtend(b);
		this.d = d;
	}
	
	public double numerical() {
		return val[0].numerical() + val[1].numerical() * Math.sqrt(d);
	}
	public QRootD conj() {
		return new QRootD(this.val[0], this.val[1].multiply(-1), d);
	}
	public Frac norm() {
		return this.multiply(this.conj()).val[0];
	}
	public QRootD add(QRootD b) {
		return (this.d == b.d) ? new QRootD(this.val[0].add(b.val[0]), this.val[1].add(b.val[1]), d) : null;
	}
	public QRootD multiply(QRootD b) {
		return (this.d == b.d) ? new QRootD(this.val[0].multiply(b.val[0]).add(this.val[1].multiply(b.val[1]).multiply(d)),
				this.val[0].multiply(b.val[1]).add(this.val[1].multiply(b.val[0])), d) : null;
	}
	public QRootD pow(int n) {
		if (n == 0) {
			return new QRootD(1, 0, d);
		} else if (n > 0) {
			return this.multiply(pow(n - 1));
		} else {
			return inverse().pow(-n);
		}
	}
	public QRootD subtract(QRootD b) {
		return this.add(b.multiply(intExtend(-1, d)));
	}
	public QRootD divide(QRootD b) {
		if (b.d == this.d && !b.norm().equals(Frac.ZERO)) {
			QRootD num = this.multiply(b.conj());
			Frac norm = b.norm();
			return new QRootD(num.val[0].divide(norm), num.val[1].divide(norm), d);
		} else {
			return null;
		}
	}
	public QRootD inverse() {
		return Common.ONE(d).divide(this);
	}
	@Override
	public boolean equals(Object o) {
		return (((QRootD) o).d == this.d) && Arrays.equals(((QRootD) o).val, this.val);
	}
	@Override
	public String toString() {
		if (d >= 0) {
			if (val[0].equals(Frac.ZERO) && val[1].equals(Frac.ZERO)) {
				return "0";
			} else if (!val[0].equals(Frac.ZERO) && !val[1].equals(Frac.ZERO)) {
				return val[0].toString() + " + (" + val[1].toString() + ")sqrt(" + d + ")";
			} else {
				return (val[0].equals(Frac.ZERO)) ? "(" + val[1].toString() + ")sqrt(" + d + ")"
						: val[0].toString();
			}
		} else if (d == -1){
			if (val[0].equals(Frac.ZERO) && val[1].equals(Frac.ZERO)) {
				return "0";
			} else if (!val[0].equals(Frac.ZERO) && !val[1].equals(Frac.ZERO)) {
				return val[0].toString() + " + (" + val[1].toString() + ")i";
			} else {
				return (val[0].equals(Frac.ZERO)) ? "(" + val[1].toString() + ")i)"
						: val[0].toString();
			}
		} else {
			if (val[0].equals(Frac.ZERO) && val[1].equals(Frac.ZERO)) {
				return "0";
			} else if (!val[0].equals(Frac.ZERO) && !val[1].equals(Frac.ZERO)) {
				return val[0].toString() + " + (" + val[1].toString() + ")isqrt(" + (-d) + ")";
			} else {
				return (val[0].equals(Frac.ZERO)) ? "(" + val[1].toString() + ")isqrt(" + (-d) + ")"
						: val[0].toString();
			}
		}
	}
	@Override
	public int hashCode() {
		//This is a bad hash lol, you don't want it to be completely injective,
		//but you also don't want everything to have the same hash
		return val[0].hashCode() + val[1].hashCode() + d;
	}
}
