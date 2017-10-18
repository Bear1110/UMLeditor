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
        m.objects.add(new classObject());
        System.out.println(m.objects.size());
    }
}
