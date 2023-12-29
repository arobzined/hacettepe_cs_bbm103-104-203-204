import java.util.ArrayList;

public class Square extends Diamonds{
    public Square(String name, int point) {
        super(name, point);
    }

    @Override
    int moves(ArrayList<ArrayList<String>> gameBoard,int row,int column,Players anPlayer) {
        int score = 0;
        if ((column == 0) || (column == 1)){
            if ((gameBoard.get(row).get(column+1).equals("S"))){
                if ((gameBoard.get(row).get(column+2).equals("S"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 15);
                    score += 15;
                    if ((gameBoard.get(row).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    if ((gameBoard.get(row).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row).set(column+1," ");
                    gameBoard.get(row).set(column+2," ");
                    return score;
                }
            }
        }
        else if ((1 < column) && (column < gameBoard.get(0).size() - 2)){
            if ((gameBoard.get(row).get(column-1).equals("S"))){
                if ((gameBoard.get(row).get(column-2).equals("S"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 15);
                    score += 15;
                    if ((gameBoard.get(row).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    if ((gameBoard.get(row).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row).set(column-1," ");
                    gameBoard.get(row).set(column-2," ");
                    return score;
                }
            }
            if ((gameBoard.get(row).get(column+1).equals("S"))){
                if ((gameBoard.get(row).get(column+2).equals("S"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 15);
                    score += 15;
                    if ((gameBoard.get(row).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    if ((gameBoard.get(row).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row).set(column+1," ");
                    gameBoard.get(row).set(column+2," ");
                    return score;
                }
            }

        }
        else if ((column == gameBoard.get(0).size() - 2) || (column == gameBoard.get(0).size() - 1)){
            if ((gameBoard.get(row).get(column-1).equals("S"))){
                if ((gameBoard.get(row).get(column-2).equals("S"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 15);
                    score += 15;
                    if ((gameBoard.get(row).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    if ((gameBoard.get(row).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row).set(column-1," ");
                    gameBoard.get(row).set(column-2," ");
                    return score;
                }
            }
        }
        return score;
    }
}
