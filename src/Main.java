import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        //creating the players
        Player p1 = new Player("David");
        Player p2 = new Player("Cédric");
        Player p3 = new Player("Tibo");
        Player p4 = new Player("Kathleen");
        Player[] playerArray = new Player[]{p1,p2,p3,p4};

        //creating board and game
        Board board = new Board(playerArray);
        Game game = board.createGame(board.getPlayers());
        
        //playing all of the rounds
        for (int i =1; i<11; i++){
            Round round = game.startRound(i);
            Random rand = new Random();
            for (Player p: playerArray){
                p.setWinsCalled(rand.nextInt(i));
            }
            for (int j=0;j<i;j++){
                for (Player p: playerArray){
                    p.setCardChosen(p.getHand().getCards()[j]);
                }
                Player winner = round.playTrick();
            }
        }

        game.printScores();
    }



}



