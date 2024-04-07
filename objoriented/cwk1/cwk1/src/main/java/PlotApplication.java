import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

/**
 * JavaFX application to plot elevations of a GPS track, for the
 * Advanced task of COMP1721 Coursework 1.
 *
 * @author Karl Samuel Kassis
 */
public class PlotApplication extends Application{

  private static Track myTrack;
  private static String filename;

  public static void init(String [] args) throws FileNotFoundException{
    if(args.length==0){
      System.err.println("No file given");
      System.exit(0);
    }
    filename=args[0];
    myTrack=new Track(filename);
  }

  @Override
  public void start(Stage stage) throws FileNotFoundException {
    NumberAxis xAxis = new NumberAxis();
    xAxis.setLabel("Distance Traveled (m)");
    NumberAxis yAxis = new NumberAxis();
    yAxis.setLabel("Elevation (m)");
    LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

    Series<Number, Number> series1 = new LineChart.Series<>();
    series1.setName(filename);
    series1.getData().add(new XYChart.Data<>(0,myTrack.get(0).getElevation()));
    for(int i=1;i<myTrack.size();i++){
    series1.getData().add(new XYChart.Data<>
    (myTrack.totalDistance(i),myTrack.get(i).getElevation()));
  }

    lineChart.getData().add(series1);

    Scene scene = new Scene(lineChart, 800, 600);
    stage.setScene(scene);
    stage.setTitle("Elevation compared to distance");
    stage.show();
  }

  public static void main(String[] args) throws FileNotFoundException {
    init(args);
    launch(args);
  }
}
