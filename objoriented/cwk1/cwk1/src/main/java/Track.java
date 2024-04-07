import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author Karl Samuel Kassis
 */

public class Track {
  private ArrayList<Point> pointsList;

  public Track() {
    pointsList = new ArrayList<Point>();
  }

  public Track(String filename) throws FileNotFoundException {
    readFile(filename);
  }

  public void readFile(String filename) throws FileNotFoundException {

    pointsList = new ArrayList<Point>();
    //declaring usefull variables
    Point pointInLine;
    String word = "";
    double lon = 0;
    double lat = 0;
    double elev = 0;
    ZonedDateTime time = null;
    File file;

    //loading the file in a variable
    file = new File(filename);
    @SuppressWarnings("resource")
    Scanner scannerFile = new Scanner(file);

    // Skip the first line
    String line = scannerFile.next();

    // Loop through each line
    while (scannerFile.hasNext()) {

      // store a single line
      line = scannerFile.next();

      int commaCounter = 0;
      //loop through a line
      for (int i = 0; i < line.length(); i++) {

        //check if a word ended
        if (line.charAt(i) == ',') {
          //check if two commas doent contain any value between them
          if(word.equals("")){
            throw new GPSException("invalid file");}
          //assig the right data to the right variable
          if (commaCounter == 0) {
            time = ZonedDateTime.parse(word);
          } else if (commaCounter == 1) {
            lon = Double.parseDouble(word);
          } else if (commaCounter == 2) {
            lat = Double.parseDouble(word);
          }
          //update commaCounter and empty word
          commaCounter++;
          word = "";
        } 
        //
        else if (i == line.length() - 1 || line.charAt(i)=='\n') {
          word += line.charAt(i);
          elev = Double.parseDouble(word);
          word="";
        } 
        //
        else {
          word += line.charAt(i);
        }
      }
      //check if there is 4 different colomns in each line
      if(commaCounter!=3){
        throw new GPSException("invalid file");}
      pointInLine = new Point(time, lon, lat, elev);
      pointsList.add(pointInLine);
    }

  }

  public void add(Point point) {
    pointsList.add(point);
  }

  public Point get(int index) {
    if(pointsList.isEmpty() || pointsList.size()-1<index || index<0){
      throw new GPSException("inexistent index");
    }
    else{
    return pointsList.get(index);}
  }

  public int size() {
    return pointsList.size();
  }

  public Point lowestPoint() {
    if(pointsList.isEmpty()){
      throw new GPSException("inexistent index");
    }
    else{
    int smallest=0;
    for(int i=1;i<pointsList.size();i++){
      if((pointsList.get(smallest)).getElevation()>(pointsList.get(i)).getElevation()){
        smallest=i;
      }
    }
      return pointsList.get(smallest);}
  }

  public Point highestPoint() {
    if(pointsList.isEmpty()){
      throw new GPSException("inexistent index");
    }
    else{
    int highest=0;
    for(int i=1;i<pointsList.size();i++){
      if((pointsList.get(highest)).getElevation()<(pointsList.get(i)).getElevation()){
        highest=i;
      }
    }
      return pointsList.get(highest);}
  }

  public double totalDistance() {
    return totalDistance(pointsList.size());
  }

  public double totalDistance(int index) {
    if(pointsList.size()<2){
      throw new GPSException("inexistent index");
    }
    else{
      double distSum=0;
      for(int i=1;i<index;i++){
        distSum+=Point.greatCircleDistance(pointsList.get(i-1),pointsList.get(i));
      }
    return distSum;}
  }

  public double averageSpeed() {
    if(pointsList.size()<2){
      throw new GPSException("inexistent index");
    }
    else{
      double totalTime=0;
      for(int i=1;i<pointsList.size();i++){
      totalTime+=ChronoUnit.SECONDS.between
      ((pointsList.get(i-1)).getTime(), (pointsList.get(i)).getTime());}
      
    return totalDistance()/totalTime;}
  }
}
