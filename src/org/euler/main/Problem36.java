package org.euler.main;

import java.util.ArrayList;

public class Problem36 {
	
	class BinaryNumber {
		
		ArrayList<Boolean> digits = new ArrayList<Boolean>();
		
		public void increment() {
			for (int i = digits.size() - 1; i >= 0; i--) {
				if (i == 0 && digits.get(i)) {
			
				} else {
					
				}
			}
		}
		
		public int toDecimal() {
			int sum = 0;
			for (int i = 0; i < digits.size(); i++) {
				if (digits.get(i)) {
					sum += Math.pow(2, digits.size() - 1);
				}
			}
			return sum;
		}
		
	}
	
	public static String reverseString(String st) {
		String k = "";
		
		for (int i = st.length() - 1; i >= 0; i--) {
			k = k + st.charAt(i);
		}
		
		return k;
	}
	
	public static boolean palindromic(String q) {
		if (q.length() % 2 == 0)
			return q.substring(0, q.length() / 2).equals(reverseString(q.substring(q.length() / 2)));
		else
			return q.substring(0, q.length() / 2).equals(reverseString(q.substring(q.length() / 2 + 1)));
	}
	
	public static int check(int k) {
		
		String z = String.valueOf(k);
		String a1 = z + reverseString(z);
		String a2 = z + reverseString(z.substring(0, z.length() - 1));
		
		int sum = 0;
		int a1Int = Integer.parseInt(a1);
		int a2Int = Integer.parseInt(a2);
		
		sum += (palindromic(Integer.toString(a1Int, 2))) ? a1Int : 0;
		sum += (palindromic(Integer.toString(a2Int, 2))) ? a2Int : 0;
		
		return sum;
	}
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 999; i++) {
			sum += check(i);
		}
		System.out.println(sum);
	}
}
