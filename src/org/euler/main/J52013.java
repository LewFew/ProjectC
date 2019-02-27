package org.euler.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class J52013 {
	
	static HashMap<String, Boolean> possibleGames = new HashMap<String, Boolean>();
	static ArrayList<Integer> toBeRemoved = new ArrayList<Integer>();
	
	static Scanner s = new Scanner(System.in);
	
	static int scores[] = {0, 0, 0, 0};

	public static void main(String[] args) {
		
		possibleGames.put("1 2", false);
		possibleGames.put("1 3", false);
		possibleGames.put("1 4", false);
		possibleGames.put("2 3", false);
		possibleGames.put("2 4", false);
		possibleGames.put("3 4", false);
		
		int fav = Integer.parseInt(s.nextLine()) - 1;
		int alreadyPlayed = Integer.parseInt(s.nextLine());
		
		for (int i = 0; i < alreadyPlayed; i++) {
			String[] info = s.nextLine().split(" ");
			
			if (possibleGames.containsKey(info[0] + " " + info[1])) {
				
				int a = Integer.parseInt(info[0]);
				int b = Integer.parseInt(info[1]);
				int c = Integer.parseInt(info[2]);
				int d = Integer.parseInt(info[3]);
				
				if (c == d) {
					scores[a - 1]++;
					scores[b - 1]++;
				} else if (c > d) {
					scores[a - 1]+=3;
				} else {
					scores[b - 1]+=3;
				}
				
				possibleGames.remove(info[0] + " " + info[1]);
				
			}
			
		}
		
		//Fun time
		
		int gamesNow = 6 - alreadyPlayed;
		int iterations = (int) Math.pow(3, gamesNow) - 1;
//		System.out.println("3^" + gamesNow + " - 1 = " + iterations);
//		
//		System.out.println(Integer.toString(iterations, 3) + " wassup fam");
//		
//		System.out.println();
//		System.out.println("Current Scores: 1 - " + scores[0] + " 2 - " + scores[1] + " 3 - " + scores[2] + " 4 - " + scores[3]);
		
		int counter = 0;
		
		String[] missing = {"00000", "0000", "000", "00", "0", ""};
		
		for (int i = 0; i <= iterations; i++) {
			int[] newScores = new int[scores.length];
			
			for (int h = 0; h < scores.length; h++) {
				newScores[h] = scores[h];
			}
			
			String[] keySet = new String[possibleGames.keySet().toArray().length];
			
			String a = Integer.toString(i, 3);
			int y = a.length() - 1;
			
			a = missing[y + (6 - gamesNow)] + a;
			//System.out.println(y);
			
			char[] trueOrFalse = a.toCharArray();
			
			
			//System.out.print("Checking configuration: " + a);
			
			for (int k = 0; k < keySet.length; k++) {
				keySet[k] = possibleGames.keySet().toArray()[k].toString();
			}
			
			for (int j = 0; j < keySet.length; j++) {
				if (trueOrFalse[j] == '0') {
					String[] k = keySet[j].split(" ");
					newScores[Integer.parseInt(k[1]) - 1]+=3;
				} else if (trueOrFalse[j] == '1') {
					String[] k = keySet[j].split(" ");
					newScores[Integer.parseInt(k[0]) - 1]+=3;
				} else if (trueOrFalse[j] == '2') {
					String[] k = keySet[j].split(" ");
					newScores[Integer.parseInt(k[1]) - 1]++;
					newScores[Integer.parseInt(k[0]) - 1]++;
				}
			}
			
			boolean willIt = true;
			
			for (int q = 0; q < 4; q++) {
				if (q != fav && newScores[q] >= newScores[fav]) {
					willIt = false;
					break;
				}
			}
			
			if (willIt) {
				counter++;
				//System.out.println(" New Scores: " + newScores[0] + " " + newScores[1] + " " + newScores[2] + " " + newScores[3] + " I WIN!");
			} else {
				//System.out.println(" New Scores: " + newScores[0] + " " + newScores[1] + " " + newScores[2] + " " + newScores[3]);
			}
		}
		
		System.out.println(counter);
		
	}

}
