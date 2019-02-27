package org.euler.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFileChooser;

public class Problem22 {

	static ArrayList<String> names = new ArrayList<String>();
	
	public static class Alphabetical implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
		
	}
	
	public static int nameScore(String name, int index) {
		int sum = 0;
		char[] k = name.toCharArray();
		
		for (int i = 0; i < k.length; i++) {
			sum += ((int) k[i]) - 64;
		}
		
		return sum * (index + 1);
	}
	
	public static void main(String[] args) {
		
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		
		File k = jfc.getSelectedFile();
		
		FileReader fr;
		
		try {
			
			fr = new FileReader(k);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			
			String massNames = "";

			while ((line = br.readLine()) != null) {
				massNames = massNames + line;
			}
			
			String[] protoNames = massNames.substring(1, massNames.length() - 1).split("\",\"");
			
			names = new ArrayList<String>(Arrays.asList(protoNames));
			
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(names, new Alphabetical());
		
		int sum = 0;
		
		for (int i = 0; i < names.size(); i++) {
			sum += nameScore(names.get(i), i);
		}
		
		System.out.println(sum);
	}

}
