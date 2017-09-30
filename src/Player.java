import java.util.*;
import javax.swing.*;
/**
 *
 * @author chris
 */
public class Player {
    // Variables: 
    private String playerName;
    private String nickName;
    private ImageIcon pic;
    private ImageIcon playerMarker;
    private JLabel pictureLabel;
    private JLabel markerLabel;
    private Vector<Integer> spacesMarked;
    
    /**
     * Constructor
     * 
     */
    public Player(){
        spacesMarked = new Vector();
        createJLabels();
    }
    
    // Setters:
    public void setName(String name){
         this.playerName = name; 
    }
    
    public void setPlayerPicture(ImageIcon PlayerPic){ 
        this.pic = PlayerPic;
        addPic();
    }
    
    public void setPlayerMarker(ImageIcon marker){
         this.playerMarker = marker;
         addMarker();
    }
    /**
     * Saving all of the spaces the player has marked 
     * @param space 
     */
    public void setPlayerLocations(int space){ 
        spacesMarked.add(space);
    }
    
    // Getters:
    public String getName(){
         return playerName;
    }
    
    public JLabel getPlayerPic(){
        return pictureLabel;
    }
    
    public JLabel getPlayerMarker(){
        return markerLabel;
    }
    
    public Vector getSpacesMarked(){ 
        return spacesMarked;
    }
    /**
     * Creating the JLabels
     */
    private void createJLabels(){ 
        pictureLabel = new JLabel();
        markerLabel = new JLabel();
    }
    /**
     * Adding the player marker to a JLabel
     */
    private void addMarker(){ 
        markerLabel.setIcon((Icon) playerMarker);
    }
    /**
     * Adding the player picture to a JLabel
     */
    private void addPic(){ 
        pictureLabel.setIcon((Icon)pic);
    }
    
}
