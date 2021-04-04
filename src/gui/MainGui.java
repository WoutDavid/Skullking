package gui;

import javax.swing.*;
import GameClasses.*;

public class MainGui {
    public static void main(String args[]){
        JFrame frame = new JFrame("Skullking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        Player p1 = new Player("David");
        Player p2 = new Player("Cédric");
        Player p3 = new Player("Tibo");
        Player p4 = new Player("Kathleen");
        Player[] playerArray = new Player[]{p1,p2,p3,p4};
        Board board = new Board();
        for (Player p: playerArray){
            board.addPlayer(p);
        }
        JButton button = new JButton("DrawHand");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
     }
}
