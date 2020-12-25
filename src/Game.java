import java.util.HashMap;
import java.util.Arrays;

//Round will be the instance that represents one entire game, so from 1 card to 10
//i've not yet created a seperate class for a rotation played, so far it just serves as one function that takes all info of the round and returns a map of the winner
//calling how mony rotations playes will have and logging that is not yet implemented
public class Game {
    private int number_of_players;
    private Player[] players;
    private Player starter;
    private int round_number = 1;
    boolean gameOver = false;

    public Game(Player[] players, Player starter){
        this.number_of_players=players.length;
        this.players=players;
        this.starter=starter;

        //Dont forget to update the players scores, starter and round number after this, it gon be important
    }
    //Rotation is the lowest level of play, it is just each player puts down one card
    //This will be called by the GUI, when the players have chosen their cards for that rotation, which will be stored in a dictionary
    //It'll probably be easier if I extract the first card from the dictionary and then compare everything to that.
    //I added a firstcolor variable to make functionality easier
    public HashMap<Player, Card> playRotation(HashMap<Player, Card> playedCards, String firstColor){
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
