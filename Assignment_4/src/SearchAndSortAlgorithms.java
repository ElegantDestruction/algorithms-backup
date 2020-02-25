import java.util.ArrayList;


/**
 * @author Jacob Hillebrand
 * hillebrandj3779@my.uwstout.edu
 *
 */

public class SearchAndSortAlgorithms implements SearchableAndSortable {

	@Override
	/*
	 * ALGORITHM: sequentialSearch(A[0..n-1], key)
	 * Searches for a given key in an arraylist
	 * INPUT: Arraylist A[0..n-1] and a search key K
	 * OUTPUT:The index of the first element of A that matches K
	 * 	or -1 if there are no matching elements
	 */
	public int sequentialSearch(ArrayList<Integer> A, int K) {
		// i <- 0
                int i = 0;
                // while i < n and A[i] != K, i++
                while (i < A.size() && A.get(i) != K) {
                        i++;
                }

                // if i < n, return i
                if (i < A.size()) {
                        return i;
                } else { //else return -1 (for failure)
                        return -1;
                }
	}

	@Override
	/*
	 * ALGORITHM: Recursive BinarySearch(A[0..n-1], value, low, high)
	 * Searches for value in array A
	 * INPUT: A sorted arraylist A[0..n-1] of n elements.
	 * OUTPUT: Index in arraylist A of key or -1 if not found
	 * Initially called with low = 0, high = n-1
	 */
	public int binarySearchRecursive(ArrayList<Integer> data, int value, int low, int high ) {
		//Check if high is less than low (exit cond.)
		if (high < low) {
			return -1;
		}

		//Grab the index of the middle of the array
		int mid = (low + high) / 2;

		//If the value in the middle of the arraylist is greater than the search key
		if (data.get(mid) > value) {
			//Only search the first half of the array
			return binarySearchRecursive(data, value, low, mid-1);
		}

		//If the value in the middle of the arraylist is less than the search key
		else if (data.get(mid) < value) {
			//Only search the second half of the arraylist
			return binarySearchRecursive(data, value, mid+1, high);
		}
		//Else, the value in the middle of the arraylist must match the search value
		else {
			//Return it
			return mid;
		}
	}

	@Override
	/*
	 * ALGORITHM: Iterative binarySearchIterative(A[0..n-1], value)
	 * Searches for value in array A
	 * INPUT: A sorted arraylist A[0..n-1] of n elements.
	 * OUTPUT: Index in arraylist A of key or -1 if not found.
	 */
        public int binarySearchIterative(ArrayList<Integer> data, int value) {
		//Set low -> front of arraylist, high -> top of arraylist
		int low = 0;
		int high = data.size() - 1;

		//While low <= high
		while (low <= high) {
			//Set mid -> center of arraylist
			int mid = (low + high) / 2;

			//If value in middle of list > search value, set high to mid-1 and re-run
			if (data.get(mid) > value) {
				high = mid - 1;
			}
			//If value in middle of list < search value, set low to mid+1 and re-run
			else if (data.get(mid) < value) {
				low = mid + 1;
			}
			//Else, value in middle of list = search value, so return it
			else {
				return mid;
			}
		}

		//If value was not found, return -1
		return -1;
	}

	@Override
	/*
	 * ALGORITHM: insertionSort(A[0..n-1])
	 * Sorts a given arraylist by insertion sort
	 * INPUT: An arraylist A[0..n-1] of n orderable elements
	 * OUTPUT: Arraylist A[0..n-1] sorted in nondecreasing order
	 */
        public void insertionSort(ArrayList<Integer> A) {
		//Run through every element in the list
		for (int i = 1; i < A.size(); i++) {
			//Set v to the current element, and j to the previous index
			int v = A.get(i);
			int j = i - 1;
			//While j >= 0 and A[j] > v
			while (j >= 0 && A.get(j) > v) {
				//Set A[j+1] = A[j]
				A.set(j + 1, A.get(j));
				//Set j--
				j = j - 1;
			}
			//Set A[j+1] = v
			A.set(j + 1, v);
		}
	}

	@Override
	/*
	 * ALGORITHM quickSort(A[0..n-1], low, high)
	 * Sorts a given arraylist via quicksort algorithm
	 * INPUT: Arraylist A[0..n-1], low starting value, high ending value
	 * OUTPUT: Arraylist A[0..n-1] sorted in nondecreasing order
	 */
        public void quickSort(ArrayList<Integer> A, int low, int high) {
		if (low < high) {
			//Partition the arraylist with partition() function
			int part_index = partition(A, low, high);

			//Sort the two partions of the list individually
			quickSort(A, low, part_index - 1);
			quickSort(A, part_index + 1, high);
		}
	}

	@Override
	/*
	 * ALGORITHM: partition(A[0..n-1], left, right)
	 * Partitions a subarray by using its first element as a pivot
	 * INPUT: A subarray A[l..r] of A[0..n-1], defined by its left and right
	 * 	indicies l and r (l < r)
	 * OUTPUT: A partition of A[l..r], with the split position returned as this 
	 * 	function's value
	 */
        public int partition(ArrayList<Integer> A, int left, int right) {

		//Assign pivot -> first array value
		//Assign low -> first array index
		//Assign high -> rightmost index + 1
		int pivot = A.get(left);
		int low = left;
		int high = right + 1;

		//Repeat until low >= high
		do {
			//Repeat until A[low] >= pivot
			while (A.get(low) < pivot && low < right) {
				//Increment low
				low++;
				//TODO Remove
				System.out.println("low: " + low);
			}
			
			//Repeat until A[high] <= pivot
			while (A.get(high) > pivot && high > left) {
				//Decrement high
				high--;
				//TODO Remove
				System.out.println("high: " + high);
			}

			//Swap the values at low and high
			swap(A, low, high);
		} while (low < high);

		//Undo the last swap, and swap the pivot with the
		//first element in the list
		swap(A, low, high);
		swap(A, left, high);
		return high;
	}

	@Override
	/*
	 * ALGORITHM: printArrayList(A[0..n-1])
	 * Prints out the passed-in arraylist to console
	 * INPUT: An arraylist A[0..n-1]
	 * OUTPUT: Arraylist is printed out to java console
	 */
	public void printArrayList(ArrayList<Integer> data) {
		//Loop through every element in the list
		for(int i = 0; i < data.size(); i++) {
			//Print out the current element to java console
			System.out.print(data.get(i) + " ");
			//If the index is > 0 and the value is a multiple of 100, print a new line
			if (i % 100 == 0 && i > 0) {
				System.out.println();
			}
		}
	}

	/*
	 * ALGORITHM: swap(A[0..n-1], val_1, val_2)
	 * Performs swap on two elements of an arraylist
	 * INPUT: Arraylist A[0..n-1], index of first value to swap,
	 * 	index of second value to swap
	 * OUTPUT: Indexes given will be swapped in given arraylist
	 */
	public void swap(ArrayList<Integer> data, int val_1, int val_2) {
		//Create temp variable of value 1
		int temp = data.get(val_1);
		//Set value 2 to the sum of the 2
		data.set(val_2, data.get(val_2) + temp);
		//Set value 1 to the difference between temp and value 2
		data.set(val_1, data.get(val_2) - temp);
		//Set value 2 to be temp
		data.set(val_2, temp);
	}
	

}
