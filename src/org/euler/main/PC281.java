package org.euler.main;

import java.util.Scanner;

public class PC281 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] inp = s.nextLine().split(" ");
		int count = 0;
		
		boolean[] k = new boolean[inp.length - 1];

		for (int i = 0; i < k.length; i++) {
			int q = Math.abs(Integer.parseInt(inp[i]) - Integer.parseInt(inp[i + 1]));
			if (q <= k.length) {
				count++;
				if (k[q - 1] != true)
					k[q - 1] = true;
			}
		}
		
		if (count == inp.length - 1) {
			System.out.println("Jolly");
		} else {
			System.out.println("Not Jolly");
		}
		
		s.close();
	}

}
