package org.euler.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Problem18 {
	
	static Scanner s = new Scanner(System.in);
	static JFileChooser jfc = new JFileChooser();
	static File file;
	
	static int triangle[][];
	static int triangleFlipped[][];
	
	static ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		
		int rows = Integer.parseInt(s.nextLine());
		triangle = new int[rows][];
		triangleFlipped = new int[rows][];
		
		jfc.showOpenDialog(null);
		file = jfc.getSelectedFile();
		
		FileReader fr;
		
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			String[] numbersString;
			int[] numbers;
			int counter = 0;
			
			while ((line = br.readLine()) != null) {
				
				if (counter >= rows) {
					break;
				}
				
				numbersString = line.split(" ");
				numbers = new int[numbersString.length];
				
				for (int i = 0; i < numbersString.length; i++) {
					numbers[i] = Integer.parseInt(numbersString[i]);
				}
				
				triangle[counter] = new int[counter + 1];
				
				for (int i = 0; i < triangle[counter].length; i++) {
					triangle[counter][i] = numbers[i];
				}
				
				counter++;
			}
			
			br.close();
			
			for (int q = 0; q < rows; q++) {
				triangleFlipped[q] = triangle[rows - q - 1];
			}
			
			System.out.println("Done Loading.");
			
			/*for (int j = 0; j < triangleFlipped.length; j++) {
				for (int k = 0; k < triangleFlipped[j].length; k++) {
					System.out.print(triangleFlipped[j][k] + " ");
				}
				System.out.print("\n");
			}*/
			
			System.out.println(largestPath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int largestPath() {
		
		for (int i = 0; i < triangleFlipped.length; i++) {
			for (int j = 0; j < triangleFlipped[i].length - 1; j++) {
				if (triangleFlipped[i][j] > triangleFlipped[i][j + 1]) {
					triangleFlipped[i + 1][j] += triangleFlipped[i][j];
				} else {
					triangleFlipped[i + 1][j] += triangleFlipped[i][j + 1];
				}
			}
		}
		
		return triangleFlipped[triangleFlipped.length - 1][0];
	}

}
