package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


public class CanvasTool extends JPanel{
    MainWindow m;
    public CanvasTool(MainWindow m){
        super();
        setBackground(new Color(35, 37, 37));
        addMouseListener(new canvasMouseEvent());
        setLayout(null);
        this.m = m;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        //for(objectRule o : m.objects){}
        //System.out.println("paintComponent");
    }
    
    
    
    
    class canvasMouseEvent extends MouseAdapter{
        
        public void mouseClicked(MouseEvent e) {
            if(m.nowMode==null)
                return;
            m.nowMode.clickOnCavans(e.getX(),e.getY());
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
