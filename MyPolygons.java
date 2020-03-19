import java.awt.desktop.SystemSleepEvent;
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
        size++;
    }

    public MyPolygons(Node n){
        sentinel = n;
        current = n;
        tail = n;
        size++;
    }

    public MyPolygons(MyPolygons mp){
        mp.reset();
        sentinel = mp.current;
        current = mp.current;
        tail = mp.current;
        size++;
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

    public void append(Polygon p){
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

    public int getSize(){
        return size;
    }


    public void setCurrentNext(){
        current = current.getNext();
    }

    public void setCurrentPrev(){
        current = current.getPrevious();
    }

    private Node getCurrent(){
        return current;
    }

    public void insertSorted(MyPolygons mp){//Inserts a node into its correct position with the node being the current of mp to avoid breaking encapsulation
        reset();
        for (int i = 0; i < size; i++) {
            if (mp.current.comesBefore(current)){
                insert(mp.current.getData());
                break;
            } else if (i==size-1){
                append(mp.current.getData());
                break;
            }
            setCurrentNext();
        }
        size++;
    }


    public void insertionSort(){
        /* int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

             Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    } */
        //current = sentinel.getNext();
        //current = current.getNext();
        //reset2();
        /*Polygon poly = new Polygon(current.getData());
        boolean inserted = false;
        for (int i = 1; i < size; i++) {
            //Loop through all the elements of the unsorted list
            inserted = false;
            if (i!=0){
                //poly = new Polygon(getElement(i).getData());
            }
            for (int j = 0; j <= i; j++) {
                //loop through all the elements of the new list until you find a place where the next item goes
                n.comesBefore(current)){
                    //insert2(poly);
                    inserted = true;
                    break;
                } else if (j==3){
                    //append2(poly);
                    inserted = true;
                    break;
                }
                //setCurrent2Next();
            }
            setCurrentNext();
        }*/
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
