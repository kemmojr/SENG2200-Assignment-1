/*
Polygon.java

Author: Timothy Kemmis
Std no: c3329386
SENG2200 assignment 1
program description: A polygon class that holds and array of Point objects.
*/


import java.util.*;
public class Polygon implements ComparePoly {

    private Point[] points;//Array of all the points
    //private Point first;
    int numOfPoints = 5, pointCount =0;


    Polygon(int numOfP){//initialises a polygon with an array of specified size
        numOfPoints = numOfP+1;
        points = new Point[numOfPoints];
    }

    Polygon(Polygon p){//copy constructor which loops through all the points of one polygon and adds them to the new polygon
        numOfPoints = p.numOfPoints;
        points = new Point[numOfPoints];
        //points = p.points;
        for (int i = 0; i < p.numOfPoints-1; i++) {
            if (p.points[i]==null){
                break;
            }
            points[i] = new Point(p.points[i].getX(),p.points[i].getY());
        }
        pointCount = p.pointCount;
    }

    public void addPoint(double x, double y){// Create a new function called finalise points which takes a complete polygon and replicates the first point into the last
        if (pointCount==(numOfPoints-1)){
            System.out.println("More points than allocated");
            return;
        }
        points[pointCount] = new Point(x, y);
        pointCount++;
    }

    public void finalise(){//copies the first point as the last for area calculations
        points[pointCount] = points[0];

    }

    public double distance(){//returns the shortest distance from the origin for a polygon
        double dist = 0;
        dist = points[0].distance();
        for (int i = 0; i < pointCount; i++) {
            if (points[i].distance()<dist){
                dist = points[i].distance();
            }
        }
        return dist;
    }

    public double area(){//calculates the area using the given formula
        double tempArea = 0, area =0;
        finalise();

        for (int i = 0; i<=numOfPoints-2;i++){
            //System.out.println("rep "+i);
            tempArea = ((points[i+1].getX()+points[i].getX())*(points[i+1].getY()-points[i].getY()));
            //System.out.println(tempArea);
            area += tempArea;
            //System.out.println("area:"+tempArea);
        }
        area = area * 0.5;
        area = Math.sqrt(area*area);
        //System.out.println("area:"+area);
        area *= 100.0;
        area = Math.round(area);
        area = area/100.0;
        return area;

    }

    public boolean comesBefore(Polygon p){//returns true if this.area() < p.area(). If their area's are within 0.1% then it returns based on distance from the origin
        double a1 = this.area();
        double a2 = p.area();
        double percentage = 0.001;
        double diff = Math.sqrt((a1-a2)*(a1-a2));
        if (a1<a2){
            if (diff/a1<percentage){
                if (this.distance()<p.distance()){
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (diff/a2<percentage){
                if (this.distance()<p.distance()){
                    return true;
                } else {
                    return false;
                }
            }
        }

        if (this.area()<p.area()){
            return true;
        } else {
            return false;
        }
    }




    @Override
    public String toString() {//toString method that formats correctly
        String out = "[";
        for (int i =0;i<pointCount;i++){
            if (i==pointCount-1){
                out += points[i].toString();
            } else {
                out += points[i].toString() + ", ";
            }
        }
        out += "] : ";
        return out;
    }
}

