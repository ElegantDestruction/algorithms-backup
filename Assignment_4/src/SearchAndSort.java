import java.util.ArrayList;


/**
 * @author Jacob Hillebrand
 * hillebrandj3779@my.uwstout.edu
 *
 */

public class SearchAndSort implements SearchableAndSortable {

	//TODO Remove all mention of variable "invalid"
	int invalid = -1;

	@Override
	/**
	 *TODO Fill out information regarding algorithm, implement algorithm
	 */
	public int sequentialSearch(ArrayList<Integer> A, int K) {
	
		return invalid;
	}

	@Override
	/**
	 *TODO Fill out information regarding algorithm, implement algorithm
	 */
	public int binarySearchRecursive(ArrayList<Integer> data, int value, int low, int high ) {

		return invalid;
	}

	@Override
	/**
	 *TODO Fill out information regarding algorithm, implement algorithm
	 */
        public int binarySearchIterative(ArrayList<Integer> data, int value) {
		return invalid;
	}

	@Override
	/**
	 *TODO Fill out information regarding algorithm, implement algorithm
	 */
        public void insertionSort(ArrayList<Integer> A) {

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
