package Button;

import Interface.MyButton;
import Interface.objectRule;
import Main.MainWindow;

public class Select extends MyButton{
    private static final long serialVersionUID = 1L;

    public Select(String type,MainWindow m){
        super(type,m);
    }
    
    public void clickOnCavans(int x, int y){
        if(MainWindow.objectClicked ==null) return;
        for(objectRule o : m.objects){
            o.repaint();
        }
    }
}
