package org.euler.main;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem25 {

	public static void main(String[] args) {
		int x = 1;
		while (true) {
			if (fib(x).toString().length() >= 1000) {
				System.out.println(x);
				break;
			}
			x++;
		}
	}
	
	public static BigInteger fib(int n) {
		
		//n -= 1;
		
		ArrayList<BigInteger> k = new ArrayList<BigInteger>();
		k.add(new BigInteger("1"));
		k.add(new BigInteger("1"));
		if (n >= 2) {
			for (int i = 2; i < n; i++) {
				k.add(k.get(i - 1).add(k.get(i - 2)));
			}
		}
		
		return k.get(k.size() - 1);
	}

}
