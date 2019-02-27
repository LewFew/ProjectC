package org.euler.main;

public class S32018 {
	
	public static class State {
		char[] board;
		int distance;
		int[] startPos = new int[2];
		boolean[] moves = new boolean[4]; // up, right, down, left
		
		public State(String[] board, int distance, int[] startPos) {
			
		}
	}
	
	public static class Feedback {
		char[] board;
		int[] startPos = new int[2];
		
		public Feedback(char[] board, int[] startPos) {
			this.board = board;
			this.startPos = startPos;
		}
	}

	public static void main(String[] args) {

	}

}
