package org.euler.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Problem42 {
	
	static String[] names;
	static String loadInput = "";

	public static void main(String[] args) {
		
		long startTime = 1;
		
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		
		File k = jfc.getSelectedFile();

		try {
			
			startTime = System.nanoTime();
			
			FileReader fr = new FileReader(k);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			
			while ((line = br.readLine()) != null) {
				loadInput += line;
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		names = loadInput.substring(1, loadInput.length() - 1).split("\",\"");
		
		int counter = 0;
		
		for (int i = 0; i < names.length; i++) {
			counter += (isTriangular(score(names[i]))) ? 1 : 0;
		}
		
		System.out.println(counter);
		
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Completed in " + (double) elapsedTime / 1000 + " microseconds.");
	}
	
	private static int score(String k) {
		char[] z = k.toCharArray();
		
		int score = 0;
		
		for (int i = 0; i < z.length; i++) {
			score += (int) z[i] - 64;
		}
		
		return score;
	}
	
	private static boolean isTriangular(int n) {
		double k = Math.sqrt(8 * n + 1);
		double z = Math.floor(k);
		
		return k == z;
	}

}
