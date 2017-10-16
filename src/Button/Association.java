package Button;


import Interface.MyButton;

public class Association extends MyButton{
    
    public Association(String type){
        super(type);
    }

    protected void click(){
        System.out.println("123456789");
    }
}
