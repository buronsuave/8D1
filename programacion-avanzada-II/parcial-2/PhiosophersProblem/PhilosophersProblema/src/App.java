import models.Chopstick;
import models.Philosopher;

import java.awt.Color;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        int n = 5;
        Philosopher philosophers[] = new Philosopher[n];
        Chopstick chopsticks[] = new Chopstick[n];

        int x = 50;
        int y = 200;
        int angle = 0; 

        int r = 20;
        int l = 20;
        Color c1 = new Color(90, 130, 130);
        Color c2 = new Color(170, 60, 30);

        for (int i = 0; i < n; i++)
        {
            Philosopher philosopher = new Philosopher(x, y, r, c1);
            philosophers[i] = philosopher;
            
        }

        System.out.println("Hello, World!");
    }
}
