package org.euler.main;

public class Problem39 {

	public static void main(String[] args) {
		long timeStart = System.nanoTime();
		
		int highest = 0;
		int highestPerimeter = 0;
		
		for (int i = 12; i <= 1000; i++) {
			int q = solutions(i);
			if (q > highest) {
				highest = q;
				highestPerimeter = i;
			}
		}
		
		System.out.println(highestPerimeter + " yielded " + highest + " solutions");
		
		long timeElapsed = System.nanoTime() - timeStart;
		System.out.println(timeElapsed);
	}
	
	public static int solutions(int n) {
		int start = n / 3;
		int stop = n / 2;
		
		int count = 0;
		
		for (int i = start; i <= stop; i++) {
			int left = n - i;
			for (int j = 1; j <= left / 2; j++) {
				int a = j;
				int b = left - j;
				count += (a * a + b * b == i * i) ? 1 : 0;
			}
		}
		
		return count;
	}

}
