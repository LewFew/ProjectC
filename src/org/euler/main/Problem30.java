package org.euler.main;

public class Problem30 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 2; i < 1000000; i++) {
			if (i == sumPowers(i)) {
				sum += i;
			}
		}
		
		System.out.println(sum);

	}
	
	public static int sumPowers(int k) {
		String l = String.valueOf(k);
		char[] j = l.toCharArray();
		
		int sum = 0;
		
		for (int i = 0; i < j.length; i++) {
			sum += Math.pow(Integer.parseInt(String.valueOf(j[i])), 5);
		}
		
		return sum;
	}

}
