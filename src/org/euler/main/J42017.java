package org.euler.main;

import java.util.Scanner;

public class J42017 {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		int minutes = Integer.parseInt(s.nextLine());
		int modulation = minutes / (60 * 12);
		int computable = minutes % (60 * 12);
		
		
		System.out.println(checkForSeries(computable) + (modulation * 31));
	}
	
	private static int checkForSeries(int minutes) {
		
		int[] time = {1, 2, 0, 0};
		
		int counter = 0;
		
		for (int i = 0; i < minutes; i++) {
			time[3]++;
			
			if (time[3] > 9) {
				time[3] = 0;
				time[2]++;
			}
			
			if (time[2] > 5) {
				time[2] = 0;
				time[1]++;
			}
			
			if (time[1] >= 10) {
				time[1] = 0;
				time[0]++;
			}
			
			if (time[0] == 1 && time[1] > 2) {
				time[0] = 0;
				time[1] = 1;
				time[2] = 0;
				time[3] = 0;
			}
			
			if (time[0] == 0) {
				int a = time[2] - time[1];
				int b = time[3] - time[2];
				
				if (a == b) {
					counter++;
				}
			} else {
				int a = time[1] - time[0];
				int b = time[2] - time[1];
				int c = time[3] - time[2];
				
				if (a == b && b == c) {
					counter++;
				}
			}
		}
		
		return counter;
	}

}
