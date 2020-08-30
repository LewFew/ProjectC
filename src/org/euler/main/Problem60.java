package org.euler.main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Problem60 {
	
	static ArrayList<Integer> foundPrimes = new ArrayList<Integer>();
	static HashMap<Integer, HashSet<Integer>> pGraph = new HashMap<Integer, HashSet<Integer>>();
	static int rootIndex = 0;
	
	public static boolean isPrime(long n) {
		BigInteger bint = new BigInteger(String.valueOf(n));
		if (!bint.isProbablePrime(10)) {return false;}
		long sqrt = (long) Math.sqrt(n);
		if (n == 1) {
			return false;
		} else {
			for (long i = 2; i <= sqrt; i++) {
				if (n % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean amicable(int a, int b) {
		return isPrime(concatenate(a, b)) && isPrime(concatenate(b, a));
	}
	
	public static int getRoot(int index) {
		if (index == 0) {
			return 1;
		} else {
			return foundPrimes.get(index);
		}
	}
	
	public static int square(int n) {
		return n * n;
	}
	
	public static int newIndex(int candidate) {
		int search = rootIndex;
		while (square(getRoot(search+1)) <= candidate) {
			search++;
		}
		return search;
	}
	
	public static int nextPrime() {
		int candidate = foundPrimes.get(foundPrimes.size() - 1);
		if (candidate == 2) {
			return 3;
		} else {
			while (true) {
				boolean success = true;
				candidate += 2;
				rootIndex = newIndex(candidate);
				for (int i = 1; i <= rootIndex; i++) {
					if (candidate % getRoot(i) == 0) {
						success = false;
						break;
					}
				}
				if (success) {return candidate; }
			}
		}
	}
	
	public static HashSet<Integer> intersectNeighbours(HashSet<Integer> neighbours) {
		HashSet<Integer> ret = new HashSet<Integer>();
		HashSet<Integer> toRemove = new HashSet<Integer>();
		boolean first = true;
		for (int i : neighbours) {
			if (first) {
				first = false;
				ret.addAll(pGraph.get(i));
			} else {
				for (int j : ret) {
					if (!pGraph.get(i).contains(j)) {
						toRemove.add(j);
					}
				}
				ret.removeAll(toRemove);
			}
		}
		return ret;
	}
	
	public static HashSet<Integer> copy (HashSet<Integer> source) {
		HashSet<Integer> ret = new HashSet<Integer>();
		for (int i : source) {
			ret.add(i);
		}
		return ret;
	}
	
	public static HashSet<HashSet<Integer>> knSubGraph(int n) {
		
		HashSet<HashSet<Integer>> ret = new HashSet<HashSet<Integer>>();
		for (int i = 0; i < foundPrimes.size(); i++) {
			HashSet<Integer> init = new HashSet<Integer>();
			init.add(foundPrimes.get(i));
			knSubGraphHelper(n-1, init, ret);
		}
		return ret;
	}
	
	public static void knSubGraphHelper(int n, HashSet<Integer> cur, HashSet<HashSet<Integer>> acc) {
		HashSet<Integer> pool = intersectNeighbours(cur);
		pool.removeAll(cur);
		if (!pool.isEmpty()) {
			for (int i : pool) {
				HashSet<Integer> copy = copy(cur);
				copy.add(i);
				if (n == 1) {
					acc.add(copy);
				} else {
					knSubGraphHelper(n-1, copy, acc);
				}
			}
		}
	}
	
	public static long concatenate(int a, int b) {
		return Long.parseLong(String.valueOf(a) + String.valueOf(b));
	}
	
	public static boolean friendly(HashSet<Integer> neighbourhood, int other) {
		for (int i : neighbourhood) {
			if (!amicable(i, other)) {
				return false;
			}
		}
		return true;
	}
	
	public static int sum(HashSet<Integer> set) {
		int sum = 0;
		for (int i : set) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {	
		long lastTime = System.nanoTime();	
		//Begin work here
		//---------------
		int n = 5;
		foundPrimes.add(2);
		HashSet<Integer> start = new HashSet<Integer>();
		pGraph.put(2, start);
		while (true) {
			int next = nextPrime();
			HashSet<Integer> nextNeighbours = new HashSet<Integer>();
			for (int i : foundPrimes) {
				if (amicable(i, next)) {
					nextNeighbours.add(i);
					pGraph.get(i).add(next);
				}
			}
			pGraph.put(next, nextNeighbours);
			HashSet<HashSet<Integer>> lowerSets = knSubGraph(n - 1);
			HashSet<HashSet<Integer>> sets = new HashSet<HashSet<Integer>>();
			for (HashSet<Integer> low : lowerSets) {
				if (friendly(low, next)) {
					HashSet<Integer> toAdd = copy(low);
					toAdd.add(next);
					sets.add(toAdd);
					System.out.println("new guy: " + next);
				}
			}
			if (!sets.isEmpty()) {
				int min = Integer.MAX_VALUE;
				HashSet<Integer> minSet = new HashSet<Integer>();
				for (HashSet<Integer> candidate : sets) {
					int s = sum(candidate);
					if (s < min) {
						min = s;
						minSet = candidate;
					}
				}
				for (int k : minSet) {
					System.out.println(k);
				}
				System.out.println("-------");
				System.out.println(min);
				break;
			} else {
				foundPrimes.add(next);
			}
		}
		//----------------
		long deltaTime = System.nanoTime() - lastTime;	
		System.out.println("Computed in " + ((double)(deltaTime/1000000000)/60.0) + " minutes.");
	}

}
 