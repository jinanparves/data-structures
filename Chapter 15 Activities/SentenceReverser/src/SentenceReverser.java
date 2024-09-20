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

        Stack<String> sentenceStack =new Stack<String>(); 
        String newSentence = new String(""); 

        while (scanner.hasNext())
        {
            String temp = scanner.next();
            sentenceStack.push(temp);

            if(temp.contains("."))
            {
                for (int i  = 0; i < sentenceStack.size();){
                    String stackWord = sentenceStack.pop(); 
                   
                    if (stackWord.substring(stackWord.length()-1).equals(".")){
                        stackWord = stackWord.substring(0, stackWord.length()-1);
                        stackWord = stackWord.substring(0,1).toUpperCase() + stackWord.substring(1);  
                    }

                    if (i == sentenceStack.size()){
                        stackWord = stackWord.substring(0,1).toLowerCase() + stackWord.substring(1);  
                        stackWord = stackWord + ".";
                    }


                    newSentence = newSentence + " " + stackWord;  
                }

                sentenceStack.clear(); 
            }
        }

        return newSentence;
       





    }
}
