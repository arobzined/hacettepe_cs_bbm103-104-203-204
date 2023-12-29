import java.util.ArrayList;

public class DesignMap extends Bejeweled{
    public void designMap(ArrayList<ArrayList<String>> gameBoard) {
        int rowNumber = gameBoard.size();
        int columnNumber = gameBoard.get(0).size();
        int i;
        int j;
        for (i = rowNumber - 1; i > 0 ;i--){
            for (j = 0 ;j < columnNumber;j++ ){
                if ((gameBoard.get(i).get(j).equals(" ")) && (j >= 0)){
                    String thisLetter = gameBoard.get(i - 1).get(j);
                    gameBoard.get(i).set(j,thisLetter);
                    gameBoard.get(i-1).set(j," ");
                }
            }
        }

    }
}
