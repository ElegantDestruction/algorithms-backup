
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author masont
 *
 */
public class SearchNSortDriver {

	public static void main(String[] args) {
		int points = 0;
		int n = 100;
		Random random = new Random();
//Testing binarySearches		
		int pointsSearch = 0;
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		
		//fill lists with same data
		for(int i = 0; i < n ; i++ ) {
			int value = random.nextInt(n*10);
			list1.add( value  );
			list2.add( value);
			list3.add(value);
			
		}
		
		//Using Collection in Java to sort list1.
		Collections.sort(list1);
		SearchAndSortAlgorithms sort = new SearchAndSortAlgorithms();
	
//Test first element		
		int foundIndexRecursive = sort.binarySearchRecursive(list1, list1.get(0), 0, list1.size()-1);
		int foundIndexIterative = sort.binarySearchIterative(list1, list1.get(0));
		//System.out.println("foundIndex is "+foundIndex);
		if(foundIndexRecursive == foundIndexIterative)
			pointsSearch+=5;
		
//Test last element		
		foundIndexRecursive = sort.binarySearchRecursive(list1, list1.get(n-1), 0, list1.size()-1);
		foundIndexIterative = sort.binarySearchIterative(list1, list1.get(n-1));
		if(foundIndexRecursive == foundIndexIterative)
			pointsSearch+=5;
		
//Test 10th (middle) element		
		foundIndexRecursive = sort.binarySearchRecursive(list1, list1.get(10), 0, list1.size()-1);
		foundIndexIterative = sort.binarySearchIterative(list1, list1.get(10));
		if(foundIndexRecursive == foundIndexIterative)
			pointsSearch+=5;
		
//Test element not found		
		foundIndexRecursive = sort.binarySearchRecursive(list1, 9999999, 0, list1.size()-1);
		foundIndexIterative = sort.binarySearchIterative(list1, 9999999);	
		if(foundIndexRecursive == foundIndexIterative)
			pointsSearch+=5;
		
		System.out.println("Points for searching is "+pointsSearch+ " out of possible 20 points in searching");
		points+=pointsSearch;
		
//InsertionSort 10 points
		
		sort.insertionSort(list2);
		
		//compare sort of list2 to list1 sorted.
		boolean match = true;
		for(int i =0; i< list1.size(); i++) {
			if(((int) list1.get(i)) != ((int)list2.get(i)) ) {
				match = false;
				System.out.println("Element list1 "+list1.get(i)+ " at index "+ i + " does not match list 2 "+list2.get(i) +" after insertion sort");
			}
	    }
		if(match) {
			System.out.println("Insertion sort works for 10 points");
			points += 10;
			System.out.println("Total points are now "+points	);	
		}
						
//QuickSort 20 points

		sort.quickSort(list3, 0, list3.size()-1);
		
		match = true;
		for(int i =0; i< list1.size(); i++) {
			if(((int) list1.get(i)) != ((int)list3.get(i)) ) {
				match = false;
				System.out.println("Element list1 "+list1.get(i)+ " at index "+ i + " does not match list 3 "+list3.get(i) +" after Quicksort");
			}
	    }
		if(match) {
			System.out.println("Quick sort works for 20 points");
			points += 20;
			System.out.println("Total points are now "+points	);
			
		}
		System.out.println("Final points are now "+points	);
	}
}
