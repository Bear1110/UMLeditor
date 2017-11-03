package Button;

import Interface.MyButton;
import Main.MainWindow;

public class Association extends MyButton {
    private static final long serialVersionUID = 1L;
    
    public Association(String type,MainWindow m){
        super(type,m);
    }
    public void implementDragFunction(){
        System.out.println("afterDrag  "+this.getClass());
    }
}
