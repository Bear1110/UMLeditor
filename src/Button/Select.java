package Button;

import java.util.ArrayList;

import Interface.BasicButton;
import Interface.objectRule;
import Main.MainWindow;

public class Select extends BasicButton{
    private static final long serialVersionUID = 1L;
    
    int x1,x2,y1,y2;

    public Select(String type,MainWindow m){
        super(type,m);
    }
    public void pressOnCavans(int x, int y){
        x1 = x;
        y1 = y;        
    }
    public void releaseOnCavans(int x, int y,MainWindow m){
        x2 = x;
        y2 = y;
        
        if(x2 < x1){
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if(y2 < y1){
            int temp = y1;
            y1 = y2;
            y2 = temp;
        }
        
        m.selectedObjects = new ArrayList<objectRule>();
        for(objectRule o : m.objects){
            o.selected = false;
            if(o.x < x1 || o.y < y1) // 左上角 有在 x1 y1 裡面
                continue;
            if(o.x+o.width > x2 || o.y+o.heigh > y2) // 左上角 有在 x1 y1 裡面
                continue;
            o.selected = true;
            m.selectedObjects.add(o);
        }
        
    }
}
