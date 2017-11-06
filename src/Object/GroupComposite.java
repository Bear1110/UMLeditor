package Object;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

import Interface.objectRule;
import Main.MainWindow;

public class GroupComposite {
    public int id,heigh = 0; //depth 
    public ArrayList<objectRule> value;
    public Hashtable<Integer,GroupComposite> layer;
    public GroupComposite father = null;

    public GroupComposite(int id) {
        this.id = id;
        value = new ArrayList<objectRule>();
        layer = new Hashtable<Integer,GroupComposite>();
    }
    public void addBasicLayer(objectRule o){
        value.add(o);
        o.groupFather = this;
    }
    public void addBasicLayer(GroupComposite c){
        GroupComposite wantAdd = findTheOlderestFather(c);
        if(wantAdd == this) return;
        layer.put(wantAdd.id, wantAdd);
        wantAdd.father = this;
        this.heigh = Math.max(wantAdd.heigh + 1, this.heigh);
    }
    private GroupComposite findTheOlderestFather(GroupComposite c) {
        if(c.father == null)
            return c;
        else
            return findTheOlderestFather(c.father);
    }
    public void selectedAll(){
        if(checkIfAllSelected()) return;
        for(objectRule o : value){
            o.selected = true;
            MainWindow.selectedObjects.add(o);
        }
        if(layer != null){// 先看他有沒有 子 GroupComposite
            for (Entry<Integer, GroupComposite> e : layer.entrySet()) {
                e.getValue().selectedAll();
            }
        }
        if(father != null){//看他是不是隸屬於某個GroupComposite
            father.selectedAll();
        }
    }
    private boolean checkIfAllSelected(){
        for(objectRule o : value){
            if(!o.selected)
                return false;
        }
        return true;
    }
    public void remove(){
        if(layer != null){// 先看他有沒有 子 GroupComposite
            for (Entry<Integer, GroupComposite> e : layer.entrySet()) {
                e.getValue().father = null;
            }
        }
        for(objectRule o : value){
            o.groupFather = null;
        }
        layer = null;
        value = null;
    }
}
