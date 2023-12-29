

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PropertyJsonReader propertyJsonReader = new PropertyJsonReader();
        ListJsonReader listJsonReader = new ListJsonReader();

        File commandtxt = new File(args[0]);

        try (BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
             Scanner inputscanner = new Scanner(commandtxt)) {
            String is = "";
            while(inputscanner.hasNextLine()){
                is += inputscanner.nextLine();is += ",";
            }
            String[] inputarray = is.split(",");

            Monopoly monopoly = new Monopoly();
            monopoly.buildBoard();
            monopoly.playMonopoly(inputarray,output);
            System.out.println("It's Britney B*tch");

        } catch (FileNotFoundException exe) {
            System.out.println("hata çıktı");
        } catch (IOException ex) {
            System.out.println("hata çıktı");
        }

    }
}
