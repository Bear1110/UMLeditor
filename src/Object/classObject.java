package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface.objectRule;

public class classObject extends objectRule{
    
    
    public classObject(int id){
        super(id);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setSize(120, 170);
        this.addActionListener(new ActionHandler());
    }    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawRect(g);
     }
    
    private void drawRect(Graphics g){
        g.setColor(Color.WHITE);
        for(int j = 0 ; j < 3 ; j++)
            g.drawRect(0,50*j, 100, 50);
    }
    
    class ActionHandler implements ActionListener {
        public ActionHandler() {
        }
        public void actionPerformed(ActionEvent e) {
          System.out.println("classObject click"+id);
        }
    }
    
}
