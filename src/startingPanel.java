import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author chris
 */
public class startingPanel extends JPanel{
    // Variables
    private final int _MaxNumberOfJLabels = 3;
    private JButton startingButtons[];
    private mainCenterJLabel frontLabel[] = new mainCenterJLabel[_MaxNumberOfJLabels];
    private JPanel centerPanel;
    private JPanel lowerPanel;
    private final int _MaxButtons  = 2;
    private boolean startButtonStatus = false;
    private boolean optionButtonStatus = false;
    /*************************************************************CREAT AND ADD mainPanelBackground*******************************/
    /** 
     * Constructors 
     */
    public startingPanel(){
        this.setLayout(new BorderLayout());
        createObjects();
    }
    /**
     * Creating all of the objects 
     */
    private void createObjects(){ 
         lowerPanel = new JPanel();
        centerPanel = new JPanel();
        startingButtons = new JButton[_MaxButtons];
        centerPanel.setLayout(new BorderLayout());
        lowerPanel.setLayout(new FlowLayout());
        customizeButtons();
        customizeFrontLabel();
        customizePanelBackgroundColor();
    }
    /**
     * Returns a boolean that represents whether the start button was pressed or not.
     * @return boolean
     */
    public boolean getStartButtonStatus(){ 
        if(startButtonStatus == true){
            // Convert startButtonStatus to false in order to reset the status of the Start Button Status:
            startButtonStatus = false;
            return true;
        }
        return startButtonStatus;
    }
    /**
     * Returns a boolean that represents whether the option button was pressed or not.
     * @return boolean
     */
    public boolean getOptionButtonStatus(){ 
        if(optionButtonStatus == true){
            // Convert optionButtonStatus to false in order to reset the status od the Option Button:
            optionButtonStatus = false;
            return true;
        }
        return optionButtonStatus;
    }
    
    /**
     * Customizes the two JButtons of the screen; add the JButtons to the lower part of the main panel
     */
    private void customizeButtons(){ 
        
        for(int i = 0; i < _MaxButtons; i++ ){ 
            startingButtons[i] = new JButton();
            switch(i){ 
                case 0:
                    startingButtons[i].setText("Start");
                    startingButtons[i].addActionListener(new ActionListener(){

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            startButtonStatus = true;
                        }
                    });
                    break;
                case 1:
                    startingButtons[i].setText("Options");
                    startingButtons[i].addActionListener(new ActionListener(){

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            optionButtonStatus = true;
                        }     
                   });
                    break;
            }
            // Adding the JButtons to the lowerLabel:
            lowerPanel.add(startingButtons[i]);
        }
        // Adding the LowerPanel to the main panel:
        this.add(lowerPanel, BorderLayout.SOUTH);
    }
    /**
     * Customize the center front label
     */
    private void customizeFrontLabel(){
        for(int i = 0; i < 3; i++){
            
            switch(i){ 
                case 0:   
                    frontLabel[i] = new mainCenterJLabel("Welcome", 0);
                    frontLabel[i].setLeftShadow(5, 5, Color.black);
                    frontLabel[i].setRightShadow(-3, -3, Color.white);
                    frontLabel[i].setForeground(Color.blue);
                    frontLabel[i].setFont(frontLabel[i].getFont().deriveFont(80f));
                    // Adding the frontLabel to the top of the centerPanel:
                    centerPanel.add(frontLabel[i], BorderLayout.NORTH);
                    break; 
                case 1:
                    frontLabel[i] = new mainCenterJLabel("To", 0);
                    frontLabel[i].setLeftShadow(5, 5, Color.white);
                    frontLabel[i].setRightShadow(-3, -3, Color.black);
                    frontLabel[i].setForeground(Color.blue);
                    frontLabel[i].setFont(frontLabel[i].getFont().deriveFont(80f));
                    // Adding the frontLabels to the center of the centerPanel:
                    centerPanel.add(frontLabel[i], BorderLayout.CENTER);
                break;
                case 2:
                    frontLabel[i] = new mainCenterJLabel("Tic Tac Toe", 0);

                    frontLabel[i].setLeftShadow(5, 5, Color.blue);
                    frontLabel[i].setRightShadow(-3, -3, Color.white);
                    frontLabel[i].setForeground(Color.black);
                    frontLabel[i].setFont(frontLabel[i].getFont().deriveFont(80f));
                    // Adding the frontLabel to the bottom of the centerPanel:
                    centerPanel.add(frontLabel[i], BorderLayout.SOUTH);
                    break;
            }
            
        }
        
        this.add(centerPanel, BorderLayout.CENTER);
    }
    
    private void customizePanelBackgroundColor(){ 
        centerPanel.setBackground(new Color(53, 73, 94));
        lowerPanel.setBackground(new Color(31, 97, 141));
    }
    
}
