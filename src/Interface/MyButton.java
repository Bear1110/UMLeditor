package Interface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class MyButton extends JButton{
    
    public String type;
    
    public MyButton(String abc){
       super(abc);
       type = abc;
       this.addActionListener(new ActionHandler());
       setBackground(Color.WHITE);
    }
    
    protected void click(){}
    
    class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          System.out.println(type);
          setBackground(Color.GRAY);
          click();
        }
    }
    
}
