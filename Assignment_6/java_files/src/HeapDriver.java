import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * @author hillebrandj3779@my.uwstout.edu
 */

public class HeapDriver {
	
	public static void main(String[] args) {
	
		//Test variables
		ArrayList<Integer> manual_input = new ArrayList<Integer>();
		ArrayList<Integer> copy_input = new ArrayList<Integer>();
		ArrayList<Integer> output_array = new ArrayList<Integer>();
		int n = 1000;
		Random random = new Random();
		Heap test_heap_1 = new Heap();
		Heap test_heap_2 = new Heap();

		//Fill up the arrays with random values
		for (int i = 0; i < n; i++) {
			int value = random.nextInt(n * 10);
			manual_input.add(value);
			copy_input.add(value);
		}

		//Fill up the test_heap_1 with the values
		for (int x : manual_input) {
			test_heap_1.enqueue(x);
		}

		//Copy values to test_heap_2
		test_heap_2.heapSort(copy_input);

		//Dequeue test_heap_1 into output list
		while (test_heap_1.size() > 0) {
			output_array.add(test_heap_1.dequeue());
		}

		//Print out the output array
		System.out.println("List 1 dequeued (descending order)");
		for (int y = 0; y < output_array.size(); y++) {
			System.out.print(output_array.get(y) + " ");
			if (y % 100 == 0 && y != 0) {
				System.out.println();
			}
		}
			
		//Space it out a bit
		System.out.println("\n");

		//Print out test_heap_2
		System.out.println("After heapSort action, copy array 2 is: ");
		test_heap_2.printArrayList();

		//Now check to see if the dequeued elements from List_1 came out sorted
		//Note: List items are in descending, not ascending order
		boolean sorted = true;
		for (int x = 1; x < output_array.size(); x++) {
			if (output_array.get(x - 1) < output_array.get(x)){
				sorted = false;
			}
		}
		
		//Output results of sort check
		if (sorted) {
			System.out.println("List_1 was properly sorted");
		}
		else {
			System.out.println("List_1 was NOT properly sorted");
		}





	}
}
