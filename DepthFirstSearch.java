package graphing;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstSearch {

	private boolean[] marked;
	private int count;
	private int[] edgeTo; 
	private final int s; 

	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		count++;
		for (int w : G.adj(v))
			if (!marked[w]){
				edgeTo[w] = v;
				dfs(G, w);
	}}

	public boolean hasPathTo(int w) {
		return marked[w];
	}
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
		path.push(x);
		path.push(s);
		return path;
		}

	public int count() {
		return count;
	}
}
