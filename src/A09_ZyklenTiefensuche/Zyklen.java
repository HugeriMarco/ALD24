package A09_ZyklenTiefensuche;

import A10_DijkstraPQShortestPath.WeightedEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zyklen {

	private Graph g;
	private int[] visited;
	private int counter =0;
	private HashMap<Integer, Integer> follow = new HashMap<>();
	private	List<Integer> cycle = new ArrayList<>();
	
	public Zyklen(Graph g) {
		this.g = g;
	}
	
	/**
	 * Retourniert einen Zyklus eines Graphen, sofern einer existiert
	 * @param g zu prüfender Graph
	 * @return Anzahl der Komponenten
	 */
	public List<Integer> getCycle() {

		visited = new int[g.numVertices()];

		for (int i = 0; i < visited.length; i++) {

			if(visited[i]!=-1)
				continue;


			search(g, i, counter);
			counter ++;
		}



		return null;
	}

	public void search(Graph g, int i, int counter)
	{

		if (visited[i]!=-1)
			return;


		for (WeightedEdge edge : g.getEdges(i)) {



			visited[i] = counter;

			if(follow.containsKey(edge.to_vertex)) {
				follow.put(i, edge.to_vertex);
				for (Map.Entry<Integer, Integer> integerIntegerEntry : follow.entrySet()) {
					cycle.add(integerIntegerEntry.getKey());

				}
				return;
			}
				

			follow.put(i,edge.to_vertex);
			search(g, edge.to_vertex, counter);

		}





	}




}
