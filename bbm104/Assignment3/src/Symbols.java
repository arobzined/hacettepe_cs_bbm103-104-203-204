import java.util.ArrayList;

public abstract class Symbols{
    private String name;
    private int point;
    public Symbols(String name,int point){
        this.setName(name);
        this.setPoint(point);
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getPoint() {return point;}

    public void setPoint(int point) {this.point = point;}

    abstract int moves(ArrayList<ArrayList<String>> gameBoard,String[] anArray,int row,int column,Players anPlayer);
}
