import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Stack;

/*
 * Author: Jacob Hillebrand
 * Date: 04/06/2020
 */

public class UndirectedGraph {
	/*
	 ****************************************************
	 * Member Variables
	 ****************************************************
	 */

	//Hash map to store the name of a Vertex as a key
	private HashMap<String, LinkedList<Vertex>> vertices;
	//ArrayList of all Vertex objects for all for all vertices in graph
	private ArrayList<Vertex> listOfVertices;

	/*
	 ****************************************************
	 * Member Methods
	 ****************************************************
	 */

	/*
	 * Undirectedgraph constructor, assigns listOfVertices and construct the HashMap vertices
	 * @param listOfVertices - ArrayList of the Vertex objects for all graph vertices
	 */
	public UndirectedGraph(ArrayList<Vertex> listOfVertices) {
		vertices = new HashMap<String, LinkedList<Vertex>>();
		for (int i = 0; i < listOfVertices.size(); i++) {
			vertices.put(listOfVertices.get(i).getName(), new LinkedList<Vertex>());
		}
		this.listOfVertices = listOfVertices;
	}

	/*
	 * addEdge - adds an edge to our graph by adding vertex v to key u in vertices and adding
	 * Vertex u to key v in vertices. Both directions must be added for edge.
	 * @param u - Vertex incident on edge
	 * @param v - Vertex incidednt on edge
	 * @return true if edge added to graph from u to v and v to u, false otherwise
	 */
	public boolean addEdge(Vertex u, Vertex v) {
		return(vertices.get(u.getName()).add(v) && vertices.get(v.getName()).add(u));
	}

	/*
	 * ALGORITHM: Iterative BreadthFirstSearch(Graph G, Vertex start)
	 * Traverses a graph using the breadth-first methodology 
	 * @param start - Vertex to start traversal upon
	 * @return T - Graph tree that represents the breadth first search tree traversal
	 */

	public UndirectedGraph breadthFirstSearch(Vertex start) {
		//initialize vertices; mark all vertices white
		for (Vertex vert : listOfVertices) {
			vert.setColor(1);
		}
		
		//Create Graph T using all vertices from G
		UndirectedGraph T = new UndirectedGraph(listOfVertices);

		//Q is a queue; insert vertex u
		ArrayList<Vertex> Q = new ArrayList<Vertex>();
		Q.add(start);

		//Begin search
		while (!Q.isEmpty()) {
			// Grab the next vertex
			Vertex u = Q.remove(0);

			//Iterate through the attached nodes to the vertex
			Iterator<Vertex> iterator = vertices.get(u.toString()).iterator();
			while (iterator.hasNext()) {
				// Grab next attached vertex
				Vertex v = iterator.next();
				if (v.getColor() == 1) {
					v.setColor(2);
					Q.add(v);
					T.addEdge(u, v);
				}
			}

			// Make u black (we've now explored it)
			u.setColor(3);
		}

		//Return our Tree
		return T;
	}

	/*
	 * ALGORITHM: Iterative DepthFirstSearch (Vertex start)
	 * Traverses a graph using the depth first methodology
	 * @param start - Vertex start is the vertex to start the traversal
	 * @return T - Graph Tree that represents the depth first seach tree
	 */

	public UndirectedGraph depthFirstSearch(Vertex start) {
		//Create Stack S
		Stack<Vertex> s = new Stack<Vertex>();

		//Create ArrayList<Vertex> visited (store order of visited vertices)
		ArrayList<Vertex> visited = new ArrayList<Vertex>();

		//Create HashMap<Vertex, Vertex> predecessor (store predecessor value)
		HashMap<Vertex, Vertex> predecessor = new HashMap<Vertex, Vertex>();

		//Initialize each vertex u in the graph to set visited to false
		for (Vertex vert : listOfVertices) {
			vert.setVisited(false);
		}

		//Push start onto s
		s.push(start);

		//While stack is not empty
		while (!s.isEmpty()) {
			//Grab the next vertex
			Vertex u = s.pop();

			//Check if we visited it
			if (!u.isVisited()) {
				u.setVisited(true);
				visited.add(u);
				
				//Now look through all adjacents of u
				Iterator<Vertex> iterator = vertices.get(u.toString()).iterator();
				while (iterator.hasNext()) {
					//Grab next attached vertex
					Vertex x = iterator.next();
					
					//If x not visited, push it onto s and put x and u into predecessor
					if (!x.isVisited()) {
						s.push(x);
						predecessor.put(x,u);
					}
				}
			}
		}

		//Create Graph T with all vertices visited
		UndirectedGraph T = new UndirectedGraph(listOfVertices);
		for (Vertex v : visited) {
			if (predecessor.get(v) != null) {
				Vertex u = predecessor.get(v);
				T.addEdge(u,v);
			}
		}

		//Return Tree
		return T;


	}

	@Override
	public String toString() {
		String s = "Current adjacency list for graph:\n";
		for (String key : vertices.keySet()) {
			s += "Vertex " + key + ":";
			LinkedList<Vertex> adjacentNodes = vertices.get(key);
			Iterator<Vertex> iterator = adjacentNodes.iterator();
			while (iterator.hasNext()) {
				Vertex vertex = iterator.next();
				s += " -> " + vertex;
			}
			s += "\n";
		}
		return s;
	}


}
