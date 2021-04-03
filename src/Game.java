import java.util.HashMap;

//Game will be the one instance that is created by Board, and represents an entire game, so round 1-10 will be created here, score will be kept here.
public class Game {
    private int numberOfPlayers;
    private Player[] players;
    private int roundNumber = 1;
    private Board parentBoard;
    boolean gameOver = false;
    private HashMap<Player, Integer> gameScores = new HashMap<Player, Integer>();

    public Game(Player[] players, Board parentBoard){
        this.numberOfPlayers=players.length;
        this.players=players;
        this.parentBoard=parentBoard;
        for (Player p: players){
            gameScores.put(p, 0);
        }

    }

    public void addScore(Player player, int score){
        this.gameScores.put(player, this.gameScores.get(player) + score);
    }
    //creates a new round, and the end of the round will call upon the updateScores method in the Game class to use the end 
    public Round startRound(int roundNumber){
        //TODO implement startround
        Round round = new Round(this.players, roundNumber, this);
        return round;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
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
        return gameScores;
    }

    public void printScores(){
        for (HashMap.Entry<Player, Integer> entry : gameScores.entrySet()) {
            System.out.println(String.format("%s has %d points", entry.getKey(), entry.getValue()));
        }   
    }

    public Board getParentBoard() {
        return parentBoard;
    }

    public void setParentBoard(Board parentBoard) {
        this.parentBoard = parentBoard;
    }
    
}
