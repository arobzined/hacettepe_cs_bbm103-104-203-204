import jdk.nashorn.internal.runtime.Scope;

import java.security.acl.AclNotFoundException;
import java.util.ArrayList;

public class Diamond extends Diamonds{
    private int count;
    private ArrayList<String> coordinateArray;
    public Diamond(String name, int point) {
        super(name, point);
    }

    @Override
    int moves(ArrayList<ArrayList<String>> gameBoard,int row,int column,Players anPlayer) {
        int score = 0;
        if (row == 0 || row == 1){
            if (column == 0 || column == 1){
                if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                    if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row+1).set(column+1," ");
                        gameBoard.get(row+2).set(column+2," ");
                        return score;
                    }
                }
            }
            else if((1 < column) && (column < gameBoard.get(0).size() - 2)){
                if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                    if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row+1).set(column+1," ");
                        gameBoard.get(row+2).set(column+2," ");
                        return score;
                    }
                }
                if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                    if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row+1).set(column-1," ");
                        gameBoard.get(row+2).set(column-2," ");
                        return score;
                    }
                }

            }
            else if((column == gameBoard.get(0).size() - 2)|| (column == gameBoard.get(0).size() - 1)){
                if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                    if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
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
                if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                    if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row+1).set(column+1," ");
                        gameBoard.get(row+2).set(column+2," ");
                        return score;
                    }
                }if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                    if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column+1," ");
                        gameBoard.get(row-2).set(column+2," ");
                        return score;
                    }
                }
            }
            else if((1 < column) && (column < gameBoard.get(0).size() - 2)){
                if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                    if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;
                        }
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column-1," ");
                        gameBoard.get(row-2).set(column-2," ");
                        return score;

                    }
                }
                if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                    if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row+1).get(column+1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row+2).get(column+2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row+1).set(column+1," ");
                        gameBoard.get(row+2).set(column+2," ");
                        return score;
                    }
                }if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                    if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column+1," ");
                        gameBoard.get(row-2).set(column+2," ");
                        return score;
                    }
                }
                if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                    if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row+1).set(column-1," ");
                        gameBoard.get(row+2).set(column-2," ");
                        return score;
                    }
                }
            }else if (column == gameBoard.get(0).size() - 2 || column == gameBoard.get(0).size() - 1){
                if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                    if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column-1," ");
                        gameBoard.get(row-2).set(column-2," ");
                        return score;
                    }
                }if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                    if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row+1).get(column-1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row+2).get(column-2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
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
                if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                    if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column+1," ");
                        gameBoard.get(row-2).set(column+2," ");
                        return score;
                    }
                }
            }
            else if((1 < column) && (column < gameBoard.get(0).size() - 2)){
                if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                    if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column-1," ");
                        gameBoard.get(row-2).set(column-2," ");
                        return score;
                    }
                }
                if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                    if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row-1).get(column+1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row-2).get(column+2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column+1," ");
                        gameBoard.get(row-2).set(column+2," ");
                        return score;
                    }
                }

            }
            else if((column == gameBoard.get(0).size() - 2)|| (column == gameBoard.get(0).size() - 1)){
                if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                    if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                        anPlayer.setPoint(anPlayer.getPoint() + 30);
                        score += 30;
                        if ((gameBoard.get(row-1).get(column-1).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        if ((gameBoard.get(row-2).get(column-2).equals("D"))){
                            anPlayer.setPoint(anPlayer.getPoint() + 30);score += 30;}
                        gameBoard.get(row).set(column," ");
                        gameBoard.get(row-1).set(column-1," ");
                        gameBoard.get(row-2).set(column-2," ");
                        return score;

                    }
                }
            }
        }
        return score;
    }
}
