import java.util.*;
public class Polygon {

    private Point[] points;
    private Point first;
    int numOfPoints = 5, pointCount =0;


    Polygon(int numOfP){
        numOfPoints = numOfP+1;
        points = new Point[numOfPoints];
    }

    public void addPoint(double x, double y){// Create a new function called finalise points which takes a complete polygon and replicates the first point into the last
        if (pointCount==(numOfPoints-1)){
            System.out.println("More points than allocated");
            return;
        }
        points[pointCount] = new Point(x, y);
        pointCount++;
    }

    public void finalise(){
        points[pointCount] = points[0];
    }

    public double distance(){
        double dist = 0;
        dist = points[0].distance();
        for (int i = 0; i < pointCount; i++) {
            if (points[i].distance()<dist){
                dist = points[i].distance();
            }
        }
        return dist;
    }

    public double area(){
        double tempArea = 0, area =0;

        for (int i = 0; i<numOfPoints-2;i++){
            System.out.println("rep "+i);
            tempArea = ((points[i+1].getX()+points[i].getX())*(points[i+1].getY()-points[i].getY()));
            System.out.println(tempArea);
            area += tempArea;
            //System.out.println("area:"+tempArea);
        }
        area = Math.sqrt(area*area);
        area = 0.5*area;
        System.out.println("area:"+area);
        area *= 100.0;
        area = Math.round(area);
        area = area/100.0;
        return area;

    }

    @Override
    public String toString() {
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
