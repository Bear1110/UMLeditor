package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import Main.MainWindow;

public abstract class objectRule extends JButton implements MouseListener , MouseMotionListener {
    private static final long serialVersionUID = 1L;
    
    public int id,x,y,width,heigh;
    public int depth = 0;
    private static boolean press = false;
    public abstract void drawInside(Graphics g);
    
    public objectRule(int id, int x, int y) {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
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
    }
    public void mouseEnter() {
        MainWindow.objectRelease = this;
    }
    public void mouseRelease() {
    }
    
    public void mousePressed(MouseEvent e) {
        press = true;
        mousePresse();
    }
    public void mouseReleased(MouseEvent e) {
        mouseRelease();
        press = false;
        MainWindow.main.nowMode.afterDrag();
    }
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e) {
        if(!press)
            return;
        mouseEnter();
    }
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e){
        int[][] directionCoordinate = {{width/2,0},{width,heigh/2},{width/2,heigh},{0,heigh/2}};
        String[] direction = {"N","E","S","W"};
        int j = 0;
        int distance = 9999999;
        for(int i = 0 ; i < 4 ;i++){
            int xx = (e.getX()-directionCoordinate[i][0]);
            int yy = (e.getY()-directionCoordinate[i][1]);
            int d = xx*xx + yy*yy;
            if(d <  distance){
                distance = d;
                j = i;
            }
        }
        System.out.println(direction[j]);        
    }
}
