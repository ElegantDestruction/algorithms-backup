import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Iterator;

public class GraphMatrix {
	/*
         ****************************************************
         * Member Variables
         ****************************************************
         */

	//Instance variable for the array of all vertices in 
	// the graph
	private Vertex[] vertices;
	//A 2D array of edge weights from Vertex to Vertex.
	// The indices in the array match the indices of the
	// Vertex in vertices
	private int[][] edgeWeights;


        /*
         ****************************************************
         * Member Methods
         ****************************************************
         */


	/*
         * GraphMatrix - constructor for GraphMatrix class
         * Assigns parameters to instance variables
         * @param vertices - Array of verticies in the graph
         * @param edgeWeights - 2D array of edge weights from vertex to vertex
         */
	public GraphMatrix(Vertex[] vertices, int[][] edgeWeights) {
		// Assign vertices
		this.vertices = vertices;
		// Assign edgeWeights
		this.edgeWeights = edgeWeights;
	}

	/*
         * Dijkstra - Algorithm to search a graph for the shortest path from 
	 * 	the input source index to any other point on the graph
         * @param sourceIndex - integer value representing the index of the Vertex to
	 * 	start the search at
         */
	public void Dijkstra(int sourceIndex) {
		//Grab our source vertex
		Vertex source = vertices[sourceIndex];
		//Setup up a priority queue for use later
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>(vertices.length, (a,b) -> a.getDistance() - b.getDistance());
		//Setup up a hash map for storing predecessor vertexes
		HashMap<Vertex, Vertex> predecessor = new HashMap<Vertex, Vertex>();

		//Make sure we've got all the distances set to max
		for (int i = 0; i < vertices.length; i++) {
			//If vertex is source
			if (i == sourceIndex) {
				vertices[i].setDistance(0); //Set to 0
			}
			else { 
				vertices[i].setDistance(Integer.MAX_VALUE); //Set to INF
			}
			//Regardless, add to priority queue Q 
			Q.add(vertices[i]);
		}

		//Begin searching
		while (Q.peek() != null) {
			//Grab the next vertex w/min distance
			Vertex u = Q.poll();

			//Find index of u in vertices
			int uIndex = 0;
			for (int j = 0; j < vertices.length; j++) {
				if (vertices[j].toString() == u.toString()) {
					uIndex = j;
				}
			}

			//For each neighbor
			for (int k = 0; k < edgeWeights[uIndex].length; k++) {
				Vertex v = vertices[k]; //Grab the neighbor vertex
				//If v is still in Q and edge from u to v
				if (Q.contains(v)) { //Didn't include the check the edge exists. Not sure how to do it
					int alt = u.getDistance() + edgeWeights[uIndex][k]; //Determine the path
					if (alt < v.getDistance()) {
						//Remove v from Q, overwrite the distance,
						//add it back to Q with the new distance,
						//and add the pair to the predecessor list
						Q.remove(v);
						v.setDistance(alt);
						Q.add(v);
						predecessor.put(v,u);
					}
				}
			}
		}



		//Print out distance to each vertex from the source	
		String distances = "";
		distances += "Distances from Vertex " + vertices[sourceIndex].toString();

		//Loop through each vertex and report the distances
		for (Vertex n : vertices) {
			//If not source node, add to print statement
			if (n.toString() != vertices[sourceIndex].toString()){
				distances += n.toString() + ", " + n.getDistance();	
			}
			//Return character
			distances += "\n";
		}

		//Print the value
		System.out.println(distances);



		//Print out path from source to each vertex 
		System.out.print("Shortest paths from Vertex " + vertices[sourceIndex].toString());
		for (int m = 0; m < vertices.length; m++) {
			//Set up variables for use
			String path = "";
			Vertex current = vertices[m];

			//As long as we aren't dealing with the source index
			if (m != sourceIndex) {
				//Set up the next arrow for path
				path = " -> " + current.toString() + ", " + current.getDistance() + path;
				//Loop through until we hit the source index
				while (predecessor.containsKey(current)) {
					//If we hit the source Vertex
					if (predecessor.get(current) == vertices[sourceIndex]){
						path = predecessor.get(current).toString() + path;
					}
					else { //If we're still working through the path
						path = " -> " + predecessor.get(current).toString() + ", " + predecessor.get(current).getDistance() + path;
					}
					//Grab the next Vertex in the path
					current = predecessor.get(current);
				}
			}
			//Print out the path in full
			System.out.println(path);
		}
	}

	/*
         * toString - overrides global toString method, allows easy printout for 
	 * 	this class's graph paths
         * @return - a string containing the contents of the graph
         */
	@Override
	public String toString() {
		//Set up a string
		String output = "";
		output += "Adjacency matrix for graph:\n";

		//Loop through all of vertices
		for (int x = 0; x < vertices.length; x++) {
			//Print out the current vertex
			output += vertices[x].toString();
			
			//Loop through all connections of current vertex
			for (int y = 0; y < edgeWeights[x].length; y++) {
				if (edgeWeights[x][y] != 0) {
					output += " -> " + vertices[y].toString() + ", " + edgeWeights[x][y] + " ";
				}
			}

			//Return character
			output += "\n";
		}

		//Return the output, which can be used as a string
		return output;
	}

}
