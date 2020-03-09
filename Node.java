import java.util.*;

public class Node {
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

    public void delete(){
        data = null;
        next = null;
        previous = null;
    }

    public double getArea(){
        return data.area();
    }

    @Override
    public String toString() {
        String out = "";
        out += data.toString();
        return out;
    }
}
