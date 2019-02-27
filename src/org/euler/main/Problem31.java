package org.euler.main;

public class Problem31 {
	
	static int[] k = { 200, 100, 50, 20, 10, 5, 2, 1 };
	static int[] u = new int[8];

	public static void main(String[] args) {
		long lastTime = System.nanoTime();
		
		int q = zeta(0, 200);
		
		long deltaTime = System.nanoTime() - lastTime;
		
		System.out.println(q);
		System.out.println("Computed in " + (deltaTime/1000000) + " milleseconds.");
	}
	
	public static void printArr(int[] arr) {
		String t = "";
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			t += arr[i] + " " + k[i] + " | ";
			sum += arr[i] * k[i];
		}
		System.out.println(t + " Sum: " + sum);
	}
	
	public static int zeta(int q, int rem) {
		
		int w = 0;
		
		if (q == k.length - 1) {
			return 1;
		}
		
		for (int i = 0; i <= rem / k[q]; i++) {
			int z = zeta(q + 1, rem - (i * k[q]));
			w += z;
		}
		
		return w;
	}

}
