import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class TravelMap {

    // Maps a single Id to a single Location.
    public Map<Integer, Location> locationMap = new HashMap<>();

    // List of locations, read in the given order
    public List<Location> locations = new ArrayList<>();

    // List of trails, read in the given order
    public List<Trail> trails = new ArrayList<>();
    public List<Trail> temp_t = new ArrayList<>();

    // TODO: You are free to add more variables if necessary.

    public void initializeMap(String filename) {
        try {
            File inputFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Location");
            NodeList nTrailList = doc.getElementsByTagName("Trail");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);


                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Location temp_ = new Location(eElement.getElementsByTagName("Name").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("Id").item(0).getTextContent()));

                    locations.add(temp_);
                    locationMap.put(temp_.id,temp_);
                }
            }
            for (int temp = 0; temp < nTrailList.getLength(); temp++) {
                Node nNode = nTrailList.item(temp);


                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Trail temp_ = new Trail(locations.get(Integer.parseInt(eElement.getElementsByTagName("Source").item(0).getTextContent())),
                            locations.get(Integer.parseInt(eElement.getElementsByTagName("Destination").item(0).getTextContent())),
                            Integer.parseInt(eElement.getElementsByTagName("Danger").item(0).getTextContent()));

                    trails.add(temp_);
                    temp_t.add(temp_);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO: Your code here
    }

    public List<Trail> getSafestTrails() {
        List<Trail> safestTrails = new ArrayList<>();
        temp_t.sort(Comparator.comparingInt(d -> d.danger));

        // Create a Union-Find data structure to keep track of connected components
        Map<Location, Location> parent = new HashMap<>();
        for (Location loc : locations) {
            parent.put(loc, loc);
        }

        for (Trail path : temp_t) {
            Location sourceParent = find(path.source, parent);
            Location destParent = find(path.destination, parent);

            if (!sourceParent.equals(destParent)) {
                // Add this trail to the minimum spanning tree
                safestTrails.add(path);

                // Update the parent map to connect the two components
                parent.put(sourceParent, destParent);
            }
        }

        return safestTrails;
    }

    // Helper function to find the parent of a location in the Union-Find data structure
    private Location find(Location loc, Map<Location, Location> parent) {
        if (loc.equals(parent.get(loc))) {
            return loc;
        }
        parent.put(loc, find(parent.get(loc), parent));
        return parent.get(loc);
    }


    public void printSafestTrails(List<Trail> safestTrails) {
        System.out.println("Safest trails are");
        int i = 0;
        for(Trail x : safestTrails){
            System.out.println("The trail from " + x.source.name + " to " + x.destination.name + " with danger " + x.danger);
            i += x.danger;
        }
        System.out.println("Total danger: " + i);
        // TODO: Your code here
    }
}
