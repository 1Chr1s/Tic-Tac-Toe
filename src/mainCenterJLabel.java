import java.awt.*;
import javax.swing.*;
/**
 *
 * @author chris
 */
public class mainCenterJLabel extends JLabel{
    // Variables:
    /*********************************************************************/
    private int leftX;
    private int leftY;
    private int rightX;
    private int rightY;
    private Color leftColor;
    private Color rightColor;
    private int tracking;
    /*********************************************************************/
    
    /** 
     * Constructor
     */
    public mainCenterJLabel(String text, int tracking){
        super(text);
        this.tracking = tracking;
    }
    /**
     *  Setting the left shadow
     * @param x - The x value of the left shadow.
     * @param y - The y value of the left shadow.
     * @param color - Setting the color of the left shadow. 
     */
    public void setLeftShadow(int x, int y, Color color){
        this.leftX = x;
        this.leftY = y;
        this.leftColor = color;
    }
    /**
     * Setting the right shadow of the text.
     * @param x - The x value of the right shadow. 
     * @param y - The y value of the right shadow.
     * @param color - Setting the color of the right shadow
     */
    public void setRightShadow(int x, int y, Color color){ 
        this.rightX = x; 
        this.rightY = y;
        this.rightColor = color;
    }
    
    public Dimension getPreferredSize(){
        // Variables:
        String text;
        FontMetrics fm ;
        int w;
        int h; 
        
        text = this.getText();
        fm = this.getFontMetrics(this.getFont());
        
        w = fm.stringWidth(text);
        w += (text.length() - 1) * tracking;
        w += this.leftX + this.rightX; 
        
        h = fm.getHeight();
        h += this.leftY + this.rightY;
        
        return new Dimension(w,h);
    }
    
    /**
     * Overriding the paintComponent method
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        // Variables:
        int h;                                  // y-value
        int x;                                  // x-value    
        char temp;                         // Temporary character variable
        int w;  
        
                
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // Getting all of the charcters of the text:
        char[] chars = getText().toCharArray();
        
        FontMetrics fontMetrics = this.getFontMetrics(this.getFont());
        
         h = fontMetrics.getAscent();
         x = 0;
        /*
        // Calculates the width of each character plus the tracking; the it draws it three times. 
        // Starts drawing each letter:
        */
        for(int i = 0; i < chars.length; i++){
            temp = chars[i];
            w = fontMetrics.charWidth(temp) + tracking;
            
            // Setting the left Color:
            g.setColor(this.leftColor);
            g.drawString(" " + chars[i], x - this.leftX, h - this.leftY);
            // Setting the right Color:
            g.setColor(this.rightColor);
            g.drawString(" " + chars[i], x + this.rightX, h + this.rightY);
            // Setting the Foreground Color:
            g.setColor(this.getForeground());
            g.drawString(" " + chars[i], x, h);
            // x is increased to be used in the next character:
            x+=w;
        }
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
    }
    
    
}
