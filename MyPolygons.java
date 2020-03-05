import java.util.*;
public class MyPolygons {
    //Store a doubly linked circular Linked List
    Node sentinel;
    Node current;

    public MyPolygons(Polygon first){
        Node n = new Node(first);
        sentinel = n;
        current = n;
    }

    public MyPolygons(){
        sentinel = null;
        current = null;
        //Node n = new Node();
    }
}
