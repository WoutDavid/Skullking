package gui;
import javax.swing.*;
import java.awt.*; 


public class BoardFrame extends JFrame {

    public BoardFrame(String title){
        super( title );                      // invoke the JFrame constructor
        setSize( 500, 500 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        setLayout( new GridLayout(2,2) );       // set the layout manager
        JTextField label = new JTextField("Insert Player name");  // construct a JLabel
        add( label );  
        JButton button = new JButton("Add Player");
        add(button);
        
        // JButton addPersonButton = new JButton();
    }

    public void makeVisible(){
        // pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
