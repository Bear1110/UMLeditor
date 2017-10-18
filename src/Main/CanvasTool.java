package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import Interface.objectRule;


public class CanvasTool extends Canvas{
    MainWindow m;
    public CanvasTool(MainWindow m){
        setBackground(new Color(35, 37, 37));
        addMouseListener(new canvasMouseEvent());
        this.m = m;
    }
    
    public void paint(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Ellipse2D.Double(10, 10, 150, 150));
        
        g.setColor(Color.WHITE);
        //for(objectRule o : m.objects){}
        for(int i = 0 ; i < m.objects.size() ; i++){
            g.drawRect(i*100+10, 10, 200, 200);
        }
        System.out.println("paint");
    }
    
    
    class canvasMouseEvent extends MouseAdapter{
        
        public void mouseClicked(MouseEvent e) {
            m.nowMode.clickOnCavans();
            repaint();
        }
        
        public void mousePressed(MouseEvent e) {
            
        }

        public void mouseReleased(MouseEvent e) {
        }
        
        public void mouseDragged(MouseEvent e) {
        }
        
    }
}
