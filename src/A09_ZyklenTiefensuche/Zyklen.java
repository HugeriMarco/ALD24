package A09_ZyklenTiefensuche;

import A10_DijkstraPQShortestPath.WeightedEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zyklen {

	private Graph g;
	private boolean[] visited;
	private HashMap<Integer, Integer> cyclemap = new HashMap<>();
	
	public Zyklen(Graph g) {
		this.g = g;
	}
	
	/**
	 * Retourniert einen Zyklus eines Graphen, sofern einer existiert
	 * @param g zu prüfender Graph
	 * @return Anzahl der Komponenten
	 */
	public List<Integer> getCycle() {

		visited = new boolean[g.numVertices()];

		for (int i = 0; i < visited.length; i++) {
			visited[i]=false;
		}

		for (int i = 0; i < visited.length; i++) {

			if (visited[i])
				continue;


			List<Integer> route = search(g, i, -1);

			if(route!=null)
				return route;
		}



		return null;
	}
	public List<Integer> search(Graph g, Integer i, Integer pred)
	{

		if(cyclemap.containsKey(i))
		{
            return createRoute(i);
		}
		if(visited[i])
			return null;

		visited[i]= true;
		cyclemap.put(pred,i);
		for (WeightedEdge edge : g.getEdges(i)) {

			if (edge.to_vertex == pred && !g.isDirected()) {
				continue;
			}

			List<Integer> cycle = search(g, edge.to_vertex, i);
			if (cycle != null) {
				return cycle;
			}





		}
		cyclemap.remove(i);

		return null;

	}

	public List<Integer> createRoute(Integer start)
	{

		List<Integer> route = new ArrayList<>();



		Integer current = start;
		while (current != null) {
			route.add(current);
			current = cyclemap.get(current);
		}

		route.add(start);

		return route;



	}
	

}
