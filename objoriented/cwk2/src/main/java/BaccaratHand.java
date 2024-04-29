public class BaccaratHand extends CardCollection {
    /**
     * BaccaratHand constructor.
     */
    public BaccaratHand() {
        super();
    }

    /**
     * Checks if BaccaratHand is Natural.
     * 
     * @return boolean
     */
    public boolean isNatural() {
        return cards.size() == 2 && (this.value() == 8 || this.value() == 9);
    }

    /**
     * returns the BaccaratHand's values in a string
     * 
     * @return String
     */
    @Override
    public String toString() {
        String string = "";
        for (Card i : cards) {
            string += i.getRank().getSymbol();
            string += i.getSuit().getSymbol() + " ";
        }
        if (!(string.equals(""))) {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    /**
     * returns the value of the BaccaratHand
     * 
     * @return int
     */
    @Override
    public int value() {
        int cardValue;
        int sum = 0;
        // adds the value of cards together
        for (Card i : cards) {
            cardValue = i.value();
            if (cardValue == 10) {
                cardValue = 0;
            }
            sum += cardValue;
        }
        return sum % 10;
    }

}