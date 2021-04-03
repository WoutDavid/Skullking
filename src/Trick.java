import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Arrays;

public class Trick {
    private LinkedHashMap<Player, Card> playedCards;
    private String firstColor=null;
    private Player winner = null;
    private Card winningCard = null;
    private boolean first = true;  
 
    public Trick(LinkedHashMap<Player, Card> playedCards){
        this.playedCards=playedCards;
    }


    //takes as input a map of players and their played cards for this trick, 
    //returns a tuple of a player who won this trick
    public Player playTrick(){
        //This forloop is for debugging purposes
        for (HashMap.Entry<Player, Card> entry : playedCards.entrySet()) {
            Player player = entry.getKey();
            Card playerCard = entry.getValue();
            System.out.println(String.format("%s plays the card %s", player, playerCard));
        }
        //set the first entry of the linkedHashMap to be the winner, because no matter what happens, the first card wins if everyone plays an escape.
        for (HashMap.Entry<Player, Card> entry : playedCards.entrySet()) {
            winner = entry.getKey();
            winningCard = entry.getValue();
            if (firstColor==null && winningCard instanceof NumericCard){
                firstColor = ((NumericCard)winningCard).getColor();
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
                if (winningCard instanceof NumericCard){
                    //if the currentCard is a personaCard, 
                    if ((currentCard instanceof PersonaCard)) {
                        //but not escape, it becomes the winning card
                        if (!(currentCard instanceof Escape)){
                            winningCard = currentCard;
                            winner = currentPlayer;
                        }
                    }
                    //if the current card is also a numeric card
                    else {
                        //if they are the same color, all you have to do is compare the numbers
                        if (((NumericCard)currentCard).getColor().equals(((NumericCard)winningCard).getColor())) {
                            if (((NumericCard)currentCard).getNumber() > ((NumericCard)winningCard).getNumber()){
                                winningCard = currentCard;
                                winner = currentPlayer;
                            }
                        } else {
                            //if they are not the same colour, you just have to check if the current card is black, cause even if the winning card was also black, the previous if 
                            //statement would've handled that situation.
                            if (((NumericCard)currentCard).getColor().equals("black")){
                                winningCard = currentCard;
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
                        if (Arrays.asList(((PersonaCard)currentCard).getTrumps()).contains(winningCard.getName())){
                            winningCard = currentCard;
                            winner = currentPlayer;
                        }
                    }
                    //if currentCard is not a personaCard, something only needs to happen when the winning card is an escape
                    else {
                        if (winningCard instanceof Escape) {
                            winningCard = currentCard;
                            winner = currentPlayer;
                            if (firstColor==null){
                                firstColor = ((NumericCard)currentCard).getColor();
                            }
                        }
                    }
                }
            }
        }
        System.out.println(String.format("%s is the winner with the %s card %n",winner, winningCard.toString()));
        winner.setWinsReceived(winner.getWinsReceived()+1);
        return winner;
    }
    
}

