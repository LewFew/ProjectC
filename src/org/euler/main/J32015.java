package org.euler.main;

import java.util.Scanner;

public class J32015 {
	
	static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
						'h', 'i', 'j', 'k', 'l', 'm', 'n',
						'o', 'p', 'q', 'r', 's', 't', 'u',
						'v', 'w', 'x', 'y', 'z'};
	
	static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	static int[] vowelIndex = {0, 4, 8, 14, 20};
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(game(s.nextLine()));
	}
	
	public static int closestVowel(int index) {
		
		int smallest = 0;
		
		for (int i = 1; i < 5; i++) {
			int k = Math.abs(index - vowelIndex[i]);
			if (k < (Math.abs(index - vowelIndex[smallest]))) {
				smallest = i;
			}
		}
		
		return vowelIndex[smallest];
	}
	
	public static String game(String input) {
		
		char[] inputArr = input.toCharArray();
		
		String output = "";
		
		for (int i = 0; i < inputArr.length; i++) {
			output = output + inputArr[i];
			if (isConsonant(getIndex(inputArr[i]))) {
				output = output + alphabet[closestVowel(getIndex(inputArr[i]))];
				output = output + alphabet[nextConsonant(getIndex(inputArr[i]))];
			}
		}
		
		return output;
	}
	
	public static int getIndex(char a) {
		return ((int) a) - 97;
	}
	
	public static int nextConsonant(int index) {
		
		if (index == 25) {
			return 25;
		} else {
			for (int i = index + 1; i < 26; i++) {
				if (isConsonant(i))
					return i;
			}
		}
		
		return 0;
	}
	
	public static boolean isConsonant(int index) {
		return !(alphabet[index] == 'a' || alphabet[index] == 'e' ||
				alphabet[index] == 'i' || alphabet[index] == 'o' ||
				alphabet[index] == 'u');
	}

}
