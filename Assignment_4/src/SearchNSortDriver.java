import java.util.ArrayList;
import java.util.Random;


/** 
 * @author Jacob Hillebrand
 *
 */

public class SearchNSortDriver {
	
	public static void main(String[] args) {
		
		SearchAndSortAlgorithms srch = new SearchAndSortAlgorithms();

		/*
		 * Make two arraylists, fill with random numbers so they can be sorted
		 */
		int n = 1000;
		Random random = new Random();
		ArrayList<Integer> i_list = new ArrayList<Integer>();
		ArrayList<Integer> q_list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			i_list.add(random.nextInt(n*10));
			//q_list.add(random.nextInt(n*10));
		}
		//TODO Switch q_list back to full n size
		for (int j = 0; j < 10; j++) {
			q_list.add(random.nextInt(n*10));
		}
		//Print the lists
		srch.printArrayList(i_list);
		srch.printArrayList(q_list);
		
		//Printout markings
		System.out.println("\nEnd arraylist building, begin testing.\n");
		System.out.println("Begin Sequential Search Testing");

		/*
		 * Test Sequential Search
		 */
		int low_edge = i_list.get(0);
		int high_edge = i_list.get(i_list.size() - 1);
		int pos_case = i_list.get(495);
		int neg_case = -32;
		//Call sequential search
		int ss_le_result = srch.sequentialSearch(i_list, low_edge);
		int ss_he_result = srch.sequentialSearch(i_list, high_edge);
		int ss_pos_result = srch.sequentialSearch(i_list, pos_case);
		int ss_neg_result = srch.sequentialSearch(i_list, neg_case);
		//If we found it, tell where. If not, say "not found"
		int search_arr[] = {low_edge, high_edge, pos_case, neg_case};
		int result_arr[] = {ss_le_result, ss_he_result, ss_pos_result, ss_neg_result};
		for (int x = 0; x < search_arr.length; x++) {
                          if (result_arr[x] == -1) {
                                  System.out.println("Key \"" + search_arr[x] + "\" not found in list");
                          }else {
                        
                                  System.out.println("Key \"" + search_arr[x] + "\" found in list at position \"" + result_arr[x] + "\"");                                                                         
                          }
                  }

		//Printout Markings
		System.out.println("End Sequential Search Testing.\nBegin Insertion Sort Testing");
		
		/*
		 * Test Insertion Sort
		 */

		//Sort i_list
		srch.insertionSort(i_list);
		//Test if sorted
		if (isSorted(i_list) == 1) {
			System.out.println("Insertion Sort of i_list successful!");
		}
		else {
			System.out.println("Insertion Sort of i_list FAILED!");
		}

		//Printout Markings
		System.out.println("End Insertion Sort Testing.\nBegin Quick Sort Testing");

		/* 
		 * Test Quick Sort
		 */
		
		//Sort q_list
		srch.quickSort(q_list, 0, q_list.size() - 1);
		//TODO Remove
		System.out.println("Exited quicksort");
		//Test if sorted
                if (isSorted(q_list) == 1) {
        		System.out.println("Insertion Sort of q_list successful!");
        	}       
        	else {
                	System.out.println("Insertion Sort of q_list FAILED!");
                }

		//Printout Markings
		System.out.println("End Quick Sort Testing.\nBegin Recursive Binary Search Testing");
		


		/*
		 * Test Recursive Binary Search
		 */
		
		//Create Test Cases
		low_edge = i_list.get(0);
		high_edge = i_list.get(i_list.size() - 1);
		pos_case = i_list.get(495);
		neg_case = -32;
		//Run searches for test cases
		int rb_le_result = srch.sequentialSearch(i_list, low_edge);
		int rb_he_result = srch.sequentialSearch(i_list, high_edge);
		int rb_pos_result = srch.sequentialSearch(i_list, pos_case);
		int rb_neg_result = srch.sequentialSearch(i_list, neg_case);
		//If we found it, tell where. If not, say "not found"
		int rb_search_arr[] = {low_edge, high_edge, pos_case, neg_case};
		int rb_result_arr[] = {rb_le_result, rb_he_result, rb_pos_result, rb_neg_result};
		for (int x = 0; x < rb_search_arr.length; x++) {
                          if (result_arr[x] == -1) {
                                  System.out.println("Key \"" + search_arr[x] + "\" not found in list");
                          }else {
                        
                                  System.out.println("Key \"" + search_arr[x] + "\" found in list at position \"" + rb_result_arr[x] + "\"");                                                                         
                          }
                  }

		//Printout Markings
		System.out.println("End Recursive Binary Search Testing.\nBegin Iterative Binary Search Testing");


		/* 
		 * Test Iterative Binary Search
		 */


		//Create Test Cases
		low_edge = i_list.get(0);
		high_edge = i_list.get(i_list.size() - 1);
		pos_case = i_list.get(495);
		neg_case = -32;
		//Run searches for test cases
		int ib_le_result = srch.sequentialSearch(i_list, low_edge);
		int ib_he_result = srch.sequentialSearch(i_list, high_edge);
		int ib_pos_result = srch.sequentialSearch(i_list, pos_case);
		int ib_neg_result = srch.sequentialSearch(i_list, neg_case);
		//If we found it, tell where. If not, say "not found"
		int ib_search_arr[] = {low_edge, high_edge, pos_case, neg_case};
		int ib_result_arr[] = {ib_le_result, ib_he_result, ib_pos_result, ib_neg_result};
		for (int x = 0; x < ib_search_arr.length; x++) {
                          if (result_arr[x] == -1) {
                                  System.out.println("Key \"" + search_arr[x] + "\" not found in list");
                          }else {
                        
                                  System.out.println("Key \"" + search_arr[x] + "\" found in list at position \"" + ib_result_arr[x] + "\"");                                                                         
                          }
                  }

		//Printout Markings
		System.out.println("Assignment 4 Testing Complete.");

	}


	/*
	 * FUNCTION: isSorted(A[0..n-1])
	 * Simple function to check if a list is sorted
	 * INPUT: arraylist A[0..n-1]
	 * OUTPUT: 1 if list is sorted, 0 if not sorted
	 */

	public static int isSorted(ArrayList<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i-1) > list.get(i)) {
				return 0;
			}
		}
		return 1;
	}


}
