import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence);
        // Complete this method. Use a Stack.
        Stack<String> bigsentences=new Stack<String>(); 
        while (scanner.hasNext())
        {
            String temp=scanner.next();
            Stack<String> sentences=new Stack<String>(); 
            sentences.push(temp);
            if(temp.contains("."))
            {
                System.out.println();
            }
        }

        return sentence;
       





    }
}
