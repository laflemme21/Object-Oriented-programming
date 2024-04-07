public class BaccaratCard extends Card{

    public BaccaratCard(Card.Rank r,Card.Suit s){
        super(r,s);

    }
    
    @Override
    public int value(){
        if(Math.min(getRank().ordinal() + 1, 10)<10){
            return Math.min(getRank().ordinal() + 1, 10);
        }
        else{
        return 0;}
    }
}