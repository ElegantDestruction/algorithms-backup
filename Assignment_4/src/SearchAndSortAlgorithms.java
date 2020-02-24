import java.util.ArrayList;


/**
 * @author Jacob Hillebrand
 * hillebrandj3779@my.uwstout.edu
 *
 */

public class SearchAndSortAlgorithms implements SearchableAndSortable {

	//TODO Remove all mention of variable "invalid"
	int invalid = -1;

	@Override
	/**
	 *TODO Fill out information regarding algorithm, implement algorithm
	 * ALGORITHM: sequentialSearch(
	 * INPUT:
	 * OUTPUT:
	 */
	public int sequentialSearch(ArrayList<Integer> A, int K) {
	
		return invalid;
	}

	@Override
	/**
	 * ALGORITHM: Recursive BinarySearch(A[0..n-1], value, low, high)
	 * Searches for value in array A
	 * INPUT: A sorted array A[0..n-1] of n elements.
	 * OUTPUT: Index in array A of key or -1 if not found
	 * Initially called with low = 0, high = n-1
	 */
	public int binarySearchRecursive(ArrayList<Integer> data, int value, int low, int high ) {
		if (high < low) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (data.get(mid) > value) {
			return binarySearchRecursive(data, value, low, mid-1);
		}
		else if (data.get(mid) < value) {
			return binarySearchRecursive(data, value, mid+1, high);
		}
		else {
			return mid;
		}
	}

	@Override
	/**
	 * ALGORITHM: Iterative binarySearchIterative(A[0..n-1], value)
	 * Searches for value in array A
	 * INPUT: A sorted array A[0..n-1] of n elements.
	 * OUTPUT: Index in array A of key or -1 if not found.
	 */
        public int binarySearchIterative(ArrayList<Integer> data, int value) {
		int low = 0;
		int high = data.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (data.get(mid) > value) {
				high = mid - 1;
			}
			else if (data.get(mid) < value) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}

	@Override
	/**
	 *TODO Fill out information regarding algorithm, implement algorithm
	 * ALGORITHM: insertionSort(A[0..n-1])
	 * Sorts a given array by insertion sort
	 * INPUT: An array A[0..n-1] of n orderable elements
	 * OUTPUT: Array A[0..n-1] sorted in nondecreasing order
	 */
        public void insertionSort(ArrayList<Integer> A) {
		for (int i = 1; i < A.size(); i++) {
			int v = A.get(i);
			int j = i -1;
			while (j >= 0 && A.get(j) > v) {
				A.set(j + 1, A.get(j));
				j = j - 1;
			}
			A.set(j + 1, v);
		}
	}

	@Override
	/**
	 *TODO Fill out information regarding algorithm, implement algorithm
	 */
        public void quickSort(ArrayList<Integer> A, int low, int high) {
	
	}

	@Override
	/**
	 *TODO Fill out information regarding algorithm, implement algorithm
	 */
        public int partition(ArrayList<Integer> A, int left, int right) {
		return invalid;
	}

	@Override
	/**
	 * TODO Fill out info regarding the algorithm, ensure algorithm works properly
	 */
	public void printArrayList(ArrayList<Integer> data) {
		for(int i = 0; i < data.size(); i++) {
			System.out.print(data.get(i) + " ");
			if (i % 100 == 0 && i < 0) {
				System.out.println();
			}
		}
	}
	

}
