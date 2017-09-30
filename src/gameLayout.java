import java.awt.*;
import javax.swing.*;

/**
 *
 * @author chris
 */
public class gameLayout extends JPanel{
    // Variables:
    private TicTacToeDrawing drawing;
    private Player p1;
    private Player p2;
   
    /**
     * 
     * @param p1
     * @param p2 
     */
    public void setPlayers(Player p1, Player p2){ 
        this.p1 = p1;
        this.p2 = p2;
        createObjects();
        setUpBoard();
    }
    
    /**
     * Creates the objects
     * 
     */
    private void createObjects(){ 
        drawing = new TicTacToeDrawing(p1, p2);
    }
    
    private void setUpBoard(){ 
        this.setLayout(new BorderLayout());
        this.add(drawing.getUpperPanel(), BorderLayout.NORTH);
        this.add(drawing, BorderLayout.CENTER);
    }
    /**
     * Returning if someone has won the game
     * @return 
     */
    public boolean statusOfGame(){ 
        return drawing.getGameStatus();
    }
}
