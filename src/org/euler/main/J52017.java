package org.euler.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class J52017 {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		int len = Integer.parseInt(s.nextLine());
		
		String[] plankString = s.nextLine().split(" ");
		int[] planks = new int[len];
		
		HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
		HashMap<Integer, Boolean> alreadyAdded = new HashMap<Integer, Boolean>();
		ArrayList<Integer> keys = new ArrayList<Integer>();
		ArrayList<Integer> objectSet = new ArrayList<Integer>();
		
		for (int i = 0; i < plankString.length; i++) {
			planks[i] = Integer.parseInt(plankString[i]);
		}
		
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				int sum = planks[i] + planks[j];
				if (!alreadyAdded.containsKey(sum)) {
					if (sums.containsKey(sum)) {
						sums.replace(sum, sums.get(sum) + 1);
						alreadyAdded.put(sum, true);
					} else {
						sums.put(sum, 1);
						keys.add(sum);
						alreadyAdded.put(sum, true);
					}
				}
			}
			alreadyAdded.clear();
		}
		
		int largest = sums.get(keys.get(0));
		
		for (int i = 0; i < keys.size(); i++) {
			if (sums.get(keys.get(i)) > largest) {
				largest = sums.get(keys.get(i));
			}
			objectSet.add(sums.get(keys.get(i)));
		}
		
		int count = 0;
		
		for (int i = 0; i < objectSet.size(); i++) {
			if (objectSet.get(i) == largest) {
				count++;
			}
		}
		
		System.out.println(largest +  " " + count);
	}

}
