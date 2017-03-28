/* the depth first search class helps determine of the verticies of a undirected graph are connected or not to a given vertex.
*/

package graphing;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstSearch {

	private boolean[] marked; // array of boolean used to keep track of marked verticies 
	private int count; // number of marked verticies 
	private int[] edgeTo; // integer array consisting of the edgesTo a given source
	private final int s;  // source

	/* conducting search for vertices that are connected in our given graph*/
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()]; // G.V() is considered and marked is assigned a boolean values 
		edgeTo = new int[G.V()]; // edgeTo is given a value based on the values of G.V() array 
		this.s = s; // source is assined as the input parameter 's'
		dfs(G, s); // depth search first if conducted. 
	}
/* conducting depth first search on our given graph 'G'*/
	private void dfs(Graph G, int v) { 
		marked[v] = true; // the index for the vertex being considere is marked as true 
		id[v] = count; // the id is assigned the same value as count 
		for (int w : G.adj(v)) // for every given w in the G.adj(v) array
			if (!marked[w]) // if the edge has not yet been marked, its sent back into the array
				dfs(G, w); // the graph is given in recursively 
}}


	public boolean hasPathTo(int w) {
		return marked[w]; // a getter module that just returns marked[w] for any given vertex
	}

/* the program is used to find if there is a path to the given vertex or not. 
And returns the shortest path if there is.  */
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) return null; // if there is no path; null is returned
		Stack<Integer> path = new Stack<Integer>();  // new stack path is created
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x); // edge x is pushed to the path
		path.push(s); // source is added to complete the path
		return path; // the stack is returned 
		}

	public int count() { // number of connected component is returned
		return count; 
	}
}
