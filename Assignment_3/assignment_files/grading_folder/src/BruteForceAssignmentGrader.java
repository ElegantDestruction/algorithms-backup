
import java.awt.Point;
import java.util.Random;

/**
 * @author YourNameHere
 *
 */
public class BruteForceAssignmentGrader {

	public static void main(String[] args) {
		
		int points = 0;
		int n = 1000;
		Random random = new Random();
		int[] list = new int[n];
		for(int i = 0; i < n ; i++ ) {
			list[i]= random.nextInt(n*10);
		}
		
		BruteForceAlgorithms brute = new BruteForceAlgorithms();
		//print random array
		//brute.printArray(list);
		//sort list
		brute.selectionSort(list);
		//Use brute to print out sorted array
		//brute.printArray(list);
		points+=5;
		System.out.println("Points +5 for selectionSort: "+points);
		
//Test SequentialSeach
		int[] data = {1,2,4,6,8,9,12,5,3};
		
		int location = brute.sequentialSearch(data, 9);
		if(location == 5)
			points+=3;
		//check for first
		location = brute.sequentialSearch(data, 1);
		if(location == 0)
			points+=4;
		//check last
		location = brute.sequentialSearch(data, 3);
		if(location == data.length-1)
			points+=4;
		//check not there
		location = brute.sequentialSearch(data, 22);
		if(location == -1)
			points+=4;
		
		System.out.println("Points should be 20 if you get all. Points are "+points);

//Test BruteForceStringMatch
		String text = "This is the end, my only friend the end";
		int startOfMatch = brute.bruteForceStringMatch( text , "end");
		System.out.println("Matches at index "+startOfMatch);
		if(startOfMatch == 12)
			points+=5;
		
		startOfMatch = brute.bruteForceStringMatch( text , "This");
		System.out.println("Matches at index "+startOfMatch);
		if(startOfMatch == 0)
			points+=5;
		
		startOfMatch = brute.bruteForceStringMatch( text , "friend the end");
		System.out.println("Matches at index "+startOfMatch);
		if(startOfMatch == 25)
			points+=5;
		
		
		startOfMatch = brute.bruteForceStringMatch( text , "friend the end!");
		System.out.println("Matches at index "+startOfMatch);
		if(startOfMatch == -1)
			points+=5;
		
		System.out.println("Points should be 40 if you get all through String Match. Points are "+points);

// Test BruteForceClosestPoints
		Point[] points1 = new Point[6];
		points1[0] = new Point(1,1);
		points1[1] = new Point(5,5);
		points1[2] = new Point(2,6);
		points1[3] = new Point(3,4);
		points1[4] = new Point(7,7);
		points1[5] = new Point(2,2);
		Point[] twoClosest = brute.bruteForceClosestPoints(points1);
		System.out.println("The closest two points are: ");
		for(int i = 0; i< twoClosest.length; i++)
			System.out.println(twoClosest[i]);
		if(points1[0]==twoClosest[0] && points1[5]==twoClosest[1])
			points+=10;
		if(points1[0]==twoClosest[1] && points1[5]==twoClosest[0])
			points+=10;
			
		System.out.println("Points should be 50 if you get all. Points are "+points);
			
	}		
}
