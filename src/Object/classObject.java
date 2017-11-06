package Object;

import java.awt.Graphics;
import java.awt.Insets;

import Interface.objectRule;

public class classObject extends objectRule{
    private static final long serialVersionUID = 1L;
    
    public classObject(int id, int x, int y,Insets insets){
        super(id, x, y,101,151,insets);
    }

    @Override
    public void drawInside(Graphics g) {        
        for(int j = 0 ; j < 3 ; j++)
            g.drawRect(0,50*j, 100, 50);
    }
}
