package org.euler.main;

import java.util.ArrayList;
import java.util.Scanner;

public class J42015 {
	
	private static class Friend {
		
		public int waitTime = 0;
		public int id;
		public int startTime;
		public boolean hasStopped = false;
		
		public Friend(int id, int startTime) {
			this.id = id;
			this.startTime = startTime;
		}
		
	}
	
	static ArrayList<Friend> friends = new ArrayList<Friend>();
	
	static Scanner s = new Scanner(System.in);
	
	public static Friend friendWithID(int id) {
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).id == id) {
				return friends.get(i);
			}
		}
		
		return null;
	}
	
	public static void bubbleSort() {
		for (int i = 0; i < friends.size(); i++) {
			for (int k = 0; k < friends.size() - 1; k++) {
				if (friends.get(k).id > friends.get(k + 1).id) {
					Friend temp = friends.get(k);
					friends.set(k, friends.get(k + 1));
					friends.set(k + 1, temp);
				}
			}
		}
	}

	public static void main(String[] args) {
		int lines = Integer.parseInt(s.nextLine());
		
		int nonWCounter = 0;
		int time = 0;
		
		for (int i = 0; i < lines; i++) {
			String[] input = s.nextLine().split(" ");
			int id = Integer.parseInt(input[1]);
			
			if (input[0].equals("W")) {
				nonWCounter = 0;
				time += id;
			} else if (input[0].equals("R")) {
				nonWCounter++;
				if (nonWCounter == 2) {
					time++;
					nonWCounter = 1;
				}
				Friend q = friendWithID(id);
				
				if (q == null) {
					Friend t = new Friend(id, time);
					friends.add(t);
				} else {
					q.startTime = time;
					q.hasStopped = false;
				}
			} else if (input[0].equals("S")) {
				nonWCounter++;
				if (nonWCounter == 2) {
					time++;
					nonWCounter = 1;
				}
				Friend q = friendWithID(id);
				q.hasStopped = true;
				q.waitTime += time - q.startTime;
			}
		}
		
		bubbleSort();
		
		for (int q = 0; q < friends.size(); q++) {
			Friend y = friends.get(q);
			if (!y.hasStopped) {
				System.out.println(friends.get(q).id + " -1");
			} else {
				System.out.println(friends.get(q).id + " " + y.waitTime);
			}
		}
	}

}
