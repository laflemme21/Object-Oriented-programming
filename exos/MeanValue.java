package sem2.objoriented.exos;



public class MeanValue {
    public static double meanValue(double[] data) {
        double sum=0;
        for(int i=0;i<data.length;i++){
            sum+=data[i];
        }
        return sum/data.length;
    }
  
    public static void main(String[] args) {
        double[] validlist = new double[args.length];
        if(args.length==0){
            System.err.print("No arguments were passed");
            System.exit(1);
        }
        for(int i=0;i<args.length;i++){
            validlist[i]=Double.parseDouble(args[i]);
        }
        System.out.printf("Mean Value = %.3f",meanValue(validlist));
    }
  }
