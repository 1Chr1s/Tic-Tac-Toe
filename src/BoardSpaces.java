

/**
 *
 * @author chris
 */
public class BoardSpaces {
    // Variables:
    private final int _MaxBoardSpaces = 9;
    
    
    // Constructor

    public boolean isBoardFull(Player p1, PLayer p2){ 
    // Varialbles: 
    int temp;
    // Getting the number of spaces both players have used:
    temp = p1.getSpacesMarked().size() + p2.getSpacesMarked().getSize();
    return temp == _MaxBoardSpaces;
    
    }
    
}
