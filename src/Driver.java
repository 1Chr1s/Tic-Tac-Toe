import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author chris
 */
public class Driver {
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { 
                mainFrame window = new mainFrame();
                try {
                    window.runFrame();
                } catch (IOException ex) {
                    Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
       });
     }
    
}
