package sem2.objoriented.exos;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
import java.text.NumberFormat;
class spheroid {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter equatorial radius in km:");
        Double equatorial_a = input.nextDouble();
        if(equatorial_a<=0){
            System.out.println("Error equatorial radius must be larger than 0");
            System.exit(0);
        }
        System.out.printf("Enter polar radius in km:");
        Double polar_c = input.nextDouble();
        if(polar_c<=0){
            System.out.println("Error polar radius must be larger than 0");
            System.exit(0);
        }
        if(polar_c>equatorial_a){
            System.out.println("Error polar radius must be smaller than equatorial radius");
            System.exit(0);
        }
        NumberFormat sci_form = new DecimalFormat("0.#####E0");
        System.out.printf("Eccentricity = %.3f \nVolume = %s cubic km",Math.sqrt(1-Math.pow(polar_c,2)/Math.pow(equatorial_a,2)),sci_form.format((4*Math.PI*Math.pow(equatorial_a,2)*polar_c)/3));
        input.close();
    }
}