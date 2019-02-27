package org.euler.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J42013 {
	
	static Scanner s = new Scanner(System.in);
	
	static ArrayList<Integer> times = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		int total = Integer.parseInt(s.nextLine());
		int chores = Integer.parseInt(s.nextLine());

		for (int i = 0; i < chores; i++) {
			times.add(Integer.parseInt(s.nextLine()));
		}
		
		Collections.sort(times);
		
		int sum = 0;
		int counter = 0;
		
		while (sum < total) {
			if (sum + times.get(counter) <= total) {
				sum += times.get(counter);
				counter++;
			} else {
				break;
			}
		}
		System.out.println(counter);
	}

}
