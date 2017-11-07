package Button;

import Interface.MyButton;
import Line.GeneraliztionLine;
import Main.MainWindow;

public class Generalization extends MyButton{
    private static final long serialVersionUID = 1L;
    
    public Generalization(String type,MainWindow m){
        super(type,m);
    }
    public void implementDragFunction(){
        m.canvas.lines.add(new GeneraliztionLine(MainWindow.objectPress,MainWindow.objectRelease));
    }
}
