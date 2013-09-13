

import javax.swing.ImageIcon;

/**
 * Basic class for Water.
 * 
 * Adapted from zetcode.com
 * 
 * @author Rodney Earl
 * @version 1.0
 */
public class Water extends Sprite{
	
	/**
	 * Constructor for water.
	 * @param xPos X coordinate of the water.
	 * @param yPos Y coordinate of the water.
	 */
	public Water(int xPos, int yPos){
		
		super(xPos, yPos);
		ImageIcon ii = new ImageIcon(this.getClass().getResource("water.png"));
		image = ii.getImage();
	}
}
