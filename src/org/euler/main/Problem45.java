package org.euler.main;

public class Problem45 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int x = 143;
		long p = 0;
		
		while (true) {
			x++;
			
			long k = hexagonal(x);
			
			if (isPentagonal(k)) {
				p = k;
				break;
			}
		}
		
		System.out.println(p);
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Completed in " + (double) elapsedTime / 1000 + " microseconds.");
	}
	
	public static boolean isPentagonal(long n) {
		long t = (long) Math.sqrt(1 + 24 * n);
		return t * t == (24 * n + 1) && (1 + t) % 6 == 0;
	}
	
	public static long hexagonal(int index) {
		return index * (2 * index - 1);
	}

}
