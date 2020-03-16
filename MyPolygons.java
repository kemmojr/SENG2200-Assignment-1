import java.awt.desktop.SystemSleepEvent;
import java.util.*;
import java.io.*;
public class MyPolygons {
    //Store a doubly linked circular Linked List
    private Node sentinel, sentinel2;
    private Node current, current2;
    private Node tail, tail2;
    private int size = 0, size2 =0;
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

    public void insert2(Polygon p){
        Node n = new Node(p);
        n.setNext(current2);
        n.setPrevious(current2.getPrevious());
        current2.setPrevious(n);
        current2.getPrevious().setNext(n);
        if (current2==sentinel2){
            sentinel2 = n;
        }
        size2++;

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

    public void append2(Polygon p){
        Node n = new Node(p);
        n.setPrevious(tail2);
        n.setNext(sentinel2);
        tail2.setNext(n);
        sentinel2.setPrevious(n);
        tail2 = n;
        size2++;
    }

    public void remove(){//remove from the head of the list
        Node newSentinel = sentinel.getNext();
        newSentinel.setPrevious(tail);
        tail.setNext(newSentinel);
        sentinel.delete();
        sentinel = newSentinel;
        size--;
    }

    public void remove(int i){//remove from a position i
        reset();
        for (int j = 0; j < size; j++) {
            if (j==i){
                //break and remove and do nessecary connections
                break;
            } else {
                setCurrentNext();
            }
        }

        Node removing = current;
        removing.getPrevious().setNext(removing.getNext());
        removing.getNext().setPrevious(removing.getPrevious());
        if (removing==sentinel){
            sentinel = removing.getNext();
        } else if (removing==tail){
            tail = removing.getPrevious();
        }
        removing.delete();
    }

    public void reset(){
        current = sentinel;
    }

    public void reset2(){
        current2 = sentinel2;
    }

    public void setCurrentNext(){
        current = current.getNext();
    }

    public void setCurrent2Next(){
        current2 = current2.getNext();
    }

    public void setCurrentPrev(){
        current = current.getPrevious();
    }

    public void setCurrent2Prev(){
        current2 = current2.getPrevious();
    }

    private Node getElement(int position){
        reset();
        for (int n = 0; n <= position; n++) {
            if (n==position){
                return current;
            } else {
                setCurrentNext();
            }
        }
        return null;
    }

    public void insertionSort(){

        Node n = new Node(sentinel.getData());
        sentinel2 = n;
        current2 = n;
        tail2 = n;
        n.setNext(n);
        n.setPrevious(n);
        size2++;

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
        reset();
        setCurrentNext();
        reset2();
        Polygon poly = new Polygon(current.getData());
        poly.comesBefore(current2.getData());
        for (int i = 1; i < size; i++) {
            //Loop through all the elements of the unsorted list
            //Polygon poly = new Polygon(current.getData());
            for (int j = 0; j <= size2; j++) {
                //loop through all the elements of the new list until you find a place where the next item goes
                if (current2.getData()!=null && poly.comesBefore(current2.getData())){
                    insert2(poly);
                    break;
                } else if (j==size2){
                    append2(poly);
                    break;
                }
                setCurrent2Next();
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
                    mp.append(p);
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

        //mp.insertionSort();
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
