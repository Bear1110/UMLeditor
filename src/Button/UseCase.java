package Button;

import Interface.MyButton;
import Main.MainWindow;
import Object.useCaseObject;

public class UseCase extends MyButton{
    private static final long serialVersionUID = 1L;
    
    public UseCase(String type,MainWindow m){
        super(type,m);
    }
    public void clickOnCavans(int x, int y){
        useCaseObject t = new useCaseObject(m.IdCount++,x,y,m.canvas.getInsets());
        m.objects.add(t);
        m.canvas.add(t);
    }
}
