package org.euler.main;

public class Problem38 {

	public static void main(String[] args) {
		
		int largest = 0;
		
		for (int i = 1; i <= 9999; i++) {
			String sum = "";
			int x = 0;
			while (sum.length() < 9) {
				x++;
				sum += (x * i);
			}
			
			if (sum.length() != 9) {
				continue;
			}
			
			if (isPandigital(sum) && Integer.parseInt(sum) > largest) {
				largest = Integer.parseInt(sum);
			}
		}
		
		System.out.println(largest);
	}
	
	public static boolean isPandigital(String q) {
		
		int[] t = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		for (int i = 0; i < q.length(); i++) {
			if ((int) q.charAt(i) > 48) {
				t[(int) q.charAt(i) - 49]++;
			} else {
				return false;
			}
		}
		
		for (int i = 0; i < t.length; i++) {
			if (t[i] != 1) {
				return false;
			}
		}
		
		return true;
	}

}
