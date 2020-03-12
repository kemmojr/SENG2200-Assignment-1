import java.awt.desktop.SystemSleepEvent;
import java.util.*;
import java.io.*;
public class MyPolygons {
    //Store a doubly linked circular Linked List
    private Node sentinel, sentinel2;
    private Node current, current2;
    private Node tail, tail2;
    private int size = 0;
    private double[] sort = null;

    public MyPolygons(Polygon first){
        Node n = new Node(first);
        sentinel = n;
        current = n;
        tail = n;
        n.setNext(n);
        n.setPrevious(n);
        size++;
    }

    public MyPolygons(Node n){
        sentinel2 = n;
        current2 = n;
        tail2 = n;
        n.setNext(n);
        n.setPrevious(n);
    }

    public MyPolygons(){
        sentinel = null;
        current = null;
        //Node n = new Node();
    }

    public void insert(Polygon p){
        Node n = new Node(p);
        n.setNext(current);
        n.setPrevious(current.getPrevious());
        current.setPrevious(n);
        current.getPrevious().setNext(n);
        if (current==sentinel){
            sentinel = n;
        }
        size++;

    }

    public void createdSortedList(double[] list){
        /*Create a new linkedList by going through the linked list and adding each node to the sorted linked list in reverse sorted order based on the area
        Node n = null;
        reset();
        for (int i=0;i<size;i++){
            if (current.getArea()==list[i]){
                n = new Node(current);
                break;
            }
            current = current.getNext();
        }
        sentinel2 = n;
        current2 = n;
        tail2 = n;
        n.setNext(n);
        n.setPrevious(n);
        Node n1 = null;
        reset();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (current.getArea()==list[i]){
                    n1 = new Node(current);
                    postpend2(n1);
                    current = current.getNext();
                    break;
                }
            }
        }*/
    }

    public void prepend(Polygon p){
        Node n = new Node(p);
        n.setNext(sentinel);
        sentinel.setPrevious(n);
        tail.setNext(n);
        n.setPrevious(tail);
        n.setNext(sentinel);
        sentinel = n;
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

    public void postpend2(Node n){
        //Node n = new Node(p);
        n.setPrevious(tail2);
        n.setNext(sentinel2);
        tail2.setNext(n);
        sentinel2.setPrevious(n);
        tail2 = n;
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

    public void reset2(){
        current2 = sentinel2;
    }

    public void insertionSort(){


        /*
        for (int i = 1; i < size; ++i) {
            double key = sort[i];
            int j = i - 1;

             Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position
            while (j >= 0 && sort[j] > key) {
                sort[j + 1] = sort[j];
                j = j - 1;
            }
            sort[j + 1] = key;
        }
        createdSortedList(sort);*/
    }

    public static void main(String args[]){

        MyPolygons mp = null;
        File file = new File("input.txt");
        System.out.println(file.canRead());
        //Scanner reader = new Scanner(new FileInputStream("input.txt"));
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
                    //System.out.println(reader.nextDouble());
                    System.out.println("i:"+i);
                    p.addPoint(reader.nextDouble(), reader.nextDouble());
                }
                if (count==0) {
                    mp = new MyPolygons(p);
                } else {
                    mp.prepend(p);
                }
                count++;
                try{
                    if (reader.next().equals("P")){
                        continue;
                    } else {
                        b = false;
                    }
                } catch (Exception e){
                    //Do nothing
                }


            }
        } catch (Exception e){
            //Exception code
            System.out.println("Error");
        }

        mp.insertionSort();
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
        /*insertionSort();
        reset2();
        for (int i=0;i<size;i++){
            out += current2.toString() + current2.getArea() + "\n";
            current2 = current2.getNext();
        }*/
        return out;
    }
}
