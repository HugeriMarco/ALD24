package A03_DoubleLinkedList;

public class DoubleLinkedList<T>
{

    private Node<T> first;
    private Node<T> last;
    private Node<T> current;


    /**
     * Einfügen einer neuen <T>
     * @param a <T>
     */
    public void add(T a) {

        if(first == null) {
            first = last = new Node<>(a);
        }


        else
        {
            Node<T> newNode = new Node<>(a);
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;


        }


    }

    /**
     * Internen Zeiger für next() zurücksetzen
     */
    public void reset() {

        current = first;

    }

    /**
     * analog zur Funktion reset()
     */
    public void resetToLast() {

        current = last;

    }

    /**
     * Liefert erste Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getFirst() {


        return first;

    }
    
    /**
     * Liefert letzte Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getLast() {

        return last;
    }
    
    /**
     * Gibt aktuelle <T> zurück und setzt internen Zeiger weiter.
     * Falls current nicht gesetzt, wird null retourniert.
     * @return <T>|null
     */
    public T next() {

    	if(current==null)
            return null;

        Node<T> newNode = current;
        current = current.getNext();
        return newNode.getData();

    }

    /**
     * analog zur Funktion next()
     * @return <T>|null
     */
    public T previous() {

        if(current==null)
            return null;

        Node<T> newNode = current;
        current = current.getPrevious();
        return newNode.getData();

    }
    
    /**
     * Current-Pointer auf nächste <T> setzen (aber nicht auslesen).
     * Ignoriert still, dass current nicht gesetzt ist.
     */
    public void moveNext() {

        if(current != null)
        {
            current = current.getNext();
        }

    }
    
    /**
     * Analog zur Funktion moveNext()
     */
    public void movePrevious() {

        if (current != null)
            current = current.getPrevious();
    }
   
    /**
     * Retourniert aktuelle (current) <T>, ohne Zeiger zu ändern
     * @return <T>
     * @throws CurrentNotSetException
     */
    public T getCurrent() throws CurrentNotSetException {

        if (current == null)
            throw new CurrentNotSetException();

    	return current.getData();
    }

    /**
     * Gibt <T> an bestimmter Position zurück
     * @param pos Position, Nummerierung startet mit 1
     * @return <T>|null
     */
    public T get(int pos) {

        int counter = 1;
        Node<T> newNode = first;


        while(newNode!=null)
        {

                    if (counter == pos) {
                        return newNode.getData();
                    }
                    newNode = newNode.getNext();
                    counter ++;

        }

         return null;
    }

    /**
     * Entfernen des Elements an der angegebenen Position.
     * Falls das entfernte Element das aktuelle Element ist, wird current auf null gesetzt.
     * @param pos
     */
    public void remove(int pos) {

        int counter = 1;
        Node<T> newNode = first;


        while(newNode!=null)
        {

            if (counter == pos) {
                if(current == newNode)
                    current = null;
                if(first == newNode)
                    first = newNode.getNext();
                if(last == newNode)
                    last = newNode.getPrevious();
                if(newNode.getPrevious()!=null)
                    newNode.getPrevious().setNext(newNode.getNext());
                if(newNode.getNext()!=null)
                    newNode.getNext().setPrevious(newNode.getPrevious());


            }
            newNode = newNode.getNext();
            counter ++;

        }



    }
    
    /**
     * Entfernt das aktuelle Element.
     * Als neues aktuelles Element wird der Nachfolger gesetzt oder
     * (falls kein Nachfolger) das vorhergehende Element 
     * @throws CurrentNotSetException
     */
    public void removeCurrent() throws CurrentNotSetException {

        if (current == null)
        {
            throw new CurrentNotSetException();
        }

        if(first == current)
            first = current.getNext();
        if(last == current)
            last = current.getPrevious();


        if(current.getPrevious()!=null)
            current.getPrevious().setNext(current.getNext());
        if(current.getNext()!=null)
            current.getNext().setPrevious(current.getPrevious());

        if(current.getNext()!=null)
            current = current.getNext();
        else
            current = current.getPrevious();


    }
    
    /**
     * Die Methode fügt die übergebene <T> nach der aktuellen (current) ein
     * und setzt dann die neu eingefügte <T> als aktuelle (current) <T>.
     * @throws CurrentNotSetException 
     */
    public void insertAfterCurrentAndMove(T a) throws CurrentNotSetException {


        if(current ==null)
            throw new CurrentNotSetException();

        Node<T> newNode = new Node<>(a);
        if(current == first)
            first.setNext(newNode);
        if(current == last)
            last = newNode;


        if(current.getNext()!=null) {
            current.getNext().setPrevious(newNode);
            newNode.setNext(current.getNext());
        }

        newNode.setPrevious(current);
        current.setNext(newNode);
        current = newNode;


    }
}
