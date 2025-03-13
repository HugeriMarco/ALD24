package A02_Queue;

public class Queue<T>
{
    private Node<T> first;
    
    private Node<T> last;

    private int counter;
    /**
     * Das vorderste (=erste) Element aus der Queue entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws QueueEmptyException 
     */
    public T dequeue() throws QueueEmptyException {

        if (first == null)
            throw new QueueEmptyException();
        else {
            Node<T> newNode = first;
            first = first.getNext();
            counter --;

            return newNode.getData();
        }
    }
    
    
    
    /**
     * Übergebenen Integer am Ende der Queue anhängen.
     * @param i Zahl
     */
    public void enqueue(T i) {

        if(first == null)
            first = last = new Node<>(i);

        else {
            Node<T> newNode = new Node<>(i);
            last.setNext(newNode);
            last = newNode;
        }

        counter++;

    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return counter;
    }
}
