import java.util.HashMap;
import java.util.LinkedHashMap;

//This class represents one of the 10 rounds that will be played each game
//so the card calling and score calculation is done on this level.
//the deck is also created on this level, each round has a new Deck.

public class Round {
    private int round_number;
    private Player[] players;
    private Deck deck = new Deck();
    private LinkedHashMap<Player, Integer> winsCalled = new LinkedHashMap<Player, Integer>();
    private LinkedHashMap<Player, Integer>  winsReceived = new LinkedHashMap<Player, Integer>();
    private boolean roundFinished = false;

    public Round(Player[] players, int round_number){
        //round begins, each player gets their hand
        this.players = players;
        this.round_number = round_number;
        HashMap<Player, Card> playedCards = new HashMap<Player, Card>();
        for (Player p: players){
            p.setHand(new Hand(round_number, p, deck));
            //Ask for everyone to call their wins
            playedCards.put(p,p.getCardChosen());
        }

    }

    public HashMap<Player, Card> playRotation(HashMap<Player, Card> playedCards){
        String firstColor = null;
        for (HashMap.Entry<Player, Card> entry : playedCards.entrySet()) {
            if (entry.getValue() instanceof NumericCard){
                firstColor = ((NumericCard)entry.getValue()).getColor();
            }
            else {
                continue;
            }
        }
        Rotation rotation = new Rotation(playedCards, firstColor);
        HashMap<Player, Card> returnMap = rotation.playRotation();
        return returnMap;
    }

    public HashMap<Player, Integer> calculateScores() throws Exception{
        //TODO implement this
        if (!roundFinished){
            throw new Exception("Exception message");
        }
        return new HashMap<Player, Integer>();

    }
    
}
