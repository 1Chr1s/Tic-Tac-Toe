import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author chris
 */
public class TicTacToeDrawing extends JPanel implements ActionListener{
    // Variables
    private Player p1;
    private Player p2;
    private JPanel topPanel;
    private final int _NumberOfSpots = 9;
    private mainCenterJLabel text[] = new mainCenterJLabel[2];
    private boardButton buttons[] = new boardButton[_NumberOfSpots];
    private WinningChecker checker;
    private int turn = 0;
    private boolean doneWithGame = false;
    private ImageIcon winnerImage = new ImageIcon(this.getClass().getResource("Images/fire.png"));
    
    /**
     * Constructor
     * @param p1
     * @param p2 
     */
    public TicTacToeDrawing(Player p1, Player p2){ 
       this.p1 = p1;
       this.p2 = p2;
       // Adding layout:
       this.setLayout(new GridBagLayout());
       //Setting background:
       this.setBackground(Color.black);
       createObjects();
       addingButtonsToMainJPanel();
    }
    
    /**
     * Adding the buttons to the JPanel
     */
    private void addingButtonsToMainJPanel(){ 
        // Variables:         
        GridBagConstraints gbc1 = new GridBagConstraints();

         // Variables :
        Dimension buttonDimension = new Dimension(300, 250);
        
         for(int i = 0; i < _NumberOfSpots; i++){
         /******Creating Object******/
            buttons[i] = new boardButton();
            buttons[i].setPreferredSize(buttonDimension);
            buttons[i].setActionCommand(String.valueOf(i));
            buttons[i].addActionListener(this);
            buttons[i].setContentAreaFilled(false);
        /*******************************/
            if(i <= 2){ 
                switch(i){
                    case 0: 
                        gbc1.gridx = 0;
                        gbc1.gridy = 0;
                      break;
                    default: 
                        gbc1.gridx++;
                      break;
                }
            }else if (i > 2  && i <= 5){
                switch(i){
                    case 3: 
                        gbc1.gridx = 0;
                        gbc1.gridy = 1;
                        break;
                    default: 
                        gbc1.gridx++;
                        break;
                }
            }else { 
                 switch(i){ 
                     case 6: 
                         gbc1.gridx = 0;
                         gbc1.gridy = 2;
                         break;
                     default: 
                         gbc1.gridx++;
                         break;
                 }
            }
            // Adding the JButtons to the JPanel:
            this.add(buttons[i], gbc1);
         }
    }
    
    /**
     * Creating the objects
     */
    private void createObjects(){ 
        // Variables:
        GridBagConstraints gbc = new GridBagConstraints();
        // Setting layout of topPanel
        topPanel = new JPanel(new GridBagLayout());
        // Setting Background to gold:
       topPanel.setBackground(new Color(142, 69, 133));
        for(int i = 0; i < 2; i++){
            switch(i){
                case 0: 
                    checker = new WinningChecker();
                    text[i] = new mainCenterJLabel(p1.getName() + " ", 3);
                    text[i].setLeftShadow(5, 5, Color.white);
                    text[i].setRightShadow(-3, -3, Color.black);
                    text[i].setForeground(Color.blue);
                    text[i].setFont(text[i].getFont().deriveFont(40f));
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.weightx = .5;
                    // Adding JLabel to the topPanel:
                    topPanel.add(text[i], gbc);
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    // Adding JLabel to the topPanel:
                    topPanel.add(p1.getPlayerMarker(), gbc);
                break;
                case 1: 
                    text[i] = new mainCenterJLabel(p2.getName() + " ", 3);
                    text[i].setLeftShadow(5, 5, Color.white);
                    text[i].setRightShadow(-3, -3, Color.black);
                    text[i].setForeground(Color.blue);
                    text[i].setFont(text[i].getFont().deriveFont(40f));
                    gbc.gridx = 2;
                    gbc.gridy = 0;
                    // Adding JLabel to the topPanel:
                    topPanel.add(text[i], gbc);
                    gbc.gridx = 2;
                    gbc.gridy = 1;
                    // Adding JLabel to the topPanel:
                    topPanel.add(p2.getPlayerMarker(), gbc);
                    break;
            }
        }
    }
    
    private void nextPlayer(){  
        turn++;
    }
    
    // Getter: 
   /**
    * 
    * @return 
    */
    public JPanel getUpperPanel(){ 
        return topPanel;
    }

    /**
     * Check to see if it is even.
     * @param i
     * @return 
     */
    private boolean isEven(int i){ 
        int temp = i %2;
        if(temp == 0){
            return true;
        }
        return false;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            // Variables:
            int playerNumber = 0;
            Player tempPlayer;
            int optionSelected;
            int index = Integer.valueOf(e.getActionCommand());
            
            if(this.isEven(turn)){
                tempPlayer = p1;
               playerNumber = 1;
            }else { 
                tempPlayer = p2;
                playerNumber = 2;
            }
            // Marks the space if it hasn't been marked yet:
            if(!buttons[index].isMarked()){ 
                // Setting the player's marker on the board:
                buttons[index].selected(tempPlayer.getPlayerMarker().getIcon());
                switch(playerNumber){ 
                    case 1: 
                            p1.setPlayerLocations(index);
                            // Checking if player 1 has one:
                            if(checker.checkIfWinner(p1)){
                                JOptionPane.showMessageDialog(this, "Congratulations " + p1.getName() + ", you won!", p2.getName() + " winner", JOptionPane.INFORMATION_MESSAGE, winnerImage);
                                optionSelected = JOptionPane.showConfirmDialog(this, "Would you like to play again?", "Play Again?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, winnerImage);
                                doneWithGame = true;
                            }
                        break;
                    case 2:
                            p2.setPlayerLocations(index);
                            // Checking if Player 2 has one:
                            if(checker.checkIfWinner(p2)){
                                JOptionPane.showMessageDialog(this, "Congratulations " + p1.getName() + ", you won!", p2.getName() + " winner", JOptionPane.INFORMATION_MESSAGE, winnerImage);
                                optionSelected = JOptionPane.showConfirmDialog(this, "Would you like to play again?", "Play Again?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, winnerImage );
                                doneWithGame = true; 
                            }
                        break;
                }
                // Check if the board is completely full: 
                
                
                // Change to the next player:
                this.nextPlayer();
            }
    }
    /**
     * Returns a boolean that represent whether someone has won the game. 
     * @return 
     */
    public boolean getGameStatus(){ 
        if(doneWithGame == true){ 
            doneWithGame = false; 
            return true; 
        }
        return doneWithGame;
    }
   /* 
    public boolean playAgain(){ 
        switch(optionSelected){
            
        }
    }
*/
}