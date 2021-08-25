package GUI;

import javax.swing.JFrame;

import Models.Fork;
import Models.Philosopher;

import java.awt.Color;
import java.awt.Graphics;

public class DFrame extends JFrame  {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1200;
    
    private Philosopher philosophers[];
    private Fork forks[];

    private int R, rx, ry;

    public DFrame(int R,  int rx, int ry, Philosopher[] philosophers, Fork[] forks) {
        super();
        this.philosophers = philosophers;
        this.forks = forks;
        init(R, rx, ry);
    }

    private void init(int R, int rx, int ry) {
        this.setTitle("Dinner");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black);

        this.R = R;
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < philosophers.length; i++)
        {
            if (philosophers[i].getForkCount() == 2)
            {
                g.setColor(Color.green);
            } 
            else if (philosophers[i].getForkCount() == 1)
            {
                g.setColor(Color.orange);
            }
            else if (philosophers[i].isHungry())
            {
                g.setColor(Color.gray);
            }    
            else 
            {
                g.setColor(Color.white);
            }

            g.fillOval(WIDTH/2 + (int) (R*Math.cos(2*i*Math.PI/philosophers.length)), HEIGHT/2 + (int) (R*Math.sin(2*i*Math.PI/philosophers.length)) , rx, ry);
        }

        g.setColor(Color.red);
        for (int i = 0; i < forks.length; i++)
        {
            if (forks[i].isAvailable())
            {
                g.fillOval(WIDTH/2 + (int) (R*Math.cos((2*i-1)*Math.PI/philosophers.length)) + rx/2 , HEIGHT/2 + (int) (R*Math.sin((2*i-1)*Math.PI/philosophers.length)) + ry/2, 10, 10);
            }
        }
    }
}
