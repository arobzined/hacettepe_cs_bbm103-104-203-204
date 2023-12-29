import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Community extends Cards{
    public static int comCount = 0;
    public static ArrayList<String> communitycards = new ArrayList<String>();
    public Community(String itemvalue){
        super(itemvalue);
    }
    public static void drawCommunityChest(Banker banker, Player thisPlayer, Player oppesitePlayer, int diceNumber, BufferedWriter output) throws IOException {
        if (comCount < communitycards.size()){
            String nextCard = communitycards.get(comCount);
            if (nextCard.equals("Advance to Go (Collect $200)")){
                thisPlayer.setPosition(0);
                thisPlayer.setMoney(thisPlayer.getMoney()+200);
                banker.setMoney(banker.getMoney() - 200);
                comCount++;
            }
            else if(nextCard.equals("Bank error in your favor - collect $75")){
                thisPlayer.setMoney(thisPlayer.getMoney() + 75);
                banker.setMoney(banker.getMoney() - 75);
                comCount++;
            }
            else if(nextCard.equals("Doctor's fees - Pay $50")){
                thisPlayer.setMoney(thisPlayer.getMoney() - 50);
                banker.setMoney(banker.getMoney() + 50);
                comCount++;
            }
            else if(nextCard.equals("It is your birthday Collect $10 from each player")){
                thisPlayer.setMoney(thisPlayer.getMoney() + 10);
                oppesitePlayer.setMoney(oppesitePlayer.getMoney() - 10);
                comCount++;
            }
            else if(nextCard.equals("Grand Opera Night - collect $50 from every player for opening night seats")){
                thisPlayer.setMoney(thisPlayer.getMoney() + 50);
                oppesitePlayer.setMoney(oppesitePlayer.getMoney() - 50);
                comCount++;
            }
            else if(nextCard.equals("Income Tax refund - collect $20")){
                thisPlayer.setMoney(thisPlayer.getMoney() + 20);
                banker.setMoney(banker.getMoney() - 20);
                comCount++;
            }
            else if(nextCard.equals("Life Insurance Matures - collect $100")) {
                thisPlayer.setMoney(thisPlayer.getMoney() + 100);
                banker.setMoney(banker.getMoney() - 100);
                comCount++;
            }
            else if(nextCard.equals("Pay Hospital Fees of $100")) {
                thisPlayer.setMoney(thisPlayer.getMoney() - 100);
                banker.setMoney(banker.getMoney() + 200);
                comCount++;

            }
            else if(nextCard.equals("Pay School Fees of $50")){
                thisPlayer.setMoney(thisPlayer.getMoney() - 50);
                banker.setMoney(banker.getMoney() + 50);
                comCount++;
            }
            else if(nextCard.equals("You inherit $100")){
                thisPlayer.setMoney(thisPlayer.getMoney() + 100);
                banker.setMoney(banker.getMoney() - 100);
                comCount++;
            }
            else if(nextCard.equals("From sale of stock you get $50")){
                thisPlayer.setMoney(thisPlayer.getMoney() + 50);
                banker.setMoney(banker.getMoney() - 50);
                comCount++;
            }
            if (thisPlayer.getName().equals("Player 1")){
                output.write(thisPlayer.getName()+"\t"+diceNumber+"\t"+
                        (thisPlayer.getPosition()+1)+"\t"+(int)thisPlayer.getMoney()+"\t"+
                        (int)oppesitePlayer.getMoney()+"\t"+thisPlayer.getName()+" draw "+nextCard);

            }
            else if(thisPlayer.getName().equals("Player 2")){
                output.write(thisPlayer.getName()+"\t"+diceNumber+"\t"+
                        (thisPlayer.getPosition()+1)+"\t"+(int)oppesitePlayer.getMoney()+"\t"+
                        (int)thisPlayer.getMoney()+"\t"+thisPlayer.getName()+" draw "+nextCard);

            }
        }
        if(comCount == communitycards.size()){
            comCount = 0;
        }
    }

    }
