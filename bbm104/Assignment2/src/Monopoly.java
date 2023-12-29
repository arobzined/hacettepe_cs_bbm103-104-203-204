import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Monopoly {
    public static ArrayList<String> board = new ArrayList<String>();


    public void buildBoard() {
        for (int i = 0;i < 40;i++){
            board.add("");
        }
        for(Lands a : Lands.landsArrayList){
            board.set(a.getId()-1,a.getName());
        }
        for(RailRoads a : RailRoads.railroadsarray){
            board.set(a.getId()-1,a.getName());
        }
        for(Companies a : Companies.comlist){
            board.set(a.getId()-1,a.getName());
        }
        board.set(0,"Go");  board.set(2,"Community Chest");
        board.set(4,"Income Tax");  board.set(7,"Chance");
        board.set(10,"Jail");  board.set(17,"Community Chest");
        board.set(20,"Free Parking");  board.set(22,"Chance");
        board.set(30,"Go to Jail");  board.set(33,"Community Chest");
        board.set(36,"Chance");  board.set(38,"Super Tax");
    }

    public void playMonopoly(String[] anInput, BufferedWriter output) throws IOException {
        Player player1 = new Player("Player 1", 15000, 0,0,false,0,false,0);
        Player player2 = new Player("Player 2", 15000, 0,0,false,0,false,0);
        Banker banker = new Banker("Banker", 100000);
        int inputLong = anInput.length;
        int count = 0;

        for (String i : anInput) {
            count++;
            if ((count == inputLong+1) || (player1.getMoney() <= 0) || (player2.getMoney() <= 0) || (player1.getBankrupt() == 1) || (player2.getBankrupt() == 1)){
                break;
            }
            String[] inputLine = i.split(";");
            if (inputLine.length == 1){
                if (inputLine[0].equals("show()")) {
                    output.write("-------------------------------------------------------------------------------------------------------------------------\n");
                    output.write(player1.getName()+"\t"+(int)player1.getMoney()+"\thave:\t");
                    for (Properties a : player1.getPropertiesList()){
                        output.write(a.getName()+",");
                    }
                    output.write("\n");
                    output.write(player2.getName()+"\t"+(int)player2.getMoney()+"\thave:\t");
                    for (Properties a : player2.getPropertiesList()){
                        output.write(a.getName()+",");
                    }
                    output.write("\n");
                    output.write(banker.getName()+"\t"+(int)banker.getMoney());
                    if (player1.getMoney() > player2.getMoney()){
                        output.write("\nWinner\t"+player1.getName()+"\n");
                    }
                    else if (player2.getMoney() > player1.getMoney()){
                        output.write("\nWinner\t"+player2.getName()+"\n");
                    }
                    output.write("-------------------------------------------------------------------------------------------------------------------------\n");

                }
            }
            else if(inputLine.length == 2){
                String playerName = inputLine[0];
                int diceNumber = Integer.parseInt(inputLine[1]);
                if (inputLine[0].equals("Player 1")) {
                    if (player1.getPosition() + diceNumber >= 40) {
                        if (player1.isInJail()) {
                            player1.stayJail(player1,player2,diceNumber,output);
                        }
                        else if(player1.isInPark()){
                            player1.stayFreeParking(player1,player2,diceNumber,output);
                        }
                        else{
                            player1.setPosition((player1.getPosition() + diceNumber) - 40);
                            int position = player1.getPosition();
                            player1.setMoney(player1.getMoney() + 200);
                            banker.setMoney(banker.getMoney() - 200);
                            for (String j : Properties.propertyArrayListNames) {
                                if (board.get(player1.getPosition()).equals(j)) {
                                    for (Lands k : Lands.landsArrayList) {
                                        if (j.equals(k.getName())) {
                                            player1.buyProperty(banker, k, player1, player2, diceNumber,output);
                                            output.write("\n");

                                        }
                                    }
                                    for (RailRoads k : RailRoads.railroadsarray) {
                                        if (j.equals(k.getName())) {
                                            player1.buyProperty(banker, k, player1, player2, diceNumber,output);
                                            output.write("\n");

                                        }
                                    }
                                    for (Companies k : Companies.comlist) {
                                        if (j.equals(k.getName())) {
                                            player1.buyProperty(banker, k, player1, player2, diceNumber,output);
                                            output.write("\n");

                                        }
                                    }

                                }
                            }    if (board.get(player1.getPosition()).equals("Chance")) {
                                    Chance.drawCard(banker, player1, player2,diceNumber,output);
                                } else if (board.get(player1.getPosition()).equals("Community Chest")) {
                                    Community.drawCommunityChest(banker, player1, player2,diceNumber,output);
                                output.write("\n");
                                } else if (board.get(player1.getPosition()).equals("Income Tax") || board.get(player1.getPosition()).equals("Super Tax")) {
                                    player1.setMoney(player1.getMoney() - 100);
                                    banker.setMoney(banker.getMoney()+100);
                                output.write(player1.getName() + "\t" + diceNumber + "\t" +
                                        (player1.getPosition()+1) + "\t" + (int)player1.getMoney() + "\t" +
                                        (int)player2.getMoney() + "\t" + player1.getName() + " paid Tax\n");
                                } else if (board.get(player1.getPosition()).equals("Go")) {
                                } else if (board.get(player1.getPosition()).equals("Jail")) {
                                    player1.stayJail(player1,player2,diceNumber,output);
                                } else if (board.get(player1.getPosition()).equals("Free Parking")) {
                                    player1.stayFreeParking(player1,player2,diceNumber,output);
                                } else if (board.get(player1.getPosition()).equals("Go to Jail")) {
                                    player1.setPosition(10);
                                    player1.stayJail(player1,player2,diceNumber,output);
                                }
                            }

                    } else {
                        if (player1.isInJail()) {
                            player1.stayJail(player1,player2,diceNumber,output);
                        }
                        else if(player1.isInPark()){
                            player1.stayFreeParking(player1,player2,diceNumber,output);
                        }
                        else {
                            player1.setPosition(player1.getPosition() + diceNumber);
                            int position = player1.getPosition();
                            for (String j : Properties.propertyArrayListNames) {
                                if (board.get(player1.getPosition()).equals(j)) {
                                    for (Lands k : Lands.landsArrayList) {
                                        if (j.equals(k.getName())) {
                                            player1.buyProperty(banker, k, player1, player2, diceNumber,output);
                                            output.write("\n");

                                        }
                                    }
                                    for (RailRoads k : RailRoads.railroadsarray) {
                                        if (j.equals(k.getName())) {
                                            player1.buyProperty(banker, k, player1, player2, diceNumber,output);
                                            output.write("\n");

                                        }
                                    }
                                    for (Companies k : Companies.comlist) {
                                        if (j.equals(k.getName())) {
                                            player1.buyProperty(banker, k, player1, player2, diceNumber,output);
                                            output.write("\n");

                                        }
                                    }

                                }
                            }   if (board.get(player1.getPosition()).equals("Chance")) {
                                    Chance.drawCard(banker, player1, player2,diceNumber,output);
                                } else if (board.get(player1.getPosition()).equals("Community Chest")) {
                                    Community.drawCommunityChest(banker, player1, player2,diceNumber,output);
                                output.write("\n");
                                } else if (board.get(player1.getPosition()).equals("Income Tax") || board.get(player1.getPosition()).equals("Super Tax")) {
                                    player1.setMoney(player1.getMoney() - 100);
                                    banker.setMoney(banker.getMoney()+100);
                                output.write(player1.getName() + "\t" + diceNumber + "\t" +
                                        (player1.getPosition()+1) + "\t" + (int)player1.getMoney() + "\t" +
                                        (int)player2.getMoney() + "\t" + player1.getName() + " paid Tax\n");
                                } else if (board.get(player1.getPosition()).equals("Go")) {
                                } else if (board.get(player1.getPosition()).equals("Jail")) {
                                    player1.stayJail(player1,player2,diceNumber,output);
                                } else if (board.get(player1.getPosition()).equals("Free Parking")) {
                                    player1.stayFreeParking(player1,player2,diceNumber,output);
                                } else if (board.get(player1.getPosition()).equals("Go to Jail")) {
                                    player1.setPosition(10);
                                    player1.stayJail(player1,player2,diceNumber,output);
                                }

                            }
                        }
                } else if (inputLine[0].equals("Player 2")) {
                    if (player2.getPosition() + diceNumber >= 40) {
                        if (player2.isInJail()) {
                            player2.stayJail(player2,player1,diceNumber,output);
                        }
                        else if(player2.isInPark()){
                            player2.stayFreeParking(player2,player1,diceNumber,output);
                        }
                        else{
                            player2.setPosition((player2.getPosition() + diceNumber) - 40);
                            int position = player2.getPosition();
                            player2.setMoney(player2.getMoney() + 200);
                            banker.setMoney(banker.getMoney() - 200);
                            for (String j : Properties.propertyArrayListNames) {
                                if (board.get(player2.getPosition()).equals(j)) {
                                    for (Lands k : Lands.landsArrayList) {
                                        if (j.equals(k.getName())) {
                                            player2.buyProperty(banker, k, player2, player1, diceNumber,output);
                                            output.write("\n");
                                        }
                                    }
                                    for (RailRoads k : RailRoads.railroadsarray) {
                                        if (j.equals(k.getName())) {
                                            player2.buyProperty(banker, k, player2, player1, diceNumber,output);
                                            output.write("\n");

                                        }
                                    }
                                    for (Companies k : Companies.comlist) {
                                        if (j.equals(k.getName())) {
                                            player2.buyProperty(banker, k, player2, player1, diceNumber,output);
                                            output.write("\n");

                                            }
                                        }
                                    }
                                }  if (board.get(player2.getPosition()).equals("Chance")) {
                                    Chance.drawCard(banker, player2, player1,diceNumber,output);
                                } else if (board.get(player2.getPosition()).equals("Community Chest")) {
                                    Community.drawCommunityChest(banker, player2, player1,diceNumber,output);
                                output.write("\n");
                                } else if (board.get(player2.getPosition()).equals("Income Tax") || board.get(player2.getPosition()).equals("Super Tax")) {
                                    player2.setMoney(player2.getMoney() - 100);
                                banker.setMoney(banker.getMoney()+100);
                                output.write(player2.getName() + "\t" + diceNumber + "\t" +
                                        (player2.getPosition()+1) + "\t" + (int)player1.getMoney() + "\t" +
                                        (int)player2.getMoney() + "\t" + player2.getName() + " paid Tax\n");
                                } else if (board.get(player2.getPosition()).equals("Go")) {
                                } else if (board.get(player2.getPosition()).equals("Jail")) {
                                    player2.stayJail(player2,player1,diceNumber,output);
                                } else if (board.get(player2.getPosition()).equals("Free Parking")) {
                                    player1.stayFreeParking(player2,player1,diceNumber,output);
                                } else if (board.get(player2.getPosition()).equals("Go to Jail")) {
                                    player2.setPosition(10);
                                    player2.stayJail(player2,player1,diceNumber,output);
                                }
                            }

                    } else {
                        if (player2.isInJail()) {
                            player2.stayJail(player2,player1,diceNumber,output);
                        }
                        else if(player2.isInPark()){
                            player2.stayFreeParking(player2,player1,diceNumber,output);
                        }
                        else{
                            player2.setPosition(player2.getPosition() + diceNumber);
                            int position = player2.getPosition();
                            for (String j : Properties.propertyArrayListNames) {
                                if (board.get(player2.getPosition()).equals(j)) {
                                    for (Lands k : Lands.landsArrayList) {
                                        if (j.equals(k.getName())) {
                                            player2.buyProperty(banker, k, player2, player1, diceNumber,output);
                                            output.write("\n");

                                        }
                                    }
                                    for (RailRoads k : RailRoads.railroadsarray) {
                                        if (j.equals(k.getName())) {
                                            player2.buyProperty(banker, k, player2, player1, diceNumber,output);
                                            output.write("\n");
                                        }
                                    }
                                    for (Companies k : Companies.comlist) {
                                        if (j.equals(k.getName())) {
                                            player2.buyProperty(banker, k, player2, player1, diceNumber,output);
                                            output.write("\n");
                                        }
                                    }
                                }
                                } if (board.get(player2.getPosition()).equals("Chance")) {
                                    Chance.drawCard(banker, player2, player1,diceNumber,output);
                                } else if (board.get(player2.getPosition()).equals("Community Chest")) {
                                    Community.drawCommunityChest(banker, player2, player1,diceNumber,output);
                                output.write("\n");
                                } else if (board.get(player2.getPosition()).equals("Income Tax") || board.get(player2.getPosition()).equals("Super Tax")) {
                                    player2.setMoney(player2.getMoney() - 100);
                                banker.setMoney(banker.getMoney()+100);
                                    output.write(player2.getName() + "\t" + diceNumber + "\t" +
                                            (player2.getPosition()+1) + "\t" + (int)player1.getMoney() + "\t" +
                                            (int)player2.getMoney() + "\t" + player2.getName() + " paid Tax\n");
                                } else if (board.get(player2.getPosition()).equals("Go")) {
                                } else if (board.get(player2.getPosition()).equals("Jail")) {
                                    player2.stayJail(player2,player1,diceNumber,output);
                                } else if (board.get(player2.getPosition()).equals("Free Parking")) {
                                    player1.stayFreeParking(player2,player1,diceNumber,output);
                                } else if (board.get(player2.getPosition()).equals("Go to Jail")) {
                                    player2.setPosition(10);
                                    player2.stayJail(player2,player1,diceNumber,output);
                                }
                            }
                        }
                    }
                }
            }

        output.write("-------------------------------------------------------------------------------------------------------------------------\n");
        output.write(player1.getName()+"\t"+(int)player1.getMoney()+"\thave:\t");
        for (Properties a : player1.getPropertiesList()){
            output.write(a.getName()+",");
        }
        output.write("\n");
        output.write(player2.getName()+"\t"+(int)player2.getMoney()+"\thave:\t");
        for (Properties a : player2.getPropertiesList()){
            output.write(a.getName()+",");
        }
        output.write("\n");
        output.write(banker.getName()+"\t"+(int)banker.getMoney());
        if (player1.getMoney() > player2.getMoney()){
            output.write("\nWinner\t"+player1.getName());
        }
        else if (player2.getMoney() > player1.getMoney()){
            output.write("\nWinner\t"+player2.getName());
        }
        output.write("\n-------------------------------------------------------------------------------------------------------------------------");

    }
}