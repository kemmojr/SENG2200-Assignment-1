import java.util.*;
public class Polygon {

    private Point[] points;
    int numOfPoints = 5;


    Polygon(int numOfPoints){
        points = new Point[numOfPoints];
    }

    public void addPoint(Point p){
        boolean b = true;
        int counter = 0;
        while (b){
            if (points[counter].getX()!=null){

            }
        }
    }

    public double distance(){
        double dist = 0;
        return dist;
    }

    public double area(){
        double area = 0;

        for (int i = 0; i<numOfPoints-2;i++){
            area = 1/2*((points[i+1].getX()+points[i].getX())*(points[i+1].getY()-points[i].getY()));
        }
        return area;

    }

    @Override
    public String toString() {
        String out = "";
        return out;
    }
}
