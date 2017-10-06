
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author chris
 */
public class JPanelController extends JPanel implements ActionListener{
// Variables: 
    CardLayout cards;
    private startingPanel starter;
    private gameLayout main;
    private enterPlayerInformation info;
    private selectingPlayerAvatar select[] = new selectingPlayerAvatar[2];
    private Player player1; 
    private Player player2;
    private Timer timer;
    private int delaySpeed = 10;
    
    /**
     * Constructor
     */
    public JPanelController(){
        displayContents();
    }
    /**
     * Displays the contents of the game
     */
    public void displayContents(){
        creatingObjects();
        addPanelToCardLayout();
    }
    /**
     * Creates the object being used.
     */
    private void creatingObjects(){ 
        timer = new Timer(delaySpeed, this);
        cards = new CardLayout();
        starter = new startingPanel();
        player1 = new Player();
        player2 = new Player();
        info = new enterPlayerInformation(player1, player2);
        main = new gameLayout();
        for(int i = 0; i < 2; i++){
           select[i] = new selectingPlayerAvatar();
        }
        
        //Starting the timer:
        timer.start();
        this.setLayout(cards);
    }
    /**
     * Adding all of the panels needed onto the layout.
     */
    private void addPanelToCardLayout(){ 
        for(int i = 0; i < 5; i++){
            switch(i){
                case 0: 
                    this.add(starter, "Starting Screen");
                    break;
                case 1:
                        this.add(info, "Input Screen");
                        break;
                case 2: 
                    this.add(select[0], "First Player Select");
                    break;
                case 3: 
                    this.add(select[1], "Second Player Select");
                    break;
                case 4: 
                    this.add(main, "Main Screen");
                    break;
            }
        }
        
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Variable:
       // boolean temp1 = select[0].doneChoosingImage();
        //boolean temp2 = select[1].doneChoosingImage();
        
        if (starter.getStartButtonStatus() == true){
            cards.show(this, "Input Screen");
        }else if(info.getButtonClickedStatus() == true){
            // Setting the player:
            select[0].setPlayer(player1);
            cards.show(this, "First Player Select");
        }else if(select[0].doneChoosingImage() == true){
            // Setting the player:
            select[1].setPlayer(player2);
            cards.show(this , "Second Player Select");
         }else if(select[1].doneChoosingImage() == true){
            // Setting the players: 
            main.setPlayers(player1, player2);
            cards.next(this);
            //cards.show(this, "Main Screen");
//         }else if(main.statusOfGame()){
         
            
            /************************STILL WORKING ON THIS PART**********************/
        }
        
    }
}
