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
		pred = new int[numv];
		for (int i = 0; i < numv; i++) {
			dist[i] = 9999;
			pred[i] = -1;// Summen im Graph dürfen nie mehr ergeben
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

		// TODO: IHRE IMPLEMENTIERUNG

		VertexHeap vertexHeap = new VertexHeap(graph.numVertices());

		for (int i = 0; i < graph.numVertices(); i++) {

			vertexHeap.insert(new Vertex(i,dist[i]));

		}

		dist[from] = 0;
		vertexHeap.setCost(from, 0);

		while(!vertexHeap.isEmpty())
		{

			Vertex v = vertexHeap.remove();

			for (WeightedEdge edge : graph.getEdges(v.vertex)) {

				int newcost = edge.weight+dist[v.vertex];


				if(dist[edge.to_vertex]>newcost) {
					dist[edge.to_vertex] = newcost;
					pred[edge.to_vertex] = v.vertex;

					vertexHeap.setCost(edge.to_vertex,newcost);

				}

			}


		}

		if(dist[to]>=9999)
			return false;


		return true;
	}
}
