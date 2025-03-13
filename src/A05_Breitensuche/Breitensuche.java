package A05_Breitensuche;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Breitensuche extends BaseTree<Integer> {


	Queue<Node<Integer>> qorder = new ArrayDeque();
	List<Integer> blist = new ArrayList<>();


	@Override
	protected int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück
	 * @param start Startknoten für Teilbaum
	 * @return Liste der Knoten in Breitenfolge
	 */
	public List<Integer> getBreadthFirstOrder(Node<Integer> start) {


		Node<Integer> newNode = start;


		qorder.add(newNode);

		while(!qorder.isEmpty())
		{
			newNode= qorder.poll();
			blist.add(newNode.getValue());
			if(newNode.getLeft()!=null)
				qorder.add(newNode.getLeft());
			if(newNode.getRight()!=null)
				qorder.add(newNode.getRight());

		}


	return blist;

	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück,
	 * allerdings nur jene Knoten, die in der angegebenen Ebene liegen (Start hat Ebene=1)
	 * @param start Startknoten für Teilbaum
	 * @param level Nur Knoten dieser Ebene ausgeben
	 * @return Liste aller Knoten
	 */
	public List<Integer> getBreadthFirstOrderForLevel(Node<Integer> start, int level) {

		Node<Integer> newNode = start;
		int lvlc = 1;
		newNode.setLevel(lvlc);




		qorder.add(newNode);

		while(!qorder.isEmpty())
		{
			newNode= qorder.poll();



			if(level==newNode.getLevel()) {
				blist.add(newNode.getValue());
			}

			if(lvlc<=newNode.getLevel())
				lvlc++;


			if(newNode.getLeft()!=null) {
				qorder.add(newNode.getLeft());
				newNode.getLeft().setLevel(lvlc);
			}

			if(newNode.getRight()!=null) {
				qorder.add(newNode.getRight());
				newNode.getRight().setLevel(lvlc);
			}


		}


		return blist;

	}

}
