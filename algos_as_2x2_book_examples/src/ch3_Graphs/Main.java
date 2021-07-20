package ch3_Graphs;

import java.util.List;
import java.util.Queue;

import ch1DataStructs.ex2_Queue;

public class Main {

	public static void main(String[] args) {
		System.out.println("prog_1 -------------");
		n1();
		System.out.println("\n\n");
		System.out.println("prog_2 -------------");
		
		System.out.println("\n\n");
		System.out.println("prog_3 -------------");
		
		System.out.println("\n\n");
		System.out.println("prog_4 -------------");
		
		System.out.println("\n\n");
		System.out.println("prog_5 -------------");
		
		System.out.println("\n\n");
		System.out.println("prog_6 -------------");
		
		System.out.println("\n\n");
	}
	
	private static void n1() {
		int V = 10;
		int s = 4;
		List<Integer>[] g = Graph.createGraph(V);
		System.out.println("Graph: ");
		for (int i=0; i<V; i++) {
			System.out.print(i + " : ");
			for (int u : g[i]) {
				System.out.print(u + " ");
			}
			System.out.println();
		}
		System.out.println("BFS");
		BFSGraph res = BFS(g, s);
		for (int i=0; i<V; i++) {
			System.out.print(s+"->"+i+" : ");
			printPath(res.p, s, i);
			System.out.println("\t    dist="+res.d[i]);
		}
	}
	
	
	private static class BFSGraph {
		public int[] p;
		public int[] d;
		public BFSGraph(int[] p, int[] d) {
			this.p = p;
			this.d = d;
		}
	}
	private static BFSGraph BFS(List<Integer>[] graph, int s) {
		int N = graph.length;
		int[] p = new int[N];
		int[] d = new int[N];
		int[] visited = new int[N];
		for (int i=0; i<N; i++) {
			p[i] = -1;
			d[i] = -1;
			visited[i] = 0;
		}
		p[s] = -1;
		d[s] = 0;
		visited[s] = 1;
		
		ex2_Queue<Integer> q = new ex2_Queue<>(N);
		q.enqueue(s);
		while (!q.empty()) {
			int u = q.dequeue();
			for (Integer v : graph[u]) {
				if (visited[v] == 0) {
					visited[v] = 1;
					d[v] = d[u]+1;
					p[v] = u;
					q.enqueue(v);
				}
			}
			visited[u] = 2;
		}
		BFSGraph res = new BFSGraph(p, d);
		
		return res;
	}
	
	private static void printPath(int[] p, int s, int v) {
		if (s==v) System.out.print(s + " ");
		else if (p[v]==-1) System.out.print("Path is not found");
		else {
			printPath(p, s, p[v]);
			System.out.print(v + " ");
		}
	}

}
