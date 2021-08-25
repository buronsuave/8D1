package threads;

import utils.ArrayOperations;

public class CustomThread implements Runnable
{
    private Thread thread;
    private static ArrayOperations operations = new ArrayOperations();
    private int array[];

    public CustomThread(String name, int array[])
    {
        thread = new Thread(this, name);
        this.array = array;
    }

    public static CustomThread buildAndInit(String name, int array[])
    {
        CustomThread customThread = new CustomThread(name, array);
        customThread.getThread().start();
        return customThread;
    }

    public Thread getThread()
    {
        return this.thread;
    }

    @Override
    public void run() 
    {
        operations.sumArrray(array);
    }       
}
