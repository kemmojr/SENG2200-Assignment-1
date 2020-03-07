import java.util.*;
import java.lang.Math;
public class Point {
    private double x = 1;
    private double y = 2;

    Point(double xValue, double yValue){
        x = xValue;
        y = yValue;
    }

    public Point(Point p){
        x = p.getX();
        y = p.getY();
    }

    public double distance(){
        double distance = Math.sqrt(x*x+y*y);

        return distance;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public String toString() {
        String out = "(" + x + ", " + y + ")";
        return out;
    }
}
