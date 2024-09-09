import java.util.*; 


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        
        Set<Integer> setOfNumbers = new HashSet<Integer>(); 

        for (int i = 2; i < n; i++){
            setOfNumbers.add(i); // We're adding multiples of two into the set 
        }

        for (int i = 2; i < n; i++){
            Iterator<Integer> iterator = setOfNumbers.iterator(); 

            while (iterator.hasNext()){
                int nextNumber = iterator.next(); 

                if (nextNumber%i == 0 && nextNumber!=i){
                    iterator.remove(); 
                }
            }            
        }

        System.out.println(setOfNumbers); 
    }
}
