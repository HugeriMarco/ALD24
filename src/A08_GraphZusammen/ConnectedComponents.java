package A08_GraphZusammen;

import A10_DijkstraPQShortestPath.Vertex;
import A10_DijkstraPQShortestPath.WeightedEdge;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
	
	/**
	 * Retourniert die Anzahl der zusammenh�ngenden Komponenten eines Graphen
	 * @param g zu pr�fender Graph
	 * @return Anzahl der Komponenten
	 */

	private int[] visited;
	private int counter = 0;

	public int getNumberOfComponents(Graph g) {

		visited = new int[g.numVertices()];

		for (int i = 0; i < visited.length; i++) {
			visited[i]=-1;
		}


		for (int i = 0; i < visited.length; i++) {

			if(visited[i] != -1)
				continue;

			search(g, i);
			counter++;

		}
		return counter;

	}

	public void search(Graph graph, int i)
	{

				if(visited[i] == 1) {
					return;
				}

				visited[i] = 1;

				List<WeightedEdge> wedges = graph.getEdges(i);
				for (WeightedEdge wedge : wedges) {
					search(graph,wedge.to_vertex);


				}



	}

}
