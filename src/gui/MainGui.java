package gui;

import javax.swing.*;
import GameClasses.Board;
public class MainGui {
    public static void main(String args[]){
        JFrame frame = new JFrame("Skullking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        Board board = new Board();
        JButton button = new JButton("DrawHand");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
     }
}
