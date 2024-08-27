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
    

        Scanner keyboard = new Scanner(System.in); 


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
