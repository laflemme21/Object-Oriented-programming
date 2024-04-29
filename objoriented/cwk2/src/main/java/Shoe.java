import java.util.Collections;

public class Shoe extends CardCollection {
    /**
     * 
     * Shoe constructor.
     * 
     * @param decks
     * @throws CardException
     */
    public Shoe(int decks) throws CardException {
        super();
        if (decks != 6 && decks != 8) {
            throw new CardException("wrong number of cards in the shoe");
        }
        BaccaratCard myBaccaratCard;
        for (int i = 0; i < decks; i++) {
            // adds all every card to the shoe for the number of decks
            for (Card.Suit j : Card.Suit.values()) {
                for (Card.Rank k : Card.Rank.values()) {
                    myBaccaratCard = new BaccaratCard(k, j);
                    this.add(myBaccaratCard);
                }
            }
        }
    }

    /**
     * Shuffles the shoe.
     * 
     * @throws CardException
     */
    public void shuffle() throws CardException {
        if (isEmpty()) {
            throw new CardException("not enough cards in the shoe");
        }
        Collections.shuffle(cards);
    }

    /**
     * Deals one card from the shoe
     * 
     * @return BaccaratCard
     * @throws CardException
     */
    public Card deal() throws CardException {
        if (isEmpty()) {
            throw new CardException("not enough cards in the shoe");
        }
        return cards.remove(0);
    }
}
