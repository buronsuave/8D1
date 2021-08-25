import threads.CustomBlockThread;
import threads.CustomThread;

public class App {
    public static void main(String[] args)
    {
        int array[] = { 1, 2, 3, 4, 5 };

        System.out.println("\nSynchronized by method\n");
        CustomThread threadC = CustomThread.buildAndInit("C", array);
        CustomThread threadD = CustomThread.buildAndInit("D", array);

        try 
        {
            threadC.getThread().join();
            threadD.getThread().join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Main Thread has been interrupted");
        }

        System.out.println("\nSynchronized by block code\n");
        CustomBlockThread threadA = CustomBlockThread.buildAndInit("A", array);
        CustomBlockThread threadB = CustomBlockThread.buildAndInit("B", array);

        try 
        {
            threadA.getThread().join();
            threadB.getThread().join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Main Thread has been interrupted");
        }
        
        System.out.println();
    }
}


        


