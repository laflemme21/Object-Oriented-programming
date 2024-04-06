import java.io.FileNotFoundException;

/**
 * Program to provide information on a GPS track stored in a file.
 *
 * @author Karl Samuel Kassis
 */
public class TrackInfo {
  public static void main(String[] args) throws FileNotFoundException {
    if(args.length==0){
      System.err.println("No file given");
      System.exit(0);
    }
    try{
    Track myTrack= new Track(args[0]);
    System.out.println(myTrack.size()+" points in track");
    System.out.println("Lowest point is "+myTrack.lowestPoint());
    System.out.println("Highest point is "+myTrack.highestPoint());
    //convert from meters to km
    System.out.printf("Total distance is %.3f km\n",myTrack.totalDistance()/1000);
    System.out.printf("Average speed is %.3f m/s\n",myTrack.averageSpeed());
  }catch(FileNotFoundException e){
    System.err.println("File not found");
    System.exit(1);
  }
   
  }
}
