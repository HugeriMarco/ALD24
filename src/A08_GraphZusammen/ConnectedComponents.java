package A08_GraphZusammen;

import A10_DijkstraPQShortestPath.WeightedEdge;

public class ConnectedComponents {
	
	/**
	 * Retourniert die Anzahl der zusammenh�ngenden Komponenten eines Graphen
	 * @param g zu pr�fender Graph
	 * @return Anzahl der Komponenten
	 */

	private int[] visited;
	public int getNumberOfComponents(Graph g) {

		int result = 0;

		visited = new int[g.numVertices()];

		for (int i = 0; i < g.numVertices(); i++) {

			visited[i] = -1;

		}



		for (int i = 0; i < g.numVertices(); i++) {

			if (visited[i]>-1)
					continue;

			search(g,i,result);

			result++;
		}

		return result;
	}

	public void search(Graph g, int i, int result)
	{

		if(visited[i]>-1)
			return;

		visited[i] = result;



		for (WeightedEdge edge : g.getEdges(i)) {

			if (visited[edge.to_vertex]>-1)
				continue;


			search(g,edge.to_vertex,result);

		}


	}

}
