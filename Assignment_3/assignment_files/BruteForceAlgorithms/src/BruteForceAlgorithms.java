import java.awt.Point;

/**
 * 
 */

/**
 * @author masont
 *
 */
public class BruteForceAlgorithms implements BruteForcible {

	@Override
	/**
	 * ALGORITHM SelectionSort(A[0..n-1])
	 * Sorts a given array A by selection sort
	 * Input: An array of A[0..n-1] of orderable elements
	 * Output: Array A[0..n-1] sorted in ascending order
	 * for i = 0 to n-2 do
	 * 	min = i;
	 *  for j=i+1 to n-1 do
	 *  	if A[j] < A[min]    min = j
	 *  swap A[i] and A[min]
	 *
	 * @param A - Array of orderable elements
	 */
	public void selectionSort(int[] A) {
		int min = 0;
		//for i = 0 to n-2 do
		for(int i = 0; i<= A.length-2; i++) {
			 	min = i; //min = i;
			 	//for j=i+1 to n-1 do
			 	for (int j=i+1; j <= A.length-1; j++) {
			 		//if A[j] < A[min]    min = j
			 		if (A[j] < A[min]   ) 
			 				min = j;
			 	}
			 	//swap A[i] and A[min]
			 	int temp = A[i];
			 	A[i] = A[min];
			 	A[min] = temp;
		}
	}

	@Override
	/**
	 * ALGORITHM SequentialSearch(A[0...n-1], K)
	 * Searches for a given value in a given array by sequential search
	 * Input: An array A[0...n-1] and a search key K
	 * Output: The index of the first element of A that matches K
	 * 	or -1 if there are no matching elements
	 */
	public int sequentialSearch(int[] A, int K) {
		// i <- 0
		int i = 0;
		// while i < n and A[i] != K, i++
		while (i < A.length && A[i] != K) {
			i++;
		}

		// if i < n, return i
		if (i < A.length) {
			return i;
		} else { //else return -1 (for failure)
			return -1;
		}
	}

	@Override
	/*
	 * ALGORITHM BruteForceStringMatch(T[0...n-1], P[0...m-1])
	 * Implements brute-force string matching
	 * Input: An array T[0...n-1] of n characters representing a text and 
	 * 	an array P[0...m-1] of m characters representing a pattern
	 * Output: The index of the first character in the text that starts a 
	 * 	matching substring or -1 if the search is unsuccessful
	 */
	public int bruteForceStringMatch(String T, String P) {
		// for i = 0 to n - m, do
		for (int i = 0; i <= T.length()-P.length(); i++) {
			int j = 0;	//set j = 0
			// while j < m AND P[j] = T[i + j], do
			while (j < P.length() && P.charAt(j) == T.charAt(i + j)) {
				j++;	//increment j
			}
			//if j = m, return i
			if (j == P.length()) {
				return i;
			}
		}
		//else return -1 if unsuccessful search
		return -1;
	}

	@Override
	/*
	 * ALGORITHM BruteForceClosestPoints(P)
	 * Input: A list P of n (n >= 2) points P_1 = (x_1,y_1),...., P_n = (x_n,y_n)
	 * Output: Indicies index1 and index2 of the closest pair of points
	 */
	public Point[] bruteForceClosestPoints(Point[] P) {
		// set up index values
		int index1=0, index2=0;
		//dmin = infinity
		double dmin = Double.MAX_VALUE;

		//for i = 1 to n - 1, do
		for (int i = 0; i < P.length - 1; i++) {
			//for j = i + 1 to n do
			for (int j = i + 1; j < P.length; j++){
				//sqrt is the square root function
				double d = Math.sqrt(Math.pow((P[i].getX() - P[j].getX()),2) + Math.pow((P[i].getY() - P[j].getY()), 2));

				//if d < dmin, set dmin = d, index1 = i, and index2 = j
				if (d < dmin) {
					dmin = d;
					index1 = i;
					index2 = j;
				}
			}
		}
		
		//use index1 and index2 to make an array of two points to return
		Point[] closest = new Point[2];
		closest[0] = P[index1];
		closest[1] = P[index2];
		return closest;
	}
	
	public void printArray(int[] data) {
		for(int i=1; i<= data.length; i++) {
			System.out.printf("%,9d" , data[i-1] );
			//System.out.printf(Locale.US, "%,d %n", 10000);
			if(i%20 == 0 && i > 0)
				System.out.println();
		}
	}
}
