package org.euler.main;

public class Problem34 {
	
	static int fact[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 10; i <= 3265920; i++) {
			sum += (curious(i)) ? i : 0;
		}
		
		System.out.println(sum);
	}
	
	public static boolean curious(int n) {
		
		int c = 0;
		String st = String.valueOf(n);
		
		for (int i = 0; i < st.length(); i++) {
			c+= fact[((int) st.charAt(i)) - 48];
		}

		return c == n;
	}

}
