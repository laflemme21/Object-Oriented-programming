import java.util.Scanner;

public class Baccarat {

  private int rounds;
  private int playerWins;
  private int bankerWins;
  private int ties;
  private BaccaratHand bankHand;
  private BaccaratHand playerHand;
  private Shoe shoe;

  /**
   * Draws a third card according to the rules
   */
  public void thirdDraw() {
    if (shoe.size() > 6
        && playerHand.value() != bankHand.value()) {

      Card pCard = shoe.deal();
      BaccaratCard pBaccaratCard = new BaccaratCard(pCard.getRank(), pCard.getSuit());
      System.out.println("Dealing third card..." + pBaccaratCard.value());

      if (playerHand.value() <= 5) {
        playerHand.add(pCard);
      }
      if (bankHand.value() < 3) {
        bankHand.add(shoe.deal());
      } else if (bankHand.value() == 3 && pBaccaratCard.value() != 8) {
        bankHand.add(shoe.deal());
      } else if (bankHand.value() == 4 && pBaccaratCard.value() > 1 && pBaccaratCard.value() < 8) {
        bankHand.add(shoe.deal());
      } else if (bankHand.value() == 5 && pBaccaratCard.value() > 3 && pBaccaratCard.value() < 8) {
        bankHand.add(shoe.deal());
      } else if (bankHand.value() == 6 && pBaccaratCard.value() > 5 && pBaccaratCard.value() < 8) {
        bankHand.add(shoe.deal());
      }
    }
  }

  /**
   * counts and prints the result of a non-Natural-hand round
   */
  public void gameStatus() {
    if (playerHand.value() == bankHand.value()) {
      System.out.println("Tie! the Player and the Banker's hands have the same values!");
      ties++;
    } else if (bankHand.value() > playerHand.value()) {
      System.out.println("The Banker Wins!");
      bankerWins++;
    } else {
      System.out.println("The Player Wins!");
      playerWins++;
    }
    System.out.println("\n");
  }

  /**
   * prints a summary rounds played
   */
  public void summary() {
    System.out.println("Rounds played: " + rounds +
        "\nBanker's wins: " + bankerWins +
        "\nPlayer's wins: " + playerWins +
        "\nTies: " + ties);
  }

  /**
   * generates a new round
   */
  public void newRound() {
    rounds++;
    System.out.printf("Round %d\n", rounds);
    bankHand = new BaccaratHand();
    playerHand = new BaccaratHand();
    for (int i = 0; i < 2; i++) {
      playerHand.add(shoe.deal());
      bankHand.add(shoe.deal());

    }
  }

  /**
   * creates a shoe with a set number of decks
   * 
   * @param num number of decks in the shoe
   */
  public Baccarat(int num) {
    shoe = new Shoe(num);
    shoe.shuffle();
  }

  /**
   * prints the current hands of the player and banker
   */
  public void printHands() {
    System.out.println("Player's hand: " + playerHand.toString() + " = " + playerHand.value());
    System.out.println("Banker's hand: " + bankHand.toString() + " = " + bankHand.value());
  }

  /**
   * checks if any of the hands are natural
   * 
   * @return boolean, true if any hand is natural, false otherwise
   */
  public boolean areNatural() {
    return bankHand.isNatural() || playerHand.isNatural();
  }

  /**
   * counts and prints the result of a Natural-hand round
   */
  public void naturalGameStatus() {
    if (bankHand.isNatural()
        && playerHand.isNatural()) {
      System.out.println("Tie! the Player and the Banker's hands are both Naturals!");
      ties++;

    } else if (bankHand.isNatural()) {
      System.out.println("The Banker Wins!");
      bankerWins++;

    } else if (playerHand.isNatural()) {
      System.out.println("The Player Wins!");
      playerWins++;

    }
    System.out.println("\n");
  }

  public static void main(String[] args) {
    String user = "y";
    Baccarat game = new Baccarat(6);
    Scanner input = new Scanner(System.in);
    // true if the shoe contains enough cards and if the user inputs y
    while ((user.charAt(0) == 'y' || user.charAt(0) == 'Y') && game.shoe.size() >= 6) {
      game.newRound();
      game.printHands();
      // draws a third card if none of the hands are Natural
      if (!(game.areNatural())) {
        game.thirdDraw();
        game.printHands();
        game.gameStatus();
      } else {
        game.naturalGameStatus();
      }
      // asks the user for input between rounds if i or interactive was given as an
      // argument

      if (args.length > 0 && (args[0].length() == 1 || args[0].length() == 11)
          && (args[0].charAt(0) == 'i' || args[0].charAt(0) == 'I')) {
        System.out.println("Another game?(y/n):");
        user = input.nextLine();
      }
    }
    game.summary();
    input.close();
    System.exit(0);

  }
}
