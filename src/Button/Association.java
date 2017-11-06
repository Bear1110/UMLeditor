package Button;

import Interface.MyButton;
import Line.AssociationLine;
import Main.MainWindow;

public class Association extends MyButton {
    private static final long serialVersionUID = 1L;
    
    public Association(String type,MainWindow m){
        super(type,m);
    }
    public void implementDragFunction(){
        m.canvas.lines.add(new AssociationLine(m.objectPress,m.objectRelease));
        System.out.println("afterDrag  "+this.getClass());
    }
}
