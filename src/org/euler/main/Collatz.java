package org.euler.main;

import java.util.HashMap;
import java.util.Scanner;

public class Collatz {
	
	HashMap<Long, Integer>paths = new HashMap<Long, Integer>();
	
	public Collatz() {

		Scanner s = new Scanner(System.in);
		
		int value = Integer.parseInt(s.nextLine());
		
		paths.put((long) 1, 1);
		
		
		/*for (int i = 1; i <= 1000000; i++) {
			//System.out.println(i);
			int length = findLen(i);
			if (length > largest) {
				//System.out.println(length + " das " + i);
				largest = length;
				identity = i;
			}
		}
		
		System.out.println(identity + ": " + largest);*/
		
		System.out.println("it's: " + findLen(value));
		
		s.close();
	}
	
	public int findLen(long x) {
		//System.out.println(x);
		if (paths.containsKey(x)){
			//System.out.println("// Reached branch " + x + " with length " + paths.get(x));
			return paths.get(x);
		} else {
			if (x % 2 == 0) {
				int q = findLen(x/2) + 1;
				System.out.print(x + "<-");
				paths.put(x, q);
				return q;
			} else {
				//System.out.println(x + " is odd");
				int q = findLen(((x * 3) + 1)/2) + 2;
				System.out.print(x + "<-");
				paths.put(x, q);
				return q;
			}
		}
	}

	public static void main(String[] args) {
		new Collatz();
	}

}
