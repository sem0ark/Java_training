package ch3_Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {
	public static List<Integer>[] createGraph(int v) {
		List<Integer>[] g = new ArrayList[v];
		
		Random r = new Random();
		
		for (int i=0; i<v; i++) {
			g[i] = new ArrayList<>();
			for (int j=0; j<v; j++) {
				if (j!=i && r.nextInt(10)<=1) {
					g[i].add(j);
				}
			}
		}
		
		return g;
	}
}
