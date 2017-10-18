package Button;


import Interface.MyButton;
import Main.MainWindow;

public class Association extends MyButton{
    
    public Association(String type,MainWindow m){
        super(type,m);
    }

    protected void click(){
        System.out.println("123456789");
    }
}
