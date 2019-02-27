package org.euler.main;

public class Problem17 {
	
	/*
		If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
		If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

		NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
	 */
	
	private static int subLengths[][] = {
			{0, 3, 3, 5, 4, 4, 3, 5, 5, 4},
			{0, 4, 6, 6, 5, 5, 5, 7, 6, 6},
			{0, 13, 13, 15, 14, 14, 13, 15, 15, 14},
			{0, 11}
	};

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += numberLength(i);
		}
		System.out.println(sum);
		//System.out.println(numberLength(1000));
	}
	
	private static int numberLength(int x) {
		String stringNum = String.valueOf(x);
		int value = 0;
		
		for (int i = 0; i < stringNum.length(); i++) {
			int index = stringNum.length() - i - 1;
			int digit = Character.getNumericValue(stringNum.charAt(index));
			
			value += subLengths[i][digit];
		}
		
		if (stringNum.length() >= 2) {
			if (stringNum.substring(stringNum.length() - 2).equals("13")
					|| stringNum.substring(stringNum.length() - 2).equals("15")
					|| stringNum.substring(stringNum.length() - 2).equals("11")
					|| stringNum.substring(stringNum.length() - 2).equals("12")
					|| stringNum.substring(stringNum.length() - 2).equals("18")
					|| stringNum.substring(stringNum.length() - 2).equals("10")) {
				value--;
			}
			
			if (stringNum.length() >= 3 && !stringNum.equals("1000")) {
				if ((stringNum.charAt(stringNum.length() - 1) == '0'
						&& stringNum.charAt(stringNum.length() - 2) == '0')) {
					value -= 3;
				}
			}
		}
		
		return value;
	}

}
