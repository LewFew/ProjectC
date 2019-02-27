package org.euler.main;

public class Problem33 {

	public static void main(String[] args) {	
		int num = 1;
		int dem = 1;
		
		
		for (int i = 10; i <= 99; i++) {
			for (int j = 10; j <= 99; j++) {
				if (i < j) {
					if (curious(i, j)) {
						num *= i;
						dem *= j;
					}
				}
			}
		}
		
		int h = GCD(num, dem);
		
		System.out.println((num / h) + "/" + (dem / h));
	}
	
	public static int GCD(int a, int b) {
		if (a == 0) {
			return b;
		} else {
			return GCD(b%a, a);
		}
	}
	
	public static boolean curious(int a, int b) {
		
		if (a % 10 != 0 && b % 10 != 0) {
		
			for (int i = 1; i <= 9; i++) {
				
				String aI = String.valueOf(a);
				String bI = String.valueOf(b);
				
				if (aI.contains(String.valueOf(i)) && bI.contains(String.valueOf(i))) {
				
					aI = aI.replace(String.valueOf(i), "");
					bI = bI.replace(String.valueOf(i), "");
					
					if (aI.length() != 0 && bI.length() != 0 && !aI.equals(bI)) {
						if ((double)((double) a / (double) b) == Double.parseDouble(aI) / Double.parseDouble(bI)) {
							//System.out.println((double)((double) a / (double) b) + " " + a + " " + b + " " + Double.parseDouble(aI) / Double.parseDouble(bI));
							return true;
						}
					}
				
				}
			}
		
		} else {
			return false;
		}
		
		return false;
	}

}
