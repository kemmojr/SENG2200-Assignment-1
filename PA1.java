import java.util.*;
import java.io.*;
public class PA1 {
    //Implement all of the main loop and working with the MyPolygons

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
                //System.out.println("While");
                int numOfPoints = reader.nextInt();
                System.out.println(numOfPoints);
                Polygon p = new Polygon(numOfPoints);
                for (int i = 0; i < numOfPoints; i++) {
                    //Point pt = new Point();
                    //System.out.println(reader.nextDouble());
                    //System.out.println("i:"+i);
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
                        //if ()
                    } else {
                        b = false;
                    }
                } catch (Exception e){
                    //Do nothing
                    break;
                }


            }
        } catch (Exception e){
            //Exception code
            System.out.println("Error");
        }

        //mp.insertionSort();
        //System.out.println("Sorted");
        System.out.println(mp);
    }
}
