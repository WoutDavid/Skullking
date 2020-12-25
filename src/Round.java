//This class represents one of the 10 rounds that will be played each game

public class Round {
    private int round_number;
    private Player[] players;
    private Deck deck = new Deck();

    public Round(Player[] players, int round_number){
        this.players = players;
        this.round_number = round_number;
        for (Player p: players){
            p.setHand(new Hand(round_number, p, deck));
        }
    }
    
}
