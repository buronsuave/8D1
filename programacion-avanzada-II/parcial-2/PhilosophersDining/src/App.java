import static javax.swing.JOptionPane.showMessageDialog;

import Exceptions.InvalidPhilNumber;
import GUI.DFrame;
import Models.Fork;
import Models.Philosopher;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        final int n = 7;
        try
        {
            checkSetup(n);
        } catch (InvalidPhilNumber e)
        {
            showMessageDialog(null, e.getMessage());
        }
        

        final Philosopher[] philosophers = new Philosopher[n];
        Fork[] forks = new Fork[philosophers.length];
        DFrame window = new DFrame(200, 600/n, 600/n, philosophers, forks);

        Philosopher.setWindow(window);

        for (int i = 0; i < forks.length; i++) 
        {
            forks[i] = new Fork();
        }

        for (int i = 0; i < philosophers.length; i++) 
        {
            Fork lFork = forks[i];
            Fork rFork = forks[(i + 1) % forks.length];

            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rFork, lFork);
            } else {
                philosophers[i] = new Philosopher(lFork, rFork);
            }

            Thread t = new Thread(philosophers[i], "" + i);
            t.start();
        }

        window.setVisible(true);
    }

    public static void checkSetup(int n) throws InvalidPhilNumber
    {
        if (n <= 0)
        {
            throw new InvalidPhilNumber("Line 12: n must be positive. Change the value and try again");
        }
    }
    
}
