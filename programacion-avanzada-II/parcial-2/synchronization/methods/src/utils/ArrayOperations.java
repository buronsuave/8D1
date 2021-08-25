package utils;

public class ArrayOperations 
{
    private int sum;

    public synchronized void sumArrray(int array[]) 
    {
        System.out.println(Thread.currentThread().getName() + " is starting");
        sum = 0;
        for (int i = 0; i < array.length; i++) 
        {
            sum += array[i];
            System.out.println("Total in thread " + Thread.currentThread().getName() + ": " + sum);
        }
        try 
        {
            Thread.sleep(10);
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Interrupted Thread");
        }

        System.out.println("Sum for " + Thread.currentThread().getName() + ": " + sum);
        System.out.println(Thread.currentThread().getName() + " ended");
    }
}
