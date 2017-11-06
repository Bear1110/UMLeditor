package Interface;

public abstract class Line {
    public objectRule from;
    public objectRule to;

    public Line(objectRule p,objectRule r) {
        this.from = p;
        this. to = r;
    }
    
    public abstract void drawLine();

}
