import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Chance extends Cards{
    private static int cardCount = 0;
    public static ArrayList<String> chancecards = new ArrayList<String>();
    public Chance(String itemvalue){
        super(itemvalue);
    }

    public static void drawCard(Banker banker, Player thisPlayer, Player oppesitePlayer, int diceNumber, BufferedWriter output) throws IOException {
        if (cardCount < chancecards.size()){
            String nextCard = chancecards.get(cardCount);
            if (nextCard.equals("Advance to Go (Collect $200)")){
                thisPlayer.setPosition(0);
                thisPlayer.setMoney(thisPlayer.getMoney()+200);
                banker.setMoney(banker.getMoney() - 200);
                cardCount++;
            }
            else if(nextCard.equals("Advance to Leicester Square")){
                thisPlayer.setPosition(26);
                for (Lands i : Lands.landsArrayList){
                    if (i.getName().equals("Leicester Square")){
                        thisPlayer.buyProperty(banker,i,thisPlayer,oppesitePlayer,diceNumber,output);

                    }
                }
                cardCount++;
            }
            else if(nextCard.equals("Go back 3 spaces")){
                thisPlayer.setPosition(thisPlayer.getPosition() - 3);
                if (thisPlayer.getPosition() == 4){
                    thisPlayer.setMoney(thisPlayer.getMoney() - 100);
                    banker.setMoney(banker.getMoney() + 100);
                }
                else if(thisPlayer.getPosition() == 19){
                    for (Lands i : Lands.landsArrayList){
                        if (i.getName().equals("Vine Street")){
                            thisPlayer.buyProperty(banker,i,thisPlayer,oppesitePlayer,diceNumber,output);
                        }
                    }
                }
                else if(thisPlayer.getPosition() == 33){
                    Community.drawCommunityChest(banker,thisPlayer,oppesitePlayer,diceNumber,output);
                }
                cardCount++;
            }
            else if(nextCard.equals("Pay poor tax of $15")){
                thisPlayer.setMoney(thisPlayer.getMoney() - 15);
                cardCount++;
            }
            else if(nextCard.equals("Your building loan matures - collect $150")){
                thisPlayer.setMoney(thisPlayer.getMoney() + 150);
                cardCount++;
            }
            else if(nextCard.equals("You have won a crossword competition - collect $100 ")){
                thisPlayer.setMoney(thisPlayer.getMoney() + 100);
                cardCount++;
            }
            if (thisPlayer.getName().equals("Player 1")){
                if ((thisPlayer.getPosition() == 19 ) || (thisPlayer.getPosition() == 26)){
                    output.write(" -- draw " +nextCard+"\n");
                }
                else if((thisPlayer.getPosition() == 33)){
                    output.write(" -- draw " +nextCard+"\n");
                }
                else {
                    output.write(thisPlayer.getName() + "\t" + diceNumber + "\t" +
                            (thisPlayer.getPosition() + 1) + "\t" + (int) thisPlayer.getMoney() + "\t" +
                            (int) oppesitePlayer.getMoney() + "\t" + thisPlayer.getName() + " draw Chance Card -" + nextCard+"\n");
                }
            }
            else if(thisPlayer.getName().equals("Player 2")){
                if ((thisPlayer.getPosition() == 19 ) || (thisPlayer.getPosition() == 26)){
                    output.write(" -- draw " +nextCard+"\n");
                }
                else if((thisPlayer.getPosition() == 33)){
                    output.write(" -- draw " +nextCard+"\n");
                }
                else {
                    output.write(thisPlayer.getName() + "\t" + diceNumber + "\t" +
                            (thisPlayer.getPosition() + 1) + "\t" + (int) oppesitePlayer.getMoney() + "\t" +
                            (int) thisPlayer.getMoney() + "\t" + thisPlayer.getName() + " draw " + nextCard+"\n");
                }
            }
        }
        if(cardCount == chancecards.size()){
            cardCount = 0;
        }
    }
    public int getCardCount() {
        return cardCount;
    }
}
