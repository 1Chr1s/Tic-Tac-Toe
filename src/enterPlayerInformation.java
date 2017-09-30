import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author chris
 */
public class enterPlayerInformation extends JPanel{
    // Variables: 
    private JTextField playerNameInput[] = new JTextField[2];
    private mainCenterJLabel[]  names = new mainCenterJLabel[2];
    private JButton doneButton;
    private Player player1;
    private Player player2;
    private boolean buttonPressed;
    
            
    /**
     * Constructor
     */
    public enterPlayerInformation(Player p1, Player p2){ 
        this.player1 = p1;
        this.player2 = p2;
        // Setting the layout manager:
        this.setLayout(new GridBagLayout());
        // Setting Background:
        this.setBackground(Color.black);
        buttonPressed = false;
        createObjects();
        setUp();
    }

    
    private void createObjects(){ 
        for(int i = 0; i < 2; i++){
            if(i < names.length){
                playerNameInput[i] = new JTextField();
                switch(i){ 
                    case 0: 
                        
                        doneButton = new JButton("Done");
                        doneButton.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Variables:
                            boolean firstJTextFieldStatus = false;
                            boolean secondJTextFieldStatus = false;
                            
                            for(int i = 0; i < 2; i++){ 
                                switch(i){ 
                                    case 0: 
                                        firstJTextFieldStatus = playerNameInput[i].getText().isEmpty();
                                        if(firstJTextFieldStatus){ 
                                            JOptionPane.showMessageDialog(null, "Oooooops, dont forget to enter a name for player 1 :) ");
                                        }
                                        break;
                                    case 1:
                                        secondJTextFieldStatus = playerNameInput[i].getText().isEmpty();
                                        if(secondJTextFieldStatus){ 
                                            JOptionPane.showMessageDialog(null, "Oooooops, dont forget to enter a name for player 2 :) ");
                                        }
                                        break;
                                }
                                if(firstJTextFieldStatus == false && secondJTextFieldStatus == false){ 
                                    player1.setName(playerNameInput[0].getText());
                                    player2.setName(playerNameInput[1].getText());
                                    // initieztes that the button has been pressed, but also that everything has been filled in.
                                    buttonPressed = true;
                                }
                            }
                            
                        }
                        });
                        names[i] = new mainCenterJLabel("Player 1 name:", 0);
                        names[i].setLeftShadow(5, 5, Color.black);
                        names[i].setRightShadow(-3, -3, Color.magenta);
                        names[i].setForeground(Color.blue);
                        names[i].setFont(names[i].getFont().deriveFont(40f));
                        break;
                  case 1:
                        names[i] = new mainCenterJLabel("Player 2 name:", 0);
                        names[i].setLeftShadow(5, 5, Color.black);
                        names[i].setRightShadow(-3, -3, Color.MAGENTA);
                        names[i].setForeground(Color.blue);
                        names[i].setFont(names[i].getFont().deriveFont(40f));
                        break;
                 }
            }
        }
    }
    
    private void setUp(){ 
        // Varialbes
            GridBagConstraints gbc1 = new GridBagConstraints();
            GridBagConstraints gbc2 = new GridBagConstraints();
            GridBagConstraints gbc3 = new GridBagConstraints();
            GridBagConstraints gbc4 = new GridBagConstraints();
            GridBagConstraints gbc5 = new GridBagConstraints();
            
        /**********************************************************************/
        for (int i = 0, c = 0; i < 3; i++) {
            
            switch(i){
                case 0: 
                    gbc1.gridx = 0;
                    gbc1.gridy = 0;
                    gbc1.ipadx = 100;
                    gbc1.ipady = 50;
                    this.add(names[c],gbc1);
                    c++;
                    gbc2.gridx = 2;
                    gbc2.gridy = 0;
                    gbc2.ipadx = 100;
                    gbc2.ipady = 50;
                    this.add(names[c], gbc2);
                    c = 0;
                    break; 
                case 1:
                    gbc3.gridx = 0;
                    gbc3.gridy = 1;
                    gbc3.ipadx = 200;
                    gbc3.ipady = 25;
                    this.add(playerNameInput[c], gbc3);
                    c++;
                    gbc4.gridx = 2;
                    gbc4.gridy = 1;
                    gbc4.ipadx = 200;
                    gbc4.ipady = 25;
                    this.add(playerNameInput[c], gbc4);
                    break;
                case 2: 
                    gbc5.gridx = 1;
                    gbc5.gridy = 2; 
                    this.add(doneButton, gbc5);
                    break;
            }
        }
    }
    
    // Setters:
    
    
    // Getters:
    public boolean getButtonClickedStatus(){ 
        if(buttonPressed == true){ 
            // Resseting the status of the button:
            buttonPressed = false;
            return true;
        }
        return buttonPressed;
    }
    
}
