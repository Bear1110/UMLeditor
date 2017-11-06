package Object;

import java.awt.Graphics;
import java.awt.Insets;

import Interface.objectRule;

public class classObject extends objectRule{
    private static final long serialVersionUID = 1L;
    
    public classObject(int id, int x, int y,Insets insets){
        super(id, x, y);
        width = 101;
        heigh = 151;
        setBounds(x + insets.left, y + insets.top,width,heigh);
    }

    @Override
    public void drawInside(Graphics g) {
        
        for(int j = 0 ; j < 3 ; j++)
            g.drawRect(0,50*j, 100, 50);
    }
}
