import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Arrays;

public class Trick {
    LinkedHashMap<Player, Card> playedCards;
    String firstColor=null;
    Player winner = null;
    Card winning_card = null;
    boolean first = true;  

    public Trick(LinkedHashMap<Player, Card> playedCards){
        this.playedCards=playedCards;
    }


    //takes as input a map of players and their played cards for this trick, 
    //returns a map of a player who won this trick with the card that they did it with
    public HashMap<Player, Card> playTrick(){
        //This forloop is for debugging purposes
        for (HashMap.Entry<Player, Card> entry : playedCards.entrySet()) {
            Player player = entry.getKey();
            Card playerCard = entry.getValue();
            System.out.println(String.format("%s plays the card %s", player, playerCard));
        }
        //set the first entry of the linkedHashMap to be the winner, because no matter what happens, the first card wins if everyone plays an escape.
        for (HashMap.Entry<Player, Card> entry : playedCards.entrySet()) {
            winner = entry.getKey();
            winning_card = entry.getValue();
            if (firstColor==null && winning_card instanceof NumericCard){
                firstColor = ((NumericCard)winning_card).getColor();
            }
            break;
        }
        //This is where the comparing of each player's cards starts.
        for (HashMap.Entry<Player, Card> entry : playedCards.entrySet()) {
            //skip the first element because that's already the winning card up until this point
            if (first) {
                first = false;
                continue;
            }
            else {
                Player currentPlayer = entry.getKey();
                Card currentCard = entry.getValue();

                //if the winning card was a numeric card
                if (winning_card instanceof NumericCard){
                    //if the currentCard is a personaCard, 
                    if ((currentCard instanceof PersonaCard)) {
                        //but not escape, it becomes the winning card
                        if (!(currentCard instanceof Escape)){
                            winning_card = currentCard;
                            winner = currentPlayer;
                        }
                    }
                    //if the current card is also a numeric card
                    else {
                        //if they are the same color, all you have to do is compare the numbers
                        if (((NumericCard)currentCard).getColor().equals(((NumericCard)winning_card).getColor())) {
                            if (((NumericCard)currentCard).getNumber() > ((NumericCard)winning_card).getNumber()){
                                winning_card = currentCard;
                                winner = currentPlayer;
                            }
                        } else {
                            //if they are not the same colour, you just have to check if the current card is black, cause even if the winning card was also black, the previous if 
                            //statement would've handled that situation.
                            if (((NumericCard)currentCard).getColor().equals("black")){
                                winning_card = currentCard;
                                winner = currentPlayer;
                            }
                        }
                    }

                }

                //if the winning card is a PersonaCard
                else {
                    //if currentCard is also a personacard
                    if (currentCard instanceof PersonaCard){
                        //check if the currentCard trumps the winning card
                        if (Arrays.asList(((PersonaCard)currentCard).getTrumps()).contains(winning_card.getName())){
                            winning_card = currentCard;
                            winner = currentPlayer;
                        }
                    }
                    //if currentCard is not a personaCard, something only needs to happen when the winning card is an escape
                    else {
                        if (winning_card instanceof Escape) {
                            winning_card = currentCard;
                            winner = currentPlayer;
                            if (firstColor==null){
                                firstColor = ((NumericCard)currentCard).getColor();
                            }
                        }
                    }
                }
            }
        }
        HashMap<Player, Card> returnMap = new LinkedHashMap<Player, Card>();
        returnMap.put(winner, winning_card);
        System.out.println(String.format("%s is the winner with the %s card %n",winner, winning_card.toString()));
        winner.setWinsReceived(winner.getWinsReceived()+1);
        return returnMap;
    }
    
}

