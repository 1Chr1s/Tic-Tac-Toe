import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
/**
 *
 * @author chris
 */
public class mainFrame extends JFrame implements ActionListener{
   public void runFrame() throws IOException{ 
       // Varibles: 
       final int delaySpeed = 10;
       Timer timer = new Timer(delaySpeed, this);
       timer.start();
       
       JPanelController controller = new JPanelController();
       this.setTitle("Tic Tac Toe");
       this.add(controller);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setSize(910, 1000);
       this.setLocationRelativeTo(null);
       this.setResizable(false);
   }

   /*******************************Trying to dynamically resize***********************************************/
    @Override
    public void actionPerformed(ActionEvent e) {
 //       this.pack();
    }
}
