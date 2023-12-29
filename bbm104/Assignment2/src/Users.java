import java.util.ArrayList;

public abstract class Users extends Monopoly{
    private String name;
    private double money;
    public static ArrayList<Properties> soldProperties = new ArrayList<Properties>();

    public Users(String name,double money){
        this.setName(name);
        this.setMoney(money);
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getMoney() {return money;}
    public void setMoney(double money) {this.money = money;}
}
