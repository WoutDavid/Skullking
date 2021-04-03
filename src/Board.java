import java.util.HashMap;
//board is the place where the gui will draw it's info from, multiple games can be played on one instance of a board
public class Board {
    private int numberOfPlayers;
    private Player[] players;
    // Score map is the overall scores over all games, <--> Game.scores: temp scores for that game.
    private HashMap<Player, Integer> scoreMap = new HashMap<Player,Integer>();

    private Player starter; 

    public Board(Player[] players){
        this.players = players;
        this.numberOfPlayers = players.length;

        for (Player p: players){
            scoreMap.put(p, 0);
        }
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

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
        this.setNumberOfPlayers(players.length);
    }

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
