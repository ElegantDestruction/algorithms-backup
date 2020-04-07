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

	//Returns this.name as a string (?)
	@Override
	public String toString() {
		return name;
	}
}
