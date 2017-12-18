package Button;

import Interface.BasicButton;
import Main.MainWindow;
import Object.classObject;

public class Class extends BasicButton{
    private static final long serialVersionUID = 1L;
    
    public Class(String type,MainWindow m){
        super(type,m);
    }
    protected void click(){
    }
    public void clickOnCavans(int x, int y){
        classObject t = new classObject(m.IdCount++,x,y,m.canvas.getInsets());
        m.objects.add(t);
        m.canvas.add(t);
    }
}
