package A09_ZyklenTiefensuche;

import A10_DijkstraPQShortestPath.WeightedEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zyklen {

	private Graph g;
	private HashMap<Integer,Integer> cyclemap;
	private boolean[] visited;
	
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
		cyclemap = new HashMap<>();

		for (int i = 0; i < g.numVertices(); i++) {

			if (visited[i])
				continue;

			List<Integer> cycle = search(i,-1);

			if (cycle != null)
				return cycle;


		}



		return null;
	}
	public List<Integer> search(Integer i, Integer pred)
	{

		if(cyclemap.containsKey(i))
			return createCycle(i);

		visited[i] = true;
		cyclemap.put(pred,i);

		for (WeightedEdge edge : g.getEdges(i)) {



			if(!g.isDirected() && edge.to_vertex == pred)
				continue;

			List<Integer> cycle = search(edge.to_vertex,i);

			if(cycle !=null)
				return cycle;

		}
		cyclemap.remove(pred);


		return null;
	}
	public List<Integer> createCycle(Integer start)
	{

		List<Integer> cycle = new ArrayList<>();

		Integer copy = start;


		while(copy!=null)
		{
			cycle.add(copy);
			copy = cyclemap.get(copy);

		}

		cycle.add(start);

		return cycle;

	}
	

}
