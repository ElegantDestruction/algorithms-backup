
import java.awt.Point;
import java.util.Random;

/**
 * @author Jacob Hillebrand
 *
 */
public class BruteForceDriver {

	public static void main(String[] args) {
		int n = 1000;
		Random random = new Random();
		int[] list = new int[n];
		for(int i = 0; i < n ; i++ ) {
			list[i]= random.nextInt(n*10);
		}
		
		BruteForceAlgorithms brute = new BruteForceAlgorithms();
		//print random array
		brute.printArray(list);
		//sort list
		brute.selectionSort(list);
		//Use brute to print out sorted array
		brute.printArray(list);

		
		//Space it out
		System.out.println("\n");


		//Test SequentialSearch
		//Arbitrarily chosen search key
		int low_edge = list[0];
		int high_edge = list[list.length - 1];
		int pos_case = list[121];
		int neg_case = -32;
		//Call sequential search
		int le_result = brute.sequentialSearch(list, low_edge);
		int he_result = brute.sequentialSearch(list, high_edge);
		int pos_result = brute.sequentialSearch(list, pos_case);
		int neg_result = brute.sequentialSearch(list, neg_case);
		// If we found it tell where. If not, say not found
		int search_arr[] = {low_edge, high_edge, pos_case, neg_case};
		int result_arr[] = {le_result, he_result, pos_result, neg_result};
		for (int x = 0; x < search_arr.length; x++) {
			if (result_arr[x] == -1) {
				System.out.println("Key \"" + search_arr[x] + "\" not found in list");
			}else {
			
				System.out.println("Key \"" + search_arr[x] + "\" found in list at position \"" + result_arr[x] + "\"");
			}
		}


		//Space it out
		System.out.println("\n");


		//Test BruteForceStringMatch
		//Make a text and some pattern
		String text = "This will be some text to search in";
		String l_bound = "Thi";
		String u_bound = " in";
		String p_case = "e tex";
		String n_case = "Huawei";
		//run it through the string matcher
		le_result = brute.bruteForceStringMatch(text, l_bound);
		he_result = brute.bruteForceStringMatch(text, u_bound);
		pos_result = brute.bruteForceStringMatch(text, p_case);
		neg_result = brute.bruteForceStringMatch(text, n_case);

		// If we found it tell where. If not, say not found
		String pattern_arr[] = {l_bound, u_bound, p_case, n_case};
		int string_match_results[] = {le_result, he_result, pos_result, neg_result};

		for (int i = 0; i < pattern_arr.length; i++) {
			if (string_match_results[i] == -1) {
				System.out.println("Pattern \"" + pattern_arr[i] + "\" not found in text");
			}else {
				System.out.println("Pattern \"" + pattern_arr[i] + "\" found in text at position \"" + string_match_results[i] + "\"");

			}
		}

		//Space it out
		System.out.println("\n");

		//Test BruteForceClosestPoints
		Point[] points = new Point[3];
		points[0] = new Point(1,1);
		points[1] = new Point(5,5);
		points[2] = new Point(2,2);
		
		Point[] twoClosest = brute.bruteForceClosestPoints(points);
		System.out.println("The closest two points are: ");
		for(int i = 0; i< twoClosest.length; i++)
			System.out.println(twoClosest[i]);
		
	}
}
