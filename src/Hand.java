public class Hand {
    private int numberCards;
    private Card[] cards;
    private Player owner;

    public Hand(int numberCards, Deck deck){
        this.cards = new Card[numberCards];
        for (int i = 0; i< numberCards; i++){
            this.cards[i] = deck.drawCard();
        }
        this.numberCards = cards.length;
    }

    public int getnumberCards() {
        return numberCards;
    }


    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
        //might want to update the gui here?
    }
    
    //removes the given card from the hand
    public void playCard(Card card) throws Exception{
        Card[] newCards = new Card[this.getCards().length-1];
        int index = -5;
        for (int i=0;i<this.getCards().length;i++){
            if (this.getCards()[i]==card){
                index = i;
                break;
            }
        }
        if (index <0){
            throw new Exception(String.format("%s is not in the hand of %s",card, owner));
        }
        for (int i=0;i<index;i++){
            newCards[i] = this.getCards()[i];
        }
        for (int i=index; i<newCards.length;i++){
            newCards[i]=this.getCards()[i+1];
        }
        this.setCards(newCards);

    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c: this.cards){
            sb.append(c.toString() + "\n");
        }

        return sb.toString();
    }
}
