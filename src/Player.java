public class Player {
    private String name;
    private int score;
    private Hand hand;
    private int winsCalled=-5;
    private int winsReceived=0;
    private Card cardChosen = null;

    public Player(String name){
        this.name = name;
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

    public int getWinsCalled() {
        return winsCalled;
    }

    public void setWinsCalled(int winsCalled) {
        this.winsCalled = winsCalled;
    }

    public int getWinsReceived() {
        return winsReceived;
    }

    public void setWinsReceived(int winsReceived) {
        this.winsReceived = winsReceived;
    }

    public void printCalledWins(){
        System.out.println(this.getName() + " called " + this.getWinsCalled() + " wins.");
    }

    @Override
    public String toString() {
        return "Player [name=" + name + "]";
    }
    
    
}
