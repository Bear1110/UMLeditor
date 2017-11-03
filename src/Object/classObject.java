package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;

import Interface.objectRule;

public class classObject extends objectRule{    
    
    public classObject(int id, int x, int y,Insets insets){
        super(id, x, y);
        setBounds(x + insets.left, y + insets.top,101,151);
    }

    @Override
    public void drawInside(Graphics g) {
        
        for(int j = 0 ; j < 3 ; j++)
            g.drawRect(0,50*j, 100, 50);
    }
}
