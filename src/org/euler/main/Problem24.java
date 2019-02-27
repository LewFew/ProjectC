package org.euler.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem24 {
	
	static Scanner s = new Scanner(System.in);

	public static int fact(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * fact(n - 1);
		}
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
	
	public static void printArr(int[] arr) {
		String k = "";
		for (int i = 0; i < arr.length; i++) {
			k = k + String.valueOf(arr[i]);
		}
		System.out.println(k);
	}
	

	public static void main(String[] args) {
		String input = s.nextLine();
		char[] q = input.toCharArray();
		int[] digits = new int[q.length];
		
		for (int i = 0; i < q.length; i++) {
			digits[i] = Integer.parseInt(String.valueOf(q[i]));
		}
		
		for (int i = 0; i < 999999; i++) {
			digits = nextPermutation(digits);
		}
		
		printArr(digits);
	}

}
