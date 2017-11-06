package Main;
import java.awt.BorderLayout;
import java.awt.Composite;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Button.Association;
import Button.Class;
import Button.Composition;
import Button.Generalization;
import Button.Select;
import Button.UseCase;
import Interface.MyButton;
import Interface.objectRule;
import Object.GroupComposite;

public class MainWindow {
    JFrame f;
    JMenuBar menuBar;
    JMenu menu, submenu;
    
    public CanvasTool canvas;
    public static MyButton nowMode;
    public static ArrayList<objectRule> objects;
    public static ArrayList<objectRule> selectedObjects;
    public Hashtable<Integer,GroupComposite> layer;
    public Hashtable<Integer,GroupComposite> GroupComposites;
    
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
      GroupComposites = new Hashtable<Integer,GroupComposite>();
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
        menu = new JMenu("Edit Menu");
        
      //a group of JMenuItems
        JMenuItem menuItem = new JMenuItem("Group");
        menuItem.addActionListener(new Group());
        menu.add(menuItem);

        menuItem = new JMenuItem("UnGroup");
        menuItem.addActionListener(new UnGroup());
        menu.add(menuItem);        
        
        
        menuBar.add(menu);
        f.setJMenuBar(menuBar);
    }
    
    class Group implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!nowMode.getClass().equals(Button.Select.class))return;
            GroupComposite test = new GroupComposite(IdCount++);
            for(objectRule o : selectedObjects){
                if(o.groupFather != null) //表示欲加入的原件他已經是某一層了
                    test.addBasicLayer(o.groupFather);
                else{
                    test.addBasicLayer(o);
                }
            }
            GroupComposites.put(test.id, test);
        }
    }
    class UnGroup implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!nowMode.getClass().equals(Button.Select.class))return;
            int max = -111;
            int id = 0;
            for(objectRule o : selectedObjects){
                if(max < o.groupFather.heigh){
                    
                    id = o.groupFather.id;
                    max = o.groupFather.heigh;
                }
            }
            GroupComposite wantRemove = GroupComposites.remove(id);
            if(wantRemove != null)
                wantRemove.remove();            
        }
    }
}
