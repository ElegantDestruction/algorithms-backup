import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;

/*
 * Author: Jacob Hillebrand
 * Date: 04/06/2020
 */

public class Vertex {

	/*
	 ****************************************************
	 * Member Variables
	 ****************************************************
	 */
	
	//Private variables for storing object properties
	private String name;
	private int color;
	private boolean visited;
	private int distance;

	//Constants for theoretical use in assigning colors
	public static final int WHITE = 1;
	public static final int GREEN = 2;
	public static final int BLACK = 3;

	/*
	 ****************************************************
	 * Member Methods
	 ****************************************************
	 */

	//Constructor
	public Vertex(String name) {
		this.name = name;
		color = WHITE;
		visited = false;
	}
	
	//Returns this.name
	public String getName() {
		return name;
	}

	//Returns this.color
	public int getColor() {
		return color;
	}

	//Sets this.color
	public void setColor(int color) {
		this.color = color;
	}

	//Returns this.visited
	public boolean isVisited() {
		return visited;
	}
	
	//Sets this.visited
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	//Returns this.distance
	public int getDistance() {
		return distance;
	}

	//Set this.distance
	public void setDistance(int distance) {
		this.distance = distance;
	}

	//Performs a distance comparison with the parameter passed in
	public int compareTo(Vertex o) {
		int value = 0;
		if (distance < o.getDistance()) {
			value = -1;
		}
		else if (distance > o.getDistance()) {
			value = 1;
		}
		return value;
	}

	//Returns this.name as a string (?)
	@Override
	public String toString() {
		return name;
	}
}
