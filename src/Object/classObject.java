package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface.objectRule;

public class classObject extends objectRule{
    
    
    public classObject(int id, int x, int y,Insets insets){
        super(id, x, y);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setBounds(x + insets.left, y + insets.top,101,151);
        this.addActionListener(new ActionHandler());
    }    
    
    class ActionHandler implements ActionListener {
        public ActionHandler() {
        }
        public void actionPerformed(ActionEvent e) {
          System.out.println("classObject click"+id);
        }
    }

    @Override
    public void drawInside(Graphics g) {
        g.setColor(Color.WHITE);
        for(int j = 0 ; j < 3 ; j++)
            g.drawRect(0,50*j, 100, 50);
    }
    
}
