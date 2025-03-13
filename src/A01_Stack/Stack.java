package A01_Stack;


public class Stack<T>
{
	 private Node<T> first;
     private int counter;
    /**
     * Oberstes Element entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws StackEmptyException 
     */
    public T pop() throws StackEmptyException {

        if (first == null)
            throw new StackEmptyException();

    	Node<T> newNode = first;
        first = newNode.getNext();
        counter--;

        return newNode.getData();
    }
    
    /**
     * Übergebenen T auf Stack (als oberstes Element) speichern.
     * @param i data
     */
    public void push(T i) {


           Node<T> newNode = new Node<>(i);
           newNode.setNext(first);
           counter++;
            first = newNode;




    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return counter;
    }
}
