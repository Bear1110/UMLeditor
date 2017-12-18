package Button;

import Interface.BasicButton;
import Line.CompositionLine;
import Main.MainWindow;

public class Composition extends BasicButton{
    private static final long serialVersionUID = 1L;
    
    public Composition(String type,MainWindow m){
        super(type,m);
    }
    public void implementDragFunction(){
        m.canvas.lines.add(new CompositionLine(MainWindow.objectPress,MainWindow.objectRelease));
    }
}
