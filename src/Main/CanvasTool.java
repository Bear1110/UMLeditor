package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import Interface.Line;
import Interface.objectRule;


public class CanvasTool extends JPanel{
    private static final long serialVersionUID = 1L;
    
    public ArrayList<Line> lines = new ArrayList<Line>();
    private Timer timer;
    
    MainWindow m;
    public CanvasTool(MainWindow m){
        super();
        setBackground(new Color(35, 37, 37));
        addMouseListener(new canvasMouseEvent());
        addMouseMotionListener(new canvasMouseEvent());
        setLayout(null);
        this.m = m;
        
        TimerTask repeatRepaint= new TimerTask(){//也可以用匿名類別的方式，
            @Override
            public void run() {
                repaint();
            }   
        };
        timer = new Timer();
        timer.schedule(repeatRepaint,100,500);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        for(Line o : lines){
            g.setColor(Color.WHITE);
            g.drawLine(
                    o.from.x+o.from.directionCoordinate[o.fromPort][0],
                    o.from.y+o.from.directionCoordinate[o.fromPort][1],
                    o.to.x+o.to.directionCoordinate[o.toPort][0],
                    o.to.y+o.to.directionCoordinate[o.toPort][1]                    
                    );
            o.drawLine(g);
        }
    }
    
    
    
    
    class canvasMouseEvent extends MouseAdapter{
        
        public void mouseClicked(MouseEvent e) {
            if(m.nowMode==null)
                return;
            m.nowMode.clickOnCavans(e.getX(),e.getY());
            repaint();            
        }
        
        public void mousePressed(MouseEvent e) {
            if(m.nowMode==null)
                return;
            m.nowMode.pressOnCavans(e.getX(), e.getY());
        }

        public void mouseReleased(MouseEvent e) {
            if(m.nowMode==null)
                return;
            m.nowMode.releaseOnCavans(e.getX(), e.getY(),m);
        }
        
        public void mouseDragged(MouseEvent e) {
            
        }
    }
}
