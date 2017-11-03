package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Main.MainWindow;

public abstract class objectRule extends JButton implements MouseListener{
    public int id;
    public int depth = 0;
    private static boolean press = false;
    protected int x;
    protected int y;
    public abstract void drawInside(Graphics g);
    
    public objectRule(int id, int x, int y) {
        super();
        addMouseListener(this);
        this.id = id;
        this.x = x;
        this.y = y;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        drawInside(g);
     }
    public void mousePresse() {
        MainWindow.objectPress = this;
        System.out.println(id+"Press");
    }
    public void mouseEnter() {
        MainWindow.objectRelease = this;
        System.out.println(id+"Enter");
    }
    public void mouseRelease() {
        System.out.println(id+"Release");
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        press = true;
        mousePresse();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        mouseRelease();
        press = false;
        MainWindow.main.nowMode.afterDrag();
    }
    @Override
    public void mouseClicked(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e) {
        if(!press)
            return;
        mouseEnter();
    }
    @Override
    public void mouseExited(MouseEvent e) {}
}
