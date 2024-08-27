import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner; 

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList<String> Inventory = new LinkedList<String>(); 
        boolean gameIsRunning  = true; 
        /*The addLast method can be used to populate a list! */
        Inventory.addLast("Sword");
        Inventory.addLast("Shield");
        Inventory.addLast("Potion"); 
        Inventory.addLast("Gamora's Sword" ); 
        Inventory.addLast("Thor's Hammer");
    

        // The list is currently [Sword, Shield, Potion, Gamora's Sword, Thor's Hammer]
        // We will now create an iterator to traverse the list. 
        // The vertical line symbol (|) will represent the iterator position. 
        // 

        ListIterator<String> inventoryIterator = Inventory.listIterator(); 

        // The next method advances the iterator over the next element in the list.
        
        System.out.println(inventoryIterator.next()); // [Sword|, Shield, Potion, Gamora's Sword, Thor's Hammer] -- it returns the element that it TRAVERSED OVER! 

        /* The next method also returns the element that the iterator passes over. */
        String secondItem = inventoryIterator.next(); 
        String thirdItem = inventoryIterator.next(); 
        String fourthItem = inventoryIterator.next();

        System.out.println("The second item is: " + secondItem); // Shield
        System.out.println("The third item is: " + thirdItem); // Potion
        System.out.println("The fourth item is: " + fourthItem); // Gamora's Sword

        /*The add method inserts an element at the iterator position. 
         * The iterator position is then positioned AFTER the element that was added. 
        */

        inventoryIterator.add("Captain America's Shield"); 
        // The list is now [Sword, Shield, Potion, Gamora's Sword, Captain America's Shield, Thor's Hammer]

        /* The remove method removes the element returned by the last call to the next on previous. 
         * The remove method can ONLY be called after calling next or previous. 
         * The remove method CANNOT be called after calling add. 
         */
        
        inventoryIterator.next(); 
        inventoryIterator.remove(); // The list is now [Sword, Shield, Potion, Gamora's Sword, Thor's Hammer] 
        inventoryIterator.set("Thanos' Infinity Gauntlet"); // The list is now [Sword, Shield, Potion, Gamora's Sword, Thanos' Infinity Gauntlet, Thor's Hammer]
        
        Scanner keyboard = new Scanner(System.in); 


        /*The hasNext method is used to determine if there is a next nide after the iterator. The hasNext method is often used in the conditon of a while loop.  */

        inventoryIterator = Inventory.listIterator();

        while (inventoryIterator.hasNext()){
            String n = inventoryIterator.next(); 
            if (n.equals("Sword")){
                inventoryIterator.remove(); 
            }
        }


        /* Enhanced for loop works with linked lists */
        for (String n: Inventory){
                System.out.println(n);
        }
        
        System.out.println(); 

        /*
         * ConcurrentModificationExceeption
         * 
         * CANNOT modify a linked list while using an itreator. 
         * UNLESS you use the iterator to do the modification. 
         */

         inventoryIterator = Inventory.listIterator(); // The Inventory looks like this now: [Shield, Potion, Gamora's Sword, Thanos' Infinity Gauntlet, Thor's Hammer]

         while (inventoryIterator.hasNext()){
             String n = inventoryIterator.next(); 
             if (n.equals("Potion")){
                Inventory.remove("Potion");  // YOU CANNOT DO THIS WHILE USING AN ITERATOR! IT CAN ONLY BE DONe USING THE LIST ITSELF! 
             }
         }

         /* The enhanced for loop AUTOMATICALLY creates an iterator. */

         for (String n: Inventory){
            if (n.equals("Gamora's Sword")){
                Inventory.remove("Gamora's Sword");
            }
         }


        System.out.println("Welcome to the Adventure Game!");

        while (gameIsRunning){
            System.out.println("You are carrying: ");

            for (String i : Inventory){
                System.out.println(i);
            }

            System.out.println("Would you like to run again (y/n)?");
            String response = keyboard.nextLine(); 

            if (response.equals("n")){
                System.out.print("You are done running!");
                gameIsRunning = false;
            }else if (response.equals("y")){
                System.out.println("You are running again!");
            }
        }
    }
}
