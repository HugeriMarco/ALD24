package A02_Queue;

public class Queue<T>
{
    private Node<T> first;
    
    private Node<T> last;
    private int counter = 0;
    /**
     * Das vorderste (=erste) Element aus der Queue entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws QueueEmptyException 
     */
    public T dequeue() throws QueueEmptyException {

        Node<T> newNode = first;

        if(counter==0)
            throw new QueueEmptyException();


        first = first.getNext();
        counter--;

    	return newNode.getData();
    }
    
    
    
    /**
     * Übergebenen Integer am Ende der Queue anhängen.
     * @param i Zahl
     */
    public void enqueue(T i) {

        Node<T> newNode = new Node<>(i);

        if(counter == 0) {
            first = newNode;
            last = newNode;
        }

        if(counter == 1)
            first.setNext(newNode);

        last.setNext(newNode);
        last = newNode;
        counter ++;
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return counter;
    }
}
