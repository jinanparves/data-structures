import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // Create a print queue of strings (using a linked list)
        Queue<String> jobs = new LinkedList<String>(); 

        // Add some print jobs
        jobs.add("Joe: Quarter 2 Expense Report"); 
        jobs.add("Cathy: Top Secret Document");
        jobs.add("Mitch: Developer Toolkit");
        
        System.out.println("Printing: "+jobs.remove()); // This will print Joe's print report
        
        // Add some more jobs 
        jobs.add("Cathy: Really Top Secret Document"); 
        jobs.add("Joe: Grocery List"); 
        jobs.add("Cathy: Can I Get Fired For This?"); 

        System.out.println("Printing:"  + jobs.remove()); // This will print Cathy's Top Secret Document report     

        jobs.add("Boss: Cathy Termination Letter"); 

        // Print the rest of the jobs in the queue: 

        while (jobs.size() > 0) {
            System.out.println(jobs.remove()); // This line will make sure that everything gets printed out at the end of the program! 
        }
    }
}
