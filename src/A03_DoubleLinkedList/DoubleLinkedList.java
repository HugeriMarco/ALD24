package A03_DoubleLinkedList;

public class DoubleLinkedList<T>
{
    private Node<T> first;
    private Node<T> last;
    private int counter = 0;
    private Node<T> current;

    /**
     * Einfügen einer neuen <T>
     * @param a <T>
     */
    public void add(T a) {

        Node<T> newNode = new Node<>(a);

        if (counter == 0)
            first = newNode;

        else {
            last.setNext(newNode);
            newNode.setPrevious(last);
        }


        last = newNode;
        counter++;




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

        if(first == null)
            return null;
        else
            return first;


    }
    
    /**
     * Liefert letzte Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getLast() {

        if(last == null)
            return null;
        else
            return last;
    }
    
    /**
     * Gibt aktuelle <T> zurück und setzt internen Zeiger weiter.
     * Falls current nicht gesetzt, wird null retourniert.
     * @return <T>|null
     */
    public T next() {


        Node<T> newNode;

        if(current==null)
        {
            return null;
        }
        else
        {

            newNode = current;
            current = current.getNext();

            return newNode.getData();

        }



    }

    /**
     * analog zur Funktion next()
     * @return <T>|null
     */
    public T previous() {

        Node<T> newNode2;

        if(current==null)
        {
            return null;
        }
        else
        {

            newNode2 = current;
            current = current.getPrevious();

            return newNode2.getData();



       }


    }
    
    /**
     * Current-Pointer auf nächste <T> setzen (aber nicht auslesen).
     * Ignoriert still, dass current nicht gesetzt ist.
     */
    public void moveNext() {

        if(current== null) {

        }
        else
            current = current.getNext();

    }
    
    /**
     * Analog zur Funktion moveNext()
     */
    public void movePrevious() {

        if(current== null) {

        }
        else
            current = current.getPrevious();

    }
   
    /**
     * Retourniert aktuelle (current) <T>, ohne Zeiger zu ändern
     * @return <T>
     * @throws CurrentNotSetException
     */
    public T getCurrent() throws CurrentNotSetException {

        if(current == null)
            throw new CurrentNotSetException();
        else
            return current.getData();
    }

    /**
     * Gibt <T> an bestimmter Position zurück
     * @param pos Position, Nummerierung startet mit 1
     * @return <T>|null
     */
    public T get(int pos) {

        Node<T> newNode = first;
        for (int i = 1; i < pos; i++) {

            newNode = newNode.getNext();

            
        }
        return newNode.getData();
    }

    /**
     * Entfernen des Elements an der angegebenen Position.
     * Falls das entfernte Element das aktuelle Element ist, wird current auf null gesetzt.
     * @param pos
     */
    public void remove(int pos) throws IndexOutOfBoundsException{

//        Node<T> newNode = first;
//
//        for (int i = 1; i < pos; i++) {
//
//            newNode = newNode.getNext();
//
//
//
//        }
//        if(newNode == current)
//            current = null;
//
//        if(newNode.getPrevious()!=null && newNode.getNext()!=null) {
//            newNode.getPrevious().setNext(newNode.getNext());
//            newNode.getNext().setPrevious(newNode.getPrevious());
//        } else if (newNode.getPrevious()==null && newNode.getNext()!=null) {
//            newNode.getNext().setPrevious(null);
//            first = newNode.getNext();
//        } else {
//            newNode.getPrevious().setNext(null);
//            last = newNode.getPrevious();
//        }
//



        if (pos <= 0 || first == null) {
            throw new IndexOutOfBoundsException("Invalid position or empty list.");
        }

        Node<T> newNode = first;


        for (int i = 1; i < pos; i++) {
            if (newNode.getNext() == null) {
                throw new IndexOutOfBoundsException("Position out of bounds.");
            }
            newNode = newNode.getNext();
        }


        if (newNode == current) {
            current = null;
        }


        if (newNode.getPrevious() != null) {
            newNode.getPrevious().setNext(newNode.getNext());
        } else {

            first = newNode.getNext();
        }

        if (newNode.getNext() != null) {
            newNode.getNext().setPrevious(newNode.getPrevious());
        } else {

            last = newNode.getPrevious();
        }
    }


    
    /**
     * Entfernt das aktuelle Element.
     * Als neues aktuelles Element wird der Nachfolger gesetzt oder
     * (falls kein Nachfolger) das vorhergehende Element 
     * @throws CurrentNotSetException
     */
    public void removeCurrent() throws CurrentNotSetException {

        if(current== null)
            throw new CurrentNotSetException();

        if(current.getPrevious()!=null && current.getNext()!=null) {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        } else if (current.getPrevious()==null && current.getNext()!=null) {
            current.getNext().setPrevious(null);
            first = current.getNext();
        } else {
            current.getPrevious().setNext(null);
            last = current.getPrevious();
        }




        if(current.getNext() ==null)
            current = current.getPrevious();
        else
            current = current.getNext();







    }
    
    /**
     * Die Methode fügt die übergebene <T> nach der aktuellen (current) ein
     * und setzt dann die neu eingefügte <T> als aktuelle (current) <T>.
     * @throws CurrentNotSetException 
     */
    public void insertAfterCurrentAndMove(T a) throws CurrentNotSetException {

        Node<T> newNode = new Node<>(a);


        if (current == null)
            throw new CurrentNotSetException();

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        if (newNode.getNext() != null) {
            newNode.getNext().setPrevious(newNode);
        }
        newNode.setPrevious(current);

        current = newNode;



    }
}
