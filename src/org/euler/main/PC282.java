package org.euler.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFileChooser;

public class PC282 {
	
	/*
	 * Solution is annoying. Problem is most likely meant to challenge
	 * implementation ability. Same as Problem 54 (Project Euler)
	 */
	
	public static int cardValue(String card) {
		switch (card) {
			case "T":
				return 10;
			case "J":
				return 11;
			case "Q":
				return 12;
			case "K":
				return 13;
			case "A":
				return 14;
			default:
				return Integer.parseInt(card);
		}
	}
	
	public static void reverseArray(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}
	
	public static boolean evaluate(String cards) {
		
		String[] p = cards.split(" ");
		
		int[] p1 = { cardValue(p[0].substring(0, 1)), cardValue(p[1].substring(0, 1)),
					 cardValue(p[2].substring(0, 1)), cardValue(p[3].substring(0, 1)),
					 cardValue(p[4].substring(0, 1)) };
		
		int[] p2 = { cardValue(p[5].substring(0, 1)), cardValue(p[6].substring(0, 1)),
					 cardValue(p[7].substring(0, 1)), cardValue(p[8].substring(0, 1)),
					 cardValue(p[9].substring(0, 1)) };
		
		boolean p1Flush = p[0].substring(1, 2).equals(p[1].substring(1, 2))
				&& p[1].substring(1, 2).equals(p[2].substring(1, 2))
				&& p[2].substring(1, 2).equals(p[3].substring(1, 2))
				&& p[3].substring(1, 2).equals(p[4].substring(1, 2));
		
		boolean p2Flush = p[5].substring(1, 2).equals(p[6].substring(1, 2))
				&& p[6].substring(1, 2).equals(p[7].substring(1, 2))
				&& p[7].substring(1, 2).equals(p[8].substring(1, 2))
				&& p[8].substring(1, 2).equals(p[9].substring(1, 2));
		
		//System.out.println(p[5].substring(1, 2) + " " + p[6].substring(1, 2) + " " + p[7].substring(1, 2) + " " + p[8].substring(1, 2));
		
		boolean p1Straight = false;
		
		boolean p2Straight = false;
		
		int p1D1 = -1;
		int p1D2 = -1;
		
		int p1T = -1;
		int p1Q = -1;
		
		int p2D1 = -1;
		int p2D2 = -1;
		
		int p2T = -1;
		int p2Q = -1;
		
		Arrays.sort(p1);
		Arrays.sort(p2);
		
		int c = 1;
		int k = 1;
		
		for (int i = 1; i < p1.length; i++) {
			if (p1[i] - p1[i - 1] == 1) {
				k++;
			} else if (p1[i] == p1[i - 1]) {
				c++;
			}
			if (p1[i] != p1[i - 1] || i == p1.length - 1){
				if (c == 2) {
					if (p1D1 == -1) {
						p1D1 = p1[i - 1];
					} else {
						p1D2 = p1[i - 1];
					}
				} else if (c == 3) {
					p1T = p1[i - 1];
				} else if (c == 4) {
					p1Q = p1[i - 1];
				}
				c = 1;
			}
		}
		
		if (k == p1.length) {
			p1Straight = true;
		}
		
		c = 1;
		k = 1;
		
		for (int i = 1; i < p2.length; i++) {
			if (p2[i] - p2[i - 1] == 1) {
				k++;
			} else if (p2[i] == p2[i - 1]) {
				c++;
			}
			if (p2[i] != p2[i - 1] || i == p2.length - 1){
				if (c == 2) {
					if (p2D1 == -1) {
						p2D1 = p2[i - 1];
					} else {
						p2D2 = p2[i - 1];
					}
				} else if (c == 3) {
					p2T = p2[i - 1];
				} else if (c == 4) {
					p2Q = p2[i - 1];
				}
				c = 1;
			}
		}
		
		if (k == p2.length) {
			p2Straight = true;
		}
		
		int p1GrossScore, p2GrossScore;
		
		if (p1Flush && p1Straight && p1[0] == 11) {
			p1GrossScore = 10;
		} else if (p1Flush && p1Straight) {
			p1GrossScore = 9;
		} else if (p1Q != -1) {
			p1GrossScore = 8;
		} else if (p1D1 != -1 && p1T != -1) {
			p1GrossScore = 7;
		} else if (!p1Straight && p1Flush) {
			p1GrossScore = 6;
		} else if (p1Straight && !p1Flush) {
			p1GrossScore = 5;
		} else if (p1T != -1 && p1D1 == -1) {
			p1GrossScore = 4;
		} else if (p1D1 != -1 && p1D2 != -1) {
			p1GrossScore = 3;
		} else if (p1D1 != -1 && p1D2 == -1) {
			p1GrossScore = 2;
		} else {
			p1GrossScore = 1;
		}
		
		if (p2Flush && p2Straight && p1[0] == 11) {
			p2GrossScore = 10;
		} else if (p2Flush && p2Straight) {
			p2GrossScore = 9;
		} else if (p2Q != -1) {
			p2GrossScore = 8;
		} else if (p2D1 != -1 && p2T != -1) {
			p2GrossScore = 7;
		} else if (!p2Straight && p2Flush) {
			p2GrossScore = 6;
		} else if (p2Straight && !p2Flush) {
			p2GrossScore = 5;
		} else if (p2T != -1 && p2D1 == -1) {
			p2GrossScore = 4;
		} else if (p2D1 != -1 && p2D2 != -1) {
			p2GrossScore = 3;
		} else if (p2D1 != -1 && p2D2 == -1) {
			p2GrossScore = 2;
		} else {
			p2GrossScore = 1;
		}
		
	//	System.out.println(p1GrossScore + " " + p2GrossScore);
		
		if (p1GrossScore > p2GrossScore) {
			return true;
		} else if (p2GrossScore > p1GrossScore) {
			return false;
		} else {
			switch (p1GrossScore) {
				case 1:
					if (p1[4] > p2[4]) {
						return true;
					} else if (p1[4] < p2[4]) {
						return false;
					} else if (p1[3] > p2[3]) {
						return true;
					} else if (p1[3] < p2[3]) {
						return false;
					} else if (p1[2] > p2[2]) {
						return true;
					} else if (p1[2] < p2[2]) {
						return false;
					} else if (p1[1] > p1[1]) {
						return true;
					} else if (p1[1] < p1[1]) {
						return false;
					} else if (p1[0] > p1[0]) {
						return true;
					} else if (p1[0] < p1[0]) {
						return false;
					}
				case 2:
				//	System.out.println(p1D1 + " " + p2D1 + " DSADSADSA");
					if (p1D1 > p2D1) {
						return true;
					} else if (p1D1 < p2D1) {
						return false;
					} else {
						if (p1[4] > p2[4]) {
							return true;
						} else if (p1[4] < p2[4]) {
							return false;
						} else if (p1[3] > p2[3]) {
							return true;
						} else if (p1[3] < p2[3]) {
							return false;
						} else if (p1[2] > p2[2]) {
							return true;
						} else if (p1[2] < p2[2]) {
							return false;
						} else if (p1[1] > p1[1]) {
							return true;
						} else if (p1[1] < p1[1]) {
							return false;
						} else if (p1[0] > p1[0]) {
							return true;
						} else if (p1[0] < p1[0]) {
							return false;
						}
					}
				case 3:
					if ((p1D1 > p2D1 && p1D1 > p2D2) || (p1D2 > p2D1 && p1D2 > p2D2)) {
						return true;
					} else if ((p2D1 > p1D1 && p2D1 > p1D2) || (p2D2 > p1D1 && p2D2 > p1D2)) {
						return false;
					} else {
						if (p1[4] > p2[4]) {
							return true;
						} else if (p1[4] < p2[4]) {
							return false;
						} else if (p1[3] > p2[3]) {
							return true;
						} else if (p1[3] < p2[3]) {
							return false;
						} else if (p1[2] > p2[2]) {
							return true;
						} else if (p1[2] < p2[2]) {
							return false;
						} else if (p1[1] > p1[1]) {
							return true;
						} else if (p1[1] < p1[1]) {
							return false;
						} else if (p1[0] > p1[0]) {
							return true;
						} else if (p1[0] < p1[0]) {
							return false;
						}
					}
				case 4:
					if (p1T > p2T) {
						return true;
					} else if (p1T < p2T) {
						return false;
					} else {
						if (p1[4] > p2[4]) {
							return true;
						} else if (p1[4] < p2[4]) {
							return false;
						} else if (p1[3] > p2[3]) {
							return true;
						} else if (p1[3] < p2[3]) {
							return false;
						} else if (p1[2] > p2[2]) {
							return true;
						} else if (p1[2] < p2[2]) {
							return false;
						} else if (p1[1] > p1[1]) {
							return true;
						} else if (p1[1] < p1[1]) {
							return false;
						} else if (p1[0] > p1[0]) {
							return true;
						} else if (p1[0] < p1[0]) {
							return false;
						}
					}
				case 5:
					if (p1[0] > p2[0]) {
						return true;
					} else if (p1[0] < p2[0]) {
						return false;
					}
				case 6:
					if (p1[4] > p2[4]) {
						return true;
					} else if (p1[4] < p2[4]) {
						return false;
					} else if (p1[3] > p2[3]) {
						return true;
					} else if (p1[3] < p2[3]) {
						return false;
					} else if (p1[2] > p2[2]) {
						return true;
					} else if (p1[2] < p2[2]) {
						return false;
					} else if (p1[1] > p1[1]) {
						return true;
					} else if (p1[1] < p1[1]) {
						return false;
					} else if (p1[0] > p1[0]) {
						return true;
					} else if (p1[0] < p1[0]) {
						return false;
					}
				case 7:
					if (p1T > p2T) {
						return true;
					} else if (p1T < p2T) {
						return false;
					} else if (p1D1 > p2D1) {
						return true;
					} else if (p1D1 < p2D1) {
						return false;
					}
				case 8:
					if (p1Q > p2Q) {
						return true;
					} else if (p1Q < p2Q) {
						return false;
					}
				case 9:
					if (p1[0] > p2[0]) {
						return true;
					} else if (p1[0] < p2[0]) {
						return false;
					}
			}
		}
	
		return false;
	}
	
	public static void escape() {
		
		System.out.println(evaluate("5C KH 5S AD 6C JC 9H QC 9C TD"));
		
		System.exit(0);
	}

	public static void main(String[] args) {
		
		long lastTime = -1;
		
		int count = 0;
		
	//	escape();
		
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		
		File text = jfc.getSelectedFile();
		
		try {
			FileReader fr = new FileReader(text);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			
			lastTime = System.nanoTime();
			
			while ((line = br.readLine()) != null) {
				boolean k = evaluate(line);
			//	System.out.println(line + " and " + ((k) ? "player 1 won" : "player 2 won"));
				count += (k) ? 1 : 0;
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long deltaTime = System.nanoTime() - lastTime;
		
		System.out.println(count);
		System.out.println((lastTime > 0) ? ("Computed in " + (deltaTime / 1000000) + " milleseconds.") : "Error.");
	}

}
