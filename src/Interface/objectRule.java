package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import Main.MainWindow;

public abstract class objectRule extends JButton implements MouseListener , MouseMotionListener {
    private static final long serialVersionUID = 1L;
    private static boolean press = false;
    
    public int id,x,y,width,heigh,depth = 0;
    public int[][] directionCoordinate = new int[4][2];
    
    public int connectionPort = 0;
    
    public abstract void drawInside(Graphics g);    
    
    public objectRule(int id, int x, int y,int width, int heigh, Insets insets) {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigh = heigh;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setBounds(x + insets.left, y + insets.top,width,heigh);
        directionCoordinate[0][0] = width / 2; //北
        directionCoordinate[1][0] = width;     //東
        directionCoordinate[1][1] = heigh / 2;
        directionCoordinate[2][0] = width / 2; //南
        directionCoordinate[2][1] = heigh;
        directionCoordinate[3][1] = heigh / 2; //西        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        drawInside(g);
     }
    public void mousePresse(int x , int y) {
        MainWindow.objectPress = this;
        connectionPort = whichDirection(x,y);
        System.out.println("mousePresse"+connectionPort);
    }
    public void mouseEnter(int x , int y) {
        MainWindow.objectRelease = this;
        connectionPort = whichDirection(x,y);
        System.out.println("mouseEnter"+connectionPort);
    }
    private int whichDirection(int x, int y){
        int distance = 9999999;
        int port = 0;
        for(int i = 0 ; i < 4 ;i++){
            int xx = (x-directionCoordinate[i][0]);
            int yy = (y-directionCoordinate[i][1]);
            int d = xx*xx + yy*yy;
            if(d <  distance){
                distance = d;
                port = i;
            }
        }
        return port;
    }
    public void mouseRelease() {
    }
    
    public void mousePressed(MouseEvent e) {
        press = true;
        mousePresse(e.getX(),e.getY());
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
        mouseEnter(e.getX(),e.getY());
    }
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e){
    }
    public void mouseMoved(MouseEvent e){
    }
    
}
