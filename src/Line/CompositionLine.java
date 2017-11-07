package Line;

import java.awt.Color;
import java.awt.Graphics;

import Interface.Line;
import Interface.objectRule;

public class CompositionLine extends Line {

    public CompositionLine(objectRule p,objectRule r) {
        super(p,r);
    }

    @Override
    public void drawLine(Graphics g) {
        g.setColor(Color.CYAN);       
        int x1 = to.x+to.directionCoordinate[toPort][0];
        int y1 = to.y+to.directionCoordinate[toPort][1]-15;
        int x2 = x1 + 30;
        int y2 = y1 + 30;
        int x = (x1+x2) / 2;
        int y = (y1+y2) / 2;
        g.drawLine(x1, y , x , y1);
        g.drawLine(x , y1, x2, y );
        g.drawLine(x2, y , x , y2);
        g.drawLine(x , y2, x1, y );
    }

}
