public class Baccarat {

  private int rounds;
  private int playerWins;
  private int bankerWins;
  private int ties;
  private BaccaratHand bankHand;
  private BaccaratHand playerHand;
  private Shoe shoe;
  public boolean playersDraw(int total){
    if(total<=5){
      return true;
    }
    return false;
  }

  public boolean banksDraw(int total, int pCard){
    if(total<3){
      return true;
    }
    else if(total==3 && pCard!=8){
      return true;
    }
    else if(total==4 && pCard>1 && pCard<8){
      return true;
    }
    else if(total==5 && pCard>3 && pCard<8){
      return true;
    }
    else if(total==6 && pCard>5 && pCard<8){
      return true;
    }
    else {return false;}
  }

  public boolean gameStatus(BaccaratHand playerHand, BaccaratHand bankHand){
    if(playerHand.isNatural()&&bankHand.isNatural()){
      System.out.println("Tie! the Player and the Banker's hands are Naturals");
      ties++;
      return false;
    }
    else if(bankHand.isNatural()){
      System.out.println("The Banker's hands is a Natural");
      bankerWins++;
      return false;
    }
    else if(playerHand.isNatural()){
      System.out.println("The Player's hands is a Natural");
      playerWins++;
      return false;
    }
    else{
      System.out.println("Neither the Player or the Banker's hand are Naturals");
      return true;
    }
  }

  public void summary(){
    System.out.println("Rounds: "+rounds+"\nBanker's wins: "+bankerWins+"\nPlayer's wins: "+playerWins+"\nTies: "+ties);
  }

  public void newGame(){
    bankHand = new BaccaratHand();
    playerHand = new BaccaratHand();
    for(int i=0;i<2;i++){
      playerHand.add(shoe.deal());
      bankHand.add(shoe.deal());
    }
    rounds++;
  }

  public void newShoe(int num){
    shoe = new Shoe(num);
    shoe.shuffle();
  }

  public void printHands(){
    System.out.println("Player's hand: "+playerHand.toString()+" = "+playerHand.value());
    System.out.println("Banker's hand: "+bankHand.toString()+" = "+bankHand.value());
    }
  public static void main(String[] args){


  }
}
