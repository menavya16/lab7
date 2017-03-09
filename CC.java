/* this program is used to find the connecting components in an undirected graph */
package graphing;

import edu.princeton.cs.algs4.Graph;

public class CC {
	private boolean[] marked; // marked is a boolean array used to store if the given vertex has been processed
	private int[] id; // id is an int array used to store the connected components of given vertex
	private int count; // count is the tally of the components that are connected to one another

	/*following module computes the connected component of a graph*/
	public CC(Graph G) {  // graph 'G' is passed in as parameter 
		marked = new boolean[G.V()]; // value for marked is assigned 
		id = new int[G.V()]; // value for id is assigned
		for (int s = 0; s < G.V(); s++) 
			if (!marked[s]) {  
				dfs(G, s);
				count++; // count is incremented
			}
	}
/* conducting depth first search on our given graph 'G'*/
	private void dfs(Graph G, int v) { 
		marked[v] = true; // the index for the vertex being considere is marked as true 
		id[v] = count; // the id is assigned the same value as count 
		for (int w : G.adj(v)) // for every given w in the G.adj(v) array
			if (!marked[w]) // if the edge has not yet been marked, its sent back into the array
				dfs(G, w); // the graph is given in recursively 
	}

	
	public boolean connected(int v, int w) {
		return id[v] == id[w]; // if the given two vertex are in the same connected component then the program returns true
	}

	public int id(int v) { // the id of a connected component containing vertex 'v' is returned. 
		return id[v];
	}

	public int count() { // the number of connected components is returned.
		return count;
	}
}
