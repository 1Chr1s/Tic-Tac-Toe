import java.util.Vector;
/**
 *
 * @author chris
 */
public class WinningChecker { 
    // Variables:
    private Vector tempVector;
    private final int minimumWinningElements = 3;
    /**
     * Boolean returning whether the player won.
     * @param player
     * @return boolean
     */
    public boolean checkIfWinner(Player player){ 
        tempVector = player.getSpacesMarked();
        if(tempVector.size() >= minimumWinningElements){
            // Checking to see if it has a possible way to win in a diagnal way:
            if(hasCorner()){ 
                if(cornerWin()){
                    return true;
                }
            }      
            if (verticalWin()){
                    return true;
           }else if(horizontalWin()){ 
                    return true;
          }
        }
        return false;
    }
    /**
     * Checking if won vertically.
     * @return 
     */
    private boolean hasCorner(){ 
        int temp;
        for(int i = 0; i < tempVector.size(); i++){ 
            temp = (int)tempVector.elementAt(i);
            if(temp % 2 == 0){ 
                return true;
            }
        }
        return false;
    }
    private boolean cornerWin(){ 
        // Variables:
        int combination1 [] = {0, 4, 8};
        int combination2 [] = {2, 4, 6};
        int tempIndex = 1;
        int shouldHave = 0;
        int winningCounter = 0;

        if(tempVector.contains(combination1[0]) == true){ 
            for(int x = 1; x < combination1.length; x++){
                //for(int i = 0; i < tempVector.size(); i++){
                    if (tempVector.contains(combination1[x])){
                        winningCounter++;
                        tempIndex++;
                        break;
                    }
                //}
                shouldHave++;
                if(shouldHave != winningCounter){ 
                    return false;
                }
            }
        }else if(tempVector.contains(combination2[0]) == true){ 
            for(int x = 0; x < combination2.length; x++){
                //for(int i = 0; i < tempVector.size(); i++){ 
                    if(tempVector.contains(combination2[x])){
                        winningCounter++;
                        tempIndex++;
                        break;
                    }
                //}
                shouldHave++;
                if(shouldHave !=winningCounter){ 
                    return false;
                }
            }            
       }
        /**************************DELETE***********************************************************/
        System.out.println("Winning counter = " + winningCounter);
            if(winningCounter >= 2){ 
                return true;
            }
            
            return false; 
    }
    /**
     * Check if won by vertical.
     * @return boolean
     */
    private boolean verticalWin(){ 
        // Variables: 
        int combination1[] = {0, 3, 6};
        int combination2[] = {1, 4, 7};
        int combination3[] = {2, 5, 8};
        int winningCounter = 0;
        int shouldHave = 0;
        //int temp = 0;
        
        if(tempVector.contains(combination1[0]) == true){  
            for(int x = 1; x < combination1.length; x++){
                for(int i = 0; i < tempVector.size(); i++){
                    if(tempVector.contains(combination1[x]) == true){
                        winningCounter++;
                        //temp++;
                        break;
                    }
                }
                shouldHave++;
                if(shouldHave != winningCounter){
                    return false;
                }
            }
        }else if(tempVector.contains(combination2[0]) == true){
            for(int x = 1; x < combination2.length; x++){
                for(int i = 0; i < tempVector.size(); i++){
                    if(tempVector.contains(combination2[x]) == true){
                        winningCounter++;
                        //temp++;
                        break;
                    }
                }
                shouldHave++;
                if(shouldHave != winningCounter){ 
                    return false;
                }
            }
        }else if(tempVector.contains(combination3[0]) == true){
            for(int x = 1; x < combination3.length; x++){
                for(int i = 0; i < tempVector.size(); i++){ 
                    if(tempVector.contains(combination3[x]) == true){
                        winningCounter++;
                        //temp++;
                        break;
                    }
                }
                shouldHave++;
                if(shouldHave !=winningCounter){
                    return false;
                }
            }
        }
        /**************************DELETE***********************************************************/
        System.out.println("Winning counter = " + winningCounter);
        if(winningCounter >= 2){
            return true;
        }
        return false;
    }
    /**
     * Checking if won by horizontal
     * @return boolean
     */
    private boolean horizontalWin(){ 
        int combination1[] = {0, 1, 2};
        int combination2[] = {3, 4, 5};
        int combination3[] = {6, 7, 8};
        int winningCounter = 0;
        //int temp = 0;
        int shouldHave = 0;
        
        if(tempVector.contains(combination1[0]) == true){  
            for(int x = 0; x < combination1.length; x++){
                for(int i = 0; i < tempVector.size(); i++){
                    if(tempVector.contains(combination1[x]) == true){
                        winningCounter++;
                        //temp++;
                        break;
                    }
                    shouldHave++;
                    if(shouldHave != winningCounter){ 
                        return false;
                    }
                }
            }
        }else if(tempVector.contains(combination2[0]) == true){
            for(int x = 0; x < combination2.length; x++){
                for(int i = 0; i < tempVector.size(); i++){
                    if(tempVector.contains(combination2[x]) == true){
                        winningCounter++;
                        //temp++;
                        break;
                    }
                    shouldHave++;
                    if(shouldHave != winningCounter){
                        return false;
                    }
                }
            }
        }else if(tempVector.contains(combination3[0]) == true){
            for(int x = 0; x < combination3.length; x++){
                for(int i = 0; i < tempVector.size(); i++){ 
                    if(tempVector.contains(combination3[x]) == true){
                        winningCounter++;
                        //temp++;
                    }
                }
                shouldHave++;
                if(shouldHave != winningCounter){
                    return false;
                }
            }
        }
       /**************************DELETE***********************************************************/
        System.out.println("Winning counter = " + winningCounter);
        if(winningCounter >= 2){
            return true;
        }
        return false;
        
    }
}
