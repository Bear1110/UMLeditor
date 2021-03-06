package Button;

import Interface.BasicButton;
import Line.AssociationLine;
import Main.MainWindow;

public class Association extends BasicButton {
    private static final long serialVersionUID = 1L;
    
    public Association(String type,MainWindow m){
        super(type,m);
    }
    public void implementDragFunction(){
        m.canvas.lines.add(new AssociationLine(MainWindow.objectPress,MainWindow.objectRelease));
    }
}
