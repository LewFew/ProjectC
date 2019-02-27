package org.euler.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFileChooser;

public class Problem59 {
	
	static int[] encrypted;
	static int[] key = new int[3];
	
	public static int[] decrypt(int[] key, int arr[]) {
	
		int[] temp = Arrays.copyOf(arr, arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			temp[i] = temp[i] ^ key[i % 3];
		}
		
		return temp;
	}
	
	public static void printMessage(int[] ascii) {
		for (int i = 0; i < ascii.length; i++) {
			System.out.print((char)ascii[i]);
		}
		System.out.println("");
	}
	
	public static boolean search(int[] arr) {
		int counter = 0;
		
		int[] word = { (char) 't', (char) 'h', (char) 'e', (char) ' '};

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == word[counter]) {
				counter++;
			} else {
				counter = 0;
			}
			if (counter == word.length) {
				System.out.println("Found it. The key is " + (char)key[0] + " " + (char)key[1] + " " + (char)key[2] + " and the msg is: ");
				printMessage(arr);
				
				int sum = 0;
				
				for (int j = 0; j < arr.length; j++) {
					sum += arr[j];
				}
				
				System.out.println("The sum of the ascii values is " + sum);
				
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		File cipher;
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		cipher = jfc.getSelectedFile();
		
		try {
			FileReader reader = new FileReader(cipher);
			BufferedReader br = new BufferedReader(reader);
			
			String[] e1 = null;
			
			String line;
			if ((line = br.readLine()) != null) {
				e1 = line.split(",");
			}
			
			encrypted = new int[e1.length];
			
			for (int i = 0; i < e1.length; i++) {
				encrypted[i] = Integer.parseInt(e1[i]);
			}
			
			outerloop:
			for (int a = 0; a < 26; a++) {
				for (int b = 0; b < 26; b++) {
					for (int c = 0; c < 26; c++) {
						key[0] = a + 97;
						key[1] = b + 97;
						key[2] = c + 97;
						if (search(decrypt(key, encrypted))) {
							break outerloop;
						}
					}
				}
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
