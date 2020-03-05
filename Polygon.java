import java.util.*;
public class Polygon {

    private Point[] points;
    int numOfPoints = 5, pointCount =0;


    Polygon(int numOfPoints){
        points = new Point[numOfPoints];
    }

    public void addPoint(Point p){
        if ((pointCount-1)>=numOfPoints){
            System.out.println("More points than allocated");
            return;
        }
        points[pointCount] = new Point(p.getX(),p.getY());
        pointCount++;
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
        double area = 0;

        for (int i = 0; i<numOfPoints-2;i++){
            area = ((points[i+1].getX()+points[i].getX())*(points[i+1].getY()-points[i].getY()));
        }
        area = Math.round(1/2*area*100);
        area = area/100;
        return area;

    }

    @Override
    public String toString() {
        String out = "[";
        for (int i =0;i<pointCount;i++){
            out += points[i].toString() + ", ";
        }
        out += "] : " + area();
        return out;
    }
}
