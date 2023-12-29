import java.util.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class IMECEPathFinder {
  public int[][] grid;
  public int height, width;
  public int maxFlyingHeight;
  public double fuelCostPerUnit, climbingCostPerUnit;
  private String fileContent;

  public IMECEPathFinder(String filename, int rows, int cols, int maxFlyingHeight, double fuelCostPerUnit,
      double climbingCostPerUnit) {

    grid = new int[rows][cols];
    this.height = rows;
    this.width = cols;
    this.maxFlyingHeight = maxFlyingHeight;
    this.fuelCostPerUnit = fuelCostPerUnit;
    this.climbingCostPerUnit = climbingCostPerUnit;

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      int row_count = 0;
      while ((line = br.readLine()) != null) {
        String[] cols_w = line.split("   ");
        for (int i = 0; i < cols_w.length; i++) {
          if (i == 0) {
            continue;
          }
          //reads the matrix file and stores in grid , basically.
          this.grid[row_count][i - 1] = Integer.parseInt(cols_w[i]);
        }
        row_count++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("grayscaleMap.dat"))){
      // this is for grayscaleMap.dat , I found the biggest and lowest bounds in here ,
      // then find the range and divide it by 255 which is maximum pixel value , then found the ratio value
      // then for every number in our grid , I found the distribution value for our ratio and store it in that
      // file.


      double max = grid[0][0];
      double min = grid[0][0];
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          max = Math.max(max, grid[i][j]); // the max at the end
          min = Math.min(min, grid[i][j]); // the min at the end
        }
      }

      double ratio = (max - min) / 255; // the ratio -> we will use it in calculation

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          int value = (int) ((grid[i][j] - min) / ratio); //the int part of the value , we are not using the rest
          bw.write(value + " ");
          //g.setColor(new Color(value, value, value));
          //g.fillRect(j, i, 1, 1);
        }
        bw.write("\n");
      }
    }catch (IOException e){
      e.printStackTrace();
    }

  }

  /**
   * Draws the grid using the given Graphics object.
   * Colors should be grayscale values 0-255, scaled based on min/max elevation
   * values in the grid
   */
  public void drawGrayscaleMap(Graphics g) {

    // TODO: draw the grid, delete the sample drawing with random color values given
    // below
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("grayscaleMap.dat"))){
    // this is the same as gridscaleMap implementation , i didn't know i shouldn't do it in here :(
    // you can uncomment it if you want but if you that grayscaleMap would be filled twice , that's unnecessary

      double max = grid[0][0];
      double min = grid[0][0];
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          max = Math.max(max, grid[i][j]);
          min = Math.min(min, grid[i][j]);
        }
      }

      double ratio = (max - min) / 255;

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          int value = (int) ((grid[i][j] - min) / ratio);
          bw.write(value + " ");
          g.setColor(new Color(value, value, value));
          g.fillRect(j, i, 1, 1);
        }
        bw.write("\n");
      }
    }catch (IOException e){
      e.printStackTrace();
    }

  }

  /**
   * Get the most cost-efficient path from the source Point start to the
   * destination Point end
   * using Dijkstra's algorithm on pixels.
   * 
   * @return the List of Points on the most cost-efficient path from start to end
   */
  public List<Point> getMostEfficientPath(Point start, Point end) {
    //the hardest part :') , i cried maybe when i was writing that code.
    List<Point> path = new ArrayList<>();

    double[][] distance = new double[height][width];
    //firstly , I created a distance array and filled with posi. infinitive number . we are going to
    //use it for compare the distances and decide the efficient one , that's why we use the biggest number here .
    for (int i = 0; i < height; i++) {
      Arrays.fill(distance[i],Double.POSITIVE_INFINITY);
    }


    Point[][] previousMove = new Point[height][width];
    PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(p -> distance[p.y][p.x]));
    // and this is previosMove array , that contains our moves . when we found the dest. point , with the
    // help of that array , we are going to found our way how we came here efficiently from start point.

    // we also created a queue that is the moves we are doing in our grid , we use this queue for wondering
    // around the matrix

    distance[start.y][start.x] = 0;
    queue.add(start);

    // we put 0 to start point's distance value , because we are start out way from here so there is no spending.
    // we also put start to queue because we are start from here again .

    while (!queue.isEmpty()) {
      Point current = queue.poll();
      // the current we are in is the next pop value from the queue , that helps us to implement the algorithm
      // in iterative way.
      if (current.x == end.x && current.y == end.y) {
        // if we reach the end point , we have to found how can we reach here , we are going to use the previousMove
        // array here.
        return thePath(path,end,previousMove);
      }

      int[] rows = {-1,-1,-1,0,0,1,1,1};
      int[] cols = {-1,0,1,-1,1,-1,0,1};

      // the possible moves for our current position.

      for (int i = 0; i < 8; i++) {
          Point neighbor = new Point(current.x + cols[i], current.y + rows[i]);
          //create the point version of that neighbor.

          if (isValid(neighbor) && grid[current.y + rows[i]][current.x + cols[i]] <= maxFlyingHeight) {
            // check the point can be in grid (not extend the sizes) and its value (height) is not bigger than maximum
            // value
            double cost = costPerUnit(current, neighbor); // the cost between current to neighbor.
            double totalCost = cost + distance[current.y][current.x]; // total cost , cost value with previous costs we have spent.
            if (totalCost < distance[neighbor.y][neighbor.x]) {
              //checking if the cost we are doing now is more efficient than we have made before ?
              //System.out.println();
              distance[neighbor.y][neighbor.x] = totalCost; //if it is , change the cost.
              previousMove[neighbor.y][neighbor.x] = current; //sign here , it is efficient to go
              queue.add(neighbor);//the neighbor point can be visitable for finding the efficient path.
            }
          }

      }
    }
    //if there is no way to found that place , it returns empty list.
    return path;
  }

  private List<Point> thePath(List<Point> path , Point end , Point[][] martix){
    // the path founding part . we are visiting here, so we have found our dest.
    // we are going to use matrix to go back to start point , and doing that we are going to add the path in
    // the beginning , so it would be sorted as start ---> end point.

    Point temp = end;
    while (temp != null) {
      path.add(0, temp);
      temp = martix[temp.y][temp.x];
    }
    return path; //the path
  }



  private boolean isValid(Point current) {
    //check is the point extends the matrix.
    return (current.x >= 0 && current.x < width && current.y >= 0 && current.y < height);
  }

  private double costPerUnit(Point current, Point nextMove) {
    //cost function we must use.
    double dist = Math.sqrt(Math.pow(current.x - nextMove.x, 2) + Math.pow(current.y - nextMove.y, 2));//(x^2 + y^2)^0.5
    double heightImp = 0.0;
    if (grid[current.y][current.x] < grid[nextMove.y][nextMove.x]) {
      heightImp = grid[nextMove.y][nextMove.x] - grid[current.y][current.x]; // if the next place is higher than we are now.
    }
    return (dist * fuelCostPerUnit) + (climbingCostPerUnit * heightImp);
  }



  /*
  This was my first Dijkstra algorithm trying so i didn't want to delete it :).It helps me a lot !
  private void wonderingInSizePath(Point current, double[][] size, double cost, Point end) {

    if (current.y == end.y || current.x == end.x) {
      return;
    }
    if (size[current.y][current.x] == 0.0 || size[current.y][current.x] > cost) {
      size[current.y][current.x] = cost;
    }
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if (i == 0 && j == 0) {
          continue; // Skip the current position
        }
        if (isValid(new Point(current.x + j, current.y + i)) && grid[current.y + i][current.x + j] <= maxFlyingHeight) {
          Point next = new Point(current.x + j, current.y + i);
          double currCost = cost + costPerUnit(current, next);
          wonderingInSizePath(next, size, currCost, end);
        }
      }
    }
  }*/


  /**
   * Calculate the most cost-efficient path from source to destination.
   * 
   * @return the total cost of this most cost-efficient path when traveling from
   *         source to destination
   */
  public double getMostEfficientPathCost(List<Point> path) {
    //calculates the cost basically , return the total from start to end
    double totalCost = 0.0;

    for(int i = 0;i < path.size() - 1;i++){
      totalCost += costPerUnit(path.get(i),path.get(i+1));
    };


    return totalCost;
  }

  /**
   * Draw the most cost-efficient path on top of the grayscale map from source to
   * destination.
   */
  public void drawMostEfficientPath(Graphics g, List<Point> path) {
    //for drawing mission 0
    for(Point elm : path){
      g.setColor(new Color(0, 255, 0));
      g.fillRect(elm.x, elm.y, 1, 1);
    }
  }

  /**
   * Find an escape path from source towards East such that it has the lowest
   * elevation change.
   * Choose a forward step out of 3 possible forward locations, using greedy
   * method described in the assignment instructions.
   * 
   * @return the list of Points on the path
   */
  public List<Point> getLowestElevationEscapePath(Point start) {
    //the mission 1 part, greedy part , I used a function and i called it recursively in itself .
    //then return the escape path.
    List<Point> pathPointsList = new ArrayList<>();
    // TODO: Your code goes here
    // TODO: Implement the Mission 1 greedy approach here
    pathPointsList.add(start);
    getNextMove(start,pathPointsList);
    //System.out.println(pathPointsList.get(pathPointsList.size() - 1).x + " - " + pathPointsList.get(pathPointsList.size() - 1).y);
    return pathPointsList;
  }

  public boolean isNotValid(Point curr){
    //if it cannot be a point in the matrix , return true.
    if(curr.x >= width){
      return true;
    }
    return false;
  }

  public List<Point> getNextMove(Point current,List<Point> list){
    Point northEast = new Point(current.x + 1, current.y - 1);
    Point east = new Point(current.x + 1, current.y);
    Point southEast = new Point(current.x + 1, current.y + 1);
    //the next moves , northeast , east and southeast .

    if(isNotValid(northEast)){
      return list;
    }
    // I only checked the one point because of only one value is changing for three of them :3 .

    Point nextMove = compareInts(northEast,east,southEast,current); // found the efficient nextMove at that point.

    list.add(nextMove); //add to path
    return getNextMove(nextMove, list); // go to next point
  }

  public Point compareInts(Point northEast,Point east, Point southEast,Point curr){
    //the comparing part , basically returns the most efficient neighbor for curr.
    int currentH = grid[curr.y][curr.x];

    int h1 = Math.abs(currentH - grid[northEast.y][northEast.x]);
    int h2 = Math.abs(currentH - grid[east.y][east.x]);
    int h3 = Math.abs(currentH - grid[southEast.y][southEast.x]);

    if(h1 < h2 && h1 < h3){
      return northEast;
    }
    else if(h2 < h1 && h2 < h3){
      return east;
    }
    else if(h3 < h2 && h3 < h1){
      return southEast;
    }
    else{
      if(h1 == h3 && h1 == h2){
        return east;
      }
      else{
        if(h1 == h2){
          return east;
        }
        else if(h1 == h3){
          return northEast;
        }
        else {
          return east;
        }
      }
    }
  }



  /**
   * Calculate the escape path from source towards East such that it has the
   * lowest elevation change.
   * 
   * @return the total change in elevation for the entire path
   */
  public int getLowestElevationEscapePathCost(List<Point> pathPointsList) {
    // basically calculates the cost , depends on the height differents in absolute value
    // and returns it.
    int totalChange = 0;

    // TODO: Your code goes here, use the output from the
    for(int i = 0;i < pathPointsList.size() - 1;i++){
      totalChange += Math.abs(grid[pathPointsList.get(i).y][pathPointsList.get(i).x] -
              grid[pathPointsList.get(i+1).y][pathPointsList.get(i+1).x]);
    }

    return totalChange;
  }

  /**
   * Draw the escape path from source towards East on top of the grayscale map
   * such that it has the lowest elevation change.
   */
  public void drawLowestElevationEscapePath(Graphics g, List<Point> pathPointsList) {
    // the drawing for greedy part.
    for(Point elm : pathPointsList){
      g.setColor(new Color(255, 255, 0));
      g.fillRect(elm.x, elm.y, 1, 1);
    }

  }
  //THANK YOU FOR READING !! IT WAS GREAT TO DEAL WITH YOUR ASSIGNMENTS , I LEARNED SO MUCH THING AND
  // I'M GRATEFUL .


}
