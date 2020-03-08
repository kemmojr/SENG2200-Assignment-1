import java.util.*;
import java.io.*;
public class MyPolygons {
    //Store a doubly linked circular Linked List
    private Node sentinel;
    private Node current;
    private Node tail;
    private int size = 0;

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
            sentinel.setPrevious(n);
            tail.setNext(n);
            n.setPrevious(tail);
            n.setNext(sentinel);
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

    public static void main(String args[]){

        MyPolygons mp = null;
        try {
            Scanner reader = new Scanner(new FileInputStream("input.txt"));
            boolean b = false;
            if (reader.next().equals("P")){
                 b = true;
            }
            int count = 0;

            while (b) {
                System.out.println("While");
                int numOfPoints = reader.nextInt();
                System.out.println(numOfPoints);
                Polygon p = new Polygon(numOfPoints);
                for (int i = 0; i < numOfPoints; i++) {
                    //Point pt = new Point();
                    //System.out.println(pt);
                    p.addPoint(reader.nextDouble(), reader.nextDouble());
                }
                if (count==0) {
                    mp = new MyPolygons(p);
                } else {
                    mp.prepend(p);
                }
                count++;
                if (reader.next().equals("P")){
                    continue;
                } else {
                    b = false;
                }

            }
        } catch (Exception e){
            //Exception code
        }
        System.out.println(mp);
    }

    @Override
    public String toString() {
        String out = "";
        reset();
        for (int i=0;i<size;i++){
            out += current.toString() + current.getArea() + "\n";
            current = current.getNext();
        }
        return out;
    }
}
