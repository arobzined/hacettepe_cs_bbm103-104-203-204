import java.util.Comparator;

public class Players implements Comparable<Players> {
    private String name;
    private int point;
    public Players(String name,int point){
        this.setName(name);
        this.setPoint(point);
    }
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getPoint() {return point;}

    public void setPoint(int point) {this.point = point;}

    @Override
    public int compareTo(Players o1) {
        if (this.point > o1.point){
            return -1;
        }
        else if(this.point < o1.point){
            return 1;
        }
        else{
            return 0;
        }
    }

}
