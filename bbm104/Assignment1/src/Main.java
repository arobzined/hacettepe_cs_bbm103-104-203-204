import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File foodfile = new File("food.txt");
        File sportfile = new File("sport.txt");
        File humanfile = new File("people.txt");
        File inputfile = new File(args[0]);

        try (BufferedWriter output = new BufferedWriter(new FileWriter("monitoring.txt"));
             Scanner foodscanner = new Scanner(foodfile);
             Scanner sportscanner = new Scanner(sportfile);
             Scanner humanscanner = new Scanner(humanfile);
             Scanner inputscanner = new Scanner(inputfile)) {

            String fs = "";
            String ss = "";
            String ps = "";
            String is = "";

            while (foodscanner.hasNextLine()) {
                fs += foodscanner.nextLine();
                fs += ",";
            }
            String[] foodarray = fs.split(",");

            while (sportscanner.hasNextLine()) {
                ss += sportscanner.nextLine();
                ss += ",";
            }
            String[] sportarray = ss.split(",");

            while (humanscanner.hasNextLine()) {
                ps += humanscanner.nextLine();
                ps += ",";
            }
            String[] humanarray = ps.split(",");

            while (inputscanner.hasNextLine()) {
                is += inputscanner.nextLine();
                is += ",";
            }
            String[] inputarray = is.split(",");

            ArrayList<String> foodidlist = new ArrayList<String>();
            ArrayList<String> sportidlist = new ArrayList<String>();
            ArrayList<String> humanidlist = new ArrayList<String>();
            ArrayList<String> inputlist = new ArrayList<String>();


            for(int i = 0;i < foodarray.length;i++){
                String elmarray[] = foodarray[i].split("\t");
                foodidlist.add(elmarray[0]);
            }
            Foods foodslist[] = new Foods[foodidlist.size()];
            for(int i = 0;i < foodarray.length;i++){
                String elmarray[] = foodarray[i].split("\t");
                Foods food = new Foods(Integer.parseInt(elmarray[0]),elmarray[1],Integer.parseInt(elmarray[2]));
                foodslist[i] = food;
            }


            for(int i = 0;i < sportarray.length;i++){
                String elmarray[] = sportarray[i].split("\t");
                sportidlist.add(elmarray[0]);
            }
            Sports sportslist[] = new Sports[sportidlist.size()];
            for(int i = 0;i < sportarray.length;i++){
                String elmarray[] = sportarray[i].split("\t");
                Sports sport = new Sports(Integer.parseInt(elmarray[0]),elmarray[1],Integer.parseInt(elmarray[2]));
                sportslist[i] = sport;
            }
            for(int i = 0;i < humanarray.length;i++){
                String elmarray[] = humanarray[i].split("\t");
                humanidlist.add(elmarray[0]);

            }
            People peopleslist[] = new People[humanidlist.size()];
            for (int i = 0;i < humanarray.length;i++){
                String elmarray[] = humanarray[i].split("\t");
                People people = new People(Integer.parseInt(elmarray[0]),elmarray[1],elmarray[2],Integer.parseInt(elmarray[3]),Integer.parseInt(elmarray[4]),Integer.parseInt(elmarray[5]));
                peopleslist[i] = people;
                peopleslist[i].bazalMetabolizmaHesalayıcı();
            }

            ArrayList<People> printlistarr = new ArrayList<People>();
            for (int i = 0;i <inputarray.length;i++){
                String elmarray[] = inputarray[i].split("\t");
                if (!(i == 0 || i == inputarray.length)){
                    output.write("***************\n");
                }
                if (elmarray.length == 3){
                    int foodOrsport = Integer.parseInt(elmarray[1]);
                    if (foodOrsport < 2000){
                        for (int j = 0;j < peopleslist.length;j++){
                           if (peopleslist[j].getPersonid() == Integer.parseInt(elmarray[0])){
                               for (int k = 0;k < foodslist.length;k++){
                                   if (foodslist[k].getFoodid() == foodOrsport){
                                       peopleslist[j].yemekYediyse(foodslist[k].getCalorieofFood(),Integer.parseInt(elmarray[2]));
                                       peopleslist[j].netcalorihesaplama();
                                       if (!printlistarr.contains(peopleslist[j])){
                                           printlistarr.add(peopleslist[j]);
                                       }

                                       output.write(elmarray[0] + " has\ttaken\t" + (foodslist[k].getCalorieofFood()*Integer.parseInt(elmarray[2])) + "kcal\tfrom\t" + foodslist[k].getFoodname()+"\n");
                                   }
                               }
                           }
                        }
                    }
                    else{
                        for (int j = 0;j < peopleslist.length;j++){
                            if (peopleslist[j].getPersonid() == Integer.parseInt(elmarray[0])){
                                for (int k = 0;k < sportslist.length;k++){
                                    if (sportslist[k].getSportid() == foodOrsport){
                                        peopleslist[j].sporYaptıysa(sportslist[k].getCalorieBurned(),Integer.parseInt(elmarray[2]));
                                        peopleslist[j].netcalorihesaplama();
                                        output.write(elmarray[0] + " has\tburned\t" + ((sportslist[k].getCalorieBurned())*(Integer.parseInt(elmarray[2])/60))+"kcal\t" + "thanks\tto\t" + sportslist[k].getSportname() + "\n");
                                    }
                                }
                            }
                        }
                    }
                }
                else if(elmarray.length == 1){
                    if (elmarray[0].equals("printList")){
                        for (int j = 0;j < printlistarr.size();j++){
                            if (printlistarr.get(j).getCalorinet() > 0) {
                                output.write(printlistarr.get(j).getPersonname() + "\t" +
                                        (2022 - printlistarr.get(j).getDateofBirth()) + "\t" + printlistarr.get(j).getBazalmetabolizma() + "kcal\t" +
                                        printlistarr.get(j).getCalorigained() + "kcal\t" + printlistarr.get(j).getCaloriburned() + "kcal\t+" +
                                        printlistarr.get(j).getCalorinet() + "kcal\n");
                            }
                            else if(printlistarr.get(j).getCalorinet() < 0){
                                output.write(printlistarr.get(j).getPersonname() + "\t" +
                                        (2022 - printlistarr.get(j).getDateofBirth()) + "\t" + printlistarr.get(j).getBazalmetabolizma() + "kcal\t" +
                                        printlistarr.get(j).getCalorigained() + "kcal\t" + printlistarr.get(j).getCaloriburned() + "kcal\t" +
                                        printlistarr.get(j).getCalorinet() + "kcal\n");
                            }
                        }
                    }
                    else if(elmarray[0].equals("printWarn")){
                        int count = 0;
                        for (int j = 0;j < printlistarr.size();j++){
                            if(printlistarr.get(j).getCalorinet() > 0){
                                count += 1;
                            }
                        }
                        if (count != 0){
                            for (int j = 0;j < printlistarr.size();j++) {
                                if(printlistarr.get(j).getCalorinet() > 0) {
                                    output.write(printlistarr.get(j).getPersonname() + "\t" +
                                            (2022 - printlistarr.get(j).getDateofBirth()) + "\t" + printlistarr.get(j).getBazalmetabolizma() + "kcal\t" +
                                            printlistarr.get(j).getCalorigained() + "kcal\t" + printlistarr.get(j).getCaloriburned() + "kcal\t+" +
                                            printlistarr.get(j).getCalorinet() + "kcal\n");

                                }
                            }
                        }
                        else if(count == 0){
                            output.write("there is no such person\n");
                        }
                    }
                    else{
                        String[] comlist = elmarray[0].split("t");
                        StringBuffer pid = new StringBuffer(comlist[1]);
                        pid.deleteCharAt(pid.length() - 1);
                        pid.deleteCharAt(0);
                        String newpid = new String(pid);
                        Integer newpid2 = new Integer(newpid);
                        for (int j = 0; j < peopleslist.length;j++){
                            if(peopleslist[j].getPersonid() == newpid2){
                                output.write(printlistarr.get(j).getPersonname() +"\t"+
                                        (2022- printlistarr.get(j).getDateofBirth()) +"\t"+ printlistarr.get(j).getBazalmetabolizma() +"\t"+
                                        printlistarr.get(j).getCalorigained() +"\t"+ printlistarr.get(j).getCaloriburned() +"\t"+
                                        printlistarr.get(j).getCalorinet()+"\n");
                            }
                        }
                    }
                }
            }
                }catch(FileNotFoundException ex){
                    System.out.println("Dosya Bulunamadı...");
                }catch(IOException ex){
                    System.out.println("Dosya açılırken bir hata oluştu...");
                }
            }
        }