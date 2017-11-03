package Object;

import java.awt.Graphics;
import java.awt.Insets;
import Interface.objectRule;

public class useCaseObject extends objectRule{
    private static final long serialVersionUID = 1L;

    public useCaseObject(int id, int x, int y,Insets insets){
        super(id, x, y);
        setBounds(x + insets.left, y + insets.top,151,101);
    }

    @Override
    public void drawInside(Graphics g) {
        g.drawOval(0, 0, 150, 100);        
    }

}
