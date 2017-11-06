package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import Interface.Line;
import Interface.objectRule;


public class CanvasTool extends JPanel{
    private static final long serialVersionUID = 1L;
    
    public ArrayList<Line> lines = new ArrayList<Line>();
    
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
        for(Line o : lines){
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
            Main.MainWindow.objectClicked = null;
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
