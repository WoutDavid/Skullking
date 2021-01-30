public class Hand {
    private int number_cards;
    private Card[] cards;
    private Player owner;

    public Hand(int number_cards, Player owner, Deck deck){
        this.cards = new Card[number_cards];
        for (int i = 0; i< number_cards; i++){
            this.cards[i] = deck.drawCard();
        }
        this.number_cards = cards.length;
        this.owner = owner;
        this.owner.setHand(this);
    }

    public int getNumber_cards() {
        return number_cards;
    }


    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
    
    
}
