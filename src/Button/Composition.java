package Button;

import Interface.MyButton;
import Main.MainWindow;

public class Composition extends MyButton{
    private static final long serialVersionUID = 1L;
    
    public Composition(String type,MainWindow m){
        super(type,m);
    }
    public void implementDragFunction(){
        System.out.println("afterDrag  "+this.getClass());
    }
}
