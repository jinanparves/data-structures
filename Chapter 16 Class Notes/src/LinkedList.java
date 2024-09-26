import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList{
    private Node first; 

    /**
        Constructs an empty linked list.
    */

    public LinkedList() {
        /*
         * first refers to the first Node in the list 
         * If the list is empty, first will be null 
         */

         this.first = null; 
         


        

    }

    



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */

    public Object getFirst(){
        if (this.first == null){
            throw new NoSuchElementException(); 
        }
        return this.first.data; 
    }


    /**
        Removes the first element in the linked list.
        @return the removed element
    */

    public Object removeFirst(){
        if (this.first == null){
            throw new NoSuchElementException(); 
        }

        Object element = this.first.data; 
        this.first = this.first.next; 
        return element; 
    }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */

    public void addFirst(Object element){
        
        Node newElement = new Node(); 
        newElement.data = element; 
        newElement.next = this.first; 
        this.first = newElement; 

    }





    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */





    //Class Node
    // Node is static because it does NOT need access to anything in LinkedList

  


    static class Node{
        public Node next; 
        public Object data; 
    }

    class LinkedListIterator  //implements ListIterator
    {
      //private data


        /**
            Constructs an iterator that points to the front
            of the linked list.
        */


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */





        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */







        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */




    }//LinkedListIterator
}//LinkedList
