import java.io.*;
import java.util.*;

public class Kingdom {
    public List<List<Integer>> adj_matrix = new ArrayList<>();
    // TODO: You should add appropriate instance variables.
    public List<List<Integer>> colony_matrix = new ArrayList<>();

    public void initializeKingdom(String filename){
        try {

            File file = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            int i = 0;
            while ((st = br.readLine()) != null){
                List<String> temp_l = Arrays.asList(st.split(" "));
                colony_matrix.add(new ArrayList<>());
                for (String x : temp_l){
                    colony_matrix.get(i).add(Integer.parseInt(x));
                }
                i++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Colony> getColonies() {
        List<Colony> colonies = new ArrayList<>();
        // TODO: DON'T READ THE .TXT FILE HERE!
        int row = 0;
        for(List<Integer> list : colony_matrix){
            int col = 0;
            for(Integer elm : list){
                if(elm == 1){
                    if(adj_matrix.isEmpty()){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(row+1);temp.add(col+1);
                        adj_matrix.add(temp);
                    }
                    else{
                        int count1 = 0;
                        int count2 = 0;
                        List<Integer> temp1 = new ArrayList<>();
                        List<Integer> temp2 = new ArrayList<>();
                        for(List<Integer> temp_list : adj_matrix){
                            if(temp_list.contains(row+1)){
                                temp1 = temp_list;
                                count1++;
                            }
                            else if(temp_list.contains(col+1)){
                                temp2 = temp_list;
                                count2++;
                            }
                        }
                        if(count1 > 0 && count2 > 0){
                            temp1.addAll(temp2);
                            adj_matrix.remove(temp2);
                        }
                        else if(count1 > 0){
                            temp1.add(col+1);
                        }
                        else if(count2 > 0){
                            temp2.add(row+1);
                        }
                        else{
                            List<Integer> temp_ = new ArrayList<>();
                            temp_.add(row+1);temp_.add(col+1);
                            adj_matrix.add(temp_);
                        }
                    }
                }
                col++;
            }
            row++;
        }
        for(List<Integer> temp : adj_matrix){
            Set<Integer> hash_Set = new HashSet<>(temp);
            temp.clear();
            temp.addAll(hash_Set);
            Collections.sort(temp);
            Colony temp_ = new Colony();
            temp_.cities = temp;
            colonies.add(temp_);
        }
        //System.out.println(adj_matrix);

        // TODO: Your code here
        return colonies;
    }

    public void printColonies(List<Colony> discoveredColonies) {
        System.out.println("Discovered colonies are");
        int i = 0;
        for(Colony x : discoveredColonies) {
            System.out.println("Colony " + (i+1) + ": " + x.cities);
            i++;
        }
        // TODO: Your code here
    }
}
