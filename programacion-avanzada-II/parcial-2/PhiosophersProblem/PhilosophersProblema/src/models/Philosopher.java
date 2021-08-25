package models;

import java.awt.Graphics;
import java.awt.Color;

public class Philosopher 
{
    private int x;
    private int y;
    private int r;
    private Color c;
    
    public Philosopher(int x, int y, int r, Color c)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
    }

    public void paint(Graphics g)
    {
        g.setColor(c);
        g.fillOval(x, y, r, r);
    }   
}
