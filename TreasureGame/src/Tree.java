

import javax.swing.ImageIcon;

/**
 * Basic class for Trees.
 * 
 * Adapted from zetcode.com
 * 
 * @author Rodney Earl
 * @version 1.0
 */
public class Tree extends Sprite{
	
	/**
	 * Constructor for trees.
	 * @param xPos X coordinate of the tree.
	 * @param yPos Y coordinate of the tree.
	 */
	public Tree(int xPos, int yPos){
		
		super(xPos, yPos);
		ImageIcon ii = new ImageIcon(this.getClass().getResource("tree.png"));
		image = ii.getImage();
	}
}
