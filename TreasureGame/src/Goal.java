


import javax.swing.ImageIcon;

/**
 * Constructor for goal locations.
 * 
 * Adapted from zetcode.com
 * 
 * @author Rodney Earl
 * @version 1.0
 */
public class Goal extends Sprite{

	/**
	 * Constructor for goals.
	 * @param xPos X coordinate of a goal.
	 * @param yPos Y coordinate of a goal.
	 */
    public Goal(int xPos, int yPos) {
    	
        super(xPos, yPos);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("goal.png"));
        image = ii.getImage();
    }
}
