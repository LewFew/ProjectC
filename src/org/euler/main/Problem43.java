package org.euler.main;

import java.util.ArrayList;
import java.util.Collections;

public class Problem43 {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
		int[] q = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		long sum = 0;
		
		for (int i = 0; i < 3628800; i++) { //3628800
			
			int y[] = { 0, 0, 0 };
			int t[] = { 2, 3, 5, 7, 11, 13, 17 };
			
			boolean d = true;
			
			for (int j = 2; j <= 8; j++) {
				y[0] = q[j - 1];
				y[1] = q[j];
				y[2] = q[j + 1];
				
				//System.out.println(j - 1);
				if (arrayToInt(y) % t[j - 2] != 0) {
					//System.out.println(arrayToInt(q) + " " + arrayToInt(y) + " " + t[j - 2] + " //");
					d = false;
					break;
				} else {
					//System.out.println(arrayToInt(q) + " " + arrayToInt(y) + " " + t[j - 2]);
				}
			}
			
			sum += (d) ? arrayToInt(q) : 0;
			if (d) {
				System.out.println(arrayToInt(q));
			}
			
			q = nextPermutation(q);
		}
		
		System.out.println(sum);
		
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Completed in " + (double) elapsedTime / 1000 + " microseconds.");
		
	}
	
	private static long arrayToInt(int[] q) {
		long z = 0;
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
