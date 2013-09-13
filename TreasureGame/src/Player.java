

import javax.swing.ImageIcon;

/**
 * Class for the Player.
 * 
 * Adapted from zetcode.com
 * 
 * @author Rodney Earl
 * @version 1.0
 */
public class Player extends Sprite{
	
	/**
	 * Constructor for the player.
	 * @param xPos X coordinate of the player.
	 * @param yPos Y coordinate of the player.
	 */
	public Player(int xPos, int yPos){
		
		super(xPos, yPos);
		ImageIcon ii = new ImageIcon(this.getClass().getResource("player.png"));
		image = ii.getImage();
	}
	
	/**
	 * Method to move the player.
	 * @param dx How far the player will move in the x direction.
	 * @param dy How far the player will move in the y direction.
	 */
	public void move(int dx, int dy){
		
		x = x + dx;
		y = y + dy;
	}
}
