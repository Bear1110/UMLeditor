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
        this.m = m;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        //for(objectRule o : m.objects){}
        System.out.println("paintComponent");
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
