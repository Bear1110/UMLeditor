import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Button.*;
import Button.Class;
import Interface.MyButton;

public class MainWindow {
    
    JFrame f;
    MyButton button[]= {
            new Select("Select"),
            new Association("Association"),
            new Generalization("Generalization"),
            new Composition("Composition"),
            new Class("Class"),
            new UseCase("use case")
            };
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MainWindow();
    }
    
    public MainWindow() {
      f = new JFrame("UML editor");
      f.setSize(800,800);
      f.setLocationRelativeTo(null);  //再取消預設之視窗相對於螢幕左上角
      addToFrame();
      f.setVisible(true);
      
      f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
      /*f.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          int result=JOptionPane.showConfirmDialog(f,"確定要結束程式嗎?","確認訊息",
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.WARNING_MESSAGE);
          if (result==JOptionPane.YES_OPTION) {System.exit(0);}
          }
        });*/
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
    }
    private void addToFrame(){
        Container cp = f.getContentPane();
        JPanel panel = new JPanel();
        JPanel area = new JPanel();
        area.setBackground(Color.BLUE);
        cp.add(area,BorderLayout.CENTER);
        
        for(int i = 0; i < button.length ; i++){
            button[i].addActionListener(new buttonClick());
            panel.add(button[i]);
        }
        
        panel.setLayout(new GridLayout(6,1,0,20));
        cp.add(panel,BorderLayout.WEST); 
    }
    
    class buttonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          for(int i = 0; i < button.length ; i++){
              button[i].setBackground(Color.WHITE);              
          }
        }
    }

}
