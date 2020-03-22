/*
MyPolygons.java

Author: Timothy Kemmis
Std no: c3329386
SENG2200 assignment 1
program description: A MyPolygons class that holds a circular LinkedList of Nodes containing Polygons.
*/

import java.util.*;
import java.io.*;
public class MyPolygons {
    //Store a doubly linked circular Linked List
    private Node sentinel;
    private Node current;
    private Node tail;
    private int size = 0;

    public MyPolygons(Polygon first){//Creates a MyPolygons object with one node from a polygon
        Node n = new Node(first);
        sentinel = n;
        current = n;
        tail = n;
        size++;
    }

    public MyPolygons(Node n){//Creates a MyPolygons object with one node from a node
        sentinel = n;
        current = n;
        tail = n;
        size++;
    }

    public MyPolygons(MyPolygons mp){//Creates a MyPolygons object with one node from a MyPolygons taking the first node of MyPolygons
        mp.current = mp.sentinel;
        Node n = new Node(mp.current);
        sentinel = n;
        current = n;
        tail = n;
        /*sentinel = mp.current;
        current = mp.current;
        tail = mp.current;*/
        size++;
    }

    public MyPolygons(){//Empty constructor
        sentinel = null;
        current = null;
        //Node n = new Node();
    }

    public void insert(Polygon p){//Insert a polygon in a node before current
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

    public void insert(Node n){//Insert a polygon in a node before current
        n.setNext(current);
        n.setPrevious(current.getPrevious());
        current.getPrevious().setNext(n);
        current.setPrevious(n);
        if (current==sentinel){
            sentinel = n;
        }
        size++;

    }

    public void prepend(Polygon p){//Add a new node at the head of the LL
        Node n = new Node(p);
        n.setNext(sentinel);
        sentinel.setPrevious(n);
        //tail.setNext(n);
        sentinel.getPrevious().setNext(n);
        //n.setPrevious(tail);
        n.setPrevious(sentinel.getPrevious());
        n.setNext(sentinel);
        sentinel = n;
        size++;
    }

    public void append(Polygon p){//Add a new node at the end of the LL
        Node n = new Node(p);
        //n.setPrevious(tail);
        n.setPrevious(sentinel.getPrevious());
        n.setNext(sentinel);
        //tail.setNext(n);
        sentinel.getPrevious().setNext(n);
        sentinel.setPrevious(n);
        tail = n;
        size++;
    }

    public void append(Node n){//Add a new node at the end of the LL
        //n.setPrevious(tail);
        n.setPrevious(sentinel.getPrevious());
        n.setNext(sentinel);
        //tail.setNext(n);
        sentinel.getPrevious().setNext(n);
        sentinel.setPrevious(n);
        tail = n;
        size++;
    }

    public void remove(){//remove from the head of the list
        Node newSentinel = sentinel.getNext();
        //newSentinel.setPrevious(tail);
        newSentinel.setPrevious(sentinel.getPrevious());
        //tail.setNext(newSentinel);
        sentinel.getPrevious().setNext(newSentinel);
        sentinel.delete();
        sentinel = newSentinel;
        size--;
    }

    public void reset(){//Set current to the sentinel
        current = sentinel;
    }

    public int getSize(){
        return size;
    }


    public void setCurrentNext(){
        System.out.println("insetcur: " + current.toString());
        Node tCurr = current.getNext();
        current = tCurr;
        System.out.println("outSetCur: " + current.toString());

    }

    public void setCurrentPrev(){
        current = current.getPrevious();
    }

    /*public Node getCurrent(){
        return current;
    }*/

    public void insertSorted(MyPolygons mp){//Inserts a node into its correct position with the node being the current of mp to avoid breaking encapsulation
        reset();
        System.out.println("inMPs insSortd: " + mp.current.toString() + ": " + mp.current.getArea() );
        for (int i = 0; i < size; i++) {
            System.out.println("curr: " +
                    current.toString() +
                    ": " + current.getArea() );
            if (mp.current.comesBefore(current)){
                insert(mp.current);
                System.out.println("yes " + size);
                break;
            } else if (i==(size-1)){
                append(mp.current);
                break;
            }
            setCurrentNext();
        }
        System.out.println("outMPs insSortd: " + mp.current.toString() + ": " + mp.current.getArea() );
    }


    public void insertionSort(MyPolygons full){
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
        full.current = full.sentinel;
        full.setCurrentNext();
        for (int i = 0; i < full.getSize(); i++) {
            for (int j = 0; j < size; j++) {
                insertSorted(full);
                full.setCurrentNext();
            }
        }
    }

    @Override
    public String toString() {//A toString method that steps through the LinkedList and outputs in in the correct format
        String out = "";
        current = sentinel;
        for (int i=0;i<size;i++){
            out += current.toString() + current.getArea() + "\n";
            current = current.getNext();
        }

        return out;
    }
}
