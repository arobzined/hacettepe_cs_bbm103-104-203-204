import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minus extends Symbols{
    public Minus(String name, int point) {
        super(name, point);
    }

    @Override
    int moves(ArrayList<ArrayList<String>> gameBoard,String[] anArray, int row, int column,Players anPlayer) {
        int score = 0;
        List<String> thisArray =  Arrays.asList(anArray);
            if (column == 0 || column == 1){
                if (thisArray.contains(gameBoard.get(row).get(column+1))){
                    if (thisArray.contains(gameBoard.get(row).get(column+2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row).set(column+1," ");
                        gameBoard.get(row).set(column+2," ");
                        return score;
                    }
                }
            }
            else if((1 < column) && (column < gameBoard.get(0).size() - 2)){
                if (thisArray.contains(gameBoard.get(row).get(column-1))){
                    if (thisArray.contains(gameBoard.get(row).get(column-2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row).set(column-1," ");
                        gameBoard.get(row).set(column-2," ");
                        return score;

                    }
                }
                if (thisArray.contains(gameBoard.get(row).get(column+1))){
                    if (thisArray.contains(gameBoard.get(row).get(column+2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row).set(column+1," ");
                        gameBoard.get(row).set(column+2," ");
                        return score;
                    }
                }
            }
            else if((column == gameBoard.get(0).size() - 2)|| (column == gameBoard.get(0).size() - 1)){
                if (thisArray.contains(gameBoard.get(row).get(column-1))){
                    if (thisArray.contains(gameBoard.get(row).get(column-2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
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
