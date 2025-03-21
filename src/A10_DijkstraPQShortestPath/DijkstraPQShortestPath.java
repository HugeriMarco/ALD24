package A10_DijkstraPQShortestPath;


public class DijkstraPQShortestPath extends FindWay {
	private int[] dist;


	public DijkstraPQShortestPath(Graph graph) {
		super(graph);
	}

	/**
	 * Startentfernung initialisieren
	 * 
	 * @param from
	 *            Startknoten
	 */
	protected void initPathSearch() {
		int numv = graph.numVertices();
		dist = new int[numv];

		for (int i = 0; i < numv; i++) {
			dist[i] = 9999;// Summen im Graph dürfen nie mehr ergeben
			pred[i] = -1;
		}
	}

	/**
	 * Berechnet *alle* kürzesten Wege ausgehend vom Startknoten Setzt dist[]-
	 * und pred[]-Arrays, kein Rückgabewert
	 * 
	 * @param from
	 *            Startknoten
	 */
	protected boolean calculatePath(int from, int to) {

		VertexHeap vheap = new VertexHeap(graph.numVertices());

		for (int i = 0; i < graph.numVertices(); i++) {

			vheap.insert(new Vertex(i,dist[i]));

		}

		vheap.setCost(from,0);
		dist[from] = 0;

		while(!vheap.isEmpty())
		{
			Vertex v = vheap.remove();



				for (WeightedEdge edge : graph.getEdges(v.vertex)) {

					int newdist = dist[v.vertex] + edge.weight;

					if(newdist < dist[edge.to_vertex])
					{
						dist[edge.to_vertex] = newdist;
						pred[edge.to_vertex] = v.vertex;
						vheap.setCost(edge.to_vertex,newdist);

					}




			}


		}

        return dist[to] < 9999;
    }
}
