public class Hand {
    private int number_cards;
    private Card[] cards;
    private String owner;

    public Hand(int number_cards, String owner, Deck deck){
        this.cards = new Card[number_cards];
        for (int i = 0; i< number_cards; i++){
            this.cards[i] = deck.drawCard();
        }
        this.number_cards = cards.length;
        this.owner = owner;
    }

    public int getNumber_cards() {
        return number_cards;
    }

    public void setNumber_cards(int number_cards) {
        this.number_cards = number_cards;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    
}
