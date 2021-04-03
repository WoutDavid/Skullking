public class test_main {
    public static void main(String[] args){
        Deck deck = new Deck();
        // System.out.println(deck.toString());
        Hand hand = new Hand(3, deck);
        System.out.println(hand.toString());
        System.out.println(deck.toString());


    }
    
}
