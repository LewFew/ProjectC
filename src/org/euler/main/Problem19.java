package org.euler.main;

public class Problem19 {
	
	public static int[] daysInMonth = {
			31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	};
	
	public static int getDays(int month, int year) {
		if (month != 1) {
			return daysInMonth[month];
		} else if (((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0))
				|| ((year % 4 == 0) && (year % 100 != 0))){
			return 29;
		} else {
			return 28;
		}
	}

	public static void main(String[] args) {
		int d = 366;
		int s = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 12; j++) {
				
				if (d % 7 == 0) {
					s++;
				}
				d += getDays(j, i + 1);
			}
		}
		
		System.out.println(s);
	}
	
}
