package A05_Breitensuche;

import java.util.*;


public class Breitensuche extends BaseTree<Integer> {

	private List<Integer> listtree = new ArrayList<>();
	private Queue<Node<Integer>> order = new ArrayDeque<>();;

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


//		if(listtree.isEmpty()) {
//
//
//			order.add(start);
//		}
//
//		if (order.isEmpty())
//		{
//			return listtree;
//		}
//
//		listtree.add(order.peek().getValue());
//
//		if (start.getLeft() != null)
//			order.add(start.getLeft());
//		if (start.getRight() != null)
//			order.add(start.getRight());
//
//
//		order.remove();
//
//		getBreadthFirstOrder(order.peek());
//
//		return listtree;

		if(listtree.isEmpty()) {

			order.add(start);
		}


		while(!order.isEmpty())
		{
				Node<Integer> copy = order.poll();
				if (copy.getLeft()!=null)
					order.add(copy.getLeft());
				if (copy.getRight()!=null)
					order.add(copy.getRight());
//				if (order.peek().getLeft() != null)
//					order.add(order.peek().getLeft());
//				if (order.peek().getRight() != null)
//					order.add(order.peek().getRight());
//
//				if (!order.isEmpty())
//					listtree.add(order.peek().getValue());

				listtree.add(copy.getValue());


		}

		return listtree;

	}



	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück,
	 * allerdings nur jene Knoten, die in der angegebenen Ebene liegen (Start hat Ebene=1)
	 * @param start Startknoten für Teilbaum
	 * @param level Nur Knoten dieser Ebene ausgeben
	 * @return Liste aller Knoten
	 */
	public List<Integer> getBreadthFirstOrderForLevel(Node<Integer> start, int level) {

		int lvl = 1;
		if(listtree.isEmpty()) {
            start.setLvl(lvl);
			order.add(start);


		}




		while(!order.isEmpty())
		{
			Node<Integer> copy = order.poll();

			if (copy.getLvl() > level) {
				break;
			}

			if(copy.getLvl()!=null)
				if(copy.getLvl() == level) {
				listtree.add(copy.getValue());
				}

			if (copy.getLvl() != null)
				lvl = copy.getLvl()+1;

			if (copy.getLeft()!=null) {
				order.add(copy.getLeft());

				copy.getLeft().setLvl(lvl);

			}
			if (copy.getRight()!=null) {
				order.add(copy.getRight());
				copy.getRight().setLvl(lvl);
			}
//


		}

		return listtree;
	}

}
