import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author chris
 */
public class selectingPlayerAvatar extends JPanel{
    // Variables:
    private Player player;
    private JButton browseButton;
    private JLabel centerLabel;
    private ImageIcon icon  = new ImageIcon(this.getClass().getResource("Images/smile.png"));
    private ImageIcon background = new ImageIcon(this.getClass().getResource("Images/customMainImage.png"));
    private String selected;
    private boolean done = false;
    
    /**
     * Setting the player 
     */
    public void setPlayer(Player player){ 
        this.player = player; 
        creatingObjects();
        addingToJPanel();
    }
        
    public void creatingObjects(){ 
        browseButton = new JButton("Select....");
        centerLabel = new JLabel("Choose your avatar, " + player.getName());
        centerLabel.setForeground(Color.red);
        this.setBackground(Color.black);
        
    }
    
    @Override
    public void paintComponent(Graphics g){ 
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, null);
    }
    
    public void addingToJPanel(){ 
        //i love christiaaaaaannnnnnnnnnn !!!!!!!
        // Variables:
        Object [] options = {"Linux", "Windows", " "};
        
                
        browseButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // Variables:
                while(done == false){
                    String option = (String)JOptionPane.showInputDialog(null, "Choose your avatar:", " Avatar Chooser",JOptionPane.PLAIN_MESSAGE, icon, options, " ");
                    if(option.equalsIgnoreCase("Linux")){
                        selected = option;
                        done = true;
                        // Setting the marker image of the player:
                        player.setPlayerMarker(new ImageIcon(this.getClass().getResource("Images/linux.png")));
                    }else if(option.equalsIgnoreCase("Windows")){ 
                        selected = option;
                        done = true;
                        // Setting the marker Image of the player:
                        player.setPlayerMarker(new ImageIcon(this.getClass().getResource("Images/windows.png")));
                    }else{ 
                        done = false;
                    }
               }
           }
        });
        this.add(centerLabel);
        this.add(browseButton);
    }
    
    /**
     * Returns the value of the string selected
     * @return 
     */
    public String optionSelected(){ 
        return selected;
    }
    
    
    public boolean doneChoosingImage(){ 
        if(done == true){ 
            // Resetting:
            done = false;
            return true;
        }
        return done;
    }
    
}