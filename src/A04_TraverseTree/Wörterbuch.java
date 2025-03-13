package A04_TraverseTree;

import java.util.HashSet;
import java.util.Set;


public class Wörterbuch {

	/**
	 * Wurzel des Baums (Startknoten)
	 */
	private Wort root;
	private int counter =1;
	private Set<String> lset = new HashSet<>();
	
	public Wort getRoot() {
		return root;
	}

	/**
	 * Zählt alle Wörter des Teilbaums ab einem bestimmten Wort
	 * @param w Wort
	 * @return Zahl der Wörter (=Anzahl der Elemente)
	 */
	public int countWordsInSubTree(Wort w) {

		if(w == null)
			return 0;


		if(w.getLeft()!=null) {
			counter++;
			countWordsInSubTree(w.getLeft());

		}

		if(w.getRight()!=null) {
			counter++;
			countWordsInSubTree(w.getRight());

		}

		return counter;

//		if(w == null)
//			return 0;
//
//		return 1 + countWordsInSubTree(w.getLeft()) + countWordsInSubTree(w.getRight());
//


	}

	/**
	 * Liefert die Menge aller Wörter retour, die ein spezifisches Präfix haben.
	 * @param prefix Wörter müssen diesen Präfix haben
	 * @return Menge aller zutreffenden Wörter
	 */
	public Set<String> getWordsWithPrefix(String prefix) {
		
		if(root == null)
			return null;

		Wort w = root;

		return search(w, prefix);



	}
	public Set<String> search(Wort w, String prefix) {

		if(w==null)
			return lset;

		if(w.getWort().startsWith(prefix))
			lset.add(w.getWort());

		if(w.getLeft()!=null) {
//			if (w.getLeft().getWort().startsWith(prefix)) {
//				lset.add(w.getLeft().getWort());
//
//			}
			search(w.getLeft(),prefix);

		}
		if(w.getRight()!=null) {
//			if (w.getRight().getWort().startsWith(prefix)) {
//				lset.add(w.getRight().getWort());
//
//			}
			search(w.getRight(), prefix);
		}

		return lset;
	}
	

	/**
	 * Neues Wort hinzufügen
	 * @param wort Hinzuzufügendes Wort
	 */
	public void add(String wort) {
		Wort neu = new Wort(wort);
		if (root == null) {			// Fall 1: Baum ist leer
			root = neu;
			return;
		}
		Wort w = root;				// Fall 2: Baum ist nicht leer
		while (true) {
			int vgl = wort.compareTo(w.getWort());
			if (vgl < 0) {			// Neues Wort ist lexikographisch kleiner
				if (w.getLeft() == null) {
					w.setLeft(neu);
					neu.setParent(w);
					return;
				}
				w = w.getLeft();
			}
			else if (vgl > 0) {		// Neues Wort ist lexikographisch größer
				if (w.getRight() == null) {
					w.setRight(neu);
					neu.setParent(w);
					return;
				}
				w = w.getRight();
			}
			else {					// Neues Wort ist lexikographisch gleich
				return;
			}
		}
	}

	public Wort find(String s) {
		return find(root, s);
	}
	
	private Wort find(Wort current, String s) {
		if (current == null) {
			return null;
		}
		int vgl = s.compareTo(current.getWort());
		if (vgl == 0) {		// Gefunden
			return current;
		}
		else if (vgl < 0) {	// Links
			return find(current.getLeft(), s);
		}
		else {				// Rechts
			return find(current.getRight(), s);
		}
	}
	
}
