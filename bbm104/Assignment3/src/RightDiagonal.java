import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightDiagonal extends Symbols{
    public RightDiagonal(String name, int point) {
        super(name, point);
    }

    @Override
    int moves(ArrayList<ArrayList<String>> gameBoard,String[] anArray ,int row, int column,Players anPlayer) {
        int score = 0;
        List<String> thisArray =  Arrays.asList(anArray);
        if (row == 0 || row == 1){
            if (column == 0 || column == 1){

            }
            else if((1 < column) && (column < gameBoard.get(0).size() - 2)){
                if (thisArray.contains(gameBoard.get(row+1).get(column-1))){
                    if (thisArray.contains(gameBoard.get(row+2).get(column-2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row+1).set(column-1," ");
                        gameBoard.get(row+2).set(column-2," ");
                        return score;
                    }
                }

            }
            else if((column == gameBoard.get(0).size() - 2)|| (column == gameBoard.get(0).size() - 1)){
                if (thisArray.contains(gameBoard.get(row+1).get(column-1))){
                    if (thisArray.contains(gameBoard.get(row+2).get(column-2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row+1).set(column-1," ");
                        gameBoard.get(row+2).set(column-2," ");
                        return score;
                    }
                }
            }
        }
        else if(1 < row && (row < gameBoard.size() - 2)){
            if (column == 0 || column == 1){
                if (thisArray.contains(gameBoard.get(row-1).get(column+1))){
                    if (thisArray.contains(gameBoard.get(row-2).get(column+2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column+1," ");
                        gameBoard.get(row-2).set(column+2," ");
                        return score;
                    }
                }
            }
            else if((1 < column) && (column < gameBoard.get(0).size() - 2)){
                if (thisArray.contains(gameBoard.get(row-1).get(column+1))){
                    if (thisArray.contains(gameBoard.get(row-2).get(column+2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column+1," ");
                        gameBoard.get(row-2).set(column+2," ");
                        return score;
                    }
                }
                if (thisArray.contains(gameBoard.get(row+1).get(column-1))){
                    if (thisArray.contains(gameBoard.get(row+2).get(column-2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row+1).set(column-1," ");
                        gameBoard.get(row+2).set(column-2," ");
                        return score;
                    }
                }
            }else if (column == gameBoard.get(0).size() - 2 || column == gameBoard.get(0).size() - 1){
                if (thisArray.contains(gameBoard.get(row+1).get(column-1))){
                    if (thisArray.contains(gameBoard.get(row+2).get(column-2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row+1).set(column-1," ");
                        gameBoard.get(row+2).set(column-2," ");
                        return score;
                    }
                }
            }
        }
        else if((row == gameBoard.size() - 2) || (row == gameBoard.size() - 1)){
            if (column == 0 || column == 1){
                if (thisArray.contains(gameBoard.get(row-1).get(column+1))){
                    if (thisArray.contains(gameBoard.get(row-2).get(column+2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column+1," ");
                        gameBoard.get(row-2).set(column+2," ");
                        return score;
                    }
                }
            }
            else if((1 < column) && (column < gameBoard.get(0).size() - 2)){
                if (thisArray.contains(gameBoard.get(row-1).get(column+1))){
                    if (thisArray.contains(gameBoard.get(row-2).get(column+2))){
                        score += 60;
                        anPlayer.setPoint(anPlayer.getPoint() + 60);
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column+1," ");
                        gameBoard.get(row-2).set(column+2," ");
                        return score;
                    }
                }
            }
            else if((column == gameBoard.get(0).size() - 2)|| (column == gameBoard.get(0).size() - 1)){

            }
        }
        return score;
    }
}
