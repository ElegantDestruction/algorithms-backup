import java.util.ArrayList;

/**
 * @author Jacob Hillebrand
 * hillebrandj3779@my.uwstout.edu
 *
 */

public class Heap implements Heapable {

	//Overarching list structure
	private ArrayList<Integer> list;

	/*
	 * CONSTRUCTOR: Heap();
	 * Creates a new list instance
	 */
	public Heap() {
		this.list = new ArrayList<Integer>();
	}



	/*
	 * ALGORITHM: enqueue(entry)
	 * INPUT: int entry - the value meant to be added to the heap
	 * OUTPUT: list will reflect that entry was added
	 */
	@Override
	public void enqueue(int entry) {
		//Pus entry onto back of list
		list.add(entry);
		//Call reheapifyUp with index of entry
		reheapifyUp(this.list.size() - 1);	
	}

	/*
	 * ALGORITHM: dequeue()
	 * INPUT: none
	 * OUTPUT: Maximum value of the heap is returned in an int
	 */
	@Override 
	public int dequeue() {
		//Store root element in a temp variable
		int root = this.list.get(0);
		//Copy last element into root position
		this.list.set(0, this.list.get(this.list.size() -1));
		//Remove last item in list
		this.list.remove(this.list.size() -1);
		//Reheapify down to refresh heap properties
		reheapifyDown(0);
		//Return the original root element
		return root;
	}

	
	/*
	 * ALGORITHM: size()
	 * Returns size of list
	 * INPUT: none
	 * OUTPUT: Returns size of list
	 */
	@Override
	public int size() {
		return this.list.size();
	}

	/*
	 * ALGORITHM: heapSort(data[0...n-1])
	 * Performs a heap sort on the given arraylist
	 * INPUT: data[0...n-1] in a heap to be sorted
	 * OUTPUT: sorted arraylist data[0...n-1]
	 */
	@Override
	public void  heapSort(ArrayList<Integer> data) {
		//Assign list to data input
		this.list = data;

		//Convert list to heap structure
		for (int x = this.list.size() - 1; x >= 0; x--) {
			//Perform reheapification upwards
			reheapifyUp(x);
		}

		//Grab current size
		int unsorted = this.list.size();

		while (unsorted > 1) {
			swap(this.list, 0, unsorted - 1);
			//Maintain the heap
			partialReheapifyDown(0, unsorted - 1);
			unsorted--;
		}
	}

	/* 
	 * ALGORITHM: reheapifyUp(currentSpot);
	 * INPUT: currentSpot - the index in the list to be reheapified
	 * OUTPUT: The list will have its heap properties restored after an addition
	 */
	private void reheapifyUp(int currentSpot) {
		//Find index of parent node of currentSpot
		int parentNode = (currentSpot - 1)/2;
		//While element is not root and greater than the parent element
		while (currentSpot > 0 && this.list.get(currentSpot) > this.list.get(parentNode)) {
			//Swap currentSpot and parentNode, then move everything up a generation
			swap(this.list, currentSpot, parentNode);
			currentSpot = parentNode;
			parentNode = (currentSpot - 1)/2;
		}
	}

	/*
	 * ALGORITHM: reheapifyDown(currentSpot)
	 * INPUT: int currentSpot - index in the list to begin reheapification
	 * OUTPUT: The list will have all heap properties restored after a removal
	 */
	private void reheapifyDown(int currentSpot) {
		//Declare child indicies
		int leftChild = currentSpot * 2 + 1;
		int rightChild = currentSpot * 2 + 2;
		//While not at a leaf node
		while (leftChild < this.list.size()) {
			//Find the largest of the two children
			int largest;
			if (rightChild < this.list.size() && this.list.get(leftChild) < this.list.get(rightChild)) {
				largest = rightChild;
			}
			else {
				largest = leftChild;
			}

			//If list at the currentSpot is greater than or equal to the largest child node, break
			if (this.list.get(currentSpot) >= this.list.get(largest)) {
				return;
			}

			//Else, swap currentSpot and largest child elements
			swap(this.list, currentSpot, largest);

			//Reset currentSpot and children indicies for another iteration
			currentSpot = largest;
			leftChild = currentSpot * 2 + 1;
			rightChild = currentSpot * 2 + 2;
		}

	}

	/*
	 * ALGORITHM: partialReheapifyDown(currentSpot, stop)
	 * Same functionality as reheapifyDown, but stops at given stoppoint,
	 * not end of list
	 * INPUT: currentSpot - current node, stop - stopping point for algorithm
	 * OUTPUT: Heap Properties are restored from 0 to stop-1. From stop to size, data is sorted
	 */
	private void partialReheapifyDown(int currentSpot, int stop) {
		//Declare child indicies
		int leftChild = currentSpot * 2 + 1;
		int rightChild = currentSpot * 2 + 2;
		//While not at a leaf node
		while (leftChild < stop) {
			//Find the largest of the two children
			int largest;
			if (rightChild < stop && this.list.get(leftChild) < this.list.get(rightChild)) {
				largest = rightChild;
			}
			else {
				largest = leftChild;
			}

			//If list at the currentSpot is greater than or equal to the largest child node, break
			if (this.list.get(currentSpot) >= this.list.get(largest)) {
				return;
			}

			//Else, swap currentSpot and largest child elements
			swap(this.list, currentSpot, largest);

			//Reset currentSpot and children indicies for another iteration
			currentSpot = largest;
			leftChild = currentSpot * 2 + 1;
			rightChild = currentSpot * 2 + 2;
		}
	}
	
	/*
         * ALGORITHM: swap(A[0..n-1], val_1, val_2)
         * Performs swap on two elements of an arraylist
         * INPUT: Arraylist A[0..n-1], index of first value to swap,
         *      index of second value to swap
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

	/*
         * ALGORITHM: printArrayList(A[0..n-1])
         * Prints out the passed-in arraylist to console
         * INPUT: An arraylist A[0..n-1]
         * OUTPUT: Arraylist is printed out to java console
         */
        public void printArrayList() {
                //Loop through every element in the list
                for(int i = 0; i < this.list.size(); i++) {
                        //Print out the current element to java console
                        System.out.print(this.list.get(i) + " ");
                        //If the index is > 0 and the value is a multiple of 100, print a new line
                        if (i % 40 == 0 && i > 0) {
                                System.out.println();
                        }
                }
                System.out.println("\n");
        }



}
