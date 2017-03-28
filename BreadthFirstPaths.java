package graphing;

/* this algorithm uses breathFirstSearch to find the shortest path between the source 
to all the other vertexes present in the graph. */

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths { 
	private boolean[] marked; // the boolean array marked is used to keep track if there is a path between two verticies or not
	private int[] edgeTo; // the integer array edgeTo is used to keep track of if there is an edge 
	private final int s;  // the integer 's' is assigned to the source 

/* in any given undirrected 'G', the following module finds all the paths 
from the source 's' to every path in the graph.
*/
	public BreadthFirstPaths(Graph G, int s) { 
		marked = new boolean[G.V()];  
		edgeTo = new int[G.V()]; 
		this.s = s;
		bfs(G, s); // bfs module is called giving in the graph and the source as the parameters 
	}

	
	/*  the following module conducts the breath first search
*/
	private void bfs(Graph G, int s) { 
		Queue<Integer> queue = new Queue<Integer>(); // a new Queue is created
		marked[s] = true; // for a given source 's'; marked is assigned to true.
		queue.enqueue(s);  // the item [source 's' in this case] is added to the queue
		while (!queue.isEmpty()) { // while loop to ensure that the program runs as long as there are items in queue
			int v = queue.dequeue(); // the last added item is removed from the queue and it is assigned to the integer 'v'
			for (int w : G.adj(v)) // the loop runs for each integer 'w' in the G.adj(v) array
				if (!marked[w]) {  // the unmarked edges are added to the queue and marked
					edgeTo[w] = v; 
					marked[w] = true;
					queue.enqueue(w);
				}
		}
	}

	public boolean hasPathTo(int v) { // a getter module that just returns marked[v] for any given vertex 'v'/
		return marked[v];
	}

	
/* the program is used to find if there is a path to the given vertex or not. 
And returns the shortest path if there is.  */
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) // if there is no path; null is returned
			return null;
		Stack<Integer> path = new Stack<Integer>(); // new stack path is created
		for (int x = v; x != s; x = edgeTo[x])  //
			path.push(x); // if there is an connecting edge present; it is added to the stack
		path.push(s); // source is pushed to path to make the shrotest path complete
		return path; // the stack of the shortest path is returned
	}

}
