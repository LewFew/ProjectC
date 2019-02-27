package org.euler.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class S12010 {
	
	static int[] vals;
	static String[] names;
	static Scanner s = new Scanner(System.in);
	
	static HashMap<Integer, String> values = new HashMap<Integer, String>();

	public static void main(String[] args) {
		vals = new int[Integer.parseInt(s.nextLine())];
		names = new String[vals.length];
		
		for (int i = 0; i < vals.length; i++) {
			String[] inputs = s.nextLine().split(" ");
			
			int r = Integer.parseInt(inputs[1]);
			int s = Integer.parseInt(inputs[2]);
			int d = Integer.parseInt(inputs[3]);
			
			values.put(2 * r + 3 * s + d, inputs[0]);
		}
			
			ArrayList<Integer> keys = new ArrayList<Integer>();
			
			Object[] keySet = values.keySet().toArray();
			
			for (int i = 0; i < keySet.length; i++) {
				keys.add(Integer.parseInt(keySet[i].toString()));
			}
			
			Collections.sort(keys);
			
			if (keys.size() >= 2 ) {
				
				boolean willSwitch = false;
						
				if (keys.get(keys.size() - 1) == keys.get(keys.size() - 2)) {
					String a = values.get(keys.get(keys.size() - 1));
					String b = values.get(keys.get(keys.size() - 2));
					
					if (a.compareTo(b) < 0) { // a > b
						willSwitch = true;
					}
				}
				
				if (!willSwitch) {
					System.out.println(values.get(keys.get(keys.size() - 1)));
					System.out.println(values.get(keys.get(keys.size() - 2)));
				} else {
					System.out.println(values.get(keys.get(keys.size() - 1)));
					System.out.println(values.get(keys.get(keys.size() - 2)));
				}
			
			} else {
				
				System.out.println(values.get(keys.get(keys.size() - 1)));
				
			}
			
	}

}
