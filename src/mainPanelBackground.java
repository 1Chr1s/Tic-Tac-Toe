import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author chris
 */
public class mainPanelBackground extends JTextField{
    // Variables:
    BufferedImage image;
    TexturePaint texture;
    
    
    /**
     * Constructor
     */
    public mainPanelBackground(File file) throws IOException{ 
        super();
        image = ImageIO.read(file);
        Rectangle rectangle= new Rectangle(0, 0, image.getWidth(null), image.getHeight(null));
        texture = new TexturePaint(image, rectangle);
        this.setOpaque(false);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setPaint(texture);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        super.paintComponent(g);
    }
    
    
}
