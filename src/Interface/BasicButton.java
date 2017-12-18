package Interface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Main.MainWindow;


public class BasicButton extends JButton{
    private static final long serialVersionUID = 1L;
    
    public MainWindow m;
    
    public BasicButton(String abc,MainWindow m){
       super(abc);
       this.m = m;
       this.addActionListener(new ActionHandler(this));
       setBackground(Color.WHITE);
    }
    
    protected void click(){}    
    public void clickOnCavans(int x,int y){}
    
    class ActionHandler implements ActionListener {
        BasicButton myButton;
        public ActionHandler(BasicButton myButton) {
            this.myButton = myButton;
        }
        public void actionPerformed(ActionEvent e) {
          for(BasicButton n : m.button){
              n.setBackground(Color.WHITE);
          }
          setBackground(Color.GRAY);
          m.nowMode = myButton;
          click();
        }
    }
    public void afterDragForObject(){
        if(MainWindow.objectPress != null && MainWindow.objectRelease != null && MainWindow.objectPress != MainWindow.objectRelease){
            implementDragFunction();
            m.canvas.repaint();
        }else{
            System.out.println("objectPress objectRelease are same or one of them is null");
        }
        MainWindow.objectPress = null;
        MainWindow.objectRelease = null;        
    }
    public void pressOnCavans(int x, int y){}
    public void releaseOnCavans(int x, int y,MainWindow m){}
    protected void implementDragFunction(){ }
    
}
