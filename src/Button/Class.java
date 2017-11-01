package Button;

import Interface.MyButton;
import Main.MainWindow;
import Object.classObject;

public class Class extends MyButton{
    
    public Class(String type,MainWindow m){
        super(type,m);
    }
    protected void click(){
    }
    public void clickOnCavans(){
        classObject t = new classObject(m.IdCount++);
        m.objects.add(t);
        m.canvas.add(t);
        System.out.println(m.objects.size());
    }
}
