package A06_Tiefensuche;

import java.util.ArrayList;
import java.util.List;

import A05_Breitensuche.BaseTree;
import A05_Breitensuche.Node;

public class Tiefensuche extends BaseTree<Film> {



	@Override
	/**
	 * Sortierkriterium im Baum: L�nge des Films
	 */
	protected int compare(Film a, Film b) {


		if (a.getL�nge() < b.getL�nge())
			return -1;
		if (a.getL�nge() > b.getL�nge())
			return 1;
		else
			return 0;
	}

	/**
	 * Retourniert die Titelliste der Film-Knoten des Teilbaums in symmetrischer Folge (engl. in-order, d.h. links-Knoten-rechts)
	 * @param node Wurzelknoten des Teilbaums
	 * @return Liste der Titel in symmetrischer Reihenfolge
	 */
	public List<String> getNodesInOrder(Node<Film> node) {

		List<String> tieflist = new ArrayList<>();

		if(node == null)
			return tieflist;

		tieflist.addAll(getNodesInOrder(node.getLeft()));
		tieflist.add(node.getValue().getTitel());
		tieflist.addAll(getNodesInOrder(node.getRight()));

		return tieflist;

	}
	
	/**
	 * Retourniert Titelliste jener Filme, deren L�nge zwischen min und max liegt, in Hauptreihenfolge (engl. pre-order, d.h. Knoten-links-rechts)
	 * @param min Minimale L�nge des Spielfilms
	 * @param max Maximale L�nge des Spielfilms
	 * @return Liste der Filmtitel in Hauptreihenfolge
	 */
	public List<String> getMinMaxPreOrder(double min, double max) {



		Node<Film> copy = root;



		return search(copy, min,max);


	}

	public List<String> search(Node<Film> copy, double min, double max) {

		List<String> tieflist = new ArrayList<>();

		if(copy == null)
			return tieflist;


		if(copy.getValue().getL�nge() > min && copy.getValue().getL�nge() < max)
			tieflist.add(copy.getValue().getTitel());
		tieflist.addAll(search(copy.getLeft(),min,max));
		tieflist.addAll(search(copy.getRight(),min,max));


		return tieflist;
	}

}
