package org.euler.common;

import java.math.BigInteger;

public class ZRootD{

	private QRootD qRD;
	
	public ZRootD(int a, int b, int d) {
		qRD = new QRootD(a, b, d);
	}
	

	public ZRootD(BigInteger a, BigInteger b, int d) {
		qRD = new QRootD(a, b, d);
	}
	
	private static ZRootD toInt(QRootD u) {
		return new ZRootD(u.val[0].val[0], u.val[1].val[0], u.d);
	}
	
	public static ZRootD intExtend(int n, int d) {
		return new ZRootD(n, 0, d);
	}
	
	public QRootD inQ() {
		return qRD;
	}
	
	public BigInteger[] component() {
		BigInteger[] ret = {qRD.val[0].val[0], qRD.val[1].val[0]};
		return ret;
	}
	
	public BigInteger norm() { return qRD.norm().val[0]; }
	public ZRootD add(ZRootD b) { return toInt(qRD.add(b.inQ())); }
	public ZRootD multiply(ZRootD b) { return toInt(qRD.multiply(b.inQ())); }
	public ZRootD subtract(ZRootD b) { return toInt(qRD.subtract(b.inQ())); }
	public ZRootD pow(int n) { return toInt(qRD.pow(n)); }
	public ZRootD conj() { return toInt(qRD.conj()); }
	
	
	public ZRootD divide(ZRootD b) {
		QRootD qApp = qRD.divide(b.inQ());
		return (qApp != null && QRootD.zRD(qApp)) ? toInt(qApp) : null;
	}
	
	@Override
	public String toString() {
		return qRD.toString();
	}
	@Override
	public boolean equals(Object o) {
		return ((ZRootD) o).inQ().equals(qRD);
	}
	@Override
	public int hashCode() {
		return qRD.hashCode();
	}
}
