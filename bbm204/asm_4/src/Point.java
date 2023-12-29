import java.util.ArrayList;
import java.util.List;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int getX(){
      return this.x;
    }
    public int getY(){
      return this.y;
    }

    public double distance(Point neighbor){
        // the euclidean part , ı used in some parts , but then I realised it is unnecessary .
        //
      int w = (this.x - neighbor.x) * (this.x - neighbor.x); 
      int h = (this.y - neighbor.y) * (this.y - neighbor.y); 
      return Math.sqrt(h + w);
    }

    // You can add additional variables and methods if necessary.
}
