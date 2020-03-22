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

    public MyPolygons(MyPolygons mp){//Creates a MyPolygons object with one node from a MyPolygons taking the first node of MyPolygons
        //mp.current = mp.sentinel;
        Node n = new Node(mp.sentinel);
        sentinel = n;
        current = n;
        tail = n;
        /*sentinel = mp.current;
        current = mp.current;
        tail = mp.current;*/
        size++;
    }

    public void insert(Polygon p){//Insert a polygon in a node before current
        Node stepper = current;
        Node n = new Node(p);
        n.setNext(stepper);
        n.setPrevious(stepper.getPrevious());
        stepper.getPrevious().setNext(n);
        stepper.setPrevious(n);
        if (stepper==sentinel){
            sentinel = n;
        }
        size++;
    }

    public void insert(Node n){//Insert a polygon in a node before current
        Node stepper = current;
        n = new Node(n);
        n.setNext(stepper);
        n.setPrevious(stepper.getPrevious());
        stepper.getPrevious().setNext(n);
        stepper.setPrevious(n);
        if (stepper==sentinel){
            sentinel = n;
        }
        size++;
    }

    public void prepend(Polygon p){//Add a new node at the head of the LL
        Node n = new Node(p);
        n.setNext(sentinel);
        sentinel.setPrevious(n);
        sentinel.getPrevious().setNext(n);
        n.setPrevious(sentinel.getPrevious());
        n.setNext(sentinel);
        sentinel = n;
        size++;
    }

    public void append(Polygon p){//Add a new node at the end of the LL
        Node n = new Node(p);
        n.setPrevious(sentinel.getPrevious());
        n.setNext(sentinel);
        sentinel.getPrevious().setNext(n);
        sentinel.setPrevious(n);
        tail = n;
        size++;
    }

    public void append(Node n){//Add a new node at the end of the LL
        n.setPrevious(sentinel.getPrevious());
        n.setNext(sentinel);
        sentinel.getPrevious().setNext(n);
        sentinel.setPrevious(n);
        tail = n;
        size++;
    }

    public void remove(){//remove from the head of the list
        Node newSentinel = sentinel.getNext();
        newSentinel.setPrevious(sentinel.getPrevious());
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
        Node tCurr = current.getNext();
        current = tCurr;
    }

    public void setCurrentPrev(){
        current = current.getPrevious();
    }

    public void insertSorted(MyPolygons mp){//Inserts a node into its correct position with the node being the current of mp to avoid breaking encapsulation
        reset();
        for (int i = 0; i < size; i++) {
            if (mp.current.comesBefore(current)){
                Node insert = mp.current;
                insert(insert);
                break;
            } else if (i==(size-1)){
                append(mp.current);
                break;
            }
            setCurrentNext();
        }
    }

    @Override
    public String toString() {//A toString method that steps through the LinkedList and outputs in in the correct format
        String out = "";
        //current = sentinel;
        Node stepper = sentinel;
        for (int i=0;i<size;i++){
            out += stepper.toString() + stepper.getArea() + "\n";
            stepper = stepper.getNext();
        }

        return out;
    }
}
