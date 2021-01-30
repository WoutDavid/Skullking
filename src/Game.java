import java.util.HashMap;

//Game will be the one instance that is created by Board, and represents an entire game, so round 1-10 will be created here, score will be kept here.
public class Game {
    private int number_of_players;
    private Player[] players;
    private int roundNumber = 1;
    boolean gameOver = false;
    private HashMap<Player, Integer> scores = new HashMap<Player, Integer>();

    public Game(Player[] players){
        this.number_of_players=players.length;
        this.players=players;
        for (Player p: players){
            scores.put(p, 0);
        }

    }

    public void addScore(Player player, int score){
        this.scores.put(player, this.scores.get(player) + score);
    }
    //creates a new round, and the end of the round will call upon the updateScores method in the Game class to use the end 
    public Round startRound(int roundNumber){
        //TODO implement startround
        Round round = new Round(this.players, roundNumber, this);
        return round;
    }

    public int getNumber_of_players() {
        return number_of_players;
    }

    public void setNumber_of_players(int number_of_players) {
        this.number_of_players = number_of_players;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public HashMap<Player, Integer> getScores() {
        return scores;
    }

    public void setScores(HashMap<Player, Integer> scores) {
        this.scores = scores;
    }
}
