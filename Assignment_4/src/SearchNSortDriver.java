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
			q_list.add(random.nextInt(n*10));
		}
		
		//Test the lists

		srch.printArrayList(i_list);
		srch.printArrayList(q_list);


	}


}
