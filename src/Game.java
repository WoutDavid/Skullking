import java.util.HashMap;
import java.util.Arrays;

//Game will be the one instance that is created by Board, and represents an entire game, so round 1-10 will be created here, score will be kept here.
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
        for (Player p: players){
            p.setScore(0);
        }

        //this isn't correct yet cause you changed the hierarchy of classes.
        for (int i = 0; i < 10; i++){
            Round round = new Round(players, i);
            
        }
        //Dont forget to update the players scores, starter and round number after this, it gon be important
    }
}
