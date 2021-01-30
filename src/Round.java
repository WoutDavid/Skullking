import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

//This class represents one of the 10 rounds that will be played each game
//so the card calling and score calculation is done on this level.
//the deck is also created on this level, each round has a new Deck.

public class Round {
    private int round_number;
    private Player[] players;
    private Player starter;
    private Game parentGame;
    private Deck deck = new Deck();
    private LinkedHashMap<Player, Card> playedCards = new LinkedHashMap<Player, Card>();
    // private LinkedHashMap<Player, Integer> winsCalled = new LinkedHashMap<Player, Integer>();
    // private LinkedHashMap<Player, Integer>  winsReceived = new LinkedHashMap<Player, Integer>();
    private boolean roundFinished = false;

    public Round(Player[] players, int round_number, Game game){
        //round begins, each player gets their hand
        this.players = players;
        int rnd = new Random().nextInt(players.length);
        this.starter = players[rnd];
        this.round_number = round_number;
        this.parentGame = game;

        for (Player p: players){
            p.setHand(new Hand(round_number, p, deck));
            //Ask for everyone to call their wins
            playedCards.put(p,p.getCardChosen());
        }
    }

    //Fills the playedCards with the currently chosen cards of the players
    //to be called right before initiating a rotation.
    public void collectPlayedCards() throws Exception{
        for (Player p: players){
            if (p.getCardChosen() == null){
                throw new Exception(String.format("%s did not choose a card yet",p.getName()));
            }
        }
        for (Player p: players){
            playedCards.put(p, p.getCardChosen());
        }
    }

    
    public HashMap<Player, Card> playRotation(LinkedHashMap<Player, Card> playedCards){
        try{
            collectPlayedCards();
        } catch(Exception e) {
            System.out.println(e);
        }

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

    public HashMap<Player, Integer> updateGameScores() throws Exception{
        //TODO implement this
        if (!isRoundFinished()){
            throw new Exception("Round is not finished");
        } else{
            for (Player p: players){
                this.getParentGame().addScore(p, p.getScore());
            }
        }
        return new HashMap<Player, Integer>();

    }

    public void updatePlayerScores() throws Exception{
        if (!isRoundFinished()){
            throw new Exception("Round is not finished, cannot update player scores");
        }
        for (Player p: players){
            if (p.getWinsCalled()==0){
                if (p.getWinsReceived() == 0){
                    p.setScore(round_number*10);
                } else {
                    p.setScore(round_number*-10);
                }
            } else if (p.getWinsCalled() == p.getWinsReceived()){
                p.setScore(p.getWinsCalled()*20);
            } else {
                int difference = Math.abs(p.getWinsCalled()-p.getWinsReceived());
                p.setScore(difference*-10);
            }
        }
    }


	public int getRound_number() {
		return round_number;
	}


	public void setRound_number(int round_number) {
		this.round_number = round_number;
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


	// public LinkedHashMap<Player, Integer> getWinsCalled() {
	// 	return winsCalled;
	// }


	// public void setWinsCalled(LinkedHashMap<Player, Integer> winsCalled) {
	// 	this.winsCalled = winsCalled;
	// }


	// public LinkedHashMap<Player, Integer> getWinsReceived() {
	// 	return winsReceived;
	// }


	// public void setWinsReceived(LinkedHashMap<Player, Integer> winsReceived) {
	// 	this.winsReceived = winsReceived;
	// }


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

