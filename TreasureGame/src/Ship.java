

import javax.swing.ImageIcon;

/**
 * Basic class for Ships.
 * 
 * Adapted from zetcode.com
 * 
 * @author Rodney Earl
 * @version 1.0
 */
public class Ship extends Sprite{
	
	/**
	 * Constructor for ships.
	 * @param xPos X coordinate of the ship.
	 * @param yPos Y coordinate of the ship.
	 */
	public Ship(int xPos, int yPos){
		
		super(xPos, yPos);
		ImageIcon ii = new ImageIcon(this.getClass().getResource("ship.png"));
		image = ii.getImage();
	}
}
