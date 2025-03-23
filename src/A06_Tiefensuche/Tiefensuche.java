package A06_Tiefensuche;

import java.util.ArrayList;
import java.util.List;

import A05_Breitensuche.BaseTree;
import A05_Breitensuche.Node;

public class Tiefensuche extends BaseTree<Film> {

	@Override
	/**
	 * Sortierkriterium im Baum: Länge des Films
	 */
	protected int compare(Film a, Film b) {


		if(a.getLänge() < b.getLänge())
			return -1;
		if(a.getLänge() > b.getLänge())
			return 1;

		return 0;
	}

	/**
	 * Retourniert die Titelliste der Film-Knoten des Teilbaums in symmetrischer Folge (engl. in-order, d.h. links-Knoten-rechts)
	 * @param node Wurzelknoten des Teilbaums
	 * @return Liste der Titel in symmetrischer Reihenfolge
	 */
	public List<String> getNodesInOrder(Node<Film> node) {

		List<String> movielist = new ArrayList<>();

		if(node == null)
			return movielist;

		movielist.addAll(getNodesInOrder(node.getLeft()));
		movielist.add(node.getValue().getTitel());
		movielist.addAll(getNodesInOrder(node.getRight()));

		return movielist;
	}
	
	/**
	 * Retourniert Titelliste jener Filme, deren Länge zwischen min und max liegt, in Hauptreihenfolge (engl. pre-order, d.h. Knoten-links-rechts)
	 * @param min Minimale Länge des Spielfilms
	 * @param max Maximale Länge des Spielfilms
	 * @return Liste der Filmtitel in Hauptreihenfolge
	 */
	public List<String> getMinMaxPreOrder(double min, double max) {




		return search(root,min,max);


	}
	public List<String> search(Node<Film> node, double min, double max)
	{

		List<String> movielist = new ArrayList<>();

		if(node == null)
			return movielist;

		if(node.getValue().getLänge()>= min && node.getValue().getLänge() <= max)
			movielist.add(node.getValue().getTitel());
		movielist.addAll(search(node.getLeft(),min,max));
		movielist.addAll(search(node.getRight(),min,max));

		return movielist;
	}

}
