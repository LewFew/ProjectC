package org.euler.common;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Common {
	public static ArrayList<Integer> decompose(long n) {
		long dummy = n;
		int len = (int)Math.floor(Math.log10(dummy));
		int[] medium = new int[10];
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i <= len; i++) {
			medium[(int) (dummy%10)]++;
			dummy/=10;
		}
		for (int i = 0; i < 10; i++) {
			ret.add(medium[i]);
		}
		return ret;
	}
	public static String repeat_string(String st, int n) {
		String ret = "";
		for (int i = 0; i < n; i++) {
			ret += st;
		}
		return ret;
	}
	public static int factorial(int n) {
		int prod = 1;
		for (int i = 1; i <= n; i++) {
			prod *= i;
		}
		return prod;
	}
	public static ArrayList<Integer> decimal_representation(int a, int b) {
		HashSet<Integer> denoms = new HashSet<Integer>();
		ArrayList<Integer> representation = new ArrayList<Integer>();
		decimal_representation_helper(a * 10, b, denoms, representation);
		return representation;
	}
	
	private static void decimal_representation_helper(int a, int b, HashSet<Integer> denoms, ArrayList<Integer> acc) {
		if (denoms.contains(a)) {
			acc.add(-1);
		} else if (b != 0){
			acc.add(Math.floorDiv(a, b));
			denoms.add(a);
			decimal_representation_helper((a - acc.get(acc.size() - 1) * b)*10, b, denoms, acc);
		}
	}
	
	public static Frac to_frac(ArrayList<Integer> decimal) {
		int last_index = decimal.size() - 1;
		boolean repeating = decimal.get(last_index) == -1;
		int raw_numerator = 0;
		for (int i = 0; i < ((repeating) ? last_index : decimal.size()); i++) {
			raw_numerator = raw_numerator * 10 + decimal.get(i);
		}
		if (repeating) {
			return (new Frac(raw_numerator, (int)Math.pow(10, decimal.size()))).divide(Frac.ONE.subtract(Frac.TEN.pow(-last_index)));
		} else {
			return new Frac(raw_numerator, (int)Math.pow(10, decimal.size()));
		}
	}
	public static int max_array_index(int[] arr) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			index = (arr[i] > arr[index]) ? i : index;
		}
		return index;
	}
	public static int min_array_index(int[] arr) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			index = (arr[i] < arr[index]) ? i : index;
		}
		return index;
	}
	public static <T> HashSet<T> to_set(ArrayList<T> arr) {
		HashSet<T> ret = new HashSet<T>();
		for (T i : arr) {
			ret.add(i);
		}
		return ret;
	}
	public static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a%b);
	}
	public static QRootD ZERO (int d) {
		return new QRootD(Frac.ZERO, Frac.ZERO, d);
	}
	public static QRootD ONE (int d) {
		return new QRootD(Frac.ONE, Frac.ZERO, d);
	}
	public static ZRootD smallUnit(int d) {
		ArrayList<QRootD> a_k = new ArrayList<QRootD>();
		ArrayList<QRootD> x_k = new ArrayList<QRootD>();
		ArrayList<BigInteger> p_k = new ArrayList<BigInteger>();
		ArrayList<BigInteger> q_k = new ArrayList<BigInteger>();
		for (int k = 0;; k++) {
			switch (k) {
				case 0:
					x_k.add(new QRootD(0, 1, d));
					a_k.add(QRootD.intExtend((int)Math.floor(Math.sqrt(d)), d));
					p_k.add(new BigInteger(String.valueOf((int)Math.floor(Math.sqrt(d)))));
					q_k.add(BigInteger.ONE);
					break;
				case 1:
					x_k.add((x_k.get(k-1).subtract(a_k.get(k-1))).inverse());
					a_k.add(QRootD.intExtend((int)Math.floor(x_k.get(k).numerical()), d));
					p_k.add((a_k.get(0).multiply(a_k.get(1))).toBigInt().add(BigInteger.ONE));
					q_k.add(a_k.get(1).toBigInt());
					break;
				default:
					x_k.add((x_k.get(k-1).subtract(a_k.get(k-1))).inverse());
					a_k.add(QRootD.intExtend((int)Math.floor(x_k.get(k).numerical()), d));
					p_k.add(a_k.get(k).toBigInt().multiply(p_k.get(k-1)).add(p_k.get(k-2)));
					q_k.add(a_k.get(k).toBigInt().multiply(q_k.get(k-1)).add(q_k.get(k-2)));
					break;
			}
			ZRootD candidate = new ZRootD(p_k.get(p_k.size() - 1), q_k.get(q_k.size() - 1), d);
			if (candidate.norm().abs().equals(BigInteger.ONE)) {
				return candidate;
			}
		}
	}
	public static HashMap<Integer, Integer> prime_factor(int n, ArrayList<Integer> prime_list, HashSet<Integer> prime_set) {
		HashMap<Integer, Integer> ret = new HashMap<Integer, Integer>();
		prime_factor_helper(n, prime_list, prime_set, ret);
		return ret;
	}
	
	private static void prime_factor_helper(int n, ArrayList<Integer> prime_list, HashSet<Integer> prime_set, HashMap<Integer, Integer> acc) {
		if (prime_set.contains(n)) {
			acc.put(n, (acc.containsKey(n)) ? acc.get(n) + 1 : 1);
		} else {
			int sqrt = (int)Math.floor(Math.sqrt(n));
			for (int j = 0; prime_list.get(j) <= sqrt; j++) {
				if (n % prime_list.get(j) == 0) {
					int cur_prime = prime_list.get(j);
					acc.put(cur_prime, (acc.containsKey(cur_prime)) ? acc.get(cur_prime) + 1 : 1);
					prime_factor_helper(n / cur_prime, prime_list, prime_set, acc);
					break;
				}
			}
		}
	}
	public static ZRootD pellsEquation(int d) {
		ZRootD smallUnit = smallUnit(d);
		BigInteger norm = smallUnit.norm();
		return (norm.equals(BigInteger.ONE)) ? smallUnit : smallUnit.multiply(smallUnit);
	}
}
