package A05_Breitensuche;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Breitensuche extends BaseTree<Integer> {

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

		Queue<Node<Integer>> queue = new ArrayDeque<>();
		List<Integer> listb = new ArrayList<>();
		queue.add(start);

		while(!queue.isEmpty())
		{


			Node<Integer> first = queue.poll();
			listb.add(first.getValue());
			start = first;

			if(start.getLeft()!=null)
				queue.add(start.getLeft());
			if(start.getRight()!=null)
				queue.add(start.getRight());



		}


		return listb;
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück,
	 * allerdings nur jene Knoten, die in der angegebenen Ebene liegen (Start hat Ebene=1)
	 * @param start Startknoten für Teilbaum
	 * @param level Nur Knoten dieser Ebene ausgeben
	 * @return Liste aller Knoten
	 */
	public List<Integer> getBreadthFirstOrderForLevel(Node<Integer> start, int level) {

		Queue<Node<Integer>> queue = new ArrayDeque<>();
		List<Integer> listb = new ArrayList<>();
		start.setLvl(1);
		queue.add(start);
		level = 1;

		while(!queue.isEmpty())
		{


            start = queue.poll();

			if(level==start.getLvl()) {
				listb.add(start.getValue());
			}

			if(level<=start.getLvl())
				level++;


			if(start.getLeft()!=null) {
					queue.add(start.getLeft());
					start.getLeft().setLvl(level);
			}

			if(start.getRight()!=null) {
					queue.add(start.getRight());
					start.getRight().setLvl(level);
			}




		}


		return listb;

//
//		Node<Integer> newNode = start;
//		int lvlc = 1;
//		newNode.setLevel(lvlc);
//
//
//
//
//		qorder.add(newNode);
//
//		while(!qorder.isEmpty())
//		{
//			newNode= qorder.poll();
//
//
//
//			if(level==newNode.getLevel()) {
//				blist.add(newNode.getValue());
//			}
//
//			if(lvlc<=newNode.getLevel())
//				lvlc++;
//
//
//			if(newNode.getLeft()!=null) {
//				qorder.add(newNode.getLeft());
//				newNode.getLeft().setLevel(lvlc);
//			}
//
//			if(newNode.getRight()!=null) {
//				qorder.add(newNode.getRight());
//				newNode.getRight().setLevel(lvlc);
//			}
//
//
//		}
//
//
//		return blist;

	}

}
