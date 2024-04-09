import java.util.*;
public class Shoe extends CardCollection{
    public Shoe(int decks) throws CardException{
        super();
        if(decks!=6&&decks!=8){
            throw new CardException("wrong number of cards in the shoe") ;
        }
        BaccaratCard myBaccaratCard;
        for(int i=0;i<decks;i++){
            for(Card.Suit j : Card.Suit.values()){
                for(Card.Rank k : Card.Rank.values()){
                    myBaccaratCard= new BaccaratCard(k,j);
                    this.add(myBaccaratCard);
                }
            }
        }
    }

    public void shuffle() throws CardException{
        if(isEmpty()){
            throw new CardException("not enough cards in the shoe") ;
        }
        Collections.shuffle(cards);
    }

    public Card deal() throws CardException{
        if(isEmpty()){
            throw new CardException("not enough cards in the shoe") ;
        }
        return cards.remove(0);
    }
}
