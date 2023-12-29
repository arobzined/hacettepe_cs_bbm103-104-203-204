import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line extends Symbols{
    public Line(String name, int point) {
        super(name, point);
    }

    @Override
    int moves(ArrayList<ArrayList<String>> gameBoard,String[] anArray, int row, int column,Players anPlayer) {
        int score = 0;
        List<String> thisArray =  Arrays.asList(anArray);
        if (row == 0 || row == 1){
            if (thisArray.contains(gameBoard.get(row+1).get(column))){
                if (thisArray.contains(gameBoard.get(row+2).get(column))){
                    score += 60;
                    anPlayer.setPoint(anPlayer.getPoint() + 60);
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column," ");
                    gameBoard.get(row+2).set(column," ");
                    return score;
                }
            }
        }
        else if((1 < row) && (row < gameBoard.size() - 2)){
            if (thisArray.contains(gameBoard.get(row-1).get(column))){
                if (thisArray.contains(gameBoard.get(row-2).get(column))){
                    score += 60;
                    anPlayer.setPoint(anPlayer.getPoint() + 60);
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column," ");
                    gameBoard.get(row-2).set(column," ");
                    return score;
                }
            }
            if (thisArray.contains(gameBoard.get(row+1).get(column))){
                if (thisArray.contains(gameBoard.get(row+2).get(column))){
                    score += 60;
                    anPlayer.setPoint(anPlayer.getPoint() + 60);
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column," ");
                    gameBoard.get(row+2).set(column," ");
                    return score;
                }
            }
        }
        else if((row == gameBoard.size() - 2)|| (row == gameBoard.size() - 1)){
            if (thisArray.contains(gameBoard.get(row-1).get(column))){
                if (thisArray.contains(gameBoard.get(row-2).get(column))){
                    score += 60;
                    anPlayer.setPoint(anPlayer.getPoint() + 60);
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
