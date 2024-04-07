package sem2.objoriented.exos;

public class CheckPassword {
  public static boolean longEnough(String password) {
    if(password.length()<12){
      return false;
    }
    return true;
  }

  public static boolean atLeastTwoDigits(String password) {
    int count=0;
    for(int i=0;i<password.length();i++){
      if(Character.isDigit(password.charAt(i))){
        count=count+1;
      }
    }
    if(count>=2){
      return true;
    }
    return false;
  }
  

  public static void main(String[] args) {
    for(String element : args){
      if(longEnough(element) && atLeastTwoDigits(element)){
        System.out.println("Password is valid");
      }
      else{
        System.out.println("Password is invalid");
        System.exit(1);
      }
    }
  }

}