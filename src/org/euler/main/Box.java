package org.euler.main;

public class Box {

	public static void main(String[] args) {
		
		for (long i = 111111111; i < 999999999; i++) {
			
			if (i % 10000000 == 0) {
				System.out.println("Milestone: " + i);
			}
			
			//.out.println(i);
			
			int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
			int q[] = stringToInt(String.valueOf(i));
			
			if (q[0] != -1) {
				//System.out.println("Actually checking.");
				for (int j = 0; j < 9; j++) {
					arr[q[j] - 1]++;
				}
				
				if (arr == q) {
					System.out.println("Found it.");
					for (int t = 0; t < 9; t++) {
						System.out.println(q[t]);
					}
					return;
				} else {
					System.out.println(i + ": ----------------");
					for (int t = 0; t < 9; t++) {
						System.out.println(q[t] + " " + arr[t]);
					}
				}
			} 
		}
		
	}
	
	public static int[] stringToInt(String k) {
		
		int[] p = new int[k.length()];
		boolean hasZero = false;
		
		String[] u = k.split("");
		
		for (int i = 0; i < u.length; i++) {
			if (u[i].equals("0"))
				hasZero = true;
			else
				p[i] = Integer.parseInt(u[i]);
		}
		
		if (hasZero)
			return new int[] {-1};
		else
			return p;
	}
	
}
