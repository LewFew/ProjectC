package org.euler.main;


public class Problem20 {

	public static void main(String[] args) {
		String k = new String("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000");
		
		char[] q = k.toCharArray();
		
		int sum = 0;
		
		for (int i = 0; i < q.length; i++) {
			sum += Integer.parseInt(String.valueOf(q[i]));
		}
		
		System.out.println(sum);

	}

}
