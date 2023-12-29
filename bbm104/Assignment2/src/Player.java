import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class Player extends Users{
    private int position;
    private int railRoadsCount;
    private int jailCount;
    private boolean isInJail;
    private int freeParkingCount;
    private boolean isInPark;
    private int bankrupt;
    private ArrayList<Properties> propertiesList = new ArrayList<Properties>();
    public Player(String name,double money,int position,int jailCount,boolean isInJail,int freeParkingCount,boolean isInPark,int bankrupt){
        super(name,money);
        this.position = position;
        this.jailCount = jailCount;
        this.isInJail = isInJail;
        this.setFreeParkingCount(freeParkingCount);
        this.setInPark(isInPark);

    }

    public ArrayList<Properties> getPropertiesList() {return propertiesList;}
    public void setPropertiesList(ArrayList<Properties> propertiesList) {this.propertiesList = propertiesList;}

    public void buyProperty(Banker banker, Properties anObject, Player anPlayer, Player otherPlayer, int diceNumber, BufferedWriter output) throws IOException {
        if ((anPlayer.getMoney() >= anObject.getCost()) || (anPlayer.propertiesList.contains(anObject))){
            if (!propertiesList.contains(anObject) && !soldProperties.contains(anObject)){
                soldProperties.add(anObject);
                this.propertiesList.add(anObject);
                setMoney(getMoney() - anObject.getCost());
                banker.setMoney(banker.getMoney() + anObject.getCost());
                if(anObject instanceof RailRoads){
                    railRoadsCount += 1;
                }
                if (anPlayer.getName().equals("Player 1")){
                    output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                            (anPlayer.getPosition()+1)+"\t"+(int)anPlayer.getMoney()+"\t"+
                            (int)otherPlayer.getMoney()+"\t"+anPlayer.getName()+" bought "+anObject.getName());
                }
                else if (anPlayer.getName().equals("Player 2")){
                    output.write(anPlayer.getName() + "\t" + diceNumber + "\t" +
                            (anPlayer.getPosition()+1) + "\t" + (int)otherPlayer.getMoney() + "\t" +
                            (int)anPlayer.getMoney() + "\t" + anPlayer.getName() + " bought " + anObject.getName());
                }
            } else if(soldProperties.contains(anObject)){
                if (anPlayer.propertiesList.contains(anObject)){
                    if (anPlayer.getName().equals("Player 1")){
                        output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                                (anPlayer.getPosition()+1)+"\t"+(int)anPlayer.getMoney()+"\t"+
                                (int)otherPlayer.getMoney()+"\t"+anPlayer.getName()+" has "+anObject.getName());
                    }
                    else if (anPlayer.getName().equals("Player 2")){
                        output.write(anPlayer.getName() + "\t" + diceNumber + "\t" +
                                (anPlayer.getPosition()+1) + "\t" + (int)otherPlayer.getMoney() + "\t" +
                                (int)anPlayer.getMoney() + "\t" + anPlayer.getName() + " has " + anObject.getName());
                    }
                }
                else {
                    if (anObject instanceof Lands) {
                        payLandRent(anObject, anPlayer, otherPlayer, diceNumber,output);
                    } else if (anObject instanceof RailRoads) {
                        payRailRoadRent(anObject, anPlayer, otherPlayer, diceNumber,output);
                    } else if (anObject instanceof Companies) {
                        payCompanyRent(anObject, anPlayer, otherPlayer, diceNumber,output);
                    }
                }
            }
        }
        else if((anPlayer.getMoney() < anObject.getCost()) && !(anPlayer.propertiesList.contains(anObject))){
            if (anPlayer.getName().equals("Player 1")){
                output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                        (anPlayer.getPosition()+1)+"\t"+(int)anPlayer.getMoney()+"\t"+
                        (int)otherPlayer.getMoney()+"\t"+anPlayer.getName()+" goes bankrupt ");
                anPlayer.setBankrupt(1);

            }
            else if (anPlayer.getName().equals("Player 2")){
                output.write(anPlayer.getName() + "\t" + diceNumber + "\t" +
                        (anPlayer.getPosition()+1) + "\t" + (int)otherPlayer.getMoney() + "\t" +
                        (int)anPlayer.getMoney() + "\t" + anPlayer.getName() + " goes bankrupt ");
                anPlayer.setBankrupt(1);
            }
        }
    }
    public void payLandRent(Properties anObject, Player anPlayer, Player otherPlayer, int diceNumber, BufferedWriter output) throws IOException {
        if(anObject.getCost() <= 2000){
            anPlayer.setMoney(anPlayer.getMoney() - (anObject.getCost() * 0.4));
            otherPlayer.setMoney(otherPlayer.getMoney() + (anObject.getCost() * 0.4));
            if (anPlayer.getName().equals("Player 1")){
                output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                        (anPlayer.getPosition()+1)+"\t"+(int)anPlayer.getMoney()+"\t"+
                        (int)otherPlayer.getMoney()+"\t"+anPlayer.getName()+" paid rent for "+anObject.getName());
            }
            else {
                output.write(anPlayer.getName() + "\t" + diceNumber + "\t" +
                        (anPlayer.getPosition()+1) + "\t" + (int)otherPlayer.getMoney() + "\t" +
                        (int)anPlayer.getMoney() + "\t" + anPlayer.getName() + " paid rent for " + anObject.getName());
            }
        } else if((2000 < anObject.getCost()) && (anObject.getCost() <= 3000)){
            anPlayer.setMoney(anPlayer.getMoney() - (anObject.getCost() * 0.3));
            otherPlayer.setMoney(otherPlayer.getMoney() + (anObject.getCost() * 0.3));
            if (anPlayer.getName().equals("Player 1")){
                output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                        (anPlayer.getPosition()+1)+"\t"+(int)anPlayer.getMoney()+"\t"+
                        (int)otherPlayer.getMoney()+"\t"+anPlayer.getName()+" paid rent for "+anObject.getName());
            } else {
                output.write(anPlayer.getName() + "\t" + diceNumber + "\t" +
                        (anPlayer.getPosition()+1) + "\t" + (int)otherPlayer.getMoney() + "\t" +
                        (int)anPlayer.getMoney() + "\t" + anPlayer.getName() + " paid rent for " + anObject.getName());
            }
        } else if((3000 < anObject.getCost()) && (anObject.getCost() <= 4000)){
            anPlayer.setMoney(anPlayer.getMoney() - (anObject.getCost() * 0.35));
            otherPlayer.setMoney(otherPlayer.getMoney() + (anObject.getCost() * 0.35));
            if (anPlayer.getName().equals("Player 1")){
                output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                        (anPlayer.getPosition()+1)+"\t"+(int)anPlayer.getMoney()+"\t"+
                        (int)otherPlayer.getMoney()+"\t"+anPlayer.getName()+" paid rent for "+anObject.getName());
            } else {
                output.write(anPlayer.getName() + "\t" + diceNumber + "\t" +
                        (anPlayer.getPosition()+1) + "\t" + (int)otherPlayer.getMoney() + "\t" +
                        (int)anPlayer.getMoney() + "\t" + anPlayer.getName() + " paid rent for " + anObject.getName());
            }
        }
    }
    public void payRailRoadRent(Properties anObject,Player anPlayer,Player otherPlayer,int diceNumber,BufferedWriter output) throws IOException {
        anPlayer.setMoney(anPlayer.getMoney() - (25*anPlayer.railRoadsCount));
        otherPlayer.setMoney(otherPlayer.getMoney() + (25*anPlayer.railRoadsCount));
        output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                (anPlayer.getPosition()+1)+"\t"+(int)anPlayer.getMoney()+"\t"+
                (int)otherPlayer.getMoney()+"\t"+anPlayer.getName()+" paid rent for "+anObject.getName());
    }
    public void payCompanyRent(Properties anObject,Player anPlayer,Player otherPlayer,int diceNumber,BufferedWriter output) throws IOException {
        anPlayer.setMoney(anPlayer.getMoney() - (4*diceNumber));
        otherPlayer.setMoney(otherPlayer.getMoney() + (4*diceNumber));
        output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                (anPlayer.getPosition()+1)+"\t"+(int)anPlayer.getMoney()+"\t"+
                (int)otherPlayer.getMoney()+"\t"+anPlayer.getName()+" paid rent for "+anObject.getName());
    }

    public void stayJail(Player anPlayer,Player otherPlayer,int diceNumber,BufferedWriter output) throws IOException {
        if (anPlayer.getJailCount() <= 3){
            if (anPlayer.getJailCount() == 0){
                if (anPlayer.getName().equals("Player 1")){
                    anPlayer.setInJail(true);
                    anPlayer.setPosition(10);
                    output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                            (anPlayer.getPosition()+1)+"\t"+(int)anPlayer.getMoney()+"\t"+
                            (int)otherPlayer.getMoney()+"\t"+anPlayer.getName()+" went to jail\n");
                    anPlayer.setJailCount(anPlayer.getJailCount() + 1);


                }
                else if(anPlayer.getName().equals("Player 2")){
                    anPlayer.setInJail(true);
                    anPlayer.setPosition(10);
                    output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                            (anPlayer.getPosition()+1)+"\t"+(int)otherPlayer.getMoney()+"\t"+
                            (int)anPlayer.getMoney()+"\t"+anPlayer.getName()+" went to jail\n");
                    anPlayer.setJailCount(anPlayer.getJailCount() + 1);

                }
            }
            else if(anPlayer.getJailCount() >= 1){
                anPlayer.setInJail(true);
                anPlayer.setPosition(10);
                if (anPlayer.getName().equals("Player 1")){
                    output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                            (anPlayer.getPosition()+1)+"\t"+(int)anPlayer.getMoney()+"\t"+
                            (int)otherPlayer.getMoney()+"\t"+anPlayer.getName()+" in jail(count="+anPlayer.getJailCount()+")\n");
                    anPlayer.setJailCount(anPlayer.getJailCount() + 1);




                }
                else if(anPlayer.getName().equals("Player 2")){
                    anPlayer.setInJail(true);
                    anPlayer.setPosition(10);
                    output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                            (anPlayer.getPosition()+1)+"\t"+(int)otherPlayer.getMoney()+"\t"+
                            (int)anPlayer.getMoney()+"\t"+anPlayer.getName()+" in jail(count="+anPlayer.getJailCount()+")\n");
                    anPlayer.setJailCount(anPlayer.getJailCount() + 1);



                }
            }
            if(anPlayer.getJailCount() > 3){
                anPlayer.setPosition(10);
                anPlayer.setJailCount(0);
                anPlayer.setInJail(false);

            }
        }
    }

    public void stayFreeParking(Player anPlayer,Player otherPlayer,int diceNumber,BufferedWriter output) throws IOException {
        if (anPlayer.getFreeParkingCount() == 0){
            anPlayer.setInPark(true);
            anPlayer.setPosition(20);
            output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                    anPlayer.getPosition()+"\t"+(int)otherPlayer.getMoney()+"\t"+
                    (int)anPlayer.getMoney()+"\t"+anPlayer.getName()+" is in Free Parking.\n");
            anPlayer.setFreeParkingCount(anPlayer.getFreeParkingCount() + 1);
        }
        else if (anPlayer.getFreeParkingCount() == 1){
            anPlayer.setInPark(false);
            anPlayer.setPosition(20);
            output.write(anPlayer.getName()+"\t"+diceNumber+"\t"+
                    anPlayer.getPosition()+"\t"+(int)otherPlayer.getMoney()+"\t"+
                    (int)anPlayer.getMoney()+"\t"+anPlayer.getName()+" is in Free Parking.(count="+anPlayer.getFreeParkingCount()+")\n");
            anPlayer.setFreeParkingCount(0);
        }
    }

    public int getPosition() {return position;}

    public void setPosition(int position) {this.position = position;}

    public int getJailCount() {return jailCount;}


    public void setJailCount(int jailCount) {this.jailCount = jailCount;}

    public boolean isInJail() {return isInJail;}

    public void setInJail(boolean inJail) {isInJail = inJail;}

    public int getFreeParkingCount() {
        return freeParkingCount;
    }

    public void setFreeParkingCount(int freeParkingCount) {
        this.freeParkingCount = freeParkingCount;
    }

    public boolean isInPark() {
        return isInPark;
    }

    public void setInPark(boolean inPark) {
        isInPark = inPark;
    }

    public int getBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(int bankrupt) {
        this.bankrupt = bankrupt;
    }
}
