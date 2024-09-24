import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "C:\\Users\\jsparves\\Documents\\GitHub\\data-structures\\Chapter 15 Activities\\StringLengthMap\\src\\test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here

            Map<Integer, Set<String>> wordsMap = new TreeMap<Integer, Set<String>>(); 
            

            while (in.hasNext())
            {
                String word = clean(in.next());
                Set<String> setOfWords = new HashSet<String>(); 
                setOfWords.add(word); 

                Integer len = word.length();

                // Update the map here
                // Modify Worked Example 15.1


                if (wordsMap.containsKey(len) == true){
                    Set<String> currentSet = wordsMap.get(len); 
                    currentSet.add(word); 
                    wordsMap.put(len, currentSet); 
                }else{
                    
                    wordsMap.put(len, setOfWords); 
                }

               
            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i

            for (int lengthValue  : wordsMap.keySet()){
                System.out.print(""+lengthValue+": "); 
                
                List<String> listOfWords = new ArrayList<>(wordsMap.get(lengthValue));
                 
                for (int i  = 0; i < listOfWords.size(); i++){
                  if (i == listOfWords.size()-1){
                    System.out.print(listOfWords.get(i));
                  }else{
                    System.out.print(listOfWords.get(i) + ", ");
                  }
                }
                
                System.out.println(); 
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
