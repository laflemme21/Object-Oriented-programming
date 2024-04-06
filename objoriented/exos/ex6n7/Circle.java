package sem2.objoriented.exos.ex6n7;
import java.lang.Math;

public class Circle {
    private double radius;

    public Circle(){
        this(1);
    }

    public Circle(double r){
        if (r<=0){
            throw new IllegalArgumentException("Invalid radius");
        }
        
        else{
        radius = r;
        }
    }    


    public double getRadius(){
        return radius;
    }

    public double area(){
        return Math.PI*Math.pow(radius,2);
    }            

    public double perimeter(){
        return 2*Math.PI*radius;
    }

    @Override
    public String toString(){
        return String.format("Circle(radius=%.4f)",getRadius());
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Circle)){
            return false;
        }
        Circle circobj = (Circle) obj;
        if(radius+0.00005>circobj.radius && radius-0.00005<circobj.radius){
            return true;
        }
        return false;
    }
}
