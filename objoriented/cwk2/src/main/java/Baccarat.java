import java.util.Scanner;
public class Baccarat {

  private int rounds;
  private int playerWins;
  private int bankerWins;
  private int ties;
  private BaccaratHand bankHand;
  private BaccaratHand playerHand;
  private Shoe shoe;

  public void thirdDraw(){
    if(shoe.size()>6
    &&playerHand.value()!=bankHand.value()
    &&!(bankHand.isNatural()
    &&playerHand.isNatural())){

      Card pCard=shoe.deal();
      BaccaratCard pBaccaratCard= new BaccaratCard(pCard.getRank(), pCard.getSuit());
      System.out.println("Dealing third card..."+pBaccaratCard.value());

      if(playerHand.value()<=5){
        playerHand.add(pCard);
      }
      if(bankHand.value()<3){
        bankHand.add(shoe.deal());
      }
      else if(bankHand.value()==3 && pBaccaratCard.value()!=8){
        bankHand.add(shoe.deal());
      }
      else if(bankHand.value()==4 && pBaccaratCard.value()>1 && pBaccaratCard.value()<8){
        bankHand.add(shoe.deal());
      }
      else if(bankHand.value()==5 && pBaccaratCard.value()>3 && pBaccaratCard.value()<8){
        bankHand.add(shoe.deal());
      }
      else if(bankHand.value()==6 && pBaccaratCard.value()>5 && pBaccaratCard.value()<8){
        bankHand.add(shoe.deal());
      }
    }
  }

  public void gameStatus(){
    if(playerHand.value()==bankHand.value()){
      System.out.println("Tie! the Player and the Banker's hands are Naturals!");
      ties++;
    }
    else if(bankHand.isNatural()){
      System.out.println("The Banker's hands is a Natural!");
      bankerWins++;
    }
    else if(playerHand.isNatural()){
      System.out.println("The Player's hands is a Natural!");
      playerWins++;
    }
    else if(bankHand.value()>playerHand.value()){
      System.out.println("The Banker Wins!");
      bankerWins++;
    }
    else{
      System.out.println("The Player Wins!");
      playerWins++;
    }
  }

  public void summary(){
    System.out.println
    ("Rounds played: "+rounds+
    "\nBanker's wins: "+bankerWins+
    "\nPlayer's wins: "+playerWins+
    "\nTies: "+ties);
  }

  public void newRound(){
    if(shoe.size()>=10){
      bankHand = new BaccaratHand();
      playerHand = new BaccaratHand();
      for(int i=0;i<2;i++){
        playerHand.add(shoe.deal());
        bankHand.add(shoe.deal());
      }
      rounds++;
    }
  }

  public Baccarat(int num){
    shoe = new Shoe(num);
    shoe.shuffle();
  }

  public void printHands(){
    System.out.println("Player's hand: "+playerHand.toString()+" = "+playerHand.value());
    System.out.println("Banker's hand: "+bankHand.toString()+" = "+bankHand.value());
    }
  public static void main(String[] args){
    String user = "y";
    Baccarat game = new Baccarat(6);
    Scanner myObj = new Scanner(System.in);
    while((user.charAt(0)=='y' || user.charAt(0)=='Y')&&game.shoe.size()>=10){

      game.newRound();
      game.printHands();
      game.thirdDraw();
      game.printHands();
      game.gameStatus();

      if(args[0].charAt(0)=='i'||args[0].charAt(0)=='I'){
        System.out.println("Another game?(y/n):");
        user = myObj.nextLine();
      }
    }
    game.summary();
    myObj.close();
    System.exit(0);

  }
}
