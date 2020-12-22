import java.util.Random;
import java.util.HashMap;


//board is the place where the gui will draw it's info from, multiple games can be played on one instance of a board
public class Board {
    private int number_of_players;
    private Player[] players;
    private HashMap<Player, Integer> score_map;
    private Player starter; 

    public Board(int number_of_players, Player[] players){
        //picking a starting player at random
        Random random = new Random();
        int randomIndex = random.nextInt(players.length);
        this.starter = players[randomIndex];

        this.number_of_players = number_of_players;
        this.players = players;

        for (Player p: players){
            score_map.put(p, 0);
        }
        //this isn't correct yet cause you changed the hierarchy of classes.
        for (int i = 0; i < 10; i++){
            Game game = new Game(players, starter);
            for (Player p: players){
                score_map.put(p, p.getScore());
            }
            this.setRound_number(round_number++);
            //this.updateDataOnBoard
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

    public int getRound_number() {
        return round_number;
    }

    public void setRound_number(int round_number) {
        this.round_number = round_number;
    }
    
}
