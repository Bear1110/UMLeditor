package Interface;

import java.awt.Graphics;

import javax.swing.JButton;

public abstract class objectRule extends JButton{
    public int id;
    public int depth = 0;
    protected int x;
    protected int y;
    
    public objectRule(int id, int x, int y) {
        super();
        this.id = id;
        this.x = x;
        this.y = y;
    }    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawInside(g);
     }
    
    public abstract void drawInside(Graphics g);
}
