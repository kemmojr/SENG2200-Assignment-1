/*
Point.java

Author: Timothy Kemmis
Std no: c3329386
SENG2200 assignment 1
program description: A Point class that stores an x and y coordinate as double type
*/

import java.lang.Math;
public class Point {
    private double x;
    private double y;

    Point(double xValue, double yValue){//Constructor that sets the x and y values
        x = xValue;
        y = yValue;
    }

    public Point(Point p){//copy constructor
        x = p.getX();
        y = p.getY();
    }

    public double distance(){//returns the dsitance of a point from the origin
        double distance = Math.sqrt(x*x+y*y);

        return distance;
    }

    //Getters
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public String toString() {//Formats the point as a string
        String out = "(" + x + "0, " + y + "0)";
        return out;
    }
}
