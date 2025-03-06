package A05_Breitensuche;

public class Node_lvl<Type> {

	/**
	 * Linkes Kind
	 */
	protected Node_lvl<Type> left;

	/**
	 * Rechtes Kind
	 */
	protected Node_lvl<Type> right;

	/**
	 * Elternelement
	 */
	protected Node_lvl<Type> parent;

	/**
	 * Wert des Knotens, hier: String, der Wort enthält
	 */
	protected final Type value;


	/**
	 * Konstruktor
	 * @param value Zu speichernder Wert
	 */
	public Node_lvl(Type value) {
		this.value = value;
	}

	public Node_lvl<Type> getLeft() {
		return left;
	}

	public void setLeft(Node_lvl<Type> left) {
		this.left = left;
	}

	public Node_lvl<Type> getRight() {
		return right;
	}

	public void setRight(Node_lvl<Type> right) {
		this.right = right;
	}

	public Node_lvl<Type> getParent() {
		return parent;
	}

	public void setParent(Node_lvl<Type> parent) {
		this.parent = parent;
	}

	public Type getValue() {
		return value;
	}
	
}
