
/* following algorith creates objects of type graph for any undirected graph */
package graphing;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class graph {

	private final int V; // number of vertices 'V'
	private int E; // number of edges 'E'
	private Bag<Integer>[] adj; // bag of integer

	/* initilizing the new graph */
	public graph(int V) {
		this.V = V; // the input parameter is assigned to 'v'
		this.E = 0; // the edge is initialized as 0
		adj = (Bag<Integer>[]) new Bag[V];  // a bag of vertices to add adjacent verticies 
		for (int v = 0; v < V; v++) 
			
			adj[v] = new Bag<Integer>(); // the vertices are added to the bag
	}

	/* initilizing a graph for the input stream given in as input parameter */
	public graph(In in) {
		this(in.readInt()); 
		int E = in.readInt(); 
		for (int i = 0; i < E; i++) { 
			int v = in.readInt();  // the input stream is read and assigned to 'v'
			int w = in.readInt(); // the input stream is read and assigned to 'w'
			addEdge(v, w); // the edges are connected 
		}
	}

	/*edge is added to form a connection between them */
	public void addEdge(int v, int w) {
		adj[v].add(w); // the vertices v and w are added by making them adjacent to eachother.
		adj[w].add(v); 
		E++; // number of edges are incremented
	}

	public int V() {
		return V; // a getter method that returns the int assigned to the integer
	}

	public int E() {
		return E; // a getter method that returns the int assigned to the integer
	}

	public Iterable<Integer> adj(int v) {
		return adj[v]; // Integer adj[v] is returned
	}

	/* the degree of connection is returned for a given vertex 'v' in graph 'G' */
	public static int degree(graph G, int v) {
		int degree = 0; // degree is initilized to a zero
		for (int w : G.adj(v)) // for every given w in the G.adj(v) array
			degree++; // degree is incremented.
		return degree; // degree is returned 
	}

	/* the max degree of the graph is returned */
	public static int maxDegree(graph G) {
		int max = 0; // max is initilized to a zero
		for (int v = 0; v < G.V(); v++) 
			if (degree(G, v) > max) 
				max = degree(G, v); // if the degree(G,v) is greater it is assigned as the new maz
		return max; // maz is returned
	}

	public static int avgDegree(graph G) {
		return 2 * G.E() / G.V(); // the average degree of the given graph is returned 
	}

	/* the number of self loops are counted and returned */
	public static int numberOfSelfLoops(graph G) {
		int count = 0; // the count is initialized to zero
		for (int v = 0; v < G.V(); v++)
			for (int w : G.adj(v))
				if (v == w) // the count is incremented if the vertex 'v' and 'w' are equal
					count++;
		return count / 2; // since everything was counted twice its divided by 2 to decrese it.
	}
	
	/* the vertices and edges are changed to strings and returned */
	public String toString() {
		String s = V + " vertices, " + E + " edges\n"; // changing the parameters of the graph (vertices and edges) into string
		for (int v = 0; v < V; v++) {
			s += v + ": "; // concatinating the vertices to string 's'
			for (int w : this.adj(v))
				s += w + " "; // concatinating the vertices adjacent to 'v' (i.e. 'w') to string 's'
			s += "\n"; // adding end line character
		}
		return s; // the string is returned
	}

}
