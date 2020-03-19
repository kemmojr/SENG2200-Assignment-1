import java.util.*;

public class Node { // Implement a compare method that compares Polygons
    //next & previous pointers of data type polygon and pointer
    //data = new Polygon
    private Polygon data;
    private Node next;
    private Node previous;

    public Node(Polygon p){
        next = this;
        previous = this;
        data = p;
    }

    public Node(Node n){
        next = n.getNext();
        previous = n.getPrevious();
        data = n.data;
    }

    public Node(Polygon p, Node nxt, Node prev){
        next = nxt;
        previous = prev;
        data = p;
    }

    public void setNext(Node nxt){
        next = nxt;
    }

    public void setPrevious(Node prev){
        previous = prev;
    }

    public void setData(Polygon p){
        data = p;
    }

    public Node getNext(){
        return next;
    }

    public Node getPrevious(){
        return previous;
    }

    public Polygon getData(){
        return data;
    }

    public void delete(){
        data = null;
        next = null;
        previous = null;
    }

    public double getArea(){
        return data.area();
    }

    public boolean comesBefore(Node n){//returns true if this.area() < p.area()
        return data.comesBefore(n.getData());
    }

    @Override
    public String toString() {
        String out = "";
        out += data.toString();
        return out;
    }
}
