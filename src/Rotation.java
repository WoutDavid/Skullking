import java.util.HashMap;
import java.util.Arrays;

public class Rotation {
    HashMap<Player, Card> playedCards;
    String firstColor;
    Player winner = null;
    Card winning_card = null;
    boolean first = true;  

    public Rotation(HashMap<Player, Card> playedCards, String firstColor){
        this.playedCards=playedCards;
        this.firstColor=firstColor;
    }


    //takes as input a map of players and their played cards for this rotation, 
    public HashMap<Player, Card> playRotation(){
        for (HashMap.Entry<Player, Card> entry : playedCards.entrySet()) {
            winner = entry.getKey();
            winning_card = entry.getValue();
            break;
        }
        for (HashMap.Entry<Player, Card> entry : playedCards.entrySet()) {
            if (first) {
                first = false;
                continue;
            }
            else {
                if (winning_card.getName().equals("number")){
                    if (!entry.getValue().getName().equals("number")){
                        winning_card = entry.getValue();
                        winner = entry.getKey();
                    }
                    else {
                        //if the new card is also a numeric card
                        //then either one of them is black and the other isn't, or the number is bigger and it is in the "firstcolor"
                        if ((((NumericCard)entry.getValue()).getNumber() > ((NumericCard)winning_card).getNumber() && ((NumericCard)entry.getValue()).getColor().equals(firstColor)) || (((NumericCard)entry.getValue()).getColor().equals("black") && (!(((NumericCard)winning_card).getColor().equals("black"))))){
                            winning_card = entry.getValue();
                            winner = entry.getKey();
                        }
                    }

                }
                //if the winning card isn't a numeric card
                else {
                    //if the entry card is a numeric card
                    if (entry.getValue().getName().equals("number")){
                        continue;
                    }
                    //if they are both personacards
                    else{
                        if (Arrays.asList(((PersonaCard)entry.getValue()).getTrumps()).contains(winning_card.getName())){
                            winning_card = entry.getValue();
                            winner = entry.getKey();
                        }
                    }
                }
            }
        }
        HashMap<Player, Card> returnMap = new HashMap<Player, Card>();
        returnMap.put(winner, winning_card);
        return returnMap;
    }
    
}

