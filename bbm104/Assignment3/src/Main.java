import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File commandtxt = new File(args[1]);
        File gameGrid = new File(args[0]);
        File leaderboard = new File("leaderboard.txt");
        try (
                BufferedWriter output = (new BufferedWriter(new FileWriter("monitoring.txt")));
                PrintWriter output2 = new PrintWriter(new BufferedWriter(new FileWriter("leaderboard.txt",true)));
                Scanner commandscanner = new Scanner(commandtxt);
                Scanner gameboardscanner = new Scanner(gameGrid);
                Scanner leaderboardscanner = new Scanner(leaderboard)) {
            String is = "";
            while(gameboardscanner.hasNextLine()){
                is += gameboardscanner.nextLine();is += ",";
            }

            String[] gameboardarray = is.split(",");
            int height = gameboardarray.length;
            String[] aLine = gameboardarray[0].split(" ");
            int width = aLine.length;
            ArrayList<ArrayList<String>> gameBoard = new ArrayList<ArrayList<String>>();
            for (String a : gameboardarray){
                String[] someline = a.split(" ");
                ArrayList<String> Line = new ArrayList<String>(Arrays.asList(someline));
                gameBoard.add(Line);
            }

            String cs = "";
            while(commandscanner.hasNextLine()){
                cs += commandscanner.nextLine();cs += ",";
            }
            String[] commandarray = cs.split(",");


            String ls = "";
            while(leaderboardscanner.hasNextLine()){
                ls += leaderboardscanner.nextLine();ls += ",";
            }
            String[] leaderboardarray = ls.split(",");

            Bejeweled bejeweled = new Bejeweled();
            bejeweled.playBejeweled(gameBoard,commandarray,leaderboardarray,output);


        } catch (
                FileNotFoundException exe) {
            System.out.println("bir hata çıktı");
        } catch (
                IOException ex) {
            System.out.println("hata çıktı");
        }
    }
}
