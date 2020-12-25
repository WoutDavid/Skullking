public class Main {
    public static void main(String[] args){
        Deck d = new Deck();
        for (int i=0; i<5; i++){
            System.out.println(d.getcards()[0].getName());
            System.out.println(d.getSize());
            d.drawCard();
            System.out.println(d.getcards()[0].getName());
            System.out.println(d.getSize());
        }

    }
}



