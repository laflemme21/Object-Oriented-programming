import java.util.*;
public class Shoe extends CardCollection{
    public Shoe(int decks){
        super();
        Card myCard;
        for(int i=0;i<decks;i++){
            for(Card.Suit j : Card.Suit.values()){
                for(Card.Rank k : Card.Rank.values()){
                    myCard= new Card(k,j);
                    this.add(myCard);
                }
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card deal() throws CardException{
        if(this.size()!=312&&this.size()!=416){
            throw new CardException("wrong number of cards in the shoe") ;
        }
        return null;
    }
}
