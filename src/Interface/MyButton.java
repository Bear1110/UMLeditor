package Interface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Main.MainWindow;


public class MyButton extends JButton{
    public MainWindow m;
    
    public MyButton(String abc,MainWindow m){
       super(abc);
       this.m = m;
       this.addActionListener(new ActionHandler(this));
       setBackground(Color.WHITE);
    }
    
    protected void click(){}    
    public void clickOnCavans(int x,int y){}
    
    class ActionHandler implements ActionListener {
        MyButton myButton;
        public ActionHandler(MyButton myButton) {
            this.myButton = myButton;
        }
        public void actionPerformed(ActionEvent e) {
          for(int i = 0; i < m.button.length ; i++){
              m.button[i].setBackground(Color.WHITE);         
          }
          setBackground(Color.GRAY);
          m.nowMode = myButton;
          click();
        }
    }
    
    
}
