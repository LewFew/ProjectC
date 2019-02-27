package org.euler.main;

import java.util.ArrayList;
import java.util.Collections;

public class Problem41 {
	
	static int[] fact = { 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
	static int largest = 0;

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
		for (int i = 1; i <= 9; i++) {
			check(i);
		}
		
		System.out.println(largest);
		
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Completed in " + ((double) elapsedTime / 1000) + " microseconds.");
		
	}
	
	public static void printArr(int[] arr) {
		String k = "";
		for (int i = 0; i < arr.length; i++) {
			k = k + String.valueOf(arr[i]);
		}
		System.out.println(k);
	}
	
	private static void check(int n) {
		
		int[] u = new int[n];
		
		for (int i = 1; i <= n; i++) {
			u[i - 1] = i;
		}	
		
		for (int i = 0; i < fact[n - 1]; i++) {
			int z = arrayToInt(u);
			if (isPrime(z) && z > largest)
				largest = z;
			u = nextPermutation(u);
		}
	}
	
	public static boolean isPrime(int n) {
		double q = Math.sqrt(n);
		int k = (int) q;
		if (q - k == 0 || (n % 2 == 0 && n != 2)) {
			return false;
		} else {
			for (int i = k; i > 1; i--) {
				if (n % i == 0)
					return false;
			}
		}
		return true;
	}
	
	private static int arrayToInt(int[] q) {
		int z = 0;
		for (int i = q.length - 1; i >= 0; i--) {
			z += Math.pow(10, i) * q[q.length - 1 - i];
		}
		return z;
	}
	
	private static int[] nextPermutation(int[] q) {
		for (int i = q.length - 2; i >= 0; i--) {
			if (q[i] < q[i + 1]) {
				
				int smallestIndex = i + 1;
				
				for (int x = i + 1; x < q.length; x++) {
					if (q[x] < q[smallestIndex] && q[x] > q[i]) {
						smallestIndex = x;
					}
				}
				
				int temp = q[i];
				q[i] = q[smallestIndex];
				q[smallestIndex] = temp;
				sortPart(q, i + 1);
				break;
			}
		}
		return q;
	}
	
	public static void reversePart(int[] arr, int index) {
		for (int i = 0; i < (arr.length - index)/2; i++) {
			int temp = arr[i + index];
			arr[i + index] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}
	
	public static void sortPart(int[] arr, int index) {
		ArrayList<Integer> part = new ArrayList<Integer>();
		for (int i = index; i < arr.length; i++) {
			part.add(arr[i]);
		}
		Collections.sort(part);
		
		for (int i = index; i < arr.length; i++){
			arr[i] = part.get(i - index);
		}
	}

}
