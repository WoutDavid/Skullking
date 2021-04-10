package gui.ActionListeners;
import GameClasses.*;
import java.awt.event.*;
import javax.swing.*;

public class AddPlayerListener implements ActionListener{
    private Board board;
    private JButton sourceButton;
    private JTextField textField;


    public AddPlayerListener(Board board, JTextField textField){
        this.board=board;
        this.textField=textField;
    }
    public void actionPerformed(ActionEvent e){
        this.sourceButton = (JButton)e.getSource();
        String playerName = textField.getText();
        
        board.addPlayer(playerName);
        
        
    }
}
