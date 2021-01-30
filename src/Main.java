public class Main {
    public static void main(String[] args){
        //creating the players
        Player p1 = new Player("David");
        Player p2 = new Player("Zeger");
        Player p3 = new Player("Tibo");
        Player p4 = new Player("Kathleen");
        Player[] playerArray = new Player[]{p1,p2,p3,p4};

        //creating board and game
        Board board = new Board(4, playerArray);
        Game game = new Game(playerArray);
        
        //starting the first round
        Round round = game.startRound(1);
        System.out.println(round.getDeck().getCards()[0].toString());

    }



}



