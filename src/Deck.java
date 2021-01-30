import java.util.Random;
public class Deck {
    private Card[] cards;
    private int size;

    public Deck(){
        //5 escape, 4*13=52 colours, 5 pirates, 1 skullking, 1 mermaid, 1 GreenFlag = 66
        String[] colors = new String[]{"black", "blue", "red", "yellow"};
        Card[] cards = new Card[66];
        int counter = 0;
        for(String s : colors) {
            for(int j=1;j<14;j++){
                cards[counter] = new NumericCard(j, s);
                counter++;
            }
        }
        

        //hier is alle kleur al geel for some reason
        
        for(int i = 53; i<58; i++){
            cards[i] = new Escape();
        }
        for(int i=58;i<63; i++){
            cards[i] = new Pirate();
        }
        cards[63] = new SkullKing();
        cards[64] = new Mermaid();
        cards[65] = new GreenPirate();

        Random rand = new Random();
		for (int i = 0; i < cards.length; i++) {
			int randomIndexToSwap = rand.nextInt(cards.length);
			Card temp = cards[randomIndexToSwap];
			cards[randomIndexToSwap] = cards[i];
			cards[i] = temp;
        }
        this.cards=cards;
        this.size = cards.length;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;;
    }
    public int getSize() {
        return this.cards.length;
    }

    public void setSize(int size) {
		this.size = size;
	}
    public Card drawCard(){
        Card return_card = this.cards[0];
        Card[] new_deck = new Card[this.getSize()-1];
        for (int i = 0; i<new_deck.length; i++){
            new_deck[i] = this.cards[i+1];
        }
        this.setCards(new_deck);
        return return_card;
    }
}

