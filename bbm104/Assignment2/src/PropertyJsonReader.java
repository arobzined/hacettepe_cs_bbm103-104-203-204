import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;


public class PropertyJsonReader<Square> extends Monopoly{
     private LinkedList<Square> squares = new LinkedList<Square>();
	 
     public PropertyJsonReader(){
         JSONParser processor = new JSONParser();
         try (Reader file = new FileReader("property.json")){
             JSONObject jsonfile = (JSONObject) processor.parse(file);
             JSONArray Land = (JSONArray) jsonfile.get("1");
             for(Object i:Land){
				 
				 //You can reach items by using statements below:
				 int id = Integer.parseInt((String)((JSONObject)i).get("id"));
				 String name = (String)((JSONObject)i).get("name");
				 int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
                 Lands land = new Lands(id,name,cost);
                 Lands.landsArrayList.add(land);
				 //And you can add these items to any data structure (e.g. array, linkedlist etc.
             }
             for(Lands i:Lands.landsArrayList){
                 Properties.propertyArrayListNames.add(i.getName());
             }

             JSONArray RailRoad = (JSONArray) jsonfile.get("2");
             for(Object i:RailRoad){
				 //You can reach items by using statements below:
                int id = Integer.parseInt((String)((JSONObject)i).get("id"));
				String name = (String)((JSONObject)i).get("name");
				int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
                RailRoads obj1 = new RailRoads(id,name,cost);
                RailRoads.railroadsarray.add(obj1);


				//And you can add these items to any data structure (e.g. array, linkedlist etc.
             }
             for(RailRoads i:RailRoads.railroadsarray){
                 Properties.propertyArrayListNames.add(i.getName());
             }
			 
             JSONArray Company = (JSONArray) jsonfile.get("3");
             for(Object i:Company){
				 //You can reach items by using statements below:
                 int id = Integer.parseInt((String)((JSONObject)i).get("id"));
				 String name = (String)((JSONObject)i).get("name");
				 int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));
                 Companies obj1 = new Companies(id,name,cost);
                 Companies.comlist.add(obj1);

             }
             for(Companies i:Companies.comlist){
                 Properties.propertyArrayListNames.add(i.getName());
             }
             
         } catch (IOException e){
             e.printStackTrace();
         } catch (ParseException e){
             e.printStackTrace();
         }
     }
     //You can add function(s) if you want
}