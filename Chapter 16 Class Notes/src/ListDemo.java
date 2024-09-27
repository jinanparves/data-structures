/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList students = new LinkedList(); 

        students.addFirst("Arthur");
        students.addFirst("Michael");
        students.addFirst("Mitch");
        students.addFirst("Jinan");


        System.out.println(students); 
    }
}
