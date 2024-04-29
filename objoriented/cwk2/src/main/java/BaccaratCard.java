public class BaccaratCard extends Card {

    /**
     * BaccaratCard constructor
     * 
     * @param r
     * @param s
     */
    public BaccaratCard(Card.Rank r, Card.Suit s) {
        super(r, s);
    }

    /**
     * returns the value of BaccaratCard
     * 
     * @return int
     */
    @Override
    public int value() {
        if (getRank().ordinal() + 1 < 10) {
            return getRank().ordinal() + 1;
        } else {
            return 0;
        }
    }
}