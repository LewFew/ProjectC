package org.euler.main;

import java.util.HashSet;
import java.util.LinkedList;

public class Problem61 {
	
	public static int p(int n, int k) {
		return ((n-2)*k*k + (4-n)*k)/2;
	}
	
	public static double ip(int val, int n) {
		return ((n-4) + Math.sqrt((n-4)*(n-4) + 8*val*(n-2)))/(2*(n-2));
	}

	public static HashSet<Integer> range(int a, int b, int n) {
		int low = (int) Math.ceil(ip(a, n));
		int high = (int) Math.floor(ip(b, n));
		HashSet<Integer> ret = new HashSet<Integer>();
		for (int i = low; i <= high; i++) {
			int candidate = p(n, i);
			if (candidate % 100 > 10) {
				ret.add(p(n, i));
			}
		}
		return ret;
	}
	
	public static LinkedList<Integer> cycleSet(int n) {
		HashSet<Integer> rem = new HashSet<Integer>();
		LinkedList<Integer> cur = new LinkedList<Integer>();
		LinkedList<Integer> ret = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			rem.add(i+3);
		}
		cycleSetHelper(rem, cur, ret);
		return ret;
	}
	
	public static void cycleSetHelper(HashSet<Integer> rem, LinkedList<Integer> cur, LinkedList<Integer> ret) {
		if (cur.size() == 0) {
			int largest = rem.size() + 2;
			HashSet<Integer> range = range(1000, 9999, largest);
			HashSet<Integer> newRem = new HashSet<Integer>();
			for (int i : rem) {newRem.add(i);}
			newRem.remove(largest);
			for (int i : range) {
				LinkedList<Integer> newCur = new LinkedList<Integer>();
				newCur.add(i);
				cycleSetHelper(newRem, newCur, ret);
			}
		} else {
			for (int i : rem) {
				if (rem.size() == 1) {
					int lastNumber = (cur.getLast() % 100) * 100 + (int)(cur.getFirst()/100);
					double polyRoot = ip(lastNumber, i);
					if (Math.floor(polyRoot) == polyRoot) {
						for (int j : cur) {
							ret.add(j);
						}
						ret.add(lastNumber);
					}
				} else {
					int low = (cur.getLast() % 100) * 100;
					HashSet<Integer> range = range(low, low+100, i);
					for (int j : range) {
						HashSet<Integer> newRem = new HashSet<Integer>();
						LinkedList<Integer> newCur = new LinkedList<Integer>();
						for (int k : rem) {
							newRem.add(k);
						}
						for (int k : cur) {
							newCur.add(k);
						}
						newCur.add(j);
						newRem.remove(i);
						cycleSetHelper(newRem, newCur, ret);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		long lastTime = System.nanoTime();
		LinkedList<Integer> test = cycleSet(6);
		int sum = 0;
		for (int i : test) {sum+=i;}
		System.out.println(sum);
		long now = System.nanoTime();
		System.out.println("Computed in " + (now-lastTime)/1000000 + " milleseconds.");
	}

}
