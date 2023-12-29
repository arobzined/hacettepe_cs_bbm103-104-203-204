import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Bejeweled {
    public void playBejeweled(ArrayList<ArrayList<String>> gameBoard, String[] commandarray, String[] leaderboardarray, BufferedWriter output) throws IOException {
        Diamond diamond = new Diamond("D", 30);
        Triangle triangle = new Triangle("T", 15);
        Square square = new Square("S", 15);
        Wildcard wildcard = new Wildcard("W", 10);
        RightDiagonal rightDiagonal = new RightDiagonal("/", 20);
        LeftDiagonal leftDiagonal = new LeftDiagonal("\\", 30);
        Plus plus = new Plus("+", 30);
        Minus minus = new Minus("-", 30);
        Line line = new Line("|", 30);
        DesignMap designMap = new DesignMap();
        String[] characterList = new String[]{"+", "-", "/", "\\", "|"};
        ArrayList<Players> playerList = new ArrayList<>();

        for (String player : leaderboardarray) {
            String[] playerInfo = player.split(" ");
            if (playerInfo.length == 2){
                int score = Integer.parseInt(playerInfo[1]);
                Players players = new Players(playerInfo[0], score);
                playerList.add(players);
            }
        }
        for (String createPlayer : commandarray){
            String[] input = createPlayer.split(" ");
            if (input.length == 1){
                if (!input[0].equals("E")){
                    Players players = new Players(input[0],0);
                    playerList.add(players);
                }
            }
        }
        Players anPlayer = playerList.get(playerList.size() - 1);
        output.write("Game grid : \n\n");
        for (ArrayList<String> a : gameBoard){
            output.write(a.toString().replace("[","").replace("]","").replace(",","") + "\n");
        }


        for (String command : commandarray) {
            Collections.sort(playerList);
            String[] input = command.split(" ");
            if (input.length == 1){
                if (input[0].equals("E")) {
                    output.write("\nPlease enter a coordinate or press E to finish the game : E\n\n");

                }
                else {
                    for (Players thisPlayer : playerList){
                        if (thisPlayer.getName().equals(input[0])){
                            output.write("Total score : " + thisPlayer.getPoint()+"\n");
                            output.write("\n");
                            output.write("Enter name : " + input[0]+"\n\n");
                            for (Players a : playerList){
                                if (a.getName().equals(input[0])){
                                    if (playerList.indexOf(a) == 0){
                                        output.write("Your rank is " + (playerList.indexOf(a)+1) + "/" + playerList.size()+
                                                ", your score is " + (a.getPoint()-playerList.get(playerList.indexOf(a)+1).getPoint()) + " higher than "
                                                + (playerList.get(playerList.indexOf(a) + 1).getName()) + "\n");
                                    }else if (playerList.indexOf(a) == playerList.size() - 1){
                                        output.write("Your rank is " + (playerList.indexOf(a)+1) + "/" + playerList.size()+
                                                ", your score is " + (playerList.get(playerList.indexOf(a)+1).getPoint()-a.getPoint()) + " lower than "
                                                + (playerList.get(playerList.indexOf(a) - 1).getName()) + "\n");
                                    }
                                    else{
                                        output.write("Your rank is " + (playerList.indexOf(a)+1) + "/" + playerList.size()+
                                                ", your score is " + (playerList.get(playerList.indexOf(a)-1).getPoint()-a.getPoint()) + " points lower than "
                                                + (playerList.get(playerList.indexOf(a) - 1).getName()) + " and " +
                                                (a.getPoint()-playerList.get(playerList.indexOf(a)+1).getPoint()) + " points higher than " +
                                                (playerList.get(playerList.indexOf(a) + 1).getName()) + "\n");
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (input.length == 2) {
                int score = 0;
                int row = Integer.parseInt(input[0]);
                int column = Integer.parseInt(input[1]);
                output.write("\nSelect coordinate or enter E to end the game: "+row+" "+column+"\n\n");
                if (row < gameBoard.size() && column < gameBoard.get(0).size()){
                    if (gameBoard.get(row).get(column).equals(" ")){
                        output.write("Please enter a valid coordinate\n");
                    }
                    else{
                        if (gameBoard.get(row).get(column).equals("D")) {
                            score = diamond.moves(gameBoard, row, column,anPlayer);
                        } else if (gameBoard.get(row).get(column).equals("S")) {
                            score = square.moves(gameBoard, row, column,anPlayer);
                        } else if (gameBoard.get(row).get(column).equals("T")) {
                            score = triangle.moves(gameBoard, row, column,anPlayer);
                        } else if (gameBoard.get(row).get(column).equals("W")) {
                            score = wildcard.moves(gameBoard, row, column,anPlayer);
                        } else if (gameBoard.get(row).get(column).equals("/")) {
                            score = rightDiagonal.moves(gameBoard, characterList, row, column,anPlayer);
                        } else if (gameBoard.get(row).get(column).equals("\\")) {
                            score = leftDiagonal.moves(gameBoard, characterList, row, column,anPlayer);
                        } else if (gameBoard.get(row).get(column).equals("+")) {
                            score = plus.moves(gameBoard, characterList, row, column,anPlayer);
                        } else if (gameBoard.get(row).get(column).equals("-")) {
                            score = minus.moves(gameBoard, characterList, row, column,anPlayer);
                        } else if (gameBoard.get(row).get(column).equals("|")) {
                            score = line.moves(gameBoard, characterList, row, column,anPlayer);
                        }
                        output.write("\n");
                        designMap.designMap(gameBoard);
                        designMap.designMap(gameBoard);
                        designMap.designMap(gameBoard);
                        for (ArrayList<String> a : gameBoard){
                            output.write(a.toString().replace("[","").replace("]","").replace(",","") + "\n");
                        }
                        output.write("\nScore : " + score + "\n");
                    }
                }
                else{
                    output.write("Please enter a valid coordinate\n");
                }
            }
        }
        output.write("\nGood Bye!\n");
        File leaderboard = new File("leaderboard.txt");
        BufferedWriter output1 = new BufferedWriter(new FileWriter(leaderboard));

        for (String a : leaderboardarray){
            output1.write(a + "\n");
        }
        output1.write(anPlayer.getName() + " " + anPlayer.getPoint());

        output1.close();
        output.close();
    }
}
