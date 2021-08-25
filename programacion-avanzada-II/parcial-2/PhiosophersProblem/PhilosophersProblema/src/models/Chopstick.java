package models;

import java.awt.Graphics;
import java.awt.Color;

public class Chopstick 
{
    private int x;
    private int y;
    private int l;
    private double a;
    private Color c;

    public void paint(Graphics g)
    {
        g.setColor(c);        
        g.drawLine(x, y, (int) (x+l*Math.cos(a)), (int) (y+l*Math.sin(a)));
    }
}
