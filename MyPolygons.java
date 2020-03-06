import java.util.*;
public class MyPolygons {
    //Store a doubly linked circular Linked List
    Node sentinel;
    Node current;
    Node tail;
    int size = 0;

    public MyPolygons(Polygon first){
        Node n = new Node(first);
        sentinel = n;
        current = n;
        tail = n;
        n.setNext(n);
        n.setPrevious(n);
        size++;
    }

    public MyPolygons(){
        sentinel = null;
        current = null;
        //Node n = new Node();
    }

    public void prepend(Polygon p){
        Node n = new Node(p);
        if (size==1){
            n.setNext(sentinel);
            n.setPrevious(sentinel);
            sentinel.setNext(n);
            sentinel.setPrevious(n);
            sentinel = n;
        } else {
            n.setNext(sentinel);
            tail.setNext(n);
            n.setPrevious(tail);
            sentinel = n;
        }
        size++;
    }

    public void postpend(Polygon p){
        Node n = new Node(p);
        n.setPrevious(tail);
        n.setNext(sentinel);
        tail.setNext(n);
        sentinel.setPrevious(n);
        tail = n;
        size++;
    }

    public void remove(){//remove from the head of the list
        Node newSentinel = sentinel.getNext();
        newSentinel.setPrevious(tail);
        tail.setNext(newSentinel);
        sentinel.delete();
        sentinel = newSentinel;
        size--;
    }

    public void reset(){
        current = sentinel;
    }
}
