public class Player {
    private String name;
    private int score;
    private Hand hand;
    private int winsCalled;
    private int winsReceived;
    private Card cardChosen = null;

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Card getCardChosen() {
        return cardChosen;
    }

    public void setCardChosen(Card cardChosen) {
        this.cardChosen = cardChosen;
    }
    
}
