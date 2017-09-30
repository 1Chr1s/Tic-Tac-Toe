import javax.swing.*;


/**
 *
 * @author chris
 */
public class boardButton extends JButton{ 
    // Variable:
    private boolean marked = false;
    // Setters:
    
    /**
     * Marking the Button by setting an icon to it.
     * @param icon 
     */
    public void selected(Icon  icon){
        this.setIcon(icon);
        mark();
    }
  
    // Getters:
    /**
     * Return whether or not the button has been marked by an Icon.
     * @return 
     */
    public boolean isMarked(){ 
        return marked;
    }
    
    /**
     * Marks the JButton 
     */
    private void mark(){ 
        marked = true;
    }

}
