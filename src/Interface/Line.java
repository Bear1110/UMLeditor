package Interface;

public abstract class Line {
    public objectRule from;
    public objectRule to;
    public int fromPort;
    public int toPort;
    public Line(objectRule p,objectRule r) {
        this.from = p;
        this. to = r;
        fromPort = from.connectionPort;
        toPort = to.connectionPort;
    }
    
    public abstract void drawLine();

}
