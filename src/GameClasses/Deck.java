package GameClasses;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import CardTypes.*;
public class Deck {
    private Card[] deckCards;
    private int size;

    public Deck(){
        //5 escape, 4*13=52 colours, 5 pirates, 1 skullking, 1 mermaid, 1 GreenFlag = 65
        String[] colors = new String[]{"black", "blue", "red", "yellow"};
        Card[] cards = new Card[65];
        int counter = 0;
        for(String s : colors) {
            for(int j=1;j<14;j++){
                cards[counter] = new NumericCard(j, s);
                counter++;
            }
        }
                
        for(int i = 52; i<57; i++){
            cards[i] = new Escape();
        }
        for(int i=57;i<62; i++){
            cards[i] = new Pirate();

        }
        cards[62] = new SkullKing();
        cards[63] = new Mermaid();
        cards[64] = new GreenPirate();

        // Shuffle the deck:
        List<Card> cardList = Arrays.asList(cards);
		Collections.shuffle(cardList);
		cardList.toArray(cards);
        this.deckCards=cards;
        this.size = cards.length;
    }

    public Card[] getCards() {
        return deckCards;
    }

    public void setCards(Card[] cards) {
        this.deckCards = cards;
        this.setSize(cards.length);
    }
    public int getSize() {
        return this.deckCards.length;
    }

    private void setSize(int size) {
		this.size = size;
	}
    public Card drawCard(){
        Card returnCard = this.deckCards[0];
        Card[] newDeck = new Card[this.getSize()-1];
        for (int i = 0; i<newDeck.length; i++){
            newDeck[i] = this.deckCards[i+1];
        }
        this.setCards(newDeck);
        return returnCard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c: this.deckCards){
            sb.append(c.toString() + "\n");
        }
        sb.append(String.format("Number of cards in deck = %d", this.size));
        return sb.toString();
    }
}

