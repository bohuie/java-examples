

import javax.swing.ImageIcon;

/**
 * Basic class for Treasure Chests.
 * 
 * Adapted from zetcode.com
 * 
 * @author Rodney Earl
 * @version 1.0
 */
public class Treasure extends Sprite{

	/**
	 * Constructor for a treasure chest.
	 * @param xPos X coordinate of the treasure chest.
	 * @param yPos Y coordinate of the treasure chest.
	 */
    public Treasure(int xPos, int yPos) {
    	
        super(xPos, yPos);
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource("chest.png"));
        image = ii.getImage();
    }

    /**
     * Method to move a treasure chest if pushed by the player.
     * @param dx How far the chest will move in the x direction.
     * @param dy How far the chest will move in the y direction.
     */
    public void move(int dx, int dy){
		
		x = x + dx;
		y = y + dy;
	}
}