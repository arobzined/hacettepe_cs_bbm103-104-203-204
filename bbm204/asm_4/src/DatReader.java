import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatReader {
    
    private String fileContent;

    public DatReader(String filename) {
        Path filePath = Path.of(filename);
        try {
            fileContent = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write the necessary Regular Expression to extract the filename given as the string and
     * surrounded by double quotation marks
     * @return the result as String
     */
    public String getStringVar(String varName) {
        String pattern = "[\\t ]*" + varName + "\\s*=\\s*\"([^\"]*)\"";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(fileContent);
        matcher.find();
        //returns the string variable
        return matcher.group(1);

    }

    /**
     * Write the necessary Regular Expression to extract floating point numbers from the input file
     * Your regular expression should support floating point numbers with an arbitrary number of
     * decimals or without any (e.g. 5, 5.2, 5.02, 5.0002, etc.).
     * @return the result as Double
     */
    public Double getDoubleVar(String varName) {
        Pattern p = Pattern.compile("[\\t ]*" + varName + "[\\t ]*=[\\t ]*([0-9]{1,13}\\.[0-9]*)?");
        Matcher m = p.matcher(fileContent);
        m.find();
        if(m.group(1) == null){
          p = Pattern.compile("[\\t ]*" + varName + "[\\t ]*=[\\t ]*([0-9]+)");
          m = p.matcher(fileContent);
          m.find();
          //this works if the number is not contains dot [1,2,3,4 if it is :D] , and returns the integer as double ofc.
          return Double.parseDouble(m.group(1));
        }
        //returns double number directly
        return Double.parseDouble(m.group(1));
    }

    /**
     * Method with a Regular Expression to extract integer numbers from the input file
     * @return the result as int
     */
    public int getIntVar(String varName) {
        Pattern p = Pattern.compile("[\\t ]*" + varName + "[\\t ]*=[\\t ]*([0-9]+)");
        Matcher m = p.matcher(fileContent);
        m.find();
        //returns the value of that varName .
        return Integer.parseInt(m.group(1));
    }

    /**
     * Write the necessary Regular Expression to extract a Point object from the input file
     * points are given as an x and y coordinate pair surrounded by parentheses and separated by a comma
     * @return the result as a Point object
     */
    public Point getPointVar(String varName) {
        String regex = "[\\t ]*" + varName + "[\\t ]*=[\\t ]*\\(([\\t ]*\\d+[\\t ]*,[\\t ]*\\d+[\\t ]*)\\)";
        Pattern pt = Pattern.compile(regex);
        Matcher m = pt.matcher(fileContent);
        m.find();
        //System.out.println(m.group(1));
        String[] list = m.group(1).split(",");
        int int1 = Integer.parseInt(list[0].strip());
        int int2 = Integer.parseInt(list[1].strip());
        //returns the point variables , I HADN'T KNOWN THAT YOU IMPLEMENT LIKE (Y,X) INSTEAD OF
        //(X,Y) , I DEAL WITH THAT LIKE 1 DAY , GIMME BACK THAT DAY ):-( (love you guys btw) .
        Point p = new Point(int1,int2);
        return p;
    } 

}
