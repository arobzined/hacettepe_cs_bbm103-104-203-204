import java.util.ArrayList;

public class Triangle extends Diamonds{
    public Triangle(String name, int point) {
        super(name, point);
    }

    @Override
    int moves(ArrayList<ArrayList<String>> gameBoard,int row,int column,Players anPlayer) {
        int score = 0;
        if ((row == 0) || (row == 1)){
            if ((gameBoard.get(row+1).get(column).equals("T"))){
                if ((gameBoard.get(row+2).get(column).equals("T"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 15);
                    score += 15;
                    if ((gameBoard.get(row+1).get(column).equals("T"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    if ((gameBoard.get(row+2).get(column).equals("T"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column," ");
                    gameBoard.get(row+2).set(column," ");
                    return score;
                }
            }
        }
        else if ((1 < row) && (row < gameBoard.size() - 2)){
            if ((gameBoard.get(row-1).get(column).equals("T"))){
                if ((gameBoard.get(row-2).get(column).equals("T"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 15);
                    score += 15;
                    if ((gameBoard.get(row-1).get(column).equals("T"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    if ((gameBoard.get(row-2).get(column).equals("T"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column," ");
                    gameBoard.get(row-2).set(column," ");
                    return score;
                }
            }
            if ((gameBoard.get(row+1).get(column).equals("T"))){
                if ((gameBoard.get(row+2).get(column).equals("T"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 15);
                    score += 15;
                    if ((gameBoard.get(row+1).get(column).equals("T"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    if ((gameBoard.get(row+2).get(column).equals("T"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column," ");
                    gameBoard.get(row+2).set(column," ");
                    return score;
                }
            }

        }
        else if ((row == gameBoard.size() - 2) || (row == gameBoard.size() - 1)){
            if ((gameBoard.get(row-1).get(column).equals("T"))){
                if ((gameBoard.get(row-2).get(column).equals("T"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 15);
                    score += 15;
                    if ((gameBoard.get(row-1).get(column).equals("T"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    if ((gameBoard.get(row-2).get(column).equals("T"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column," ");
                    gameBoard.get(row-2).set(column," ");
                    return score;
                }
            }
        }
        return score;

    }
}
