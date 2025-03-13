package A05_Breitensuche;

public class NodewithLevel<Type> {

	/**
	 * Linkes Kind
	 */
	protected NodewithLevel<Type> left;

	/**
	 * Rechtes Kind
	 */
	protected NodewithLevel<Type> right;

	/**
	 * Elternelement
	 */
	protected NodewithLevel<Type> parent;

	protected int level;

	/**
	 * Wert des Knotens, hier: String, der Wort enthält
	 */
	protected final Type value;


	/**
	 * Konstruktor
	 * @param value Zu speichernder Wert
	 */
	public NodewithLevel(Type value) {
		this.value = value;
	}

	public NodewithLevel<Type> getLeft() {
		return left;
	}

	public void setLeft(NodewithLevel<Type> left) {
		this.left = left;
	}

	public NodewithLevel<Type> getRight() {
		return right;
	}

	public void setRight(NodewithLevel<Type> right) {
		this.right = right;
	}

	public NodewithLevel<Type> getParent() {
		return parent;
	}

	public void setParent(NodewithLevel<Type> parent) {
		this.parent = parent;
	}

	public Type getValue() {
		return value;
	}
	
}
