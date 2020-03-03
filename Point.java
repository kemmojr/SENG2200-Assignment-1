import java.util.*;
import java.lang.Math;
public class Point {
    double x = 1;
    double y = 2;

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
