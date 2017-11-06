package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

import Main.MainWindow;
import Object.GroupComposite;

public abstract class objectRule extends JButton implements MouseListener , MouseMotionListener {
    private static final long serialVersionUID = 1L;
    private static boolean press = false;
    private Timer timer;
    public GroupComposite groupFather;
    
    public int id,x,y,width,heigh,depth = 0;
    public int[][] directionCoordinate = new int[4][2];
    public boolean selected = false;
    
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
        
        TimerTask repeatRepaint= new TimerTask(){//也可以用匿名類別的方式，
            @Override
            public void run() {
                repaint();
            }   
        };
        timer = new Timer();
        timer.schedule(repeatRepaint,100,500);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        drawInside(g);
        if(MainWindow.nowMode.getClass().equals(Button.Select.class) && selected)
                drawConnectionPort(g);
     }
    
    private void drawConnectionPort(Graphics g){
        int recrWidth = 10;
        g.fillRect(directionCoordinate[0][0]-recrWidth/2,directionCoordinate[0][1],recrWidth,recrWidth);
        g.fillRect(directionCoordinate[1][0]-recrWidth,directionCoordinate[1][1]-recrWidth/2,recrWidth,recrWidth);
        g.fillRect(directionCoordinate[2][0]-recrWidth/2,directionCoordinate[2][1]-recrWidth,recrWidth,recrWidth);
        g.fillRect(directionCoordinate[3][0],directionCoordinate[3][1]-recrWidth/2,recrWidth,recrWidth);
    }
    
    public void mousePresse(int x , int y) {
        MainWindow.objectPress = this;
        connectionPort = whichDirection(x,y);
    }
    public void mouseEnter(int x , int y) {
        MainWindow.objectRelease = this;
        connectionPort = whichDirection(x,y);
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
    
    public void mousePressed(MouseEvent e) {
        press = true;
        mousePresse(e.getX(),e.getY());
    }
    public void mouseReleased(MouseEvent e) {
        press = false;
        MainWindow.nowMode.afterDragForObject();
    }
    
    public void mouseEntered(MouseEvent e) {
        if(!press)
            return;
        mouseEnter(e.getX(),e.getY());
    }
    public void mouseClicked(MouseEvent e){
        if(MainWindow.nowMode.getClass().equals(Button.Select.class)){
            MainWindow.selectedObjects = new ArrayList<objectRule>();
            for(objectRule o : MainWindow.objects)
                o.selected = false;
            if(groupFather != null){
                groupFather.selectedAll();
            }else
                selected = true;
        }
    }
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
    
}
