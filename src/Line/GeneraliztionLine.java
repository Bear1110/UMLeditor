package Line;

import java.awt.Color;
import java.awt.Graphics;

import Interface.Line;
import Interface.objectRule;

public class GeneraliztionLine extends Line {

    public GeneraliztionLine(objectRule p,objectRule r) {
        super(p,r);
    }

    @Override
    public void drawLine(Graphics g) {
        
        g.setColor(Color.CYAN);
        int x = to.x+to.directionCoordinate[toPort][0];
        int y = to.y+to.directionCoordinate[toPort][1];
        
        int rightOrLift = (to.x > from.x) ? -30 : 30;
        g.drawLine(x , y, x+rightOrLift, y+30);
        g.drawLine(x , y, x+rightOrLift, y-30);
    }

}
