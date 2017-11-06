package Object;

import java.awt.Graphics;
import java.awt.Insets;
import Interface.objectRule;

public class useCaseObject extends objectRule{
    private static final long serialVersionUID = 1L;

    public useCaseObject(int id, int x, int y,Insets insets){
        super(id, x, y,151,101,insets);
    }

    @Override
    public void drawInside(Graphics g) {
        g.drawOval(0, 0, 150, 100);        
    }

}
