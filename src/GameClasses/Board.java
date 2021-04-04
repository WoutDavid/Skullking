package GameClasses;
import java.util.HashMap;
import java.util.ArrayList;


//board is the place where the gui will draw it's info from, multiple games can be played on one instance of a board
public class Board {
    private int numberOfPlayers;
    private ArrayList<Player> players = new ArrayList<Player>();

    // Score map is the overall scores over all games, <--> Game.scores: temp scores for that game.
    private HashMap<Player, Integer> scoreMap = new HashMap<Player,Integer>();

    private Player starter; 

    //empty constructor, since all functionality is upon clicking buttons, the Board is something abstract
    public Board(){}

    public void addPlayer(Player player){
        this.players.add(player);
        scoreMap.put(player, 0);
        numberOfPlayers++;
    }
    public Game createGame(Player[] playerArray){
        Game game = new Game(playerArray, this);
        return game;
    }
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    // Only to be used locally, by the setPlayers method
    private void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    //Returns the list of players as an array, not as an arraylist, the arraylist is purely to be used by the board class, not by other classes.
    public Player[] getPlayers() {
        return (Player[])(players.toArray());
    }

    // public void setPlayers(Player[] players) {
    //     this.players = players;
    //     this.setNumberOfPlayers(players.length);
    // }

    public HashMap<Player, Integer> getscoreMap() {
        return scoreMap;
    }

    public void setScoreMap(HashMap<Player, Integer> scoreMap) {
        this.scoreMap = scoreMap;
    }

    public Player getStarter() {
        return starter;
    }

    public void setStarter(Player starter) {
        this.starter = starter;
    }
    
}
