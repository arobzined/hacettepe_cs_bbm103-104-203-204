import java.util.ArrayList;

public class Wildcard extends Diamonds{
    public Wildcard(String name, int point) {
        super(name, point);
    }

    @Override
    int moves(ArrayList<ArrayList<String>> gameBoard,int row,int column,Players anPlayer) {
        int score = 0;
        if (row == 0 || row == 1){
            if (column == 0 || column == 1){
                String downwardletter = gameBoard.get(row+1).get(column);
                String rightletter = gameBoard.get(row).get(column+1);
                String rightdowndiagonalLetter = gameBoard.get(row+1).get(column+1);
                if ((downwardletter.equals("W")) || (gameBoard.get(row+2).get(column).equals(downwardletter)) || (gameBoard.get(row+2).get(column).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column).equals("T")) || (gameBoard.get(row+1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column).equals("T")) || (gameBoard.get(row+2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column," ");
                    gameBoard.get(row+2).set(column," ");
                }
                else if ((rightletter.equals("W")) || (gameBoard.get(row).get(column+2).equals(rightletter)) || (gameBoard.get(row).get(column+2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+1).equals("T")) || (gameBoard.get(row).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+2).equals("T")) || (gameBoard.get(row).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column + 1, " ");
                    gameBoard.get(row).set(column + 2, " ");
                }
                else if ((rightdowndiagonalLetter.equals("W")) || (gameBoard.get(row+2).get(column+2).equals(rightdowndiagonalLetter)) || (gameBoard.get(row+2).get(column+2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column+1).equals("T")) || (gameBoard.get(row+1).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column+2).equals("T")) || (gameBoard.get(row+2).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column+1," ");
                    gameBoard.get(row+2).set(column+2," ");
                }
            }
            else if((1 < column) && (column < gameBoard.get(0).size() - 2)){
                String downwardletter = gameBoard.get(row+1).get(column);
                String leftletter = gameBoard.get(row).get(column-1);
                String rightletter = gameBoard.get(row).get(column+1);
                String rightdownLetter = gameBoard.get(row+1).get(column+1);
                String leftdownLetter = gameBoard.get(row+1).get(column-1);
                if ((downwardletter.equals("W")) || (gameBoard.get(row+2).get(column).equals(downwardletter)) || (gameBoard.get(row+2).get(column).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column).equals("T")) || (gameBoard.get(row+1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column).equals("T")) || (gameBoard.get(row+2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column," ");
                    gameBoard.get(row+2).set(column," ");
                }
                else if ((leftletter.equals("W")) || (gameBoard.get(row).get(column-2).equals(leftletter)) || (gameBoard.get(row).get(column-2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-1).equals("T")) || (gameBoard.get(row).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-2).equals("T")) || (gameBoard.get(row).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column - 1, " ");
                    gameBoard.get(row).set(column - 2, " ");
                }
                else if ((rightletter.equals("W")) || (gameBoard.get(row).get(column+2).equals(rightletter)) || (gameBoard.get(row).get(column+2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+1).equals("T")) || (gameBoard.get(row).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+2).equals("T")) || (gameBoard.get(row).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column + 1, " ");
                    gameBoard.get(row).set(column + 2, " ");
                }
                else if ((rightdownLetter.equals("W")) || (gameBoard.get(row+2).get(column+2).equals(rightdownLetter)) || (gameBoard.get(row+2).get(column+2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column+1).equals("T")) || (gameBoard.get(row+1).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column+2).equals("T")) || (gameBoard.get(row+2).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column+1," ");
                    gameBoard.get(row+2).set(column+2," ");
                }
                else if ((leftdownLetter.equals("W")) || (gameBoard.get(row+2).get(column-2).equals(leftdownLetter)) || (gameBoard.get(row-2).get(column+2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column-1).equals("T")) || (gameBoard.get(row+1).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column-2).equals("T")) || (gameBoard.get(row+2).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column-1," ");
                    gameBoard.get(row+2).set(column-2," ");
                }

            }
            else if((column == gameBoard.get(0).size() - 2)|| (column == gameBoard.get(0).size() - 1)){
                String downwardletter = gameBoard.get(row+1).get(column);
                String leftletter = gameBoard.get(row).get(column+1);
                String leftdownLetter = gameBoard.get(row+1).get(column-1);
                if ((downwardletter.equals("W")) || (gameBoard.get(row+2).get(column).equals(downwardletter)) || (gameBoard.get(row+2).get(column).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column).equals("T")) || (gameBoard.get(row+1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column).equals("T")) || (gameBoard.get(row+2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column," ");
                    gameBoard.get(row+2).set(column," ");
                }
                else if ((leftletter.equals("W")) || (gameBoard.get(row).get(column+2).equals(leftletter)) || (gameBoard.get(row).get(column+2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-1).equals("T")) || (gameBoard.get(row).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-2).equals("T")) || (gameBoard.get(row).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column - 1, " ");
                    gameBoard.get(row).set(column - 2, " ");
                }
                else if ((leftdownLetter.equals("W")) || (gameBoard.get(row+2).get(column-2).equals(leftdownLetter)) || (gameBoard.get(row+2).get(column-2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column-1).equals("T")) || (gameBoard.get(row+1).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column-2).equals("T")) || (gameBoard.get(row+2).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column-1," ");
                    gameBoard.get(row+2).set(column-2," ");
                }
            }
        }
        else if(1 < row && row < gameBoard.size() - 2){
            if ((column == 0) || (column == 1)){
                String upwardletter = gameBoard.get(row-1).get(column);
                String downwardletter = gameBoard.get(row+1).get(column);
                String rightletter = gameBoard.get(row).get(column+1);
                String rightdownLetter = gameBoard.get(row+1).get(column+1);
                String rightupLetter = gameBoard.get(row-1).get(column+1);
                if ((upwardletter.equals("W")) || (gameBoard.get(row-2).get(column).equals(upwardletter)) || (gameBoard.get(row-2).get(column).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column).equals("T")) || (gameBoard.get(row-1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column).equals("T")) || (gameBoard.get(row-2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column," ");
                    gameBoard.get(row-2).set(column," ");
                }
                else if ((downwardletter.equals("W")) || (gameBoard.get(row+2).get(column).equals(downwardletter)) || (gameBoard.get(row+2).get(column).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column).equals("T")) || (gameBoard.get(row+1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column).equals("T")) || (gameBoard.get(row+2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row+1).set(column, " ");
                    gameBoard.get(row+2).set(column, " ");
                }
                else if ((rightletter.equals("W")) || (gameBoard.get(row).get(column+2).equals(rightletter)) || (gameBoard.get(row).get(column+2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+1).equals("T")) || (gameBoard.get(row).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+2).equals("T")) || (gameBoard.get(row).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column + 1, " ");
                    gameBoard.get(row).set(column + 2, " ");
                }
                else if ((rightdownLetter.equals("W")) || (gameBoard.get(row+2).get(column+2).equals(rightdownLetter)) || (gameBoard.get(row+2).get(column+2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column+1).equals("T")) || (gameBoard.get(row+1).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column+2).equals("T")) || (gameBoard.get(row+2).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column+1," ");
                    gameBoard.get(row+2).set(column+2," ");
                }
                else if ((rightupLetter.equals("W")) || (gameBoard.get(row-2).get(column+2).equals(rightupLetter)) || (gameBoard.get(row-2).get(column+2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column+1).equals("T")) || (gameBoard.get(row-1).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column+2).equals("T")) || (gameBoard.get(row-2).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column+1," ");
                    gameBoard.get(row-2).set(column+2," ");
                }
            }
            else if((1 < column) && (column < gameBoard.get(0).size() - 2)){
                String upwardletter = gameBoard.get(row-1).get(column);
                String downwardletter = gameBoard.get(row+1).get(column);
                String leftLetter = gameBoard.get(row).get(column-1);
                String rightletter = gameBoard.get(row).get(column+1);
                String leftUpLetter = gameBoard.get(row-1).get(column-1);
                String rightdownLetter = gameBoard.get(row+1).get(column+1);
                String rightupLetter = gameBoard.get(row-1).get(column+1);
                String leftdownLetter = gameBoard.get(row+1).get(column-1);

                if ((upwardletter.equals("W")) || (gameBoard.get(row-2).get(column).equals(upwardletter)) || (gameBoard.get(row-2).get(column).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column).equals("T")) || (gameBoard.get(row-1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column).equals("T")) || (gameBoard.get(row-2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column," ");
                    gameBoard.get(row-2).set(column," ");
                }
                else if ((downwardletter.equals("W")) || (gameBoard.get(row+2).get(column).equals(downwardletter)) || (gameBoard.get(row+2).get(column).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column).equals("T")) || (gameBoard.get(row+1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column).equals("T")) || (gameBoard.get(row+2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row+1).set(column, " ");
                    gameBoard.get(row+2).set(column, " ");
                }
                else if ((leftLetter.equals("W")) || (gameBoard.get(row).get(column-2).equals(leftLetter)) || (gameBoard.get(row).get(column-2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-1).equals("T")) || (gameBoard.get(row).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-2).equals("T")) || (gameBoard.get(row).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column - 1, " ");
                    gameBoard.get(row).set(column - 2, " ");
                }
                else if ((rightletter.equals("W")) || (gameBoard.get(row).get(column+2).equals(rightletter)) || (gameBoard.get(row).get(column+2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+1).equals("T")) || (gameBoard.get(row).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+2).equals("T")) || (gameBoard.get(row).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column + 1, " ");
                    gameBoard.get(row).set(column + 2, " ");
                }
                else if ((leftUpLetter.equals("W")) || (gameBoard.get(row-2).get(column-2).equals(leftUpLetter)) || (gameBoard.get(row-2).get(column-2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column-1).equals("T")) || (gameBoard.get(row-1).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column-2).equals("T")) || (gameBoard.get(row-2).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column-1," ");
                    gameBoard.get(row-2).set(column-2," ");
                }
                else if ((rightdownLetter.equals("W")) || (gameBoard.get(row+2).get(column+2).equals(rightdownLetter)) || (gameBoard.get(row+2).get(column+2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column+1).equals("T")) || (gameBoard.get(row+1).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column+2).equals("T")) || (gameBoard.get(row+2).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column+1," ");
                    gameBoard.get(row+2).set(column+2," ");
                }
                else if ((rightupLetter.equals("W")) || (gameBoard.get(row-2).get(column+2).equals(rightupLetter)) || (gameBoard.get(row-2).get(column+2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column+1).equals("T")) || (gameBoard.get(row-1).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column+2).equals("T")) || (gameBoard.get(row-2).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column+1," ");
                    gameBoard.get(row-2).set(column+2," ");
                }
                else if ((leftdownLetter.equals("W")) || (gameBoard.get(row+2).get(column-2).equals(leftdownLetter)) || (gameBoard.get(row+2).get(column-2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column-1).equals("T")) || (gameBoard.get(row+1).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column-2).equals("T")) || (gameBoard.get(row+2).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column-1," ");
                    gameBoard.get(row+2).set(column-2," ");
                }
            }
            else if((column == gameBoard.get(0).size() - 2) || (column == gameBoard.get(0).size() - 1)){
                String upwardletter = gameBoard.get(row-1).get(column);
                String downwardletter = gameBoard.get(row+1).get(column);
                String leftLetter = gameBoard.get(row).get(column-1);
                String leftUpLetter = gameBoard.get(row-1).get(column-1);
                String leftdownLetter = gameBoard.get(row+1).get(column-1);

                if ((upwardletter.equals("W")) || (gameBoard.get(row-2).get(column).equals(upwardletter)) || (gameBoard.get(row-2).get(column).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column).equals("T")) || (gameBoard.get(row-1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column).equals("T")) || (gameBoard.get(row-2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column," ");
                    gameBoard.get(row-2).set(column," ");
                }
                else if ((downwardletter.equals("W")) || (gameBoard.get(row+2).get(column).equals(downwardletter)) || (gameBoard.get(row+2).get(column).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column).equals("T")) || (gameBoard.get(row+1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column).equals("T")) || (gameBoard.get(row+2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row+1).set(column, " ");
                    gameBoard.get(row+2).set(column, " ");
                }
                else if ((leftLetter.equals("W")) || (gameBoard.get(row).get(column-2).equals(leftLetter)) || (gameBoard.get(row).get(column-2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-1).equals("T")) || (gameBoard.get(row).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-2).equals("T")) || (gameBoard.get(row).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column - 1, " ");
                    gameBoard.get(row).set(column - 2, " ");
                }
                else if ((leftUpLetter.equals("W")) || (gameBoard.get(row-2).get(column-2).equals(leftUpLetter)) || (gameBoard.get(row-2).get(column-2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column-1).equals("T")) || (gameBoard.get(row-1).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column-2).equals("T")) || (gameBoard.get(row-2).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column-1," ");
                    gameBoard.get(row-2).set(column-2," ");
                }
                else if ((leftdownLetter.equals("W")) || (gameBoard.get(row+2).get(column-2).equals(leftdownLetter)) || (gameBoard.get(row+2).get(column-2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+1).get(column-1).equals("T")) || (gameBoard.get(row+1).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+1).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row+2).get(column-2).equals("T")) || (gameBoard.get(row+2).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row+2).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row+1).set(column-1," ");
                    gameBoard.get(row+2).set(column-2," ");
                }
            }
        }
        else if((row == gameBoard.size() - 2) || (row == gameBoard.size() - 1)){
            if (column == 0 || column == 1){
                String upwardletter = gameBoard.get(row-1).get(column);
                String rightletter = gameBoard.get(row).get(column+1);
                String rightupLetter = gameBoard.get(row-1).get(column+1);

                if ((upwardletter.equals("W")) || (gameBoard.get(row-2).get(column).equals(upwardletter)) || (gameBoard.get(row-2).get(column).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column).equals("T")) || (gameBoard.get(row-1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column).equals("T")) || (gameBoard.get(row-2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column," ");
                    gameBoard.get(row-2).set(column," ");
                }
                else if ((rightletter.equals("W")) || (gameBoard.get(row).get(column+2).equals(rightletter)) || (gameBoard.get(row).get(column+2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+1).equals("T")) || (gameBoard.get(row).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+2).equals("T")) || (gameBoard.get(row).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column + 1, " ");
                    gameBoard.get(row).set(column + 2, " ");
                }
                else if ((rightupLetter.equals("W")) || (gameBoard.get(row-2).get(column+2).equals(rightupLetter)) || (gameBoard.get(row-2).get(column+2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column+1).equals("T")) || (gameBoard.get(row-1).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column+2).equals("T")) || (gameBoard.get(row-2).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column+1," ");
                    gameBoard.get(row-2).set(column+2," ");
                }

            }
            else if((1 < column) && (column < gameBoard.get(0).size() - 2)){
                String upwardletter = gameBoard.get(row-1).get(column);
                String leftLetter = gameBoard.get(row).get(column-1);
                String rightletter = gameBoard.get(row).get(column+1);
                String leftUpLetter = gameBoard.get(row-1).get(column-1);
                String rightupLetter = gameBoard.get(row-1).get(column+1);

                if ((upwardletter.equals("W")) || (gameBoard.get(row-2).get(column).equals(upwardletter)) || (gameBoard.get(row-2).get(column).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column).equals("T")) || (gameBoard.get(row-1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column).equals("T")) || (gameBoard.get(row-2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column," ");
                    gameBoard.get(row-2).set(column," ");
                }
                else if ((leftLetter.equals("W")) || (gameBoard.get(row).get(column-2).equals(leftLetter)) || (gameBoard.get(row).get(column-2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-1).equals("T")) || (gameBoard.get(row).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-2).equals("T")) || (gameBoard.get(row).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column - 1, " ");
                    gameBoard.get(row).set(column - 2, " ");
                }
                else if ((rightletter.equals("W")) || (gameBoard.get(row).get(column+2).equals(rightletter)) || (gameBoard.get(row).get(column+2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+1).equals("T")) || (gameBoard.get(row).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column+2).equals("T")) || (gameBoard.get(row).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column + 1, " ");
                    gameBoard.get(row).set(column + 2, " ");
                }
                else if ((leftUpLetter.equals("W")) || (gameBoard.get(row-2).get(column-2).equals(leftUpLetter)) || (gameBoard.get(row-2).get(column-2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column-1).equals("T")) || (gameBoard.get(row-1).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column-2).equals("T")) || (gameBoard.get(row-2).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column-1," ");
                    gameBoard.get(row-2).set(column-2," ");
                }
                else if ((rightupLetter.equals("W")) || (gameBoard.get(row-2).get(column+2).equals(rightupLetter)) || (gameBoard.get(row-2).get(column+2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column+1).equals("T")) || (gameBoard.get(row-1).get(column+1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column+1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column+2).equals("T")) || (gameBoard.get(row-2).get(column+2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column+2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column+1," ");
                    gameBoard.get(row-2).set(column+2," ");
                }

            }
            else if((column == gameBoard.get(0).size() - 2)|| (column == gameBoard.get(0).size() - 1)){
                String upwardletter = gameBoard.get(row-1).get(column);
                String leftLetter = gameBoard.get(row).get(column-1);
                String leftUpLetter = gameBoard.get(row-1).get(column-1);
                if ((upwardletter.equals("W")) || (gameBoard.get(row-2).get(column).equals(upwardletter)) || (gameBoard.get(row-2).get(column).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column).equals("T")) || (gameBoard.get(row-1).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column).equals("T")) || (gameBoard.get(row-2).get(column).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column," ");
                    gameBoard.get(row-2).set(column," ");
                }
                else if ((leftLetter.equals("W")) || (gameBoard.get(row).get(column-2).equals(leftLetter)) || (gameBoard.get(row).get(column-2).equals("W"))) {
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-1).equals("T")) || (gameBoard.get(row).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row).get(column-2).equals("T")) || (gameBoard.get(row).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column, " ");
                    gameBoard.get(row).set(column - 1, " ");
                    gameBoard.get(row).set(column - 2, " ");
                }
                else if ((leftUpLetter.equals("W")) || (gameBoard.get(row-2).get(column-2).equals(leftUpLetter)) || (gameBoard.get(row-2).get(column-2).equals("W"))){
                    anPlayer.setPoint(anPlayer.getPoint() + 10);
                    score += 10;
                    if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-1).get(column-1).equals("T")) || (gameBoard.get(row-1).get(column-1).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-1).get(column-1).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                    else if((gameBoard.get(row-2).get(column-2).equals("T")) || (gameBoard.get(row-2).get(column-2).equals("S"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 15);score += 15;}
                    else if((gameBoard.get(row-2).get(column-2).equals("W"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 10);score += 10;}
                    gameBoard.get(row).set(column," ");
                    gameBoard.get(row-1).set(column-1," ");
                    gameBoard.get(row-2).set(column-2," ");
                }


            }
        }
        return score;

    }

}
