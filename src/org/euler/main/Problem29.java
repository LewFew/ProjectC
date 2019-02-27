package org.euler.main;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem29 {
	
	static Set<BigInteger> terms = new HashSet<BigInteger>();

	public static void main(String[] args) {
		int a = 2;
		int b = 2;
		
		while (a <= 100) {
			
			BigInteger k = new BigInteger(String.valueOf(a)).pow(b);
			
			if (!terms.contains(k)) {
				terms.add(k);
			}
			
			b++;
			if (b > 100) {
				b = 2;
				a++;
			}
		}
		
		System.out.println(terms.size() + " <--- size");
		
//		for (BigInteger q : terms) {
//			System.out.println(q);
//		}
	}

}
