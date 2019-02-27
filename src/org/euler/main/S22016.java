package org.euler.main;

import java.util.Arrays;
import java.util.Scanner;

public class S22016 {
	
	static boolean question1;
	static int n;
	
	static int[] a;
	static int[] b;
	
	static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		
		question1 = (s.nextLine().equals("1")) ? true : false;
		n = Integer.parseInt(s.nextLine());
		
		a = new int[n];
		b = new int[n];
		
		String k[] = s.nextLine().split(" ");
		
		for (int i = 0; i < k.length; i++) {
			a[i] = Integer.parseInt(k[i]);
		}
		
		String q[] = s.nextLine().split(" ");
		
		for (int i = 0; i < q.length; i++) {
			b[i] = Integer.parseInt(q[i]);
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int sum = 0;
		
		if (question1) {
			for (int i = 0; i < n; i++) {
				sum += Math.max(a[i], b[i]);
			}
		} else {
			for (int i = 0; i < n; i++) {
				sum += Math.max(a[i], b[b.length - 1 - i]);
			}
		}
		
		System.out.println(sum);
	}

}
