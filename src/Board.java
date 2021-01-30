import java.util.HashMap;
//board is the place where the gui will draw it's info from, multiple games can be played on one instance of a board
public class Board {
    private int number_of_players;
    private Player[] players;
    private HashMap<Player, Integer> score_map = new HashMap<Player,Integer>();

    private Player starter; 

    public Board(int number_of_players, Player[] players){
        this.number_of_players = number_of_players;
        this.players = players;

        for (Player p: players){
            score_map.put(p, 0);
        }

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

    public HashMap<Player, Integer> getScore_map() {
        return score_map;
    }

    public void setScore_map(HashMap<Player, Integer> score_map) {
        this.score_map = score_map;
    }

    public Player getStarter() {
        return starter;
    }

    public void setStarter(Player starter) {
        this.starter = starter;
    }
    
}
