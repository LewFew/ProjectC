package org.euler.main;

import java.util.HashMap;
import java.util.Scanner;

public class S12016 {

	/*
	 * An anagram of a string is formed by rearranging the letters in the string. For example, the anagrams
	 * of aab are aab, aba, and baa
	 * 
	 * A wildcard anagram of a string is an anagram of the string where some of the letters might have
	 * been replaced with an asterisk (*).  For example, two possible wildcard anagrams of aab are *ab
	 * and *b*.
	 * 
	 * Given two strings, determine whether the second string is a wildcard anagram of the first string.
	 */
	
	static Scanner s;
	static String st1, st2;
	
	static HashMap<Integer, Integer> letterCount1 = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> letterCount2 = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		st1 = s.nextLine();
		st2 = s.nextLine();
		
		char[] st1Char = st1.toCharArray();
		char[] st2Char = st2.toCharArray();
		
		for (int i = 0; i < st1Char.length; i++) {
			if (letterCount1.containsKey((int)st1Char[i])) {
				letterCount1.replace((int)st1Char[i], letterCount1.get((int)st1Char[i]) + 1);
			} else {
				letterCount1.put((int)st1Char[i], 1);
			}
		}
		
		for (int i = 0; i < st2Char.length; i++) {
			if (letterCount2.containsKey((int)st2Char[i])) {
				letterCount2.replace((int)st2Char[i], letterCount2.get((int)st2Char[i]) + 1);
			} else {
				letterCount2.put((int)st2Char[i], 1);
			}
		}
		
		int difference = 0;
		boolean isAnagram = true;
		
		for (int j : letterCount1.keySet()) {
			if (letterCount2.containsKey(j)) {
				if (letterCount1.get(j) - letterCount2.get(j) >= 0) {
					difference += letterCount1.get(j) - letterCount2.get(j);
				} else {
					isAnagram = false;
					break;
				}
			} else {
				difference += letterCount1.get(j);
			}
		}
		
		if (letterCount2.containsKey((int) '*')) {
		
			if (difference != letterCount2.get((int) '*')) {
				isAnagram = false;
			}
		
		}
		
		System.out.println((isAnagram) ? "A" : "N");
	}
	
}
