package Models;

import GUI.DFrame;

public class Philosopher implements Runnable {

    private Fork lfork;
    private Fork rfork;
    private int forkCount;
    private boolean isHungry;
    private static DFrame window;

    public Philosopher(Fork lfork, Fork rfork) {
        this.lfork = lfork;
        this.rfork = rfork;
        this.isHungry = true;
    }

    public static void setWindow(DFrame frame)
    {
        window = frame;
    }

    public boolean isHungry() 
    {
        return isHungry;
    }

    public void setHungry(boolean isHungry) 
    {
        this.isHungry = isHungry;
    }

    public int getForkCount()
    {
        return forkCount;
    }

    @Override
    public void run() 
    {
        try 
        {
            while (true) 
            {
                Thread.sleep(((int) (Math.random() * 1000 + 1000)));
                forkCount = 0;
                isHungry = true;
                window.repaint();
                synchronized (lfork) 
                {
                    lfork.setAvailable(false);
                    forkCount = 1;
                    window.repaint();
                    synchronized (rfork) 
                    {
                        rfork.setAvailable(false);
                        forkCount = 2;
                        window.repaint();
                        Thread.sleep(((int) (Math.random() * 4000 + 2000)));

                        rfork.setAvailable(true);
                        forkCount = 0;
                        isHungry = false;
                    }
                    lfork.setAvailable(true);
                    window.repaint();
                    Thread.sleep(((int) (Math.random() * 4000 + 2000)));
                }
            }
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
            return;
        }
    }

}
