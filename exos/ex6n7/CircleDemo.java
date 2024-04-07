package sem2.objoriented.exos.ex6n7;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CircleDemo {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        System.out.printf("Radius    =?\n");
        double r = inputScanner.nextDouble();
        Circle circle1 = new Circle(r);
        DecimalFormat formatter = new DecimalFormat("#.###");
        System.out.println("Radius1    = "+formatter.format(circle1.getRadius()));
        System.out.println("Perimeter1 = "+formatter.format(circle1.perimeter()));
        System.out.println("area1      = "+formatter.format(circle1.area()));
        System.out.println(circle1.toString()+"\n");

        System.out.printf("Radius2    =?\n");
        r = inputScanner.nextDouble();
        inputScanner.close();
        Circle circle2 = new Circle(r);
        System.out.println("Radius2    = "+formatter.format(circle2.getRadius()));
        System.out.println("Perimeter2 = "+formatter.format(circle2.perimeter()));
        System.out.println("area2      = "+formatter.format(circle2.area()));
        System.out.println(circle2.toString()+"\n");

        System.out.println("c1==c2: "+circle1.equals(circle2));

        try{
            Circle circle3 = new Circle(-1);
            System.out.println(circle3.getRadius());

        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
    }
}