import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

//This class represents one of the 10 rounds that will be played each game
//so the card calling and score calculation is done on this level.

//the deck is also created on this level, each round has a new Deck.

public class Round {
    private int roundNumber;
    private int tricksPlayed;
    private Player[] players;
    private Player starter;
    private Game parentGame;
    private Deck deck = new Deck();
    private LinkedHashMap<Player, Card> playedCards = new LinkedHashMap<Player, Card>();
    private boolean roundFinished = false;

    public Round(Player[] players, int roundNumber, Game game){
        //round begins, each player gets their hand
        this.players = players;
        int rnd = new Random().nextInt(players.length);
        this.starter = players[rnd];
        this.roundNumber = roundNumber;
        this.parentGame = game;
        this.tricksPlayed=0;
        
        for (Player p: players){
            p.setHand(new Hand(roundNumber, deck));
        }
    }
    // Boolean function to check if everyone called their wins
    // Actual win calling will be done on GUI level
    public boolean checkWins(){
        Boolean returnBool = true;
        for (Player p: players){
            if (p.getWinsCalled()<0){
                returnBool=false;
            }
        }
        return returnBool;
    }
    //Fills the playedCards with the currently chosen cards of the players
    //to be called right before initiating a Trick.
    public void collectPlayedCards() throws Exception{
        for (Player p: players){
            if (p.getCardChosen() == null){
                throw new Exception(String.format("%s did not choose a card yet %n",p.getName()));
            }
        }
        for (Player p: players){
            playedCards.put(p, p.getCardChosen());
        }
    }

    
    public Player playTrick(){
        try{
            collectPlayedCards();
        } catch(Exception e) {
            System.out.println(e);
        }
        // Create Trick object
        Trick Trick = new Trick(playedCards);

        //Define the winner using the playTrick method
        Player trickWinner = Trick.playTrick();
        //Give update winsreceived of the winner
        trickWinner.oneWinReceived();
        // Update tricks played counter
        tricksPlayed++;

        if (tricksPlayed==roundNumber){
            roundFinished=true;
            try{
                this.updatePlayerScores();
            } catch(Exception e) {
                System.out.println(e);
            }
            try{
                this.updateGameScores();
            }catch(Exception e) {
                System.out.println(e);
            }
        }
        return trickWinner;

    }

    public HashMap<Player, Integer> updateGameScores() throws Exception {
        if (!isRoundFinished()){
            throw new Exception("Round is not finished");
        } else{
            for (Player p: players){
                this.getParentGame().addScore(p, p.getScore());
                // After updating the game scores, flush the player scores, since they represent temp scores
                p.setScore(0);
            }
        }
        return new HashMap<Player, Integer>();

    }
    // Updates the players scores based on their current values of winscalled and winsreceived, and then puts those values to zero
    public void updatePlayerScores() throws Exception{
        if (!isRoundFinished()){
            throw new Exception("Round is not finished, cannot update player scores");
        }
        // Now we're going to calculate the score based on winscalled and received.
        for (Player p: players){
            // If the player called 0 wins
            if (p.getWinsCalled()==0){
                // And also received them:
                if (p.getWinsReceived() == 0){
                    p.setScore(roundNumber*10);
                // if he got a different number:
                } else {
                    p.setScore(roundNumber*-10);
                }
            // If the player did not call 0 wins
            } else if (p.getWinsCalled() == p.getWinsReceived()){
                p.setScore(p.getWinsCalled()*20);
            } else {
                // calculate the absolute difference between the two 
                int difference = Math.abs(p.getWinsCalled()-p.getWinsReceived());
                p.setScore(difference*-10);
            }
            // Reset their wins stats
            p.setWinsCalled(-5);
            p.setWinsReceived(0);
        }
    }

	public int getRound_number() {
		return roundNumber;
	}


	public void setRound_number(int roundNumber) {
		this.roundNumber = roundNumber;
	}


	public Player[] getPlayers() {
		return players;
	}


	public void setPlayers(Player[] players) {
		this.players = players;
	}


	public Deck getDeck() {
		return deck;
	}


	public void setDeck(Deck deck) {
		this.deck = deck;
	}


	public boolean isRoundFinished() {
		return roundFinished;
	}


	public void setRoundFinished(boolean roundFinished) {
		this.roundFinished = roundFinished;
	}

    public Game getParentGame() {
        return parentGame;
    }

    public void setParentGame(Game parentGame) {
        this.parentGame = parentGame;
    }

    public LinkedHashMap<Player, Card> getPlayedCards() {
        return playedCards;
    }


}

