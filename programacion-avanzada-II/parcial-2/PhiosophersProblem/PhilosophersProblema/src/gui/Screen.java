package gui;

import javax.swing.JFrame;

import models.Chopstick;
import models.Philosopher;

import java.awt.Color;
import java.awt.Graphics;

public class Screen extends JFrame
{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Philosopher philosophers[];
    private Chopstick chopsticks[];

    public Screen(Philosopher philosophers[], Chopstick chopsticks[])
    {
        super("Philosophers Dinner Problem");
        this.philosophers = philosophers;
        this.chopsticks = chopsticks;
        init();
    }

    public void init()
    {
        setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        // Draw table
        g.setColor(new Color(155, 103, 60));
        g.fillOval(WIDTH/2, HEIGHT/2, 100, 100);

        // Draw philosophers
        for (int i = 0; i < philosophers.length; i++)
        {   
            philosophers[i].paint(g);
        }

        // Draw chopsticks
        for (int i = 0; i < chopsticks.length; i++)
        {
            chopsticks[i].paint(g);
        }
    }
}
