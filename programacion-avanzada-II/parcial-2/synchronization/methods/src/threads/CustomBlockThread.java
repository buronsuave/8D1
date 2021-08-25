package threads;

import utils.ArrayBlockOperations;

public class CustomBlockThread implements Runnable
{
    private Thread thread;
    private static ArrayBlockOperations operations = new ArrayBlockOperations();
    private int array[];

    public CustomBlockThread(String name, int array[])
    {
        thread = new Thread(this, name);
        this.array = array;
    }

    public static CustomBlockThread buildAndInit(String name, int array[])
    {
        CustomBlockThread customThread = new CustomBlockThread(name, array);
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
