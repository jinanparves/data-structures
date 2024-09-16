import java.text.NumberFormat.Style;
import java.util.*; 

/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> gradesMap = new HashMap<>(); 
        

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();


            if (input.equals("Q")){
                done = true;
            } 

            else if (input.equals("A")){
                System.out.println("Please enter in a name: "); 
                String givenName =  in.next(); 
                System.out.println("\nPlease enter in a grade: ");
                String givenGrade =  in.next(); 

                gradesMap.put(givenName, givenGrade); 
            } else if (input.equals("R")){
                System.out.println("Please enter in a name: "); 
                String givenName =  in.next(); 

                if (gradesMap.containsKey(givenName)){
                    gradesMap.remove(givenName); 
                }else {
                    System.out.println("That person does not exist within our system!\n");
                }
            
            } else if (input.equals("M"))
            {
                System.out.println("Please enter in a name: "); 
                String givenName =  in.next(); 

                if (gradesMap.containsKey(givenName)){
                    System.out.println("\nPlease enter in a grade: ");
                    String givenGrade =  in.next(); 

                    gradesMap.remove(givenName); 
                    gradesMap.put(givenName, givenGrade); 
                }else {
                    System.out.println("That person does not exist within our system!");
                }
                
            } else if (input.equalsIgnoreCase("P"))
            {

                ArrayList<String> sortedNameKeys = new ArrayList<String>(gradesMap.keySet()); 

                Collections.sort(sortedNameKeys); 

                for (String i : sortedNameKeys){
                    System.out.println(i + ": " + gradesMap.get(i)); 
                }
            } else
            {
                done = true;
            }
        }
    }
}
