public class BaccaratHand extends CardCollection{

    public BaccaratHand(){
        super();
    }

    public boolean isNatural(){
        return cards.size()==2 && (this.value()==8 || this.value()==9);
    }

    @Override
    public String toString(){
        String string="";
        for(Card i: cards){
            string+=i.getRank().getSymbol();
            string+=i.getSuit().getSymbol()+" ";
        }
        if(!(string.equals(""))){
        string = string.substring(0, string.length()-1);}
        return string;
    }

    @Override
    public int value(){
        int cardValue;
        int sum=0;
        for(Card i: cards){
            cardValue=i.value();
            if(cardValue==10){
                cardValue=0;
            }
            sum+=cardValue;
        }
        return sum%10;
    }


}