import java.util.ArrayList;


public class GraphPathsDriver {

	public static void main(String[] args) {
		//Create vertices.
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");

		//Store in an array of vertices
		Vertex[] vertices = new Vertex[3];
		vertices[0] = A;
		vertices[1] = B;
		vertices[2] = C;

		//Create edge weight matrix and use to create graph.
		int[][] distances = {{0, 1, 3}, {1, 0, 1}, {3, 1, 0}};
		GraphMatrix graph1 = new GraphMatrix(vertices, distances);

		//Print out graph for 20 points.
		System.out.println(graph1);
		
		//Call Dijkstra with Vertex A index. Uncomment once implemented. //Test with  more challenging graphs.
		graph1.Dijkstra(0);


		//Breathing room
		System.out.println("\n\n");

		/******************************************************************************
		 * Test Case!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
		 */

		//Create Vertices
		Vertex Alpha = new Vertex("Alpha");
		Vertex Bravo = new Vertex("Bravo");
		Vertex Charlie = new Vertex("Charlie");
		Vertex Delta = new Vertex("Delta");

		//Sore in an array of vertices
		Vertex[] m_vertices = new Vertex[4];
		m_vertices[0] = Alpha;
		m_vertices[1] = Bravo;
		m_vertices[2] = Charlie;
		m_vertices[3] = Delta;

		//Create edge weight matrix and use to create graph
		int[][] m_distances = {{0,7,2,1}, {7,0,4,3}, {2,4,0,5}, {1,3,5,0}};
		GraphMatrix graph2electricboogaloo = new GraphMatrix(m_vertices, m_distances);

		//Print out graph for 20 points
		System.out.println(graph2electricboogaloo);

		//Call Dijkstra with Vertex Alpha index
		graph2electricboogaloo.Dijkstra(0);

	}
}
