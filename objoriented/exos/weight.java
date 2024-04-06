package sem2.objoriented.exos;

import java.util.Scanner;
class weightt {
    public static void main(String[] args) {
        Scanner scanner_obj = new Scanner(System.in);
        System.out.printf("Enter weight in kilograms: ");
        Double kg = scanner_obj.nextDouble();
        scanner_obj.close();
        
        System.out.printf("Equivalent imperial weight is %d lb %.1f oz",(int)(kg/0.45359237),(kg/0.45359237-(int)(kg/0.45359237))*16);
    }
}