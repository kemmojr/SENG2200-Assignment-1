import java.util.*;
public class Polygon {

    private Point[] points;
    private Point first;
    int numOfPoints = 5, pointCount =0;


    Polygon(int numOfPoints){
        points = new Point[numOfPoints];
    }

    public void addPoint(double x, double y){
        if (pointCount==0){
            first = new Point(x,y);
        }

        if ((pointCount-1)>=numOfPoints){
            System.out.println("More points than allocated");
            return;
        }
        points[pointCount] = new Point(x, y);
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
        double tempArea = 0, area =0;

        for (int i = 0; i<numOfPoints-2;i++){
            tempArea = ((points[i+1].getX()+points[i].getX())*(points[i+1].getY()-points[i].getY()));
            tempArea = Math.sqrt(tempArea*tempArea);
            area += tempArea;
            System.out.println("area:"+area);
        }
        area = 0.5*area;
        area *= 100;
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
