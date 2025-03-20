package A09_ZyklenTiefensuche;

import A10_DijkstraPQShortestPath.WeightedEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zyklen {

	private Graph g;
	private HashMap<Integer,Integer> vertexNext;
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
		vertexNext = new HashMap<>(g.numVertices()+1);

		for (int i = 0; i < g.numVertices(); i++) {
			visited[i] = false;

		}

		for (int i = 0; i < g.numVertices(); i++) {

			if(visited[i])
				continue;

			List<Integer> cycle = search(i,-1);

			if (cycle !=null)
				return cycle;

		}

		return null;
	}
	public List<Integer> search(Integer i, Integer pred)
	{

		if(vertexNext.containsKey(i))
			return createCycle(i);

		vertexNext.put(pred,i);

		visited[i]=true;

		for (WeightedEdge edge : g.getEdges(i)) {

			if(!g.isDirected() && edge.to_vertex == pred)
				continue;


			List<Integer> cycle = search(edge.to_vertex,i);
			if (cycle!=null)
				return cycle;

		}
		vertexNext.remove(pred);


		return null;
	}
	public List<Integer> createCycle(Integer start)
	{

//		List<Integer> cycle = new ArrayList<>(vertexNext.size());
//		Integer copy = start;
//		cycle.add(start);
//
//		while(copy!=null)
//		{
//			cycle.add(copy);
//			copy = vertexNext.get(copy);
//		}
//		cycle.add(start);
//		return cycle;

		List<Integer> cycle = new ArrayList<Integer>();

		// follow, start
		/*
			2, 3
			3, 4
			4, 5
			5, 2 => 2, 3, 4, 5, 2

			-1,2
			2,3
			3,4
			4,5
		 */


		Integer current = start;

		while (current!=null) {
			cycle.add(current);
			current = vertexNext.get(current);
		}

		cycle.add(start);

		return cycle;

	}
	
	

}
