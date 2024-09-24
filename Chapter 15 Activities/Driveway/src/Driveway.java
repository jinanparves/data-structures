import java.util.Stack;
//import java.util.Scanner;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{
    /**
      * Stack representing the cars in the driveway.
    */
    private Stack<Integer> driveway;
    /**
      * Stack representing the cars in the street.
    */
    private Stack<Integer> street;

    /**
      * Constructor.
    */
    public Driveway()
    {
        // Complete the constructor
        driveway = new Stack<Integer>(); 
        street = new Stack<Integer>(); 

    }

    /**
      * Add the given license plate to the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void add(int licensePlate)
    {
        // Complete this method

        if (driveway.contains(licensePlate) || street.contains(licensePlate)){
          System.out.println("The car is already in either street or driveway! Duplicate!");
        }else{
          driveway.push(licensePlate); 
        }

      print(); 
    }

    /**
      * Remove the given license plate from the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void remove(int licensePlate){
      // Complete this method

      if (driveway.contains(licensePlate)){

       while (!driveway.isEmpty()){
          int license = driveway.peek(); 
          if (license == licensePlate){
            street.push(driveway.pop()); 
            break; 
          }else{
            street.push(driveway.pop()); 
          }
        }

      }else{
        System.out.println("The license plate is not in the driveway!");
      }
      
      print(); 
    }

    /**
      * Prints the driveway and street details to the screen.
    */
    public void print()
    {
        System.out.println("In Driveway, starting at first in (one license plate per line):");
     
        // Print the cars in the driveway here
        for (int car : driveway){
          System.out.println(car);
        }

        System.out.println("In Street, starting at first in (one license plate per line):");

        // Print the cars in the street here
        for (int car : street){
          System.out.println(car);
        }    
      }
}
