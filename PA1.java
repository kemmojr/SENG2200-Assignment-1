/*
PA1.java

Author: Timothy Kemmis
Std no: c3329386
SENG2200 assignment 1
program description: A class to hold the main method and manipulate MyPolygons objects when calling insertion sort.
*/

import java.util.*;
import java.io.*;
public class PA1 {
    //Implement all of the main loop and working with the MyPolygons

    public static void insertionSort(MyPolygons full, MyPolygons empty){
        //empty.insertionSort(full);
        full.reset();
        full.setCurrentNext();
        for (int i = 1; i < full.getSize(); i++) {
            empty.insertSorted(full);
            full.setCurrentNext();
        }
    }

    public void insertionSorting(MyPolygons full, MyPolygons empty){

    }

    public static void main(String args[]){

        MyPolygons mp = null;
        MyPolygons mpSorted = null;

        try {//A try/catch statement to import from a file
            Scanner reader = new Scanner(new FileInputStream("input.txt"));//Scanner reader object to use for stepping through the data in the file

            boolean b = false; //A variable to break from the while loop
            if (reader.next().equals("P")){//If there is a p, meaning another polygon exists, continue looping
                b = true;
            }
            int count = 0;

            while (b) {

                int numOfPoints = reader.nextInt(); //The number of points in the polygon
                Polygon p = new Polygon(numOfPoints);//creates empty Polygon with correct array size
                for (int i = 0; i < numOfPoints; i++) {//Loops through and adds the necessary number of points to Polygon
                    p.addPoint(reader.nextDouble(), reader.nextDouble());//Adds a point with the two x & y co-ordinate values from the file
                }
                if (count==0) {
                    mp = new MyPolygons(p);//create a new MyPolygon for storing the Polygons
                } else {
                    mp.append(p);//Otherwise add the polygon to the LinkedList
                }
                count++;
                try{
                    if (reader.next().equals("P")){//checks if there is another Polygon and if not then break from the while loop
                        continue;
                    } else {
                        b = false;
                    }
                } catch (Exception e){
                    //A catch to avoid errors when reading from file
                    break;
                }


            }

            mpSorted = new MyPolygons(mp);//creates empty MP for putting a sorted LinkedList in
        } catch (Exception e){
            //Exception code for if there is a problem reading from file
            System.out.println("Error");
        }


        System.out.println("Unsorted list");
        System.out.println(mp);
        insertionSort(mp,mpSorted);
        System.out.println("Sorted list");
        System.out.println(mpSorted);


    }
}
