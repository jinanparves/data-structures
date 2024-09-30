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
            Returns an integer that represents the size of the LinkedList. Implemented by directly traversing the links, not using an iterator.
        */

        public int size(){
            int size = 0; 
            Object currentNode = this.getFirst(); 

            while (currentNode != null){
                size++; 
                this.first = this.first.next; 
            }

            return size; 
        }

        /**
            Returns an integer that represents the size of the LinkedList. Implemented by recursively traversing the links, not using an iterator.
            @param start the firstNode in the LinkedList 
        */

        public int size(Node start){
            if (start == null){
                return 0; 
            }else{
                return 1 + size(start.next);
            }
        }


     /**
            Returns a boolean true/false that checks if the LinkedList has the given object. Implemented by directly traversing the links, and not using an iterator. 
            @param obj the Object to check in the LinkedList
        */

        public boolean contains(Object obj){
            boolean doesContain = false; 
            Object currentNode = this.getFirst(); 

            while (currentNode != null){
                if (currentNode.equals(obj)){
                    doesContain  = true; 
                    break; 
                }
                this.first = this.first.next; 
            }


            return doesContain; 
        }


        /**
            Returns a boolean true/false that checks if the LinkedList has the given object. Implemented by recursively traversing the links. 
            @param start the first Node in the LinkedList  
            @param obj the Object to check in the LinkedList
        */

        private static boolean contains(Node start, Object obj){
            if (start.equals(obj)){
                return true; 
            } else if (start.equals(null)){
                return false; 
            }else {
                return contains(start.next, obj); 
            }
        }
 

    public String toString(){
        String toReturn = new String(""); 
        LinkedListIterator it1 = new LinkedListIterator(); 

        while (it1.hasNext()){
            it1.next();
            toReturn = toReturn + " " + it1.position.data; 
        }

        return toReturn; 
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
        private Node position; 
        private Node previous; 
        private boolean isAfterNext; 

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */

        public LinkedListIterator(){
            position = null; 
            previous = null;  
            isAfterNext = false; 
        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next(){
            if (!hasNext()){
                throw new NoSuchElementException(); 
            }

            previous = position; 

            if (position == null){
                // We know that we are the beginning of the list 
                position = first; 

            }else {
                position = position.next; 
            }

            isAfterNext = true; 
            return previous; 
        }

        

    
        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext(){
            // Check if the list is empty 
            if (position == null){
                // this means that the list MIGHT be empty 
                return first != null; // if first is null, it removes falls. If it is null, then it is empty. This means that we have something. 
            }else{

            }

            // The iterator has moved 
            return position.next != null; 
        }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */

        public void add(Object element){
            // Check if the iterator is at the beginning 

            if (position == null){
                // this means we want to ADD to the beginning of the list 
                addFirst(element);
                position = first; 
            }else { // there is a position associated with it ! 
                Node newNode = new Node(); 
                newNode.data = element; 
                newNode.next = position.next;
                
                
                // Set the next element of the CURRENT position to point to our new node 
                
                position.next = newNode; 
                position = newNode; 
            }

            isAfterNext = false; 
        }
        

        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */

        public void remove(){
            // You can ONLY call it after you've called the NEXT method. Otherwise, it'll give us an exception! 
            if (isAfterNext == false){
                throw new IllegalStateException(); 
            }

            // We're going to check if the iterator is at the beginning 
            if (position == first){
                removeFirst(); 
                position = null; 
            }else{
                previous.next = position.next; 
                position = previous; 
            }

            isAfterNext = false; 
        }

        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */

        public void set(Object element){
            if (!isAfterNext){
                throw new IllegalStateException();
            }

            position.data = element; 
        }

   

       

    }//LinkedListIterator
}//LinkedList
