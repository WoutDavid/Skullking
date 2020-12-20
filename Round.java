import java.util.HashMap;

import java.util.HashMap;
public class Round {
    private int number_of_players;
    private Player[] players;
    private Player starter;
    private int round_number;
    private Deck deck = new Deck();
    boolean roundOver = false;

    public Round(int number_of_players, Player[] players, Player starter, int round_number){
        this.number_of_players=number_of_players;
        this.players=players;
        this.starter=starter;
        this.round_number = round_number;

        //the player already exits, so now we gotta give them hands:
        for (Player p: players){
            Hand hand = new Hand(round_number, p, deck);
        }
        //Dont forget to update the players scores, starter and round number after this, it gon be important
    }
    //This will be called by the GUI, when the players have chosen their cards for that rotation, which will be stored in a dictionary
    //It'll probably be easier if I extract the first card from the dictionary and then compare everything to that.
    public void playRotation(HashMap<Player, Card> playedCards){
        Player winner = null;
        Card winning_card = null;
        boolean first = true;  
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
                        if (((NumericCard)entry.getValue()).getNumber() > ((NumericCard)winning_card).getNumber()){
                            winning_card = entry.getValue();
                            winner = entry.getKey();
                        }
                    }

                }
                else {
                    
                }
            }


        }

    }
    
}
