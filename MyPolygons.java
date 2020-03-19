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
        n.setNext(n);
        n.setPrevious(n);
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


    public void setCurrentNext(){
        current = current.getNext();
    }

    public void setCurrentPrev(){
        current = current.getPrevious();
    }


    public void insertionSort(){

        Node n = new Node(sentinel);
        //sentinel2 = n;
        //current2 = n;
        //tail2 = n;
        //size2=1;

        /* int n = arr.length; random comment
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
        current = sentinel.getNext();
        //current = current.getNext();
        //reset2();
        Polygon poly = new Polygon(current.getData());
        boolean inserted = false;
        for (int i = 1; i < size; i++) {
            //Loop through all the elements of the unsorted list
            inserted = false;
            if (i!=0){
                //poly = new Polygon(getElement(i).getData());
            }
            for (int j = 0; j <= i; j++) {
                //loop through all the elements of the new list until you find a place where the next item goes
                if (n.comesBefore(current)){
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
        }
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
                //System.out.println("While");
                int numOfPoints = reader.nextInt();
                System.out.println(numOfPoints);
                Polygon p = new Polygon(numOfPoints);
                for (int i = 0; i < numOfPoints; i++) {
                    //Point pt = new Point();
                    //System.out.println(reader.nextDouble());
                    //System.out.println("i:"+i);
                    p.addPoint(reader.nextDouble(), reader.nextDouble());
                }
                if (count==0) {
                    mp = new MyPolygons(p);
                } else {
                    mp.append(p);
                }
                count++;
                try{
                    if (reader.next().equals("P")){
                        continue;
                        //if ()
                    } else {
                        b = false;
                    }
                } catch (Exception e){
                    //Do nothing
                    break;
                }


            }
        } catch (Exception e){
            //Exception code
            System.out.println("Error");
        }

        //mp.insertionSort();
        //System.out.println("Sorted");
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
