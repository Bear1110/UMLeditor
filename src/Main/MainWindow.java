package Main;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Button.*;
import Button.Class;
import Interface.MyButton;
import Interface.objectRule;

public class MainWindow {
    JFrame f;
    JMenuBar menuBar;
    JMenu menu, submenu;
    
    public CanvasTool canvas;
    public static ArrayList<objectRule> objects;
    public ArrayList<objectRule> selectedObjects;
    public static MyButton nowMode;
    public int IdCount = 0;
    public MyButton button[]= {
            new Select("Select",this),
            new Association("Association",this),
            new Generalization("Generalization",this),
            new Composition("Composition",this),
            new Class("Class",this),
            new UseCase("use case",this)
            };
    
    public static void main(String[] args) {
        new MainWindow();
    }
    public static objectRule objectClicked = null;
    public static objectRule objectPress = null;
    public static objectRule objectRelease = null;
    
    public MainWindow() {
      f = new JFrame("UML editor");
      f.setSize(800,800);
      f.setLocationRelativeTo(null);  //再取消預設之視窗相對於螢幕左上角
      objects = new ArrayList<objectRule>();
      selectedObjects = new ArrayList<objectRule>();
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
        canvas = new CanvasTool(this);
        cp.add(canvas);
        
        JPanel panel = new JPanel();
        for(MyButton n : button){
            panel.add(n);
        } 
        panel.setLayout(new GridLayout(6,1,0,20));
        cp.add(panel,BorderLayout.WEST);       
        AboutMenu();
    }
    
    private void AboutMenu(){
        menuBar = new JMenuBar();
        menu = new JMenu("A Menu");
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menu.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                // TODO Auto-generated method stub
                System.out.println("menuSelected");                
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                // TODO Auto-generated method stub
                
            }
          
        });
        menuBar.add(menu);
        f.setJMenuBar(menuBar);
    }
}
