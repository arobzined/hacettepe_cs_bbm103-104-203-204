import java.util.ArrayList;

public abstract class Diamonds {
    private String name;
    private int point;
    public Diamonds(String name,int point){
        this.setName(name);
        this.setPoint(point);
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getPoint() {return point;}

    public void setPoint(int point) {this.point = point;}

    abstract int moves(ArrayList<ArrayList<String>> gameBoard,int row,int column,Players anPlayer);

}
